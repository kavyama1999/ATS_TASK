<%@page import="employe.db.layer.model.employee"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp" %>

<portlet:actionURL name="filttercompany" var="filttercompanyURL" />
 
<%
    List<employee> employees = (List<employee>) request.getAttribute("employees");
%>
<h3>Filter by Company</h3>

<%-- <portlet:renderURL var="filterCompanyURLs">
    <portlet:param name="mvcRenderCommandName" value="kavya" />
</portlet:renderURL> --%>

<aui:form action="<%=filttercompanyURL %>" method="post">
    <aui:input type="text" name="company" 
           placeholder="Enter company name" value="" />
    <aui:button type="submit" value="Search"> </aui:button>
</aui:form>


<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Company</th>
    </tr>
    <c:forEach items="${employees}" var="employee">
        <tr>
            <td>${employee.empId}</td>
            <td>${employee.name}</td>
            <td>${employee.company}</td>
        </tr>
    </c:forEach>
</table>