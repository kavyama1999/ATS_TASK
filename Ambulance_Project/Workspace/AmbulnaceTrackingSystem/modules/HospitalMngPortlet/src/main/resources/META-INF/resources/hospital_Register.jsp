<%@ include file="./init.jsp" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>

<liferay-theme:defineObjects />

<!-- ✅ Success / Error Messages -->
<liferay-ui:success key="hospital-added-success" message="✅ Hospital registered successfully!" />
<liferay-ui:error key="hospital-add-error" message="❌ Error occurred while registering the hospital." />

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="card shadow-lg rounded-4 border-0">

  <div class="card-header bg-primary text-white text-center rounded-top-4 py-3">
    <h2 class="mb-0 emoji-header">
        🏥 Register Hospital
    </h2>
</div>
                <div class="card-body p-4">

                    <!-- ✅ Action URL -->
                    <portlet:actionURL name="/add_hospital" var="addHospitalURL" />

                    <!-- ✅ Hospital Registration Form -->
                    <aui:form action="<%= addHospitalURL %>" method="post" name="hospitalForm">

                        <div class="mb-3">
                            <aui:input name="hospitalName" label="Hospital Name" required="true" placeholder="Enter hospital name">
                                <aui:validator name="required" />
                            </aui:input>
                        </div>

                        <div class="mb-3">
                            <aui:input name="location" label="Location" required="true" placeholder="Enter city or area">
                                <aui:validator name="required" />
                            </aui:input>
                        </div>

                        <div class="mb-3">
                            <aui:input name="address" label="Address" type="textarea" placeholder="Enter hospital address" required="true">
                                <aui:validator name="required" />
                            </aui:input>
                        </div>

                        <div class="mb-3">
                            <aui:input name="contactNumber" label="Contact Number" required="true" placeholder="Enter contact number">
                                <aui:validator name="required" />
                                <aui:validator name="number" />
                                <aui:validator name="minLength">10</aui:validator>
                                <aui:validator name="maxLength">10</aui:validator>
                            </aui:input>
                        </div>

                        <div class="text-center mt-4">
                            <aui:button type="submit" value="Register Hospital" cssClass="btn btn-success btn-lg px-4 rounded-pill shadow-sm" />
                        </div>

                    </aui:form>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
    .card {
        background-color: #ffffff;
    }
    .card-header {
        background: linear-gradient(135deg, #007bff, #0056b3);
    }
    .aui-field-input {
        border-radius: 10px !important;
        border: 1px solid #ced4da !important;
        padding: 0.5rem 1rem !important;
    }
    .btn-success {
        background: linear-gradient(135deg, #28a745, #218838);
        border: none;
    }
    .btn-success:hover {
        background: linear-gradient(135deg, #218838, #1e7e34);
    }
    
    .emoji-header {
    font-family: "Segoe UI Emoji", "Apple Color Emoji", "Noto Color Emoji", sans-serif;
    }

</style>
