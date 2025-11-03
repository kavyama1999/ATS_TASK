<%-- <%@ include file="./init.jsp" %>



<h2>AccountMgmtSystem</h2>

<portlet:renderURL var="addAccountURL">
    <portlet:param name="jspPage" value="/addAccount.jsp"/>
</portlet:renderURL>
<a href="${addAccountURL}">Add Account</a><br>
 --%>
 
 
 <%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="java.util.List" %>
<%@ page import="AccountMgmtSystemDB.model.AccountMngt" %>
<%@ page import="AccountMgmtSystemDB.service.AccountMngtLocalServiceUtil" %>

<%
List<AccountMngt> accountList = AccountMngtLocalServiceUtil.getAccountMngts(-1, -1);
%>


<div class="account-container">

    <div class="account-header">
        <h2>Account Management System</h2>

        <portlet:renderURL var="addAccountURL">
            <portlet:param name="jspPage" value="/addAccount.jsp" />
        </portlet:renderURL>

        <a href="${addAccountURL}" class="add-btn">+ Add Account</a>
    </div>

    <table class="account-table">
        <thead>
            <tr>
                <th>Account No</th>
                <th>Holder Name</th>
                <th>Type</th>
                <th>Balance</th>
                <th>Email</th>
                <th>PhoneNo</th>
                <th>Branch Name</th>
                <th>IFSC Code</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <%
            if (accountList != null && !accountList.isEmpty()) {
                for (AccountMngt acc : accountList) {
            %>
            <tr>
                <td><%= acc.getAccountNumber() %></td>
                <td><%= acc.getAccountHolderName() %></td>
                <td><%= acc.getAccountType() %></td>
                <td><%= acc.getBalance() %></td>
                <td><%= acc.getEmail() %></td>
                <td><%= acc.getPhoneNumber() %></td>
                <td><%= acc.getBranchName() %></td>
                <td><%= acc.getIfscCode() %></td>
                <td>
                    <!-- Edit URL -->
                    <portlet:renderURL var="editAccountURL">
                        <portlet:param name="jspPage" value="/editAccount.jsp" />
                        <portlet:param name="accountId" value="<%= String.valueOf(acc.getAccountId()) %>" />
                    </portlet:renderURL>
                    
                    <a href="${editAccountURL}" class="action-btn btn-edit">Edit</a>

                    <!-- Delete URL -->
                   <%--  <portlet:actionURL name="deleteAccount" var="deleteAccountURL">
                        <portlet:param name="accountId" value="<%= String.valueOf(acc.getAccountId()) %>" />
                    </portlet:actionURL>


                    <aui:form action="${deleteAccountURL}" method="post" style="display:inline;">
                        <aui:button type="submit" value="Delete" cssClass="action-btn btn-delete" />
                    </aui:form> --%>
                    
                    
   <portlet:actionURL name="deleteAccount" var="deleteAccountURL">
    <portlet:param name="accountId" value="<%= String.valueOf(acc.getAccountId()) %>" />
</portlet:actionURL>

<aui:form action="${deleteAccountURL}" method="post" name="deleteForm" style="display:inline;">
    <aui:button 
        type="submit" value="Delete" cssClass="action-btn btn-delete" 
        onClick="return confirm('Are you sure you want to delete this account?');" 
    />
</aui:form>
                    
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="9" style="text-align:center;padding:15px;">No accounts found.</td>
            </tr>
            <%
            }
            %>
        </tbody>
    </table>
</div>

<style>
.account-container {
    max-width: 95%;
    margin: 30px auto;
    padding: 20px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
    font-family: 'Segoe UI', sans-serif;
}

.account-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

.account-header h2 {
    color: #0066cc;
    margin: 0;
    font-weight: 600;
}

.add-btn {
    background-color: #0066cc;
    color: white;
    padding: 10px 20px;
    border-radius: 6px;
    text-decoration: none;
    font-weight: 500;
}

.add-btn:hover {
    background-color: #004c99;
}

.account-table {
    width: 100%;
    border-collapse: collapse;
}

.account-table th,
.account-table td {
    border: 1px solid #ddd; /* Divider lines between columns */
    padding: 10px;
    text-align: center;
    vertical-align: middle;
}

.account-table th {
    background-color: #0066cc;
    color: white;
}

.account-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.account-table tr:hover {
    background-color: #eef5ff;
}

/* Common button style */
.action-btn {
    display: inline-block;
    width: 75px;
    text-align: center;
    padding: 6px 0;
    border-radius: 5px;
    font-size: 14px;
    font-weight: 500;
    text-decoration: none;
    color: white;
    border: none;
    cursor: pointer;
}

/* Edit Button */
.btn-edit {
    background-color: #28a745;
}

.btn-edit:hover {
    background-color: #218838;
}

/* Delete Button */
.btn-delete {
    background-color: #dc3545;
}

.btn-delete:hover {
    background-color: #c82333;
}
</style>

 