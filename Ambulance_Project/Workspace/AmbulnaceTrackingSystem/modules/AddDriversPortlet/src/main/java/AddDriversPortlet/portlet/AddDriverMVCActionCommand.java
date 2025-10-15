package AddDriversPortlet.portlet;

import AddDriversPortlet.constants.AddDriversPortletKeys;
import AddAmbulanceDb.model.Driver;
import AddAmbulanceDb.service.DriverLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Date;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + AddDriversPortletKeys.ADDDRIVERS,
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
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

            // ===== Get form parameters =====
            String firstName = ParamUtil.getString(actionRequest, "driverName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            if (lastName.isEmpty()) lastName = "N/A"; // Liferay requires lastName
            String fullName = firstName + " " + lastName;
            String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
            String email = ParamUtil.getString(actionRequest, "email");
            String address = ParamUtil.getString(actionRequest, "address");
            String password = ParamUtil.getString(actionRequest, "password");

            // ===== Basic validation =====
            if (firstName.isEmpty() || contactNumber.isEmpty() || email.isEmpty()
                    || address.isEmpty() || password.isEmpty()) {
                SessionErrors.add(actionRequest, "driver-add-error");
                log.error("❌ Validation failed: Missing required fields");
                return;
            }

            // ===== Create Liferay User =====
            long creatorUserId = themeDisplay.getUserId();
            long companyId = themeDisplay.getCompanyId();
            Locale locale = themeDisplay.getLocale();
            
            // Let Liferay auto-generate a unique screenName
            boolean autoScreenName = true;

            User user = UserLocalServiceUtil.addUser(
                    creatorUserId,
                    companyId,
                    false, // autoPassword = false
                    password,
                    password,
                    autoScreenName,
                    null, // screenName is ignored because autoScreenName = true
                    email,
                    locale,
                    firstName,
                    "", // middleName
                    lastName,
                    companyId, companyId, true, 1, 1, 1990, // birthday: Jan 1, 1990
                    "Ambulance Driver", // jobTitle
					1,
                    null, null, null, null, // groupIds, organizationIds, roleIds, userGroupIds
                    false, serviceContext
            );


            log.info("✅ Liferay user created successfully: " + user.getUserId());

            // ===== Create custom Driver record =====
            long driverId = CounterLocalServiceUtil.increment(Driver.class.getName());
            
            Driver driver = DriverLocalServiceUtil.createDriver(CounterLocalServiceUtil.increment(Driver.class.getName()));

            driver.setUserId(user.getUserId());
            driver.setDriverName(fullName);
            driver.setContactNumber(contactNumber);
            driver.setEmail(email);
            driver.setAddress(address);
            driver.setStatus("Active"); // or WorkflowConstants.STATUS_APPROVED if integer
            driver.setCreateDate(new Date());
            driver.setModifiedDate(new Date());

            DriverLocalServiceUtil.addDriver(driver); // saves to DB

            
            log.info("✅ Driver record saved successfully: " + fullName);

            SessionMessages.add(actionRequest, "driver-added-success");

            
            
            
        } catch (Exception e) {
            log.error("❌ Error while saving driver", e);
            SessionErrors.add(actionRequest, "driver-add-error");
        }
    }
}
