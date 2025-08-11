<%@ page import="com.ats.bank.model.bank" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ include file="./init.jsp" %>


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>





<style>
  table.bankList {
    border: 1px solid black;
    border-collapse: collapse;
    width: 80%;
    margin: 20px auto;
  }

  table.bankList th, table.bankList td {
    border: 1px solid black;
    padding: 8px;
    text-align: left;
  }

  .action-buttons a {
    margin-right: 10px;
    text-decoration: none;
    color: blue;
  }

  .action-buttons a:hover {
    text-decoration: underline;
  }
</style>

<h2 style="text-align: center;">Bank Employee List</h2>

<table class="bankList   w-100"  >
  <thead>
    <tr>
      <th>Name</th>
      <th>Address</th>
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
    <c:forEach var="banks" items="${bankList}">
      <tr>
        <td>${banks.name}</td>
        <td>${banks.address}</td>
        <td class="action-buttons">
   
         <!--   to edit data -->
                  
                    <portlet:renderURL var="editBankDataURL">
                        <portlet:param name="jspPage" value="/updateBankData.jsp" />
                        <portlet:param name="bankId" value="${banks.bankId}" />
                    </portlet:renderURL>
                    
 
                <a href="${editBankDataURL}">Edit</a>
          
     <!-- to delete data -->

                 <portlet:actionURL name="deleteBankData" var="deleteBankDataURL">
                  <portlet:param name="bankId" value="${banks.bankId}" />
                  </portlet:actionURL>
                    

          <a href="${deleteBankDataURL}" onclick="return confirm('Are you sure you want to delete this entry?');">Delete</a>
        
        
        </td>
      </tr>
    </c:forEach>
  </tbody>
</table>
