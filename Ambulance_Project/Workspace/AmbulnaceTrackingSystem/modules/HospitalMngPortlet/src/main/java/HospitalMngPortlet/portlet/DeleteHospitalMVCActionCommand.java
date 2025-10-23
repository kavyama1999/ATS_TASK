package HospitalMngPortlet.portlet;

import AddAmbulanceDb.service.HospitalLocalServiceUtil;
import HospitalMngPortlet.constants.HospitalMngPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HospitalMngPortletKeys.HOSPITALMNG,
        "mvc.command.name=deleteHospital"
    },
    service = MVCActionCommand.class
)
public class DeleteHospitalMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(DeleteHospitalMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long hospitalId = ParamUtil.getLong(actionRequest, "hospitalId");

        try {
            if (hospitalId > 0) {
                HospitalLocalServiceUtil.deleteHospital(hospitalId);
                SessionMessages.add(actionRequest, "hospital-deleted-success");
                log.info("Hospital deleted successfully -> ID: " + hospitalId);
            } else {
                SessionErrors.add(actionRequest, "invalid-hospital-id");
                log.error("Invalid hospital ID for delete: " + hospitalId);
            }

        } catch (Exception e) {
            SessionErrors.add(actionRequest, "hospital-delete-error");
            log.error("Error deleting hospital with ID: " + hospitalId, e);
        }
    }
}
