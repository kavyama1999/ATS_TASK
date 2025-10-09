package HospitalMngPortlet.portlet;

import AddAmbulanceDb.model.Hospital;
import AddAmbulanceDb.service.HospitalLocalServiceUtil;
import HospitalMngPortlet.constants.HospitalMngPortletKeys;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * ✅ Handles the "Register Hospital" form submission and saves data to the database.
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HospitalMngPortletKeys.HOSPITALMNG,
        "mvc.command.name=/add_hospital",
//        "hide-default-success-message=true"

    },
    service = MVCActionCommand.class
)
public class AddHospitalMVCActionCommand extends BaseMVCActionCommand {

    private static final Log _log = LogFactoryUtil.getLog(AddHospitalMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {

        _log.info("🚀 AddHospitalMVCActionCommand triggered");

        try {
            //  Get form parameters
            String hospitalName = ParamUtil.getString(actionRequest, "hospitalName");
            String location = ParamUtil.getString(actionRequest, "location");
            String address = ParamUtil.getString(actionRequest, "address");
            String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");

            _log.info("📋 Received data -> Name: " + hospitalName + ", Location: " + location + ", Contact: " + contactNumber);

            //  Validate mandatory fields
            if (hospitalName.isEmpty() || location.isEmpty() || address.isEmpty() || contactNumber.isEmpty()) {
                SessionErrors.add(actionRequest, "hospital-add-error");
                _log.error("❌ Validation failed — missing required fields");
                return;
            }

            //  Get context details (user, company, group)
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Hospital.class.getName(), actionRequest);

            //  Create a new Hospital object
            long hospitalId = CounterLocalServiceUtil.increment(Hospital.class.getName());
            Hospital hospital = HospitalLocalServiceUtil.createHospital(hospitalId);

            hospital.setGroupId(themeDisplay.getScopeGroupId());
            hospital.setCompanyId(themeDisplay.getCompanyId());
            hospital.setUserId(themeDisplay.getUserId());
            hospital.setUserName(themeDisplay.getUser().getFullName());
            hospital.setCreateDate(new Date());
            hospital.setModifiedDate(new Date());

            hospital.setHospitalName(hospitalName.trim());
            hospital.setLocation(location.trim());
            hospital.setAddress(address.trim());
            hospital.setContactNumber(contactNumber.trim());

            //  Save to database
            HospitalLocalServiceUtil.addHospital(hospital);

            // Add success message
            SessionMessages.add(actionRequest, "hospital-added-success");
            _log.info("✅ Hospital saved successfully -> ID: " + hospitalId + ", Name: " + hospitalName +", Location:" + location + ","
            		+ "Address :"+address+ ",ContactNumber :"+contactNumber);

        } catch (Exception e) {
            _log.error("❌ Error while saving hospital", e);
            SessionErrors.add(actionRequest, "hospital-add-error");
        }
    }
}
