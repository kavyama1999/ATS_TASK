<%@ include file="./init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="AddAmbulanceDb.model.Hospital" %>
<%@ page import="AddAmbulanceDb.service.HospitalLocalServiceUtil" %>

<h2 style="text-align:center; margin-bottom:20px; color:#007bff;">Hospital Management</h2>

<!-- Messages -->
<liferay-ui:success key="hospital-added-success" message="Hospital registered successfully!" />
<liferay-ui:error key="hospital-add-error" message="Error occurred while registering the hospital." />

<liferay-ui:success key="hospital-update-success" message="Hospital updated successfully!" />
<liferay-ui:error key="hospital-update-error" message="Failed to update hospital." />

<liferay-ui:success key="hospital-delete-success" message="Hospital deleted successfully!" />
<liferay-ui:error key="hospital-delete-error" message="Failed to delete hospital." />


<liferay-ui:success key="hospital-deleted-success" message="Hospital deleted successfully!" />
<liferay-ui:error key="hospital-delete-error" message="Error deleting hospital." />
<liferay-ui:error key="invalid-hospital-id" message="Invalid hospital ID." />


<!-- Navigation Button -->
<portlet:renderURL var="hospitalRegisterPageURL">
    <portlet:param name="jspPage" value="/hospital_Register.jsp" />
</portlet:renderURL>

<div style="display:flex; gap:30px; margin-bottom:20px;">
    <a href="${hospitalRegisterPageURL}" class="btn btn-primary">Add Hospital</a>
</div>

<%
    List<Hospital> hospitalList = null;
    String errorMessage = null;

    try {
        hospitalList = HospitalLocalServiceUtil.getHospitals(-1, -1);

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
                        <th>Actions</th>
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
    <div style="display:flex; gap:5px; justify-content:center;">
        <!-- Edit Button -->
        <portlet:renderURL var="editHospitalURL">
            <portlet:param name="jspPage" value="/editHospital.jsp" />
            <portlet:param name="hospitalId" value="<%= String.valueOf(hospital.getHospitalId()) %>" />
        </portlet:renderURL>
        <a href="<%= editHospitalURL %>" class="btn btn-sm btn-primary">Edit</a>

        <!-- Delete Button -->
        <portlet:actionURL var="deleteHospitalURL" name="deleteHospital" />
        <aui:form action="<%= deleteHospitalURL %>" method="post" style="display:inline;">
            <aui:input type="hidden" name="hospitalId" value="<%= hospital.getHospitalId() %>" />
            <aui:button type="submit" value="Delete" cssClass="btn btn-sm btn-danger"
                        onClick="return confirm('Are you sure you want to delete this hospital?');" />
        </aui:form>
    </div>
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

.btn-sm {
    padding: 4px 8px;
    font-size: 0.875rem;
}
</style>
