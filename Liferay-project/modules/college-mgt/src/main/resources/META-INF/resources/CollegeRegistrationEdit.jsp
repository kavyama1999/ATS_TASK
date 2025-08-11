<%@page import="com.college.model.college"%>
<%@page import="com.college.service.collegeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp"%>


<!-- <portlet:actionURL name="addEmployee" var="addEmployeeURL" />
 -->
<portlet:actionURL name="editcollegeRegistration" var="editRegiURL" />

 <portlet:actionURL name="deleteCollege" var="deleteClgURL">
                 <portlet:param name="collegeId" value="${clg.collegeId}" />
      </portlet:actionURL>
<a href="${deleteClgURL}" onclick="return confirm('Are you sure you want to delete this employee?');">
Delete</a>
                   
                   

<%
long data = ParamUtil.getLong(renderRequest, "collegeId");
college data1 = collegeLocalServiceUtil.fetchcollege(data);
%>




<aui:form action="${editRegiURL}" method="POST">
<%-- <aui:input type="text" name="name" value="<%=emp.getName() %>"></aui:input>
 --%>
    <aui:input type="hidden" name="collegeId" value="<%= data1.getCollegeId() %>" />

    <aui:input name="name" type="text" value="<%=data1.getName()%>" required="true" />

    <aui:input name="address" type="text" value="<%=data1.getAddress()%>" required="true" />

    <aui:select name="gender" value="<%=data1.getGender()%>">
        <aui:option label="select gender" />
        <aui:option value="male" label="male" />
        <aui:option value="female" label="female" />
    </aui:select>

    <aui:button type="submit" value="Submit" />
</aui:form>

