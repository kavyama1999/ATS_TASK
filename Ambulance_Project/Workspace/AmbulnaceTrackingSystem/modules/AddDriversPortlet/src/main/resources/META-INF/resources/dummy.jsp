<%-- <%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>ADD DRIVERS</h2>

<liferay-ui:success key="driver-added-success" message="Driver added successfully!" />
<liferay-ui:error key="driver-add-error" message="Failed to add driver. Please try again." />


<marquee behavior="scroll" direction="left" style="font-size:24px; font-weight:bold; color:#007bff; margin-bottom:15px;">
    🚗 Driver Management 🚗
</marquee>


<portlet:renderURL var="driverRegisterPageURL">
    <portlet:param name="jspPage" value="/addDriver.jsp" />
</portlet:renderURL>


<div style="display:flex; gap:30px; margin-bottom:20px;">
   
    <a href="${driverRegisterPageURL}" class="btn btn-primary">Add Drivers</a>
</div>

 --%>
 
 
 package AddDriversPortlet.portlet;

import AddDriversPortlet.constants.AddDriversPortletKeys;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
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

import java.util.Locale;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import AddAmbulanceDb.model.Driver;
import AddAmbulanceDb.service.DriverLocalServiceUtil;

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
                0, 0, true, 1, 1, 1990, // birthdate
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
           
         // Get default list types for address
            ListType listType = ListTypeLocalServiceUtil.getListType(
                themeDisplay.getCompanyId(), "Billing", // or "Shipping", etc. (or use ListTypeConstants)
                com.liferay.portal.kernel.model.ListTypeConstants.ADDRESS
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
                "Bengaluru",            // city
                "",                 // zip code
                0l,                  // region (state)
                101l,                   // countryId (use PortalUtil.getDefaultCountryId(companyId))
                0l, // address type (billing/shipping/other)
                false,                 // mailing
                true,                  // primary
              " 1234567891",
                serviceContext
            );

            log.info("✅ Address added to user: " + user.getFullName());
            
            
//            ✅ Now save phone number separately into Phone table
            Phone phone = PhoneLocalServiceUtil.addPhone(
               user.getUserId(),                          // user performing the action
                user.getModelClassName(),         // class name
                user.getUserId(),                 // primary key (user)
                contactNumber,                    // number from form
                "91",                             // extension (e.g. country code)
                11008,                            // typeId (usually 'Personal' or 'Business')
                true,                             // primary
                serviceContext
            );
            // 6️⃣ Save driver details in custom Driver table
//            Driver driver = DriverLocalServiceUtil.createDriver(CounterLocalServiceUtil.increment(Driver.class.getName()));
//            driver.setDriverName(firstName + " " + lastName);
//            driver.setContactNumber(contactNumber);
//            driver.setEmail(emailAddress);
//            driver.setAddress(address);
//            driver.setUserId(user.getUserId());
//            driver.setCreateDate(new Date());
//            driver.setModifiedDate(new Date());
//            driver.setHospitalId(0);
//            driver.setAmbulanceId(0);

            //Driver driver = DriverLocalServiceUtil.getInstance();
//          driver.setUserId(user.getUserId());
//          driver.setAddress(address);
//          driver.setContactNumber(contactNumber);
//          DriverLocalServiceUtil.addDriver(driver);
            
            //DriverLocalServiceUtil.addDriver(driver);
            log.info("🚗 Driver record saved successfully with userId: " + user.getUserId());

            SessionMessages.add(actionRequest, "driver-added-success");

        } catch (Exception e) {
            log.error("❌ Error while creating driver user", e);
            SessionErrors.add(actionRequest, "driver-add-error");
        }
    }
}
 ]
 
 
 =========================================================================
 =========================================================================
 <%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="AddAmbulanceDb.model.Driver" %>
<%@ page import="AddAmbulanceDb.service.DriverLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="java.util.List" %>

<%@ page import="com.liferay.portal.kernel.model.Address" %>


<portlet:renderURL var="driverRegisterPageURL">
    <portlet:param name="jspPage" value="/addDriver.jsp" />
</portlet:renderURL>


<div style="display:flex; gap:30px; margin-bottom:20px;">
   
    <a href="${driverRegisterPageURL}" class="btn btn-primary">Add Drivers</a>
</div>


<h2>🚑 Driver List</h2>

<liferay-ui:success key="driver-added-success" message="Driver added successfully!" />
<liferay-ui:error key="driver-add-error" message="Failed to add driver. Please try again." />

