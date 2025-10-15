<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil,
                 com.liferay.portal.kernel.util.Validator,
                 com.liferay.portal.kernel.model.User" %>

<!-- JSTL Core Taglib -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Liferay AUI Taglib -->
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>



<%
    String errorMessage = (String) request.getAttribute("errorMessage");
    String successMessage = (String) request.getAttribute("successMessage");

    User verifiedUser = (User) request.getAttribute("verifiedUser");
    Long userId = (Long) request.getAttribute("userId");
    String emailAddress = (String) request.getAttribute("emailAddress");
%>

<div class="verification-container">
    <h2>Email Verification</h2>

    <!-- Error message -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger"><%= errorMessage %></div>
    </c:if>

    <!-- Success message -->
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success"><%= successMessage %></div>
    </c:if>

    <!-- Show OTP form only if user exists -->
    <c:if test="${verifiedUser != null}">
        <portlet:actionURL name="/action/signUp/sendOTP" var="sendOTPActionURL" />

        <aui:form action="<%= sendOTPActionURL %>" method="post" name="verifyEmailForm">
            <aui:fieldset>
                <aui:input name="emailAddress" type="text" label="Email Address"
                    value="<%= emailAddress %>" readonly="true" />
                <aui:input name="userId" type="hidden" value="<%= userId %>" />
                <aui:button type="submit" value="Send OTP" cssClass="btn-primary" />
            </aui:fieldset>
        </aui:form>
    </c:if>
</div>

<style>
.verification-container {
    max-width: 600px;
    margin: 0 auto;
    padding: 20px;
    text-align: center;
}

.alert {
    padding: 15px;
    margin: 20px 0;
    border-radius: 4px;
}

.alert-success { 
    color: #155724; 
    background-color: #d4edda; 
    border-color: #c3e6cb; 
}

.alert-danger { 
    color: #721c24; 
    background-color: #f8d7da; 
    border-color: #f5c6cb; 
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
