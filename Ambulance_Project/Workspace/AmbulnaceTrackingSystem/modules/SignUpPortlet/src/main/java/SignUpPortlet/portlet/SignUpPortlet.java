//package SignUpPortlet.portlet;
//
//import SignUpPortlet.constants.SignUpPortletKeys;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//
//import java.io.IOException;
//
//import javax.portlet.Portlet;
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * @author Admin
// */
//@Component(
//    property = {
//        "com.liferay.portlet.display-category=category.sample",
//        "com.liferay.portlet.header-portlet-css=/css/main.css",
//        "com.liferay.portlet.instanceable=true",
//        "javax.portlet.display-name=SignUp",
//        "javax.portlet.init-param.template-path=/",
//        "javax.portlet.init-param.view-template=/view.jsp",
//        "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
//        "javax.portlet.resource-bundle=content.Language",
//        "javax.portlet.security-role-ref=power-user,user"
//    },
//    service = Portlet.class
//)
//public class SignUpPortlet extends MVCPortlet {
//
//	@Override
//	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		System.out.println("test doview");
//		System.out.println("test doview");
//
//		super.doView(renderRequest, renderResponse);
//	}
//
//	


package SignUpPortlet.portlet;

import SignUpPortlet.constants.SignUpPortletKeys;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "com.liferay.portlet.display-category=category.sample",
        "com.liferay.portlet.header-portlet-css=/css/main.css",
        "com.liferay.portlet.instanceable=true",
        "javax.portlet.display-name=SignUp",
        "javax.portlet.init-param.template-path=/",
        "javax.portlet.init-param.view-template=/view.jsp",
        "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
        "javax.portlet.resource-bundle=content.Language",
        "javax.portlet.security-role-ref=power-user,user"
    },
    service = Portlet.class
)
public class SignUpPortlet extends MVCPortlet {

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {

        // Get the render parameter from the verification link
        String mvcRenderCommandName = ParamUtil.getString(renderRequest, "mvcRenderCommandName");
        System.out.println("Render command received: " + mvcRenderCommandName);

        if ("/verify-email".equals(mvcRenderCommandName)) {
            long userId = ParamUtil.getLong(renderRequest, "userId");

            // Handle namespaced param if userId is 0
            if (userId <= 0) {
                for (String key : renderRequest.getParameterMap().keySet()) {
                    if (key.endsWith("userId")) {
                        try {
                            userId = Long.parseLong(renderRequest.getParameter(key));
                            break;
                        } catch (Exception ignored) {}
                    }
                }
            }

            try {
                if (userId <= 0) {
                    renderRequest.setAttribute("errorMessage", "Invalid or missing verification link.");
                } else {
                    User user = UserLocalServiceUtil.fetchUser(userId);
                    if (user == null) {
                        renderRequest.setAttribute("errorMessage", "User not found or invalid link.");
                    } else {
                        renderRequest.setAttribute("verifiedUser", user);
                        renderRequest.setAttribute("userId", user.getUserId());
                        renderRequest.setAttribute("emailAddress", user.getEmailAddress());
                    }
                }
            } catch (Exception e) {
                renderRequest.setAttribute("errorMessage", "Error retrieving user: " + e.getMessage());
                e.printStackTrace();
            }

            // Include verify_email.jsp
            getPortletContext().getRequestDispatcher("/verify_email.jsp")
                    .include(renderRequest, renderResponse);
            
            return;
        }

        // Default view.jsp
        super.doView(renderRequest, renderResponse);
    }
}
