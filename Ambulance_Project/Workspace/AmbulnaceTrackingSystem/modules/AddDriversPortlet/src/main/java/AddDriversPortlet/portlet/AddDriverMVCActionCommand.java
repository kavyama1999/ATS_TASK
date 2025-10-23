

//package AddDriversPortlet.portlet;
//
//import AddDriversPortlet.constants.AddDriversPortletKeys;
//
//import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.model.Address;
//import com.liferay.portal.kernel.model.ListType;
//import com.liferay.portal.kernel.model.Role;
//import com.liferay.portal.kernel.model.User;
//import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
//import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
//import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
//import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
//import com.liferay.portal.kernel.service.ServiceContext;
//import com.liferay.portal.kernel.service.ServiceContextFactory;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.servlet.SessionErrors;
//import com.liferay.portal.kernel.servlet.SessionMessages;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.util.WebKeys;
//import com.liferay.portal.kernel.workflow.WorkflowConstants;
//
//import java.util.Locale;
//import java.util.Date;
//
//import javax.portlet.ActionRequest;
//import javax.portlet.ActionResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//import AddAmbulanceDb.model.Driver;
//import AddAmbulanceDb.service.DriverLocalServiceUtil;
//
//@Component(
//        immediate = true,
//        property = {
//                "javax.portlet.name=" + AddDriversPortletKeys.ADDDRIVERS,
//                "mvc.command.name=addDriver"
//        },
//        service = MVCActionCommand.class
//)
//public class AddDriverMVCActionCommand extends BaseMVCActionCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(AddDriverMVCActionCommand.class);
//
//    @Override
//    protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
//
//        try {
//            // 1️⃣ Get form fields
//            String firstName = ParamUtil.getString(actionRequest, "driverName");
//            String lastName = ParamUtil.getString(actionRequest, "lastName");
//            String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
//            String emailAddress = ParamUtil.getString(actionRequest, "email");
//            String password = ParamUtil.getString(actionRequest, "password");
//            String address = ParamUtil.getString(actionRequest, "address");
//
//            if (Validator.isNull(firstName) || Validator.isNull(lastName) ||
//                Validator.isNull(contactNumber) || Validator.isNull(emailAddress) ||
//                Validator.isNull(password) || Validator.isNull(address)) {
//
//                SessionErrors.add(actionRequest, "driver-add-error");
//                log.error("❌ Missing required fields");
//                return;
//            }
//
//            // 2️⃣ Get ThemeDisplay & ServiceContext
//            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
//
//            long companyId = themeDisplay.getCompanyId();
//            long creatorUserId = themeDisplay.getUserId();
//            Locale locale = themeDisplay.getLocale();
//            String screenName = emailAddress.split("@")[0];
//
//            // 3️⃣ Create Liferay user
//            User user = UserLocalServiceUtil.addUser(
//                creatorUserId,
//                companyId,
//                false, // autoPassword
//                password, password, // password1, password2
//                false, // autoScreenName
//                screenName, // screenName
//                emailAddress,
//                locale,
//                firstName, "", lastName,
//                0, 0, true, 1, 1, 1990, // birthdate
//                "Ambulance Driver",
//                1, new long[0], new long[0],
//                new long[0], new long[0],
//                false, // sendEmail
//                serviceContext
//            );
//
//            // 4️⃣ Activate user
//            user.setStatus(WorkflowConstants.STATUS_APPROVED);
//            user = UserLocalServiceUtil.updateUser(user);
//            log.info("✅ User created: " + user.getFullName());
//
//            // 5️⃣ Assign “Driver” role to user
//            String roleName = "Driver"; // exact name from Control Panel → Roles
//            Role driverRole = RoleLocalServiceUtil.getRole(companyId, roleName);
//            if (driverRole != null) {
//                UserLocalServiceUtil.addRoleUsers(driverRole.getRoleId(), new long[]{user.getUserId()});
//                log.info("🧩 Assigned 'Driver' role to userId: " + user.getUserId());
//            } else {
//                log.error("⚠️ Role 'Driver' not found in the system!");
//            }
//           
//         // Get default list types for address
//            ListType listType = ListTypeLocalServiceUtil.getListType(
//                themeDisplay.getCompanyId(), "Billing", // or "Shipping", etc. (or use ListTypeConstants)
//                com.liferay.portal.kernel.model.ListTypeConstants.ADDRESS
//            );
//
//            Address useraddress = AddressLocalServiceUtil.addAddress( "",
//            	user.getUserId(),        // userId performing the operation
//                user.getModelClassName(), // "com.liferay.portal.kernel.model.User"
//                user.getUserId(),                // primary key of the user
//                "",
//                "",
//                address,     // street1
//                "",              // street2
//                "",                    // street3
//                "Bangalore",            // city
//                "",                 // zip code
//                0l,                  // region (state)
//                101l,                   // countryId (use PortalUtil.getDefaultCountryId(companyId))
//                0l, // address type (billing/shipping/other)
//                false,                 // mailing
//                true,                  // primary
//                "1234567891",
//                serviceContext
//            );

