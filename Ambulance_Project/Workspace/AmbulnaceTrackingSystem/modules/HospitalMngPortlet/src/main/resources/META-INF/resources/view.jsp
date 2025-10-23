<%@ include file="./init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page import="java.util.List" %>
<%@ page import="AddAmbulanceDb.model.Hospital" %>
<%@ page import="AddAmbulanceDb.model.Ambulance" %>
<%@ page import="AddAmbulanceDb.model.Driver" %>
<%@ page import="AddAmbulanceDb.service.HospitalLocalServiceUtil" %>
<%@ page import="AddAmbulanceDb.service.AmbulanceLocalServiceUtil" %>
<%@ page import="AddAmbulanceDb.service.DriverLocalServiceUtil" %>

<h2 style="text-align:center; margin-bottom:20px; color:#007bff;">Hospital Management</h2>

<!-- Messages -->
<liferay-ui:success key="hospital-added-success" message="Hospital registered successfully!" />
<liferay-ui:error key="hospital-add-error" message="Error occurred while registering the hospital." />



<liferay-ui:success key="assign-success" message="Hospital, ambulance, and driver linked successfully!" />
<liferay-ui:error key="assign-error" message="Failed to assign data. Please try again." />

<liferay-ui:success key="assign-success" message="Hospital, ambulance, and driver linked successfully!" />
<liferay-ui:error key="assign-error" message="Failed to assign data. Please try again." />


<!-- ✅ Navigation Buttons -->
<portlet:renderURL var="hospitalRegisterPageURL">
    <portlet:param name="jspPage" value="/hospital_Register.jsp" />
</portlet:renderURL>




<marquee behavior="scroll" direction="left" style="font-size:24px; font-weight:bold; color:#007bff; margin-bottom:15px;">
    🚗 Hospital Management 🚗
</marquee>


<div style="display:flex; gap:30px; margin-bottom:20px;">
    <a href="${hospitalRegisterPageURL}" class="btn btn-primary">Add Hospital</a>
</div>

<%
    List<Hospital> hospitalList = null;
    List<Ambulance> ambulanceList = null;
    List<Driver> driverList = null;
    String errorMessage = null;

    try {
        hospitalList = HospitalLocalServiceUtil.getHospitals(-1, -1);
        ambulanceList = AmbulanceLocalServiceUtil.getAmbulances(-1, -1);
        driverList = DriverLocalServiceUtil.getDrivers(-1, -1);

        if (hospitalList == null || hospitalList.isEmpty()) {
            errorMessage = "No hospitals found in database.";
        }
    } catch (Exception e) {
        e.printStackTrace();
        errorMessage = "Failed to fetch data.";
    }
%>

<div class="container mt-5">
    <h3 class="text-center mb-4">Registered Hospitals</h3>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger text-center"><%= errorMessage %></div>
    </c:if>

    <c:if test="${empty errorMessage}">
        <div class="table-container">
            <table class="hospital-table">
                <thead>
                    <tr>
                        <th>SI.NO</th>
                        <th>Hospital Name</th>
                        <th>Location</th>
                        <th>Address</th>
                        <th>Contact Number</th>
                        <th>Assign Details</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        int count = 1;
                        for (Hospital hospital : hospitalList) {
                    %>
                    <tr>
                        <td><%= count++ %></td>
                        <td><%= hospital.getHospitalName() %></td>
                        <td><%= hospital.getLocation() %></td>
                        <td><%= hospital.getAddress() %></td>
                        <td><%= hospital.getContactNumber() %></td>
                        <td>
                            <portlet:actionURL name="assignHospitalData" var="assignHospitalDataURL" />

                            <aui:form action="<%= assignHospitalDataURL %>" method="post" name="assignForm_<%= hospital.getHospitalId() %>">
                                <aui:input type="hidden" name="hospitalId" value="<%= hospital.getHospitalId() %>" />

                                <div style="display:flex; align-items:center; gap:10px;">
                                    <!-- ✅ Ambulance Dropdown -->
                                    <aui:select name="ambulanceId" label="Ambulance" required="true">
                                        <aui:option value="">Select Ambulance</aui:option>
                                        <%
                                            if (ambulanceList != null && !ambulanceList.isEmpty()) {
                                                for (Ambulance amb : ambulanceList) {
                                        %>
                                            <aui:option value="<%= amb.getAmbulanceId() %>"><%= amb.getAmbulanceNumber() %></aui:option>
                                        <%
                                                }
                                            } else {
                                        %>
                                            <aui:option disabled="true" value="">No Ambulance Found</aui:option>
                                        <%
                                            }
                                        %>
                                    </aui:select>

                                    <!-- ✅ Driver Dropdown -->
                                    <aui:select name="driverId" label="Driver" required="true">
                                        <aui:option value="">Select Driver</aui:option>
                                        <%
                                            if (driverList != null && !driverList.isEmpty()) {
                                                for (Driver drv : driverList) {
                                        %>
                                            <aui:option value="<%= drv.getDriverId() %>"><%= drv.getDriverName() %></aui:option>
                                        <%
                                                }
                                            } else {
                                        %>
                                            <aui:option disabled="true" value="">No Driver Found</aui:option>
                                        <%
                                            }
                                        %>
                                    </aui:select>

                                    <!-- ✅ Submit Button -->
                                    <aui:button type="submit" value="Submit" cssClass="btn btn-primary btn-sm" />
                                </div>
                            </aui:form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </c:if>
</div>

<style>
.container {
    max-width: 1100px;
    margin: auto;
}

.table-container {
    border-radius: 8px;
    overflow: hidden;
    padding: 5px;
}

.hospital-table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
}

.hospital-table th, .hospital-table td {
    padding: 12px 15px;
    border: 1px solid #007bff;
    text-align: center;
}

.hospital-table thead th {
    background-color: #007bff;
    color: #fff;
    font-weight: bold;
}

.hospital-table tbody tr:nth-child(odd) {
    background-color: #f9f9f9;
}

.hospital-table tbody tr:hover {
    background-color: #cce5ff;
    cursor: pointer;
}

.aui-field-wrapper-content select {
    border-radius: 4px;
    border: 1px solid #007bff;
    padding: 5px;
}
</style>
