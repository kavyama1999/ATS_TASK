//package AddAmbulancePortlet.portlet;
//
//import AddAmbulanceDb.model.Ambulance;
//import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;
//import AddAmbulancePortlet.constants.AddAmbulancePortletKeys;
//
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + AddAmbulancePortletKeys.ADDAMBULANCE,
//        "mvc.command.name=addOrUpdateAmbulance" // Use the same name if combined add/update
//    },
//    service = MVCActionCommand.class
//)
//public class UpdateAmbulanceMVCActionCommand extends BaseMVCActionCommand {
//
//    @Override
//    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//
//        // Get the form values
//        long ambulanceId = ParamUtil.getLong(actionRequest, "ambulanceId");
//        String ambulanceNumber = ParamUtil.getString(actionRequest, "ambulanceNumber");
//        String vehicleType = ParamUtil.getString(actionRequest, "vehicleType");
//        String status = ParamUtil.getString(actionRequest, "status");
//        String location = ParamUtil.getString(actionRequest, "location");
//        String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
//        String driverName=ParamUtil.getString(actionRequest, "driverName");
//
//        try {
//            if (ambulanceId > 0) {
//                // Fetch existing ambulance
//                Ambulance ambulance = AmbulanceLocalServiceUtil.getAmbulance(ambulanceId);
//
//                // Update fields
//                ambulance.setAmbulanceNumber(ambulanceNumber);
//                ambulance.setVehicleType(vehicleType);
//                ambulance.setStatus(status);
//                ambulance.setLocation(location);
//                ambulance.setContactNumber(contactNumber);
//                ambulance.setDriverName(driverName);
//
//                // Persist changes
//                AmbulanceLocalServiceUtil.updateAmbulance(ambulance);
//
//                // Success message
//                SessionMessages.add(actionRequest, "ambulance-update-success");
//            } else {
//                // Optional: handle add new ambulance if ambulanceId == 0
//                SessionErrors.add(actionRequest, "invalid-ambulance-id");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            SessionErrors.add(actionRequest, "ambulance-update-error");
//        }
//
//        // Redirect back to the view page after update
//        actionResponse.setRenderParameter("jspPage", "/view.jsp");
//    }
//}
package AddAmbulancePortlet.portlet;

import AddAmbulanceDb.model.Ambulance;
import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;
import AddAmbulancePortlet.constants.AddAmbulancePortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.model.User;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AddAmbulancePortletKeys.ADDAMBULANCE,
        "mvc.command.name=addOrUpdateAmbulance"
    },
    service = MVCActionCommand.class
)
public class UpdateAmbulanceMVCActionCommand extends BaseMVCActionCommand {

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        long ambulanceId = ParamUtil.getLong(actionRequest, "ambulanceId");
        String ambulanceNumber = ParamUtil.getString(actionRequest, "ambulanceNumber");
        String vehicleType = ParamUtil.getString(actionRequest, "vehicleType");
        String status = ParamUtil.getString(actionRequest, "status");
        String location = ParamUtil.getString(actionRequest, "location");
        String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
        long driverId = ParamUtil.getLong(actionRequest, "driverId"); // from dropdown

        try {
            if (ambulanceId > 0) {
                Ambulance ambulance = AmbulanceLocalServiceUtil.getAmbulance(ambulanceId);

                ambulance.setAmbulanceNumber(ambulanceNumber);
                ambulance.setVehicleType(vehicleType);
                ambulance.setStatus(status);
                ambulance.setLocation(location);
                ambulance.setContactNumber(contactNumber);

                // ✅ Fetch driver full name and store it
                if (driverId > 0) {
                    User driver = UserLocalServiceUtil.fetchUser(driverId);
                    if (driver != null) {
                        ambulance.setDriverName(driver.getFullName());
                    }
                } else {
                    ambulance.setDriverName(""); // if no driver selected
                }

                AmbulanceLocalServiceUtil.updateAmbulance(ambulance);

                SessionMessages.add(actionRequest, "ambulance-update-success");
            } else {
                SessionErrors.add(actionRequest, "invalid-ambulance-id");
            }
        } catch (Exception e) {
            e.printStackTrace();
            SessionErrors.add(actionRequest, "ambulance-update-error");
        }

        actionResponse.setRenderParameter("jspPage", "/view.jsp");
    }
}
