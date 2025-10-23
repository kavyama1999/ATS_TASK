<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.model.Address" %>
<%@ page import="com.liferay.portal.kernel.service.AddressLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="java.util.List" %>

<!-- ✅ Success / Error messages -->
<liferay-ui:success key="driver-added-success" message="Driver added successfully!" />
<liferay-ui:error key="driver-add-error" message="Failed to add driver. Please try again." />

<liferay-ui:success key="driver-update-success" message="Driver updated successfully!" />
<liferay-ui:error key="driver-update-error" message="Failed to update driver. Please try again." />

<!-- ✅ Navigation Button -->
<portlet:renderURL var="driverRegisterPageURL">
    <portlet:param name="jspPage" value="/addDriver.jsp" />
</portlet:renderURL>

<div style="display:flex; gap:30px; margin-bottom:20px;">
    <a href="${driverRegisterPageURL}" class="btn btn-primary">Add Driver</a>
</div>

<h2>🚑 Driver List</h2>

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
    <p>No driver records found.</p>
<%
    } else {
%>

<!-- ✅ Table -->
<table class="table table-striped table-bordered mt-3">
    <thead class="table-header-blue">
        <tr>
            <th>SI.NO</th>
            <th>Driver Name</th>
            <th>Email</th>
            <th>Status</th>
            <th>Contact Number</th>
            <th>Address</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <%
        int count = 1;
        for (User driver : driverUsers) {

            String driverName = driver.getFullName();
            String email = driver.getEmailAddress();
            String status = driver.isActive() ? "Active" : "Inactive";
            String contactNumber = "N/A";
            String address = "N/A";

            // ✅ Fetch address from Address table
            try {
                List<Address> addresses = AddressLocalServiceUtil.getAddresses(
                        companyId,
                        com.liferay.portal.kernel.model.User.class.getName(),
                        driver.getUserId()
                );
                if (Validator.isNotNull(addresses) && !addresses.isEmpty()) {
                    Address addr = addresses.get(0);
                    if (Validator.isNotNull(addr.getStreet1())) {
                        address = addr.getStreet1();
                    }
                }
            } catch (Exception e) {
                address = "N/A";
            }
    %>

        <tr>
            <td><%= count++ %></td>
            <td><%= driverName %></td>
            <td><%= email %></td>
            <td style="font-weight:bold; color:<%= driver.isActive() ? "green" : "red" %>;"><%= status %></td>
            <td><%= contactNumber %></td>
            <td><%= address %></td>
            <td>
                <%-- ✅ Edit Button --%>
                <portlet:renderURL var="editDriverURL">
                    <portlet:param name="jspPage" value="/editDriver.jsp" />
                    <portlet:param name="driverId" value="<%= String.valueOf(driver.getUserId()) %>" />
                </portlet:renderURL>
                <a href="<%= editDriverURL %>" class="btn btn-sm btn-primary">Edit</a>

                <%-- ✅ Delete Button --%>
                <portlet:actionURL name="deleteDriver" var="deleteDriverURL">
                    <portlet:param name="driverId" value="<%= String.valueOf(driver.getUserId()) %>" />
                </portlet:actionURL>
                <a href="${deleteDriverURL}" 
                   onclick="return confirm('Are you sure you want to delete this driver?');" 
                   class="btn btn-sm btn-danger">
                   Delete
                </a>
            </td>
        </tr>
    <%
        } // end for
    %>
    </tbody>
</table>

<%
    } // end else
%>

<!-- ✅ Styles -->
<style>
.table {
    width: 100%;
    margin-top: 20px;
    border-collapse: collapse;
}

.table th, .table td {
    padding: 10px;
    border: 1px solid #ddd;
    text-align: center;
}

/* ✅ Blue header style */
.table-header-blue th {
    background-color: #007bff; /* Blue color */
    color: white;
    text-align: center;
}

/* ✅ Row hover effect */
.table tbody tr:hover {
    background-color: #f1f1f1;
}

/* ✅ Buttons */
.btn-sm {
    padding: 3px 8px;
    font-size: 0.875rem;
}

.btn-primary {
    background-color: #007bff;
    border-color: #007bff;
    color: white;
}

.btn-danger {
    background-color: #dc3545;
    border-color: #dc3545;
    color: white;
}
</style>
