
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.Collections"%>
<%@page import="employe.db.layer.service.employeeLocalServiceUtil"%>
<%@page import="employe.db.layer.model.employee"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<%
    List<employee> employees = (List<employee>) request.getAttribute("employees");
%>


<!-- DataTables CSS CDN -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.6/css/jquery.dataTables.min.css" />

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>

<!-- DataTables JS CDN -->
<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>

<portlet:renderURL var="addEmployeeURL">
    <portlet:param name="jspPage" value="/addEmployee.jsp"/>
</portlet:renderURL>




<portlet:renderURL var="editEmployeePageURL">
    <portlet:param name="jspPage" value="/editEmployee.jsp"/>
 </portlet:renderURL>
 
<portlet:renderURL var="viewPageURL">
    <portlet:param name="jspPage" value="/view.jsp"/>
</portlet:renderURL>
   

<a href="${addEmployeeURL }">Add Employee</a><br>


<a href="${editEmployeePageURL }">Edit</a>

<!-- ===============================================================================
 -->
 
<!-- Company Filter Form -->
<%-- <h3>Cuastom Query</h3>
<form action="${filterCompanyURL}" method="get">
    <label for="company">Filter by Company:</label>
    <input type="text" name="company" id="company" placeholder="Enter company name" value="${param.company}" />
    <input type="submit" value="Search" />
</form> --%>



<!--

 ===============================================================================
 -->
 <portlet:actionURL name="filttercompany" var="filttercompanyURL" />
 
<%
	/*
	Object comEmployees = request.getAttribute("comEmployees");
	List<employee> empList = (null ==comEmployees)?Collections.EMPTY_LIST:(List<employee>)comEmployees;
	
	List<employee> employeeList = employeeLocalServiceUtil.getemployees(-1, -1);
	//if(Validator.isNotNull(empList)){
	//	employeeList = (List<employee>)comEmployees;
	//}
	*/
	
	 String companyName = ParamUtil.getString(request, "company");
    List<employee> employeeList;
    if (Validator.isNotNull(companyName)) {
        employeeList = employeeLocalServiceUtil.getEmployeeByCompany(companyName);
    } else {
        employeeList = employeeLocalServiceUtil.getemployees(-1, -1);
    }
    request.setAttribute("employeeList", employeeList);
	
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

<br/>

<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Company</th>
    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.empId}</td>
            <td>${employee.name}</td>
            <td>${employee.company}</td>
        </tr>
    </c:forEach>
</table>
 
 <!--===============================================  -->
 <h2>Employee List</h2>

<table id="employeeTable" class="display w-100"  >
    <thead>
        <tr>
            <th>Name</th>
            <th>Salary</th>
            <th>Gender</th>
            <th>Company</th>
            <th>Age</th>
            
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="emp" items="${employees}">
            <tr>
                <td>${emp.name}</td>
                <td>${emp.salary}</td>
                <td>${emp.gender}</td>
                <td>${emp.company}</td>
                <td>${emp.age}</td>
               <td>
               
               <portlet:renderURL var="viewURL">
        <portlet:param name="jspPage" value="/viewEmployee.jsp" />
        <portlet:param name="empId" value="${emp.empId}" />
    </portlet:renderURL>
               
    <portlet:renderURL var="editURL">
        <portlet:param name="jspPage" value="/editEmployee.jsp" />
        <portlet:param name="empId" value="${emp.empId}" />
    </portlet:renderURL>

    <a href="${editURL}">Edit</a>
    
    <portlet:actionURL name="deleteEmployee" var="deleteURL">
        <portlet:param name="empId" value="${emp.empId}" />
    </portlet:actionURL>

    <a href="${deleteURL}" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
    
</td>
                
            </tr>
        </c:forEach>
    </tbody>
</table>

<script>
    $(document).ready(function () {
        $('#employeeTable').DataTable();
    });
</script>
