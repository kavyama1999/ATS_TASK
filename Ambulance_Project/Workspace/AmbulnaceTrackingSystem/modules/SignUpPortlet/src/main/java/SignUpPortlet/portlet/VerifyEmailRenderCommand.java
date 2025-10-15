//package SignUpPortlet.portlet;
//
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//import org.osgi.service.component.annotations.Component;
//
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import java.util.Map;
//
//import SignUpPortlet.constants.SignUpPortletKeys;
//
//@Component(
//        immediate = true,
//        property = {
//                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
//                "mvc.command.name=/verify-email"
//        },
//        service = MVCRenderCommand.class
//)
//public class VerifyEmailRenderCommand implements MVCRenderCommand {
//
//    @Override
//    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
//
//    	
//        long userId = ParamUtil.getLong(renderRequest, "userId");
//
//        System.out.println("🔍 DEBUG: userId param = " + userId);
//        renderRequest.getParameterMap().forEach((k,v) -> System.out.println(k + " = " + String.join(",", v)));
//
//        // ✅ Fix for namespaced params (_SignUpPortlet_INSTANCE_xxx_userId)
//        if (userId <= 0) {
//            Map<String, String[]> params = renderRequest.getParameterMap();
//            for (String key : params.keySet()) {
//                if (key.endsWith("userId")) {
//                    try {
//                        userId = Long.parseLong(params.get(key)[0]);
//                        break;
//                    } catch (Exception ignored) {}
//                }
//            }
//        }
//
//        try {
//            if (userId <= 0) {
//                renderRequest.setAttribute("errorMessage", "Invalid or missing verification link.");
//                return "/verify_email.jsp";
//            }
//
//            // ✅ Get user safely
//            User user = UserLocalServiceUtil.fetchUser(userId);
//            if (user == null) {
//                renderRequest.setAttribute("errorMessage", "User not found or invalid link.");
//                return "/verify_email.jsp";
//            }
//
//            renderRequest.setAttribute("verifiedUser", user);
//            renderRequest.setAttribute("userId", userId);
//            renderRequest.setAttribute("emailAddress", user.getEmailAddress());
//
//            // ✅ Pass status
//            if (user.getStatus() == WorkflowConstants.STATUS_APPROVED) {
//                renderRequest.setAttribute("alreadyVerified", true);
//            } else {
//                renderRequest.setAttribute("showOTPForm", true);
//            }
//
//        } catch (Exception e) {
//            renderRequest.setAttribute("errorMessage", "Invalid user or verification link expired.");
//            e.printStackTrace();
//        }
//
//        return "/verify_email.jsp";
//    }
//}