//            log.info("✅ Address added to user: " + user.getFullName());
//            
////            // 6️⃣ Save driver details in custom Driver table
////            Driver driver = DriverLocalServiceUtil.createDriver(CounterLocalServiceUtil.increment(Driver.class.getName()));
////            driver.setDriverName(firstName + " " + lastName);
////            driver.setContactNumber(contactNumber);
////            driver.setEmail(emailAddress);
////            driver.setAddress(address);
////            driver.setUserId(user.getUserId());
////            driver.setCreateDate(new Date());
////            driver.setModifiedDate(new Date());
////            driver.setHospitalId(0);
////            driver.setAmbulanceId(0);
//
//            //Driver driver = DriverLocalServiceUtil.getInstance();
////          driver.setUserId(user.getUserId());
////          driver.setAddress(address);
////          driver.setContactNumber(contactNumber);
////          DriverLocalServiceUtil.addDriver(driver);
//            
////            DriverLocalServiceUtil.addDriver(driver);
//            log.info("🚗 Driver record saved successfully with userId: " + user.getUserId());
//
//            SessionMessages.add(actionRequest, "driver-added-success");
//
//        } catch (Exception e) {
//            log.error("❌ Error while creating driver user", e);
//            SessionErrors.add(actionRequest, "driver-add-error");
//        }
//    }
//}




package AddDriversPortlet.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.AddressLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.model.ListTypeConstants;

