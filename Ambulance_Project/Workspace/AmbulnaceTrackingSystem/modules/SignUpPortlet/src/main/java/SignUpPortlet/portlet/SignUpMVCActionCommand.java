package SignUpPortlet.portlet;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import SignUpPortlet.constants.SignUpPortletKeys;

import java.util.Locale;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
                "mvc.command.name=/action/signUp/register"
        },
        service = MVCActionCommand.class
)
public class SignUpMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long companyId = themeDisplay.getCompanyId();

            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String screenName = ParamUtil.getString(actionRequest, "screenName");
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            String password = ParamUtil.getString(actionRequest, "password");

            if (!Validator.isEmailAddress(emailAddress)) {
                actionResponse.setRenderParameter("errorMessage", "Invalid email address");
                return false;
            }

            // Check if user already exists
            try {
                User existingUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
                if (existingUser != null) {
                    actionResponse.setRenderParameter("errorMessage", "Email address already registered");
                    return false;
                }
            } catch (Exception e) {
                // User doesn't exist — OK to continue
            }

            Locale locale = themeDisplay.getLocale();
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

            // Create inactive user (no OTP yet)
            User user = UserLocalServiceUtil.addUser(
                    0, companyId, false, password, password,
                    false, screenName, emailAddress,
                    themeDisplay.getLocale(), firstName, "", lastName,
                    0, 0, true, 1, 1, 2000, "", 0, null, null, null, null,
                    false, serviceContext
            );

            // Create expando attributes (empty for now)
            createExpandoAttributes(user);

            // Set inactive until email verified
            UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE, serviceContext);

            // ✅ Build only the verification link (no OTP yet)
            String portalURL = themeDisplay.getPortalURL();
            String groupFriendlyURL = themeDisplay.getScopeGroup().getFriendlyURL();
            String portletInstanceId = themeDisplay.getPortletDisplay().getId();

            // Construct correct verification URL
            String verificationLink = portalURL + "/web" + groupFriendlyURL +
                    "/ambulance?p_p_id=" + portletInstanceId +
                    "&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view" +
                    "&_SignUpPortlet_SignUpPortlet_INSTANCE_kizn_jspPage=%2Fverify_email.jsp" +
                    "&mvcRenderCommandName=%2Fverify-email" +
                    "&userId=" + user.getUserId();

            // Send verification link only (no OTP)
            sendVerificationEmail(user, verificationLink);

            actionResponse.setRenderParameter("successMessage",
                    "Registration successful! Please check your email for the verification link.");

        } catch (Exception e) {
            e.printStackTrace();
            actionResponse.setRenderParameter("errorMessage", "Registration failed: " + e.getMessage());
            return false;
        }

        return true;
    }

    // ✅ Create expando fields for OTP (empty for now)
    private void createExpandoAttributes(User user) {
        try {
            if (!user.getExpandoBridge().hasAttribute("verificationOTP")) {
                user.getExpandoBridge().addAttribute("verificationOTP", false);
            }
            if (!user.getExpandoBridge().hasAttribute("otpGeneratedTime")) {
                user.getExpandoBridge().addAttribute("otpGeneratedTime", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Send only verification link
    private void sendVerificationEmail(User user, String verificationLink) {
        try {
            String subject = "Verify Your Email - SOS Ambulance Portal";
            String htmlBody = "<html><body style='font-family: Arial, sans-serif;'>"
                    + "<h3 style='color: #333;'>Verify Your Email Address</h3>"
                    + "<p>Hello <strong>" + user.getFullName() + "</strong>,</p>"
                    + "<p>Thank you for registering with the SOS Ambulance Portal.</p>"
                    + "<p>Please click the button below to verify your email and continue your registration process:</p>"
                    + "<p><a href='" + verificationLink + "' style='display:inline-block;background-color:#007bff;color:white;padding:12px 24px;text-decoration:none;border-radius:4px;font-weight:bold;'>Verify Email Address</a></p>"
                    + "<p>Or copy and paste this link in your browser:</p>"
                    + "<p style='word-break:break-all;color:#666;'>" + verificationLink + "</p>"
                    + "<hr><p style='font-size:12px;color:#999;'>If you didn’t register, please ignore this email.</p>"
                    + "</body></html>";

            InternetAddress from = new InternetAddress("kavyama1408@gmail.com", "SOS Ambulance Portal");
            InternetAddress to = new InternetAddress(user.getEmailAddress(), user.getFullName());

            MailMessage mailMessage = new MailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setBody(htmlBody);
            mailMessage.setHTMLFormat(true);

            MailServiceUtil.sendEmail(mailMessage);

            System.out.println("✅ Verification email (link only) sent to: " + user.getEmailAddress());
            System.out.println("🔗 Verification link: " + verificationLink);

        } catch (Exception e) {
            System.err.println("❌ Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
