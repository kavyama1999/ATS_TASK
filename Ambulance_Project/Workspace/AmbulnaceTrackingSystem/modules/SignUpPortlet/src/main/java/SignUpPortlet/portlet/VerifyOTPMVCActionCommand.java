package SignUpPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import org.osgi.service.component.annotations.Component;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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

    private static final Log _log = LogFactoryUtil.getLog(VerifyOTPMVCActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        try {
            long userId = ParamUtil.getLong(actionRequest, "userId");
            String enteredOTP = ParamUtil.getString(actionRequest, "otp");

            if (userId <= 0) {
                actionResponse.setRenderParameter("errorMessage", "Invalid user ID. Please re-enter your email and resend the OTP.");
                actionResponse.setRenderParameter("mvcRenderCommandName", "/verify-email");
                return false;
            }

            User user = UserLocalServiceUtil.getUser(userId);

            if (user == null) {
                actionResponse.setRenderParameter("errorMessage", "User not found for ID: " + userId);
                actionResponse.setRenderParameter("mvcRenderCommandName", "/verify-email");
                return false;
            }

            String storedOTP = (String) user.getExpandoBridge().getAttribute("verificationOTP");

            // ✅ Validate OTP
            if (storedOTP == null || !enteredOTP.equals(storedOTP)) {
                actionResponse.setRenderParameter("errorMessage", "Invalid or expired OTP. Please try again.");
                actionResponse.setRenderParameter("mvcRenderCommandName", "/enter-otp");
                actionResponse.setRenderParameter("userId", String.valueOf(userId));
                return false;
            }

            // ✅ Activate user account
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
            UserLocalServiceUtil.updateStatus(userId, WorkflowConstants.STATUS_APPROVED, serviceContext);

            // ✅ Clear OTP fields
            user.getExpandoBridge().setAttribute("verificationOTP", "");
            user.getExpandoBridge().setAttribute("otpGeneratedTime", "");

            _log.info("✅ OTP verified successfully for userId: " + userId);

            // ✅ Redirect to home page
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String homeURL = themeDisplay.getPortalURL() + themeDisplay.getPathMain();
            actionResponse.sendRedirect(homeURL);

            return true;

        } catch (Exception e) {
            _log.error("❌ OTP verification failed", e);
            actionResponse.setRenderParameter("errorMessage", "OTP verification failed: " + e.getMessage());
            actionResponse.setRenderParameter("mvcRenderCommandName", "/enter-otp");
            return false;
        }
    }
}