import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import AddDriversPortlet.constants.AddDriversPortletKeys;

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

        try {
            // 1️⃣ Get form fields
            String firstName = ParamUtil.getString(actionRequest, "driverName");
            String lastName = ParamUtil.getString(actionRequest, "lastName");
            String contactNumber = ParamUtil.getString(actionRequest, "contactNumber");
            String emailAddress = ParamUtil.getString(actionRequest, "email");
            String password = ParamUtil.getString(actionRequest, "password");
            String address = ParamUtil.getString(actionRequest, "address");

            if (Validator.isNull(firstName) || Validator.isNull(lastName) ||
                Validator.isNull(contactNumber) || Validator.isNull(emailAddress) ||
                Validator.isNull(password) || Validator.isNull(address)) {

                SessionErrors.add(actionRequest, "driver-add-error");
                log.error("❌ Missing required fields");
                return;
            }

            // 2️⃣ Get ThemeDisplay & ServiceContext
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);

            long companyId = themeDisplay.getCompanyId();
            long creatorUserId = themeDisplay.getUserId();
            Locale locale = themeDisplay.getLocale();
            String screenName = emailAddress.split("@")[0];

            // 3️⃣ Create Liferay user
            User user = UserLocalServiceUtil.addUser(
                creatorUserId,
                companyId,
                false, // autoPassword
                password, password, // password1, password2
                false, // autoScreenName
                screenName, // screenName
                emailAddress,
                locale,
                firstName, "", lastName,
                0, 0, true, 1, 1, 1990, // birthdate (dummy)
                "Ambulance Driver",
                1, new long[0], new long[0],
                new long[0], new long[0],
                false, // sendEmail
                serviceContext
            );

            // 4️⃣ Activate user
            user.setStatus(WorkflowConstants.STATUS_APPROVED);
            user = UserLocalServiceUtil.updateUser(user);
            log.info("✅ User created: " + user.getFullName());

            // 5️⃣ Assign “Driver” role to user
            String roleName = "Driver"; // exact name from Control Panel → Roles
            Role driverRole = RoleLocalServiceUtil.getRole(companyId, roleName);
            if (driverRole != null) {
                UserLocalServiceUtil.addRoleUsers(driverRole.getRoleId(), new long[]{user.getUserId()});
                log.info("🧩 Assigned 'Driver' role to userId: " + user.getUserId());
            } else {
                log.error("⚠️ Role 'Driver' not found in the system!");
            }

            // 6️⃣ Add address to Address_ table
            ListType addressListType = ListTypeLocalServiceUtil.getListType(
                creatorUserId, "billing", com.liferay.portal.kernel.model.ListTypeConstants.ADDRESS
            );

            Address useraddress = AddressLocalServiceUtil.addAddress( "",
                	user.getUserId(),        // userId performing the operation
                    user.getModelClassName(), // "com.liferay.portal.kernel.model.User"
                    user.getUserId(),                // primary key of the user
                    "",
                    "",
                    address,     // street1
                    "",              // street2
                    "",                    // street3
                    "Bangalore",            // city
                    "",                 // zip code
                    0l,                  // region (state)
                    101l,                   // countryId (use PortalUtil.getDefaultCountryId(companyId))
                    0l, // address type (billing/shipping/other)
                    false,                 // mailing
                    true,                  // primary
                    "",
                    serviceContext
                );


            log.info("✅ Address added to user: " + user.getFullName());

            // 7️⃣ Add phone number to Phone_ table
            
            /*
            try {
                ListType phoneListType = ListTypeLocalServiceUtil.getListType(
                    creatorUserId, "mobile-phone", com.liferay.portal.kernel.model.ListTypeConstants.PHONE
                );

                Phone phone = PhoneLocalServiceUtil.addPhone(
                    user.getUserId(),
                    user.getModelClassName(),
                    user.getUserId(),
                    contactNumber,
                    "",
                    phoneListType.getListTypeId(),
                    true, // primary phone
                    serviceContext
                );

                log.info("📞 Phone added for userId: " + user.getUserId() + " | Number: " + contactNumber);
            } catch (Exception e) {
                log.error("⚠️ Error adding phone: " + e.getMessage(), e);
            }
            
            */
            
            
            // 7️⃣ Add phone number to Phone_ table
         // 7️⃣ Add phone number to Phone_ table
            try {
                ListType phoneListType = null;

                try {
                    // Try getting "mobile" phone type (most common)
                    phoneListType = ListTypeLocalServiceUtil.getListType(
                    		creatorUserId, "mobile", ListTypeConstants.PHONE
                    );
                } catch (Exception ex) {
                    log.warn("⚠️ 'mobile' phone type not found, trying fallback...");
                }

                // Fallback — get any available phone type
                if (phoneListType == null) {
                    java.util.List<ListType> phoneTypes = ListTypeLocalServiceUtil.getListTypes(
                    		creatorUserId ,ListTypeConstants.PHONE
                    );
                    if (!phoneTypes.isEmpty()) {
                        phoneListType = phoneTypes.get(0);
                        log.info("📋 Using fallback phone type: " + phoneListType.getName());
                    }
                }

                if (phoneListType == null) {
                    throw new Exception("❌ No valid phone list type found in Liferay.");
                }

                Phone phone = PhoneLocalServiceUtil.addPhone(
                    user.getUserId(),
                    user.getModelClassName(),
                    user.getUserId(),
                    contactNumber,
                    "",
                    phoneListType.getListTypeId(),
                    true,
                    serviceContext
                );

                log.info("📞 Phone added successfully for userId: " + user.getUserId());
            } catch (Exception e) {
                log.error("⚠️ Error adding phone for userId: " + user.getUserId(), e);
            }



           log.info("🚑 Driver record saved successfully for userId: " + user.getUserId());

            // 9️⃣ Success message
            SessionMessages.add(actionRequest, "driver-added-success");

        } catch (Exception e) {
            log.error("❌ Error while creating driver user", e);
            SessionErrors.add(actionRequest, "driver-add-error");
        }
    }
}

