<%@ include file="/init.jsp" %>

<h2>NEW ADD AMBILANE</h2>

<liferay-ui:success key="ambulance-added-success" message="Ambulance added successfully!" />
<liferay-ui:error key="ambulance-add-error" message="Failed to add ambulance. Please try again." />


<!-- ✅ Navigation Buttons -->


<portlet:renderURL var="ambulanceRegisterPageURL">
    <portlet:param name="jspPage" value="/ambulance_Register.jsp" />
</portlet:renderURL>

<portlet:renderURL var="driverRegisterPageURL">
    <portlet:param name="jspPage" value="/addDriver.jsp" />
</portlet:renderURL>


<div style="display:flex; gap:30px; margin-bottom:20px;">
    <a href="${ambulanceRegisterPageURL}" class="btn btn-primary">Add Ambulance</a>
    <a href="${driverRegisterPageURL}" class="btn btn-primary">Add Drivers</a>
</div>