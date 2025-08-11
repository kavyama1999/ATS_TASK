<%@ include file="./init.jsp" %>

<portlet:actionURL name="employeeByCompany" var="employeeByCompanyURL"/>

<aui:form action="<%=employeeByCompanyURL %>" method="post">
	<aui:input name="comapny" type="text"/>
	<aui:button type="submit">Search</aui:button>
</aui:form>