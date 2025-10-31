<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page import="AccountMgmtSystemDB.model.AccountMngt" %>
<%@ page import="AccountMgmtSystemDB.service.AccountMngtLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>



<%
long accountId = ParamUtil.getLong(request, "accountId");
AccountMngt account = null;

if (accountId > 0) {
    account = AccountMngtLocalServiceUtil.fetchAccountMngt(accountId);
}
%>

<div style="max-width:700px; margin: 40px auto; background: #fff; padding: 25px; border-radius: 10px; box-shadow: 0 2px 10px rgba(0,0,0,0.1); font-family: 'Segoe UI', sans-serif;">
    <h2 style="color: #0066cc; text-align: center; margin-bottom: 25px;">Edit Account</h2>

    <portlet:actionURL name="updateAccount" var="updateAccountURL" />

    <aui:form action="${updateAccountURL}" method="post">
        <aui:input name="accountId" type="hidden" value="<%= accountId %>" />

        <aui:input name="accountNumber" label="Account Number" value="<%= account != null ? account.getAccountNumber() : \"\" %>" />
        <aui:input name="accountHolderName" label="Account Holder Name" value="<%= account != null ? account.getAccountHolderName() : \"\" %>" />
        <aui:input name="accountType" label="Account Type" value="<%= account != null ? account.getAccountType() : \"\" %>" />
        <aui:input name="balance" label="Balance" value="<%= account != null ? account.getBalance() : 0 %>" />
        <aui:input name="email" label="Email" value="<%= account != null ? account.getEmail() : \"\" %>" />
        <aui:input name="phoneNumber" label="Phone Number" value="<%= account != null ? account.getPhoneNumber() : \"\" %>" />
        <aui:input name="branchName" label="Branch Name" value="<%= account != null ? account.getBranchName() : \"\" %>" />
        <aui:input name="ifscCode" label="IFSC Code" value="<%= account != null ? account.getIfscCode() : \"\" %>" />

        <div style="text-align: center; margin-top: 25px;">
            <aui:button type="submit" value="Update Account" cssClass="btn btn-primary" />
            <portlet:renderURL var="backURL">
                <portlet:param name="jspPage" value="/view.jsp" />
            </portlet:renderURL>
<%--             <a href="${backURL}" style="margin-left: 10px; background-color: #6c757d; color: white; padding: 7px 15px; border-radius: 5px; text-decoration: none;">Cancel</a>
 --%>        </div>
    </aui:form>
</div>

<style>
.btn.btn-primary {
    background-color: #0066cc;
    color: white;
    padding: 8px 20px;
    border-radius: 5px;
    border: none;
    cursor: pointer;
}
.btn.btn-primary:hover {
    background-color: #004c99;
}
</style>
