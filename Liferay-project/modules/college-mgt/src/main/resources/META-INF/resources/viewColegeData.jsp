<%-- <%@page import="employe.db.layer.service.employeeLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ include file="./init.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>

<%
    List<college> employees = (List<college>) request.getAttribute("colleges");
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

<a href="${addEmployeeURL }">Add Employee</a><br>
<a href="${editEmployeePageURL }">Edit</a>



<h2>Employee List</h2>

<table id="employeeTable" class="display">
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
 --%>