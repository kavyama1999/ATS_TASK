package HospitalMngPortlet.portlet;

import HospitalMngPortlet.constants.HospitalMngPortletKeys;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import AddAmbulanceDb.model.Ambulance;
import AddAmbulanceDb.model.Driver;
import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;
import AddAmbulanceDb.service.DriverLocalServiceUtil;
import HospitalMngPortlet.constants.HospitalMngPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * ✅ Handles adding a new Ambulance Driver.
 */
@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + HospitalMngPortletKeys.HOSPITALMNG,
        "mvc.command.name=addDriver"
    },
    service = MVCActionCommand.class
)
public class AddDriverMVCActionCommand extends BaseMVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AddDriverMVCActionCommand.class);

    @Override
    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        log.info("🧑‍✈️ AddDriverMVCActionCommand triggered");

        try {
            // Get form values
            String driverName = ParamUtil.getString(actionRequest, "driverName");
            String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
            String email = ParamUtil.getString(actionRequest, "email");
            String address = ParamUtil.getString(actionRequest, "address");

            // Validate inputs
            if (driverName.isEmpty() || contactNumber.isEmpty() || email.isEmpty() || address.isEmpty()) {
                SessionErrors.add(actionRequest, "driver-add-error");
                log.error("❌ Validation failed: Missing required fields");
                return;
            }

            // Create driver entry
            long driverId = CounterLocalServiceUtil.increment(Driver.class.getName());

            Driver driver = DriverLocalServiceUtil.createDriver(driverId);

            driver.setDriverName(driverName);
            driver.setContactNumber(contactNumber);
            driver.setEmail(email);
            driver.setAddress(address);
            driver.setCreateDate(new Date());
            driver.setModifiedDate(new Date());

            // Save to DB
            DriverLocalServiceUtil.addDriver(driver);

            SessionMessages.add(actionRequest, "driver-added-success");
            log.info("✅ Driver saved successfully -> Name: " + driverName);

        } catch (Exception e) {
            log.error("❌ Error while saving driver", e);
            SessionErrors.add(actionRequest, "driver-add-error");
        }
    }
}
