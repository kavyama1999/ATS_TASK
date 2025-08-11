
<%@page import="employe.db.layer.service.employeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="employe.db.layer.model.employee"%>
<%@ include file="./init.jsp" %>



<portlet:actionURL name="editEmployee"  var="editEmployeeURL"/>

<portlet:renderURL var="viewPageURL">
    <portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>

<%

long employeeId=ParamUtil.getLong(renderRequest, "empId");

 employee emp=  employeeLocalServiceUtil.fetchemployee(employeeId);


%>

<aui:form action="${editEmployeeURL }" method="post">

<aui:input type="hidden"  name="empId" value="<%=emp.getEmpId() %>"></aui:input>

<aui:input type="text" name="name" value="<%=emp.getName() %>"></aui:input>

<aui:input  type="text" name="age" value="<%=emp.getAge()%>"></aui:input>
<aui:input type="text"  name="company" value="<%=emp.getCompany() %>"></aui:input>
<aui:input type="text" name="salary" value="<%=emp.getSalary() %>"></aui:input>

<aui:select name="gender">
<aui:option label="select gender"/>
<aui:option value="1" label="male"/>
<aui:option value="0" label="female"/>

</aui:select>

     <div class="d-flex justify-content-between">
        <aui:button type="submit" value="Update"/>
        <a class="btn btn-dark" href="${viewPageURL}">Back</a>
    </div>

</aui:form>