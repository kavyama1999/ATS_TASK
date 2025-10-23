package AddAmbulancePortlet.portlet;

import AddAmbulancePortlet.constants.AddAmbulancePortletKeys;
import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    property = {
        "javax.portlet.name=" + AddAmbulancePortletKeys.ADDAMBULANCE,
        "mvc.command.name=/delete_ambulance"   // ✅ use consistent slash-style naming
    },
    service = MVCActionCommand.class
)
public class DeleteAmbulanceMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long ambulanceId = ParamUtil.getLong(actionRequest, "ambulanceId");

        try {
            if (ambulanceId > 0) {
                AmbulanceLocalServiceUtil.deleteAmbulance(ambulanceId);

                SessionMessages.add(actionRequest, "ambulance-delete-success");
            } else {
                SessionErrors.add(actionRequest, "ambulance-delete-error");
            }

        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "ambulance-delete-error");
        }

        // Redirect back to view.jsp
        actionResponse.setRenderParameter("jspPage", "/view.jsp");
    }
}
