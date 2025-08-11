<%@ include file="./init.jsp" %>

<%@ page import="java.util.List" %>
<%@ page import="com.college.model.college" %>

<p>
	<b><liferay-ui:message key="collegemgt.caption"/></b>
</p>

<portlet:renderURL var="regiURL">
    <portlet:param name="mvcPath" value="/CollegeRegistration.jsp" />
</portlet:renderURL>

<h2><a href="${regiURL}">College Registration</a></h2>

<h2>sdhhfujdh</h2>



<!-- //taking list of data from DB -->
<%
  List<college> colleges= (List<college>)request.getAttribute("colleges");

%>

<table id="collegeTable" class="display" style="width:100%; border-collapse: collapse; border: 1px solid #ddd;">
    <thead>
        <tr style="background-color: #f2f2f2;">
            <th style="border: 1px solid #ddd; padding: 8px;">Name</th>
            <th style="border: 1px solid #ddd; padding: 8px;">Address</th>
            <th style="border: 1px solid #ddd; padding: 8px;">Gender</th>
            <th style="border: 1px solid #ddd; padding: 8px;">Action</th>
       
             <!-- <th style="border: 1px solid #ddd; padding: 8px;">Edit</th>
             <th style="border: 1px solid #ddd; padding: 8px;">Delete</th> -->
 
  </tr>
    </thead>
    <tbody>
        <c:forEach var="clg" items="${colleges}">
            <tr>
                <td style="border: 1px solid #ddd; padding: 8px;">${clg.name}</td>
                <td style="border: 1px solid #ddd; padding: 8px;">${clg.address}</td>
                <td style="border: 1px solid #ddd; padding: 8px;">${clg.gender}</td>
                <td style="border: 1px solid #ddd; padding: 8px;">
                    
                
                
              <!--   to edit data -->
                
                
                    <portlet:renderURL var="editRegiURL">
                        <portlet:param name="jspPage" value="/CollegeRegistrationEdit.jsp" />
                        <portlet:param name="collegeId" value="${clg.collegeId}" />
                    </portlet:renderURL>
                    
                <a href="${editRegiURL}">Edit</a>


<!-- to delete the data-->     
  
  <portlet:actionURL name="deleteCollege" var="deleteClgURL">
                 <portlet:param name="collegeId" value="${clg.collegeId}" />
      </portlet:actionURL>
                    
                   
              <a href="${deleteClgURL}" onclick="return confirm('Are you sure you want to delete this employee?');">Delete</a>
                   
                   
                   
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
