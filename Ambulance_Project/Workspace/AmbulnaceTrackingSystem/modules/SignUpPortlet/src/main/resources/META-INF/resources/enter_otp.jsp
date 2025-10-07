<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
String emailAddress = ParamUtil.getString(request, "emailAddress");
String errorMessage = ParamUtil.getString(request, "errorMessage");
%>

<div class="verification-container">
    <h2>Enter OTP</h2>

    <!-- ❌ Remove successMessage here (it will show on home page after redirect) -->
    <c:if test="<%= errorMessage != null && !errorMessage.isEmpty() %>">
        <div class="alert alert-danger">
            <%= errorMessage %>
        </div>
    </c:if>

    <portlet:actionURL name="/action/signUp/verifyOTP" var="verifyOTPActionURL" />

    <aui:form action="<%= verifyOTPActionURL %>" method="post">
        <aui:fieldset>
            <aui:input name="otp" label="Enter OTP" type="text" required="true" placeholder="Enter the OTP you received" />

            <!-- ✅ Hidden email address instead of userId -->
            <input type="hidden" name="<portlet:namespace />emailAddress" value="<%= emailAddress %>" />

            <aui:button type="submit" value="Verify OTP" cssClass="btn-primary" />
        </aui:fieldset>
    </aui:form>
</div>

<style>
.verification-container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
}
.alert {
    padding: 15px;
    margin: 20px 0;
    border: 1px solid transparent;
    border-radius: 4px;
}
.alert-success {
    color: #3c763d;
    background-color: #dff0d8;
    border-color: #d6e9c6;
}
.alert-danger {
    color: #a94442;
    background-color: #f2dede;
    border-color: #ebccd1;
}
.btn-primary {
    background-color: #007bff;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
</style>
