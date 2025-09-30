<%@ include file="./init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<portlet:actionURL name="/action/signUp/register" var="signUpActionURL" />

<div class="signup-container">
    <h2>User Registration</h2>
    
    <aui:form action="<%= signUpActionURL %>" method="post" name="signUpForm">
        <aui:fieldset label="User Information">
            <aui:input name="firstName" label="First Name" type="text" required="true" />
            <aui:input name="lastName" label="Last Name" type="text" required="true" />
            <aui:input name="screenName" label="Screen Name" type="text" required="true" />
            <aui:input name="emailAddress" label="Email Address" type="email" required="true" />
            <aui:input name="password" label="Password" type="password" required="true" />
            <aui:button type="submit" value="Register" cssClass="btn-primary" />
        </aui:fieldset>
    </aui:form>
</div>

<%
    String successMessage = ParamUtil.getString(request, "successMessage");
    String errorMessage = ParamUtil.getString(request, "errorMessage");
%>

<c:if test="${not empty successMessage}">
    <div class="alert alert-success">
        <strong>Success!</strong> <%= successMessage %>
    </div>
</c:if>

<c:if test="${not empty errorMessage}">
    <div class="alert alert-danger">
        <strong>Error!</strong> <%= errorMessage %>
    </div>
</c:if>

<style>
.signup-container {
    max-width: 500px;
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