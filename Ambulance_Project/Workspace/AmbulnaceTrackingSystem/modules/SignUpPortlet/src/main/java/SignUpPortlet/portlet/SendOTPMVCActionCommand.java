package SignUpPortlet.portlet;

import AmbulanceDb2.model.AmbSignUp;
import AmbulanceDb2.service.AmbSignUpLocalServiceUtil;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

import java.util.Date;
import java.util.List;
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

    private static final Log _log = LogFactoryUtil.getLog(SendOTPMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            // ✅ 1️⃣ Get parameters
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            long userId = ParamUtil.getLong(actionRequest, "userId");

            // ✅ 2️⃣ Validate email format
            if (!Validator.isEmailAddress(emailAddress)) {
                actionResponse.setRenderParameter("mvcRenderCommandName", "/verify-email");
                actionResponse.setRenderParameter("errorMessage", "Invalid email format. Please enter a valid email address.");
                actionResponse.setRenderParameter("userId", String.valueOf(userId));
                return false;
            }

            // ✅ 3️⃣ Check user validity
            User user;
            try {
                user = UserLocalServiceUtil.getUser(userId);
            } catch (Exception e) {
                _log.error("❌ Invalid userId: " + userId, e);
                actionResponse.setRenderParameter("mvcRenderCommandName", "/verify-email");
                actionResponse.setRenderParameter("errorMessage", "Invalid verification link or user not found.");
                return false;
            }

            // ✅ 4️⃣ Ensure entered email matches registered one
            if (user == null || !user.getEmailAddress().equalsIgnoreCase(emailAddress)) {
                _log.warn("⚠️ Entered email does not match registered email for userId: " + userId);
                actionResponse.setRenderParameter("mvcRenderCommandName", "/verify-email");
                actionResponse.setRenderParameter("errorMessage", "Invalid email! Please enter the same email you registered with.");
                actionResponse.setRenderParameter("userId", String.valueOf(userId));
                return false;
            }

            // ✅ 5️⃣ Generate OTP
            String otp = generateOTP();

            // ✅ 6️⃣ Send OTP via Email
            sendOTPEmail(emailAddress, otp);

            // ✅ 7️⃣ Save / update AmbSignUp record
            ServiceContext serviceContext = ServiceContextFactory.getInstance(AmbSignUp.class.getName(), actionRequest);

            // Delete previous OTPs for same email (clean old records)
            List<AmbSignUp> existingRecords = AmbSignUpLocalServiceUtil.getAmbSignUps(-1, -1);
            for (AmbSignUp record : existingRecords) {
                if (record.getEmail().equalsIgnoreCase(emailAddress)) {
                    AmbSignUpLocalServiceUtil.deleteAmbSignUp(record);
                }
            }

            // Create new OTP record
            AmbSignUp ambSignUp = AmbSignUpLocalServiceUtil.createAmbSignUp(0);
            ambSignUp.setCompanyId(themeDisplay.getCompanyId());
            ambSignUp.setGroupId(themeDisplay.getScopeGroupId());
            ambSignUp.setUserId(userId);
            ambSignUp.setCreateDate(new Date());
            ambSignUp.setModifiedDate(new Date());
            ambSignUp.setEmail(emailAddress);
            ambSignUp.setOTP(otp);
            ambSignUp.setStatus(true); // 1 = Active (OTP generated)

            AmbSignUpLocalServiceUtil.addAmbSignUp(ambSignUp);

            _log.info("✅ OTP generated and saved for email: " + emailAddress + ", userId=" + userId);

            // ✅ 8️⃣ Redirect user to OTP entry page
            actionResponse.setRenderParameter("mvcRenderCommandName", "/enter-otp");
            actionResponse.setRenderParameter("emailAddress", emailAddress);
            actionResponse.setRenderParameter("userId", String.valueOf(userId));
            actionResponse.setRenderParameter("successMessage", "OTP sent successfully to your registered email address.");

        } catch (Exception e) {
            _log.error("❌ Failed to send OTP", e);
            actionResponse.setRenderParameter("mvcRenderCommandName", "/verify-email");
            actionResponse.setRenderParameter("errorMessage", "Failed to send OTP. Please try again.");
            return false;
        }

        return true;
    }

    // ✅ Helper method: Generate 6-digit OTP
    private String generateOTP() {
        return String.valueOf(100000 + new Random().nextInt(900000));
    }

    // ✅ Helper method: Send OTP email
    private void sendOTPEmail(String emailAddress, String otp) {
        try {
            String subject = "Your OTP for Email Verification";
            String body = "<html><body style='font-family: Arial, sans-serif;'>"
                    + "<h3>Hello,</h3>"
                    + "<p>Your One Time Password (OTP) for email verification is:</p>"
                    + "<h2 style='color:#007bff;'>" + otp + "</h2>"
                    + "<p>This OTP is valid for 10 minutes.</p>"
                    + "<p>If you did not request this, please ignore this email.</p>"
                    + "<hr><p style='font-size:12px;color:#999;'>© 2025 SOS Ambulance Portal</p>"
                    + "</body></html>";

            InternetAddress from = new InternetAddress("kavyama1408@gmail.com", "SOS Ambulance Portal");
            InternetAddress to = new InternetAddress(emailAddress);

            MailMessage mailMessage = new MailMessage(from, to, subject, body, true);
            MailServiceUtil.sendEmail(mailMessage);

            _log.info("📧 OTP email sent successfully to: " + emailAddress);
        } catch (Exception e) {
            _log.error("❌ Error sending OTP email to: " + emailAddress, e);
        }
    }
}
