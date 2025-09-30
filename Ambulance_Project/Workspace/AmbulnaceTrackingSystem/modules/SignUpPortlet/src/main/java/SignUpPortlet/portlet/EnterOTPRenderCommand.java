package SignUpPortlet.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import SignUpPortlet.constants.SignUpPortletKeys;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
                "mvc.command.name=/enter-otp"
        },
        service = MVCRenderCommand.class
)
public class EnterOTPRenderCommand implements MVCRenderCommand {

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
        long userId = ParamUtil.getLong(renderRequest, "userId");
        String emailAddress = ParamUtil.getString(renderRequest, "emailAddress");
        String successMessage = ParamUtil.getString(renderRequest, "successMessage");
        String errorMessage = ParamUtil.getString(renderRequest, "errorMessage");

        renderRequest.setAttribute("userId", userId);
        renderRequest.setAttribute("emailAddress", emailAddress);
        renderRequest.setAttribute("successMessage", successMessage);
        renderRequest.setAttribute("errorMessage", errorMessage);

        return "/enter_otp.jsp";
    }
}
