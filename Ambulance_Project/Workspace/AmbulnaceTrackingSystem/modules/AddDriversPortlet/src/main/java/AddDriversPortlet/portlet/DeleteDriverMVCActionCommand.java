package AddDriversPortlet.portlet;

import AddDriversPortlet.constants.AddDriversPortletKeys;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AddDriversPortletKeys.ADDDRIVERS,
        "mvc.command.name=deleteDriver"
    },
    service = MVCActionCommand.class
)
public class DeleteDriverMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        long userId = ParamUtil.getLong(actionRequest, "driverId");

        try {
            User user = UserLocalServiceUtil.fetchUser(userId);

            if (user != null) {
                // Mark user as inactive
                user.setStatus(WorkflowConstants.STATUS_INACTIVE); 
                UserLocalServiceUtil.updateUser(user);

                SessionMessages.add(actionRequest, "driver-delete-success");
            } else {
                SessionErrors.add(actionRequest, "driver-not-found");
            }

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "driver-delete-error");
        }
    }
}
