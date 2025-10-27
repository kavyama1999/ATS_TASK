//package AddAmbulancePortlet.portlet;
//
//import AddAmbulanceDb.model.Ambulance;
//import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;
//
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.WebKeys;
//import AddAmbulancePortlet.constants.AddAmbulancePortletKeys;
//
//
//import java.util.Date;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//
//import org.osgi.service.component.annotations.Component;
//
///**
// * ✅ Handles adding a new ambulance.
// */
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + AddAmbulancePortletKeys.ADDAMBULANCE,
//        "mvc.command.name=addAmbulance"
//    },
//    service = MVCActionCommand.class
//)
//public class AddAmbulanceMVCActionCommand extends BaseMVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(AddAmbulanceMVCActionCommand.class);
//
//    @Override
//    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//
//        log.info("🚑 AddAmbulanceMVCActionCommand triggered");
//
//        try {
//            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//
//            // Get form values
//            String ambulanceNumber = ParamUtil.getString(actionRequest, "ambulanceNumber");
//            String vehicleType = ParamUtil.getString(actionRequest, "vehicleType");
//            String status = ParamUtil.getString(actionRequest, "status");
//            String location = ParamUtil.getString(actionRequest, "location");
//            String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
//           String driverName=ParamUtil.getString(actionRequest, "driverName");
//
//            // Validate inputs
//            if (ambulanceNumber.isEmpty() || vehicleType.isEmpty() || status.isEmpty()) {
//                SessionErrors.add(actionRequest, "ambulance-add-error");
//                log.error("❌ Validation failed: Missing required fields");
//                return;
//            }
//
//            // Create ambulance entry
//            long ambulanceId = CounterLocalServiceUtil.increment(Ambulance.class.getName());
//
//            Ambulance ambulance = AmbulanceLocalServiceUtil.createAmbulance(ambulanceId);
//
//            // You can set hospitalId later after assigning — right now set to 0 if not available
//            ambulance.setHospitalId(0);
//            ambulance.setDriverId(0);
//            ambulance.setAmbulanceNumber(ambulanceNumber);
//            ambulance.setVehicleType(vehicleType);
//            ambulance.setStatus(status);
//            ambulance.setLocation(location);
//            ambulance.setContactNumber(contactNumber);
//            ambulance.setCreateDate(new Date());
//            ambulance.setModifiedDate(new Date());
//            ambulance.setDriverName(driverName);
//
//            // Save to DB
//            AmbulanceLocalServiceUtil.addAmbulance(ambulance);
//
//            SessionMessages.add(actionRequest, "ambulance-added-success");
//            log.info("✅ Ambulance saved successfully -> Number: " + ambulanceNumber);
//            log.info("✅ Ambulance saved successfully -> Number: " + ambulance);
//
//        } catch (Exception e) {
//            log.error("❌ Error while saving ambulance", e);
//            SessionErrors.add(actionRequest, "ambulance-add-error");
//        }
//    }
//}



package AddAmbulancePortlet.portlet;

import AddAmbulanceDb.model.Ambulance;
import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.model.User;

import AddAmbulancePortlet.constants.AddAmbulancePortletKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AddAmbulancePortletKeys.ADDAMBULANCE,
        "mvc.command.name=/addAmbulance"
    },
    service = MVCActionCommand.class
)
public class AddAmbulanceMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AddAmbulanceMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        log.info("🚑 AddAmbulanceMVCActionCommand triggered");

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            // Get form values
            String ambulanceNumber = ParamUtil.getString(actionRequest, "ambulanceNumber");
            String vehicleType = ParamUtil.getString(actionRequest, "vehicleType");
            String status = ParamUtil.getString(actionRequest, "status");
            String location = ParamUtil.getString(actionRequest, "location");
            String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
            long driverId = ParamUtil.getLong(actionRequest, "driverId");

            // Validate inputs
            if (ambulanceNumber.isEmpty() || vehicleType.isEmpty() || status.isEmpty() || driverId == 0) {
                SessionErrors.add(actionRequest, "ambulance-add-error");
                log.error("❌ Validation failed: Missing required fields");
                return;
            }

            // ✅ Fetch driver name
            String driverName = "";
            try {
                User driverUser = UserLocalServiceUtil.getUser(driverId);
                driverName = driverUser.getFullName();
            } catch (Exception e) {
                log.warn("⚠️ Unable to fetch driver name for userId: " + driverId);
            }

            // ✅ Create ambulance entry
            long ambulanceId = CounterLocalServiceUtil.increment(Ambulance.class.getName());
            Ambulance ambulance = AmbulanceLocalServiceUtil.createAmbulance(ambulanceId);

            ambulance.setHospitalId(0);
            ambulance.setDriverId(driverId);
            ambulance.setDriverName(driverName);
            ambulance.setAmbulanceNumber(ambulanceNumber);
            ambulance.setVehicleType(vehicleType);
            ambulance.setStatus(status);
            ambulance.setLocation(location);
            ambulance.setContactNumber(contactNumber);
            ambulance.setCreateDate(new Date());
            ambulance.setModifiedDate(new Date());

            // ✅ Save to DB
            AmbulanceLocalServiceUtil.addAmbulance(ambulance);

            SessionMessages.add(actionRequest, "ambulance-added-success");
            log.info("✅ Ambulance saved successfully with driver: " + driverName);

        } catch (Exception e) {
            log.error("❌ Error while saving ambulance", e);
            SessionErrors.add(actionRequest, "ambulance-add-error");
        }
    }
}