<%
    // ✅ Get ThemeDisplay properly
    ThemeDisplay themeDisplay1 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    long companyId = themeDisplay1.getCompanyId();
    String roleName = "Driver"; // must match the role name in Liferay Control Panel

    List<User> driverUsers = null;

    try {
        // ✅ 1. Fetch the "Driver" role
        Role driverRole = RoleLocalServiceUtil.getRole(companyId, roleName);

        // ✅ 2. Fetch all users who have that role
        driverUsers = UserLocalServiceUtil.getRoleUsers(driverRole.getRoleId());

    } catch (Exception e) {
        out.println("<div style='color:red;'>⚠️ Error fetching driver users: " + e.getMessage() + "</div>");
    }

    if (driverUsers == null || driverUsers.isEmpty()) {
%>
        <p style="color:gray;">No drivers found with the 'Driver' role.</p>
<%
    } else {
%>

<table class="table table-bordered table-hover table-striped" style="width:100%; margin-top:15px;">
    <thead style="background-color:#007bff; color:white;">
        <tr>
            <th>Driver Name</th>
            <th>Email</th>
            <th>Status</th>
            <th>Contact Number</th>
            <th>Address</th>
        </tr>
    </thead>
    <tbody>
<%
        for (User driver : driverUsers) {

            
	  String driverName = driver.getFullName();
            String email = driver.getEmailAddress();

            String contactNumber = (driver != null && driver.getPhones().size() > 0)
                    ? driver.getPhones().get(0).toString()
                    : "N/A";

           /*  String address = (driver != null && driver.getAddresses().size() > 0)
                    ? driver.getAddresses().get(0).toString()
                    : "N/A";
 */
 
 String address = "N/A";
 if (Validator.isNotNull(driver.getAddresses()) && !driver.getAddresses().isEmpty()) {
     Address addr = driver.getAddresses().get(0);
     address = Validator.isNotNull(addr.getStreet1()) ? addr.getStreet1() : "N/A";
 }
            String status = driver.isActive() ? "Active" : "Inactive";
%>
        <tr>
            <td><%= driverName %></td>
            <td><%= email %></td>
            <td style="font-weight:bold; color:<%= driver.isActive() ? "green" : "red" %>;"><%= status %></td>
            <td><%= contactNumber %></td>
            <td><%= address %></td>
        </tr>
<%
        } // end for
%>
    </tbody>
</table>

<%
    } // end else
%>
 ==========================================================
 
 <%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.model.Address" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.AddressLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="java.util.List" %>

<portlet:renderURL var="driverRegisterPageURL">
    <portlet:param name="jspPage" value="/addDriver.jsp" />
</portlet:renderURL>

<div style="display:flex; gap:30px; margin-bottom:20px;">
    <a href="${driverRegisterPageURL}" class="btn btn-primary">Add Drivers</a>
</div>

<h2>🚑 Driver List</h2>

<liferay-ui:success key="driver-added-success" message="Driver added successfully!" />
<liferay-ui:error key="driver-add-error" message="Failed to add driver. Please try again." />

<%
    ThemeDisplay themeDisplay1 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    long companyId = themeDisplay1.getCompanyId();
    String roleName = "Driver";

    List<User> driverUsers = null;

    try {
        Role driverRole = RoleLocalServiceUtil.getRole(companyId, roleName);
        driverUsers = UserLocalServiceUtil.getRoleUsers(driverRole.getRoleId());
    } catch (Exception e) {
        out.println("<div style='color:red;'>⚠️ Error fetching driver users: " + e.getMessage() + "</div>");
    }

    if (driverUsers == null || driverUsers.isEmpty()) {
%>
        <p style="color:gray;">No drivers found with the 'Driver' role.</p>
<%
    } else {
%>

<table class="table table-bordered table-hover table-striped" style="width:100%; margin-top:15px;">
    <thead style="background-color:#007bff; color:white;">
        <tr>
            <th>Driver Name</th>
            <th>Email</th>
            <th>Status</th>
            <th>Address</th>
        </tr>
    </thead>
    <tbody>
<%
        for (User driver : driverUsers) {

            String driverName = driver.getFullName();
            String email = driver.getEmailAddress();

            // Fetch address from Address table based on userId
            String address = "N/A";
            try {
                List<Address> addresses = AddressLocalServiceUtil.getAddresses();
                if (addresses != null && !addresses.isEmpty()) {
                    for (Address addr : addresses) {
                        if (addr != null && Validator.isNotNull(addr.getStreet1())) {
                            address = addr.getStreet1(); // fetch street1 column
                            break; // only the first address
                        }
                    }
                }
            } catch (Exception e) {
                address = "N/A";
            }

            String status = driver.isActive() ? "Active" : "Inactive";
%>
        <tr>
            <td><%= driverName %></td>
            <td><%= email %></td>
            <td style="font-weight:bold; color:<%= driver.isActive() ? "green" : "red" %>;"><%= status %></td>
            <td><%= address %></td>
        </tr>
<%
        } // end for
%>
    </tbody>
</table>

<%
    } // end else
%>
 