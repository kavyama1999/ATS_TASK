package HospitalMngPortlet.portlet;

import AddAmbulanceDb.model.Hospital;
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
        "mvc.command.name=updateHospital"
    },
    service = MVCActionCommand.class
)
public class UpdateHospitalMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(UpdateHospitalMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long hospitalId = ParamUtil.getLong(actionRequest, "hospitalId");

        try {
            Hospital hospital = HospitalLocalServiceUtil.fetchHospital(hospitalId);

            if (hospital == null) {
                SessionErrors.add(actionRequest, "hospital-not-found");
                log.error("Hospital not found for ID: " + hospitalId);
                return;
            }

            hospital.setHospitalName(ParamUtil.getString(actionRequest, "hospitalName"));
            hospital.setLocation(ParamUtil.getString(actionRequest, "location"));
            hospital.setAddress(ParamUtil.getString(actionRequest, "address"));
            hospital.setContactNumber(ParamUtil.getString(actionRequest, "contactNumber"));

            HospitalLocalServiceUtil.updateHospital(hospital);
            SessionMessages.add(actionRequest, "hospital-updated-success");
            log.info("Hospital updated successfully -> ID: " + hospitalId);

        } catch (Exception e) {
            SessionErrors.add(actionRequest, "hospital-update-error");
            log.error("Error updating hospital", e);
        }
    }
}
