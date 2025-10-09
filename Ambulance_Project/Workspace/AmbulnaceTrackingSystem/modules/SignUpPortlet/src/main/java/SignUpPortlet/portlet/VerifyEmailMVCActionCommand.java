//package SignUpPortlet.portlet;
//
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.search.Indexer;
//import com.liferay.portal.kernel.search.IndexerRegistryUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.ServiceContextFactory;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//import org.osgi.service.component.annotations.Component;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//import java.util.Date;
//
//import SignUpPortlet.constants.SignUpPortletKeys;
//
//@Component(
//        immediate = true,
//        property = {
//                "javax.portlet.name=" + SignUpPortletKeys.SIGNUP,
//                "mvc.command.name=/verify-email"
//        },
//        service = MVCActionCommand.class
//)
//public class VerifyEmailMVCActionCommand implements MVCActionCommand {
//
//    @Override
//    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
//        try {
//            long userId = ParamUtil.getLong(actionRequest, "userId");
//            ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
//
//            if (userId <= 0) {
//                actionResponse.setRenderParameter("errorMessage", "Invalid verification link.");
//                return false;
//            }
//
//            User user = UserLocalServiceUtil.getUser(userId);
//            
//            System.out.println("🔍 Before verification:");
//            System.out.println("🔍 User ID: " + userId);
//            System.out.println("🔍 Status: " + user.getStatus());
//            System.out.println("🔍 Email Verified: " + user.isEmailAddressVerified());
//            System.out.println("🔍 Type: " + user.getType());
//
//            // ✅ Preserve the user type (1) while updating other fields
//            user.setEmailAddressVerified(true);
//            user.setPasswordModifiedDate(new Date());
//            
//            // Update user while preserving type
//            user = UserLocalServiceUtil.updateUser(user);
//            
//            // Update status to APPROVED
//            UserLocalServiceUtil.updateStatus(
//                user.getUserId(), 
//                WorkflowConstants.STATUS_APPROVED, 
//                serviceContext
//            );
//
//            // Get updated user to verify changes
//            user = UserLocalServiceUtil.getUser(userId);
//            
//            // Reindex for search
//            Indexer<User> indexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);
//            indexer.reindex(user);
//
//            System.out.println("✅ After verification:");
//            System.out.println("✅ User ID: " + userId);
//            System.out.println("✅ Status: " + user.getStatus());
//            System.out.println("✅ Email Verified: " + user.isEmailAddressVerified());
//            System.out.println("✅ Type: " + user.getType());
//            System.out.println("✅ Active: " + user.isActive());
//
//            actionResponse.setRenderParameter("successMessage",
//                "Your email has been verified successfully! You can now log in.");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            actionResponse.setRenderParameter("errorMessage",
//                "Email verification failed: " + e.getMessage());
//            return false;
//        }
//        return true;
//    }
//}