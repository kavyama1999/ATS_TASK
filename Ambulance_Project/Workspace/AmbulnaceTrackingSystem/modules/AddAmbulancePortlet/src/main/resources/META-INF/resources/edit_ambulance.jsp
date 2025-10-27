<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="AddAmbulanceDb.model.Ambulance" %>
<%@ page import="AddAmbulanceDb.service.AmbulanceLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.stream.Collectors" %>

<%
    long ambulanceId = ParamUtil.getLong(request, "ambulanceId");
    Ambulance ambulance = null;

    if (ambulanceId > 0) {
        ambulance = AmbulanceLocalServiceUtil.fetchAmbulance(ambulanceId);
    } else {
        out.println("<p>Invalid Ambulance ID.</p>");
    }

    long companyId = themeDisplay.getCompanyId();
    Role driverRole = RoleLocalServiceUtil.fetchRole(companyId, "Driver");
    List<User> activeDrivers = null;

    if (driverRole != null) {
        List<User> allDrivers = UserLocalServiceUtil.getRoleUsers(driverRole.getRoleId());
        activeDrivers = allDrivers.stream().filter(User::isActive).collect(Collectors.toList());
    }
%>

<% if (ambulance != null) { %>
<div class="container mt-5">
    <div class="card shadow-lg p-4 rounded">
        <div class="card-header bg-primary text-white text-center rounded-top-4 py-3">
            <h2 class="mb-0 emoji-header">🚑 Edit Ambulance - <%= ambulance.getAmbulanceNumber() %></h2>
        </div>

        <div class="card-body p-4">
            <portlet:actionURL name="addOrUpdateAmbulance" var="updateAmbulanceURL" />

            <aui:form action="<%= updateAmbulanceURL %>" method="post" name="fm">
                <aui:input type="hidden" name="ambulanceId" value="<%= ambulance.getAmbulanceId() %>" />

                <aui:input name="ambulanceNumber" label="Ambulance Number" required="true"
                           value="<%= ambulance.getAmbulanceNumber() %>" />

                <aui:select name="vehicleType" label="Vehicle Type" required="true">
                    <aui:option value="Basic Life Support"
                                selected="<%= "Basic Life Support".equals(ambulance.getVehicleType()) %>">
                        Basic Life Support (BLS)
                    </aui:option>
                    <aui:option value="Advanced Life Support"
                                selected="<%= "Advanced Life Support".equals(ambulance.getVehicleType()) %>">
                        Advanced Life Support (ALS)
                    </aui:option>
                    <aui:option value="Patient Transport Vehicle"
                                selected="<%= "Patient Transport Vehicle".equals(ambulance.getVehicleType()) %>">
                        Patient Transport Vehicle
                    </aui:option>
                </aui:select>

                <!-- ✅ Driver Dropdown -->
                <aui:select name="driverId" label="Driver" required="true">
                    <aui:option value="">-- Select Driver --</aui:option>
                    <%
                        if (activeDrivers != null && !activeDrivers.isEmpty()) {
                            for (User driver : activeDrivers) {
                                boolean selected = ambulance.getDriverName() != null &&
                                                   ambulance.getDriverName().equals(driver.getFullName());
                    %>
                                <aui:option value="<%= driver.getUserId() %>" selected="<%= selected %>">
                                    <%= driver.getFullName() %>
                                </aui:option>
                    <%
                            }
                        } else {
                    %>
                        <aui:option disabled="true" value="">No active drivers available</aui:option>
                    <%
                        }
                    %>
                </aui:select>

                <aui:select name="status" label="Status" required="true">
                    <aui:option value="Available" selected="<%= "Available".equals(ambulance.getStatus()) %>">Available</aui:option>
                    <aui:option value="On Duty" selected="<%= "On Duty".equals(ambulance.getStatus()) %>">On Duty</aui:option>
                    <aui:option value="Maintenance" selected="<%= "Maintenance".equals(ambulance.getStatus()) %>">Maintenance</aui:option>
                </aui:select>

                <aui:input name="location" label="Current Location" value="<%= ambulance.getLocation() %>" />

                <aui:input name="contactNumber" label="Contact Number" value="<%= ambulance.getContactNumber() %>" />

                <div class="text-center mt-4">
                    <aui:button type="submit" value="Update Ambulance" cssClass="btn btn-primary" />
                </div>
            </aui:form>
        </div>
    </div>
</div>
<% } %>

<style>
.container { max-width: 700px; }
.card { background: #ffffff; border-radius: 15px; border: 1px solid #ddd; }
.btn-primary { background-color: #007bff; border-color: #007bff; }
.btn-primary:hover { background-color: #0056b3; }
.emoji-header { font-family: "Segoe UI Emoji", "Apple Color Emoji", "Noto Color Emoji", sans-serif; }
</style>
