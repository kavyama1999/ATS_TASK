<%@ include file="./init.jsp"%>


<!-- <portlet:actionURL name="addEmployee" var="addEmployeeURL" />
 -->
<portlet:actionURL name="collegeRegistration" var="regiURL" />


<aui:form action="<%= regiURL %>" method="POST">

	<aui:input name="name" type="text" required="true" />
	<aui:input name="address" type="text" required="true" />
	<aui:select name="gender">
		<aui:option label="select gender" />
		<aui:option value="male" label="male" />
		<aui:option value="female" label="female" />
	</aui:select>

	<aui:button type="submit" value="Submit" />



	<%--  <div class="d-flex justify-content-between">
        <aui:button type="submit" value="Submit"/>
        <a class="btn btn-dark" href="${viewPageURL}">Back</a>
    </div> --%>

</aui:form>