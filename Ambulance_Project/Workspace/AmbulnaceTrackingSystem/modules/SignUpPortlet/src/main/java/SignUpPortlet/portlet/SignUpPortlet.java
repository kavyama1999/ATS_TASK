package SignUpPortlet.portlet;

import SignUpPortlet.constants.SignUpPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
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

//    @Override
//    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//            throws java.io.IOException, javax.portlet.PortletException {
//
//        // ✅ Check if user is visiting the verification page
//        String mvcRenderCommandName = ParamUtil.getString(renderRequest, "mvcRenderCommandName");
//
//        if ("/verify-email".equalsIgnoreCase(mvcRenderCommandName)) {
//
//            long userId = 0;
//
//            // ✅ Handle Liferay's namespaced parameter automatically
//            for (String param : renderRequest.getParameterMap().keySet()) {
//                if (param.endsWith("userId")) {
//                    userId = ParamUtil.getLong(renderRequest, param);
//                    break;
//                }
//            }
//
//            // ✅ Validate userId
//            if (userId <= 0) {
//                renderRequest.setAttribute("errorMessage", "Invalid or missing verification link.");
//                include("/verify_email.jsp", renderRequest, renderResponse);
//                return;
//            }
//
//            try {
//                User user = UserLocalServiceUtil.getUser(userId);
//
//                if (user == null) {
//                    renderRequest.setAttribute("errorMessage", "User not found or invalid link.");
//                    include("/verify_email.jsp", renderRequest, renderResponse);
//                    return;
//                }
//
//                // ✅ Pass user info to JSP
//                renderRequest.setAttribute("verifiedUser", user);
//                renderRequest.setAttribute("userId", userId);
//
//                // ✅ If already verified, show info
//                if (user.getStatus() == WorkflowConstants.STATUS_APPROVED) {
//                    renderRequest.setAttribute("alreadyVerified", true);
//                } else {
//                    renderRequest.setAttribute("showOTPForm", true);
//                }
//
//            } catch (Exception e) {
//                renderRequest.setAttribute("errorMessage", "Invalid verification link or user not found.");
//            }
//
//            // ✅ Render verification page
//            include("/verify_email.jsp", renderRequest, renderResponse);
//            return;
//        }
//
//        // ✅ Otherwise, show normal view.jsp
//        super.doView(renderRequest, renderResponse);
//    }
	
	
	
//private static final Log log = LogFactoryUtil.getLog(SignUpPortlet.class);
//	
//	@Override
//	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		// get the token and userId from url
//		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
//		HttpServletRequest originalRequest = PortalUtil.getOriginalServletRequest(httpRequest);
// 
//		String userIdStr = originalRequest.getParameter("userId");
//		long userId = 0;
//		if (userIdStr != null) {
//		    userId = Long.parseLong(userIdStr);
//		}
//		log.info("userId in doview  Portlet: "+userId);
//        
//        
//        renderRequest.setAttribute("userId", userId);
//        
//        
//		super.doView(renderRequest, renderResponse);
//	}
//}
	
}
