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
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;

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

            // Get form values
            String firstName = ParamUtil.getString(actionRequest, "firstName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String screenName = ParamUtil.getString(actionRequest, "screenName");
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            String password = ParamUtil.getString(actionRequest, "password");

            // Validate email
            if (!Validator.isEmailAddress(emailAddress)) {
                actionResponse.setRenderParameter("errorMessage", "Invalid email address");
                return false;
            }

            // Check if user exists
            try {
                User existingUser = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
                if (existingUser != null) {
                    actionResponse.setRenderParameter("errorMessage", "Email address already registered");
                    return false;
                }
            } catch (Exception e) {
                // User doesn't exist — continue
            }

            Locale locale = themeDisplay.getLocale();
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

            long[] groupIds = new long[0];
            long[] organizationIds = new long[0];
            long[] roleIds = new long[0];
            long[] userGroupIds = new long[0];

            // Create inactive user
            User user = UserLocalServiceUtil.addUser(
                0, companyId, false, password, password,
                false, screenName, emailAddress,
                locale, firstName, "", lastName,
                0, 0, true, 1, 1, 2000, "", 1,
                groupIds, organizationIds, roleIds, userGroupIds,
                false, serviceContext
            );

            // Add Expando attributes
            createExpandoAttributes(user);

            // Mark user inactive until email verification
            UserLocalServiceUtil.updateStatus(user.getUserId(), WorkflowConstants.STATUS_INACTIVE, serviceContext);

            // ✅ Generate proper verification link
            PortletURL verificationURL = PortletURLFactoryUtil.create(
                    actionRequest,
                    SignUpPortletKeys.SIGNUP,
                    themeDisplay.getPlid(),
                    PortletRequest.RENDER_PHASE
            );

            verificationURL.setParameter("mvcRenderCommandName", "/verify-email");
            verificationURL.setParameter("userId", String.valueOf(user.getUserId()));

            String verificationLink = verificationURL.toString();

            // Send verification email
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

            System.out.println("✅ Verification email sent to: " + user.getEmailAddress());
            System.out.println("🔗 Verification link: " + verificationLink);

        } catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
