<%@ include file="/init.jsp" %>

<!-- <p>
	<b><liferay-ui:message key="signup.caption"/></b>
</p> -->
<h2>Welcome To Ambulance Tracking System</h2>
<h2>Today Work</h2>


<portlet:renderURL var="signUpPageURL">
	<portlet:param name="jspPage" value="/signUp.jsp" />
</portlet:renderURL>


<a href="${signUpPageURL }">User Registration Page</a>