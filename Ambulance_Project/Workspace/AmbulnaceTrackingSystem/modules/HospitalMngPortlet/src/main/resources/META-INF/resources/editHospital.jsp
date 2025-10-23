<%@ include file="./init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@ page import="AddAmbulanceDb.model.Hospital" %>
<%@ page import="AddAmbulanceDb.service.HospitalLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>


<%
    long hospitalId = ParamUtil.getLong(request, "hospitalId");
    Hospital hospital = HospitalLocalServiceUtil.fetchHospital(hospitalId);

    if (hospital == null) {
%>
    <div class="alert alert-danger">Hospital not found.</div>
<%
        return;
    }
%>

<h2>Edit Hospital</h2>

<portlet:actionURL name="updateHospital" var="updateHospitalURL" />

<aui:form action="<%= updateHospitalURL %>" method="post" name="editHospitalForm">
    <aui:input type="hidden" name="hospitalId" value="<%= hospital.getHospitalId() %>" />

    <div class="mb-3">
        <aui:input name="hospitalName" label="Hospital Name" required="true" value="<%= hospital.getHospitalName() %>" />
    </div>

    <div class="mb-3">
        <aui:input name="location" label="Location" required="true" value="<%= hospital.getLocation() %>" />
    </div>

   
     <div class="mb-3">
        <!-- FIXED: use value attribute for textarea -->
        <aui:input name="address" label="Address" type="textarea" required="true"
                   value="<%= hospital.getAddress() %>" />
    </div>

    <div class="mb-3">
        <aui:input name="contactNumber" label="Contact Number" required="true" value="<%= hospital.getContactNumber() %>" />
    </div>

    <aui:button type="submit" value="Update Hospital" cssClass="btn btn-success" />
</aui:form>
