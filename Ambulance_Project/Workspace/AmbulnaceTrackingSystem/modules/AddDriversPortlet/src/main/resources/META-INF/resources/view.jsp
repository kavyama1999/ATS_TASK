<%@ include file="/init.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>ADD DRIVERS</h2>

<liferay-ui:success key="driver-added-success" message="Driver added successfully!" />
<liferay-ui:error key="driver-add-error" message="Failed to add driver. Please try again." />


<marquee behavior="scroll" direction="left" style="font-size:24px; font-weight:bold; color:#007bff; margin-bottom:15px;">
    🚗 Driver Management 🚗
</marquee>


<portlet:renderURL var="driverRegisterPageURL">
    <portlet:param name="jspPage" value="/addDriver.jsp" />
</portlet:renderURL>


<div style="display:flex; gap:30px; margin-bottom:20px;">
   
    <a href="${driverRegisterPageURL}" class="btn btn-primary">Add Drivers</a>
</div>

