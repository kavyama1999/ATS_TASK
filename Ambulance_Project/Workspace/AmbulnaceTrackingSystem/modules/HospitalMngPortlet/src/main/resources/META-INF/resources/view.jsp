<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="java.util.List" %>
<%@ page import="AddAmbulanceDb.model.Hospital" %>
<%@ page import="AddAmbulanceDb.service.HospitalLocalServiceUtil" %>

<h2 style="text-align:center; margin-bottom:20px; color:#007bff;">Hospital Management</h2>

<!-- ✅ Success / Error Messages -->
<liferay-ui:success key="hospital-added-success" message="Hospital registered successfully!" />
<liferay-ui:error key="hospital-add-error" message=" Error occurred while registering the hospital." />

<liferay-ui:success key="ambulance-added-success" message=" Ambulance added successfully!" />
<liferay-ui:error key="ambulance-add-error" message="Failed to add ambulance. Please try again." />

<liferay-ui:success key="driver-added-success" message=" Ambulance added successfully!" />
<liferay-ui:error key="driver-add-error" message="Failed to add ambulance. Please try again." />


<!-- ****************************************************************** -->

<portlet:renderURL var="hospitalRegisterPageURL">
    <portlet:param name="jspPage" value="/hospital_Register.jsp" />
</portlet:renderURL>



<!-- ****************************************************************** -->

<portlet:renderURL var="ambulanceRegisterPageURL">
    <portlet:param name="jspPage" value="/ambulance_Register.jsp" />
</portlet:renderURL>

<!-- ****************************************************************** -->

<portlet:renderURL var="driverRegisterPageURL">
    <portlet:param name="jspPage" value="/addDriver.jsp" />
</portlet:renderURL>

<!-- ****************************************************************** -->

<div style="display:flex; gap:30px; margin-bottom:20px;">
    <a href="${hospitalRegisterPageURL}" class="btn btn-primary">Add Hospital</a>
    <a href="${ambulanceRegisterPageURL}" class="btn btn-primary">Add Ambulance</a>
    <a href="${driverRegisterPageURL}" class="btn btn-primary">Add Drivers</a>

</div>

<%
    List<Hospital> hospitalList = null;
    String errorMessage = null;

    try {
        hospitalList = HospitalLocalServiceUtil.getHospitals(-1, -1); // fetch all hospitals
        if (hospitalList == null || hospitalList.isEmpty()) {
            errorMessage = "No hospitals found in database.";
        }
    } catch (Exception e) {
        e.printStackTrace();
        errorMessage = "Failed to fetch hospital data.";
    }
%>

<div class="container mt-5">
    <h3 class="text-center mb-4">Registered Hospitals</h3>

    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger text-center"><%= errorMessage %></div>
    </c:if>

    <c:if test="<%= (hospitalList != null && !hospitalList.isEmpty()) %>">
        <div class="table-container">
            <table class="hospital-table">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Hospital Name</th>
                        <th>Location</th>
                        <th>Address</th>
                        <th>Contact Number</th>
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
                    </tr>
                    <% } %>
                </tbody>
            </table>
        </div>
    </c:if>
</div>

<style>
/* Container */
.container {
    max-width: 1000px;
    margin: auto;
}

/* Box around table */
.table-container {
   /*  border: 2px solid #007bff; Blue border */
    border-radius: 8px;
    overflow: hidden;
    padding: 5px;
}

/* Table Styling */
.hospital-table {
    width: 100%;
    border-collapse: collapse;
    background-color: #fff;
}

.hospital-table th, .hospital-table td {
    padding: 12px 15px;
    text-align: left;
    border: 1px solid #007bff; /* Line between columns */
}

.hospital-table thead th {
    background-color: #007bff; /* Blue header */
    color: #fff;
    font-weight: bold;
}

.hospital-table tbody tr:nth-child(odd) {
    background-color: #f9f9f9; /* Alternating row color */
}

.hospital-table tbody tr:hover {
    background-color: #cce5ff; /* Hover effect */
    cursor: pointer;
}

/* Button Styling */
.btn-primary {
    background-color: #007bff;
    color: #fff;
    padding: 10px 20px;
    text-decoration: none;
    border-radius: 5px;
    transition: all 0.3s ease;
}

.btn-primary:hover {
    background-color: #0056b3;
    color: #fff;
    text-decoration: none;
}
</style>
