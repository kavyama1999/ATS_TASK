<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
/* long userId = ParamUtil.getLong(request, "userId");
 */
 long userId = ParamUtil.getLong(request, "userId");

String errorMessage = ParamUtil.getString(request, "errorMessage");
String successMessage = ParamUtil.getString(request, "successMessage");
%>

<div class="verification-container">
    <h2>Enter OTP</h2>

    <c:if test="<%= successMessage != null && !successMessage.isEmpty() %>">
        <div class="alert alert-success">
            <%= successMessage %>
        </div>
    </c:if>

    <c:if test="<%= errorMessage != null && !errorMessage.isEmpty() %>">
        <div class="alert alert-danger">
            <%= errorMessage %>
        </div>
    </c:if>

    <portlet:actionURL name="/action/signUp/verifyOTP" var="verifyOTPActionURL" />

    <aui:form action="<%= verifyOTPActionURL %>" method="post">
        <aui:fieldset>
            <aui:input name="otp" label="Enter OTP" type="text" required="true" placeholder="Enter the OTP you received" />

            <!-- Hidden userId must be included -->
       <aui:input name="userId" type="hidden" value="<%= userId %>" />

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
