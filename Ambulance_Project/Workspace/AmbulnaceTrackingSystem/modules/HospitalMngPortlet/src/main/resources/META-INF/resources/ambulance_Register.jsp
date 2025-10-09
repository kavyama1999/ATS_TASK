<%@ include file="./init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="container mt-5">
    <div class="card shadow-lg p-4 rounded">
    
    <div class="card-header bg-primary text-white text-center rounded-top-4 py-3">
    <h2 class="mb-0 emoji-header">
        🚑 Add New Ambulance
    </h2>
</div>

                <div class="card-body p-4">


        <portlet:actionURL name="addAmbulance" var="addAmbulanceURL" />

        <aui:form action="<%= addAmbulanceURL %>" method="post" name="fm">

            <aui:input name="ambulanceNumber" label="Ambulance Number" required="true" placeholder="e.g., KA01AB1234" />

            <aui:select name="vehicleType" label="Vehicle Type" required="true">
                <aui:option value="">-- Select Vehicle Type --</aui:option>
                <aui:option value="Basic Life Support">Basic Life Support (BLS)</aui:option>
                <aui:option value="Advanced Life Support">Advanced Life Support (ALS)</aui:option>
                <aui:option value="Patient Transport Vehicle">Patient Transport Vehicle</aui:option>
            </aui:select>

            

            <aui:select name="status" label="Status" required="true">
                <aui:option value="Available">Available</aui:option>
                <aui:option value="On Duty">On Duty</aui:option>
                <aui:option value="Maintenance">Maintenance</aui:option>
            </aui:select>

            <aui:input name="location" label="Current Location" placeholder="e.g., MG Road, Bengaluru" />
            <aui:input name="contactNumber" label="Contact Number" placeholder="e.g., 9876543210" />

            <div class="text-center mt-4">
                <aui:button type="submit" value="Save Ambulance" cssClass="btn btn-primary" />
                <aui:button type="reset" value="Clear" cssClass="btn btn-secondary ml-2" />
            </div>
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
.text-primary {
    color: #007bff !important;
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
