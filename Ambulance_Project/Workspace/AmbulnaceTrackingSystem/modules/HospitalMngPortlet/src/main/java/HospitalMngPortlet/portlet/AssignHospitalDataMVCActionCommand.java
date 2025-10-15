package HospitalMngPortlet.portlet;

import AddAmbulanceDb.model.Ambulance;
import AddAmbulanceDb.model.Driver;
import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;
import AddAmbulanceDb.service.DriverLocalServiceUtil;
import HospitalMngPortlet.constants.HospitalMngPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HospitalMngPortletKeys.HOSPITALMNG,
        "mvc.command.name=assignHospitalData"
    },
    service = MVCActionCommand.class
)
public class AssignHospitalDataMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AssignHospitalDataMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {

    	

        log.info("Inside Assign Ambulance method");
        long hospitalId = ParamUtil.getLong(request, "hospitalId");
        long ambulanceId = ParamUtil.getLong(request, "ambulanceId");
        long driverId = ParamUtil.getLong(request, "driverId");

        log.info("🚑 Assigning => Hospital ID: " + hospitalId + ", Ambulance ID: " + ambulanceId + ", Driver ID: " + driverId);

        try {
            if (ambulanceId > 0) {
                Ambulance amb = AmbulanceLocalServiceUtil.getAmbulance(ambulanceId);
                amb.setHospitalId(hospitalId);
                amb.setDriverId(driverId);
                AmbulanceLocalServiceUtil.updateAmbulance(amb);
            }

            if (driverId > 0) {
                Driver drv = DriverLocalServiceUtil.getDriver(driverId);
                drv.setHospitalId(hospitalId);
                drv.setAmbulanceId(ambulanceId);
                DriverLocalServiceUtil.updateDriver(drv);
            }

            SessionMessages.add(request, "assign-success");

        } catch (Exception e) {
            log.error("❌ Error linking hospital, ambulance, and driver", e);
            SessionErrors.add(request, "assign-error");
        }
    }
}
