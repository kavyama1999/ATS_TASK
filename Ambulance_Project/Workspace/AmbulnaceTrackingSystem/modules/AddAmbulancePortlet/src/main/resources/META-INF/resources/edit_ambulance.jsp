<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ page import="AddAmbulanceDb.model.Ambulance" %>
<%@ page import="AddAmbulanceDb.service.AmbulanceLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
    // Get ambulanceId from request
    long ambulanceId = ParamUtil.getLong(request, "ambulanceId");
    Ambulance ambulance = null;

    if (ambulanceId > 0) {
        // Fetch ambulance details
        ambulance = AmbulanceLocalServiceUtil.fetchAmbulance(ambulanceId);
    } else {
        out.println("<p>Invalid Ambulance ID.</p>");
    }
%>

<% if (ambulance != null) { %>
<h2>Edit Ambulance - <%= ambulance.getAmbulanceNumber() %></h2>

<portlet:actionURL name="addOrUpdateAmbulance" var="updateAmbulanceURL" />

<aui:form action="<%= updateAmbulanceURL %>" method="post" name="fm">

    <%-- Hidden field to retain ambulance ID --%>
    <aui:input type="hidden" name="ambulanceId" value="<%= ambulance.getAmbulanceId() %>" />

    <%-- Ambulance Number --%>
    <aui:input name="ambulanceNumber" label="Ambulance Number" required="true"
               value="<%= ambulance.getAmbulanceNumber() %>" />

    <%-- Vehicle Type --%>
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

    <%-- Status --%>
    <aui:select name="status" label="Status" required="true">
        <aui:option value="Available" selected="<%= "Available".equals(ambulance.getStatus()) %>">Available</aui:option>
        <aui:option value="On Duty" selected="<%= "On Duty".equals(ambulance.getStatus()) %>">On Duty</aui:option>
        <aui:option value="Maintenance" selected="<%= "Maintenance".equals(ambulance.getStatus()) %>">Maintenance</aui:option>
    </aui:select>

    <%-- Location --%>
    <aui:input name="location" label="Current Location"
               value="<%= ambulance.getLocation() %>" />

    <%-- Contact Number --%>
    <aui:input name="contactNumber" label="Contact Number"
               value="<%= ambulance.getContactNumber() %>" />

    <div class="text-center mt-4">
        <aui:button type="submit" value="Update Ambulance" cssClass="btn btn-primary" />
    </div>
</aui:form>
<% } %>
