package SignUpPortlet.portlet;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import SignUpPortlet.constants.SignUpPortletKeys;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
                "mvc.command.name=/verify-email"
        },
        service = MVCRenderCommand.class
)
public class VerifyEmailRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        long userId = ParamUtil.getLong(renderRequest, "userId");
        
        try {
            User user = UserLocalServiceUtil.getUser(userId);
            renderRequest.setAttribute("user", user);
            renderRequest.setAttribute("userId", userId);
            
            // Check if user is already verified
            if (user.getStatus() == WorkflowConstants.STATUS_APPROVED) {
                renderRequest.setAttribute("alreadyVerified", true);
            } else {
                renderRequest.setAttribute("showOTPForm", true);
            }
            
        } catch (Exception e) {
            renderRequest.setAttribute("error", "Invalid user ID or user not found");
            e.printStackTrace();
        }
        
        return "/verify_email.jsp";
    }
}