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
import org.osgi.service.component.annotations.Component;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Random;

import SignUpPortlet.constants.SignUpPortletKeys;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
                "mvc.command.name=/action/signUp/sendOTP"
        },
        service = MVCActionCommand.class
)
public class SendOTPMVCActionCommand implements MVCActionCommand {

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            long userId = ParamUtil.getLong(actionRequest, "userId");

            if (!Validator.isEmailAddress(emailAddress)) {
                actionResponse.setRenderParameter("errorMessage", "Invalid email address");
                return false;
            }

            // Fetch the user by ID or email
            User user = null;
            if (userId > 0) {
                user = UserLocalServiceUtil.getUser(userId);
            } else {
                user = UserLocalServiceUtil.getUserByEmailAddress(themeDisplay.getCompanyId(), emailAddress);
            }

            if (user == null) {
                actionResponse.setRenderParameter("errorMessage", "User not found.");
                return false;
            }

            // ✅ Generate OTP
            String otp = generateOTP();
            long otpGeneratedTime = System.currentTimeMillis();

            // ✅ Update Expando attributes securely using admin service context
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
            user = UserLocalServiceUtil.updateUser(user); // refresh
            user.getExpandoBridge().setAttribute("verificationOTP", otp, false);
            user.getExpandoBridge().setAttribute("otpGeneratedTime", String.valueOf(otpGeneratedTime), false);
            UserLocalServiceUtil.updateUser(user); // persist update

            // ✅ Send OTP email
            sendOTPEmail(user, otp);

            System.out.println("✅ OTP sent successfully to: " + user.getEmailAddress());
            System.out.println("🔢 OTP: " + otp);

            // Redirect to OTP entry page
            actionResponse.setRenderParameter("mvcRenderCommandName", "/enter-otp");
            actionResponse.setRenderParameter("userId", String.valueOf(user.getUserId()));
            actionResponse.setRenderParameter("successMessage", "OTP sent successfully to your registered email.");

        } catch (Exception e) {
            e.printStackTrace();
            actionResponse.setRenderParameter("errorMessage", "Failed to send OTP: " + e.getMessage());
            return false;
        }

        return true;
    }

    private String generateOTP() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    private void sendOTPEmail(User user, String otp) {
        try {
            String subject = "Your OTP for Email Verification";
            String body = "<html><body style='font-family: Arial, sans-serif;'>"
                    + "<h3>Hello " + user.getFullName() + ",</h3>"
                    + "<p>Your One Time Password (OTP) for email verification is:</p>"
                    + "<h2 style='color:#007bff;'>" + otp + "</h2>"
                    + "<p>This OTP is valid for 10 minutes.</p>"
                    + "<p>If you did not request this, please ignore this email.</p>"
                    + "<hr><p style='font-size:12px;color:#999;'>SOS Ambulance Portal</p>"
                    + "</body></html>";

            InternetAddress from = new InternetAddress("kavyama1408@gmail.com", "SOS Ambulance Portal");
            InternetAddress to = new InternetAddress(user.getEmailAddress());

            MailMessage mailMessage = new MailMessage();
            mailMessage.setFrom(from);
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setBody(body);
            mailMessage.setHTMLFormat(true);

            MailServiceUtil.sendEmail(mailMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
