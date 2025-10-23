<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.model.Address" %>
<%@ page import="com.liferay.portal.kernel.service.AddressLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    long driverId = ParamUtil.getLong(request, "driverId");  // userId passed via URL param
    User driverUser = UserLocalServiceUtil.fetchUser(driverId);

    String contactNumber = "";
    String address = "";

    if (driverUser != null) {
        // ✅ Fetch contact number from Expando
        if (driverUser.getExpandoBridge() != null) {
            Object contactObj = driverUser.getExpandoBridge().getAttribute("contactNumber");
            if (contactObj != null) contactNumber = contactObj.toString();
        }

        // ✅ Fetch address from Liferay’s Address table
        List<Address> addresses = AddressLocalServiceUtil.getAddresses(
            driverUser.getCompanyId(),
            User.class.getName(),
            driverUser.getUserId()
        );

        if (addresses != null && !addresses.isEmpty()) {
            Address primaryAddress = addresses.get(0); // You can modify this if multiple addresses exist
            if (primaryAddress != null) {
                address = primaryAddress.getStreet1();
            }
        }
    }
%>

<div class="container mt-5">
    <div class="card shadow-lg p-4 rounded">

        <div class="card-header bg-primary text-white text-center rounded-top-4 py-3">
            <h2 class="mb-0 emoji-header">✏️ Update Ambulance Driver</h2>
        </div>

        <div class="card-body p-4">
            <portlet:actionURL name="updateDriver" var="updateDriverURL" />

            <aui:form name="updateDriverForm" action="<%= updateDriverURL %>" method="post">
                <!-- Hidden field for User ID -->
                <aui:input name="driverId" type="hidden" value="<%= driverUser != null ? driverUser.getUserId() : 0 %>" />

                <!-- Driver Name -->
                <aui:input name="driverName" label="Driver Name" required="true"
                           value="<%= driverUser != null ? driverUser.getFirstName() : "" %>" />

                <!-- Last Name -->
                <aui:input name="lastName" label="Last Name" required="true"
                           value="<%= driverUser != null ? driverUser.getLastName() : "" %>" />

                <!-- Email -->
                <aui:input name="email" label="Email" required="true"
                           value="<%= driverUser != null ? driverUser.getEmailAddress() : "" %>" />

                <!-- Contact Number -->
                <aui:input name="contactNumber" label="Contact Number"
                           value="<%= contactNumber %>" />

                <!-- Address -->
                <aui:input name="address" type="textarea" rows="2" label="Address"
                           value="<%= address %>" />

              <%--   <!-- Password -->
                <aui:input name="password" type="password" label="Password"
                           placeholder="Enter new password (leave blank to keep existing)" />
 --%>
                <aui:button type="submit" value="Update" cssClass="btn btn-primary" />
                <aui:button type="cancel" value="Cancel"
                            onClick="window.history.back();" cssClass="btn btn-secondary ml-2" />
            </aui:form>
        </div>
    </div>
</div>

<style>
.container {
    max-width: 700px;
}
.card {
    background: #ffffff;
    border-radius: 15px;
    border: 1px solid #ddd;
}
.btn-primary {
    background-color: #007bff;
    border-color: #007bff;
}
.btn-primary:hover {
    background-color: #0056b3;
}
.btn-secondary {
    background-color: #6c757d;
    border-color: #6c757d;
}
.emoji-header {
    font-family: "Segoe UI Emoji", "Apple Color Emoji", "Noto Color Emoji", sans-serif;
}
</style>
