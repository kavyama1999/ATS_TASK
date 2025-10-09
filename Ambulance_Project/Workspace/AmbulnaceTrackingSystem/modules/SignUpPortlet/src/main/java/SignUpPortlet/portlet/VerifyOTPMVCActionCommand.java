package SignUpPortlet.portlet;

import AmbulanceDb2.model.AmbSignUp;
import AmbulanceDb2.service.AmbSignUpLocalServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;
import java.util.List;

import SignUpPortlet.constants.SignUpPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
        "mvc.command.name=/action/signUp/verifyOTP"
    },
    service = MVCActionCommand.class
)
public class VerifyOTPMVCActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(VerifyOTPMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

    	log.info("Inside method for verifyOTP MVC Action coommand");
        try {
            String emailAddress = ParamUtil.getString(actionRequest, "emailAddress");
            String enteredOTP = ParamUtil.getString(actionRequest, "otp");

            List<AmbSignUp> allRecords = AmbSignUpLocalServiceUtil.getAmbSignUps(-1, -1);
            AmbSignUp matchedRecord = null;

            for (AmbSignUp record : allRecords) {
                if (record.getEmail().equalsIgnoreCase(emailAddress) && record.getOTP().equals(enteredOTP)) {
                    matchedRecord = record;
                    break;
                }
            }

            if (matchedRecord == null) {
                actionResponse.setRenderParameter("errorMessage", "Invalid or expired OTP. Please try again.");
                actionResponse.setRenderParameter("mvcRenderCommandName", "/enter-otp");
                actionResponse.setRenderParameter("emailAddress", emailAddress);
                return false;
            }

            // ✅ Change amb_ambsignup status from 1 → 0 after verification
            matchedRecord.setStatus(false); // false = 0
            matchedRecord.setModifiedDate(new Date());
            AmbSignUpLocalServiceUtil.updateAmbSignUp(matchedRecord);

            log.info("✅ OTP verified successfully for: " + emailAddress);
            log.info("✅ OTP : " + enteredOTP);


            // ✅ Also update user_ table → set status = 0 (active)
            try {
                User user = UserLocalServiceUtil.fetchUserByEmailAddress(
                        matchedRecord.getCompanyId(), emailAddress);

                if (user != null) {
                    user.setStatus(0); // active
                    UserLocalServiceUtil.updateUser(user);
                    log.info("✅ User table status updated to 0 for: " + emailAddress);
                } else {
                    log.warn("⚠️ User not found in user_ table for: " + emailAddress);
                }
            } catch (Exception e) {
                log.error("❌ Failed to update user table for: " + emailAddress, e);
            }

            // ✅ Redirect to home page with success message
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String homeURL = themeDisplay.getPortalURL() + themeDisplay.getPathMain();

            actionResponse.sendRedirect(homeURL + "?successMessage=Registration completed successfully!");
            return true;

        } catch (Exception e) {
            log.error("❌ OTP verification failed", e);
            actionResponse.setRenderParameter("errorMessage", "OTP verification failed: " + e.getMessage());
            actionResponse.setRenderParameter("mvcRenderCommandName", "/enter-otp");
            return false;
        }
    }
}
