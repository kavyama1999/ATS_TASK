<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page import="AddAmbulanceDb.model.Ambulance" %>
<%@ page import="AddAmbulanceDb.service.AmbulanceLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%-- <%@ include file="./ambulance_Register.jsp" %>
 --%>



<liferay-ui:success key="ambulance-added-success" message="Ambulance added successfully!" />
<liferay-ui:error key="ambulance-add-error" message="Failed to add ambulance. Please try again." />

<liferay-ui:success key="ambulance-update-success" message="Ambulance Updated successfully!" />
<liferay-ui:error key="ambulance-update-error" message="Failed to Update ambulance. Please try again." />

<!-- ✅ Navigation Buttons -->


<portlet:renderURL var="ambulanceRegisterPageURL">
    <portlet:param name="jspPage" value="/ambulance_Register.jsp" />
</portlet:renderURL>



<div style="display:flex; gap:30px; margin-bottom:20px;">
    <a href="${ambulanceRegisterPageURL}" class="btn btn-primary">Add Ambulance</a>
</div>

<%
    List<Ambulance> ambulances = AmbulanceLocalServiceUtil.getAmbulances(-1, -1);
%>

<% if (ambulances != null && !ambulances.isEmpty()) { %>
    <table class="table table-striped table-bordered mt-3">
        <thead class="thead-dark">
            <tr>
                <th>SI.NO</th>
                <th>Ambulance Number</th>
                <th>Vehicle Type</th>
                <th>Status</th>
                <th>Location</th>
                <th>Contact Number</th>
                <th>Driver Name</th>
                
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
        <%
            int count = 1;
            for (Ambulance amb : ambulances) {
        %>
            <tr>
                <td><%= count++ %></td>
                <td><%= amb.getAmbulanceNumber() %></td>
                <td><%= amb.getVehicleType() %></td>
                <td><%= amb.getStatus() %></td>
                <td><%= amb.getLocation() %></td>
                <td><%= amb.getContactNumber() %></td>
                <td><%= amb.getDriverName()%></td>
                
    <td>
   
    <%-- Edit Button --%>
    <portlet:renderURL var="editAmbulanceURL">
        <portlet:param name="jspPage" value="/edit_ambulance.jsp" />
        <portlet:param name="ambulanceId" value="<%= String.valueOf(amb.getAmbulanceId()) %>" />
    </portlet:renderURL>
<%--     <a href="<%= editAmbulanceURL %>" class="btn btn-sm btn-warning">Edit</a>
 --%>
     <a href="<%= editAmbulanceURL %>" class="btn btn-sm btn-primary">Edit</a>
 
    <%-- Delete Button --%>
  
   
 <portlet:actionURL name="/delete_ambulance" var="deleteAmbulanceURL">
    <portlet:param name="ambulanceId" value="<%= String.valueOf(amb.getAmbulanceId()) %>" />
</portlet:actionURL>

<a href="${deleteAmbulanceURL}" 
   onclick="return confirm('Are you sure you want to delete this ambulance?');" class="btn btn-sm btn-primary">
   Delete
</a>

    
</td>

   </tr>
        <% } %>
        </tbody>
    </table>
<% } else { %>
    <p>No ambulance records found.</p>
<% } %>

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
.thead-dark {
    background-color: #007bff;
    color: white;
}
.btn-sm {
    padding: 3px 8px;
    font-size: 0.875rem;
}
</style>
