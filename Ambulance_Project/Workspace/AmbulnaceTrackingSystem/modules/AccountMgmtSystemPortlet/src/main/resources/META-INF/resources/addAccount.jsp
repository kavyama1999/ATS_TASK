<%@ include file="./init.jsp" %>


<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="java.util.List"%>

<%
List<AssetCategory> assetCategories = AssetCategoryLocalServiceUtil.getChildCategories(34176);
%>
<%

%>

<div class="account-form-container" style="max-width:700px;margin:30px auto;background:#fff;border-radius:10px;box-shadow:0 2px 10px rgba(0,0,0,0.1);padding:30px;">
    <h2 style="text-align:center;color:#0066cc;margin-bottom:25px;">Account Management Form</h2>

<portlet:actionURL name="addAccount" var="addAccountURL" />

    <aui:form action="${addAccountURL}" method="post" name="fm">
        <div class="form-section">
            <aui:fieldset label="Account Information">
                <aui:input name="accountNumber" label="Account Number" type="text" placeholder="Enter account number" required="true" />
                <aui:input name="accountHolderName" label="Account Holder Name" type="text" placeholder="Enter full name" required="true" />
               
               
               <%--  <aui:select name="accountType" label="Account Type" required="true">
                    <aui:option value="">-- Select Account Type --</aui:option>
                    <aui:option value="Savings">Savings</aui:option>
                    <aui:option value="Current">Current</aui:option>
                    <aui:option value="Salary">Salary</aui:option>
                </aui:select>
                 --%>
               
               
       <%-- <aui:select name="accountType" label="Account Type" required="true">

	<%
	for (AssetCategory assetCategory : assetCategories) {
	%>
      <aui:option value="">-- Select Account Type --</aui:option>
	
	<aui:option value="<%=assetCategory.getCategoryId()%>"><%=assetCategory.getName()%>
	</aui:option>

	<%
	}
	%>
	</aui:select> --%>        
   
    <aui:select name="accountType" label="Account Type" required="true">
    <aui:option value="">-- Select Account Type --</aui:option>

    <%
    for (AssetCategory assetCategory : assetCategories) {
    %>
        <aui:option value="<%= assetCategory.getName() %>">
            <%= assetCategory.getName() %>
        </aui:option>
    <%
    }
    %>
</aui:select>
            
            
     <aui:input name="balance" label="Balance" type="number" step="0.01" placeholder="Enter initial balance" />
            </aui:fieldset>

            <aui:fieldset label="Contact Information">
                <aui:input name="email" label="Email Address" type="email" placeholder="Enter email" />
                <aui:input name="phoneNumber" label="Phone Number" type="text" placeholder="Enter phone number" />
            </aui:fieldset>

            <aui:fieldset label="Branch Information">
                <aui:input name="branchName" label="Branch Name" type="text" placeholder="Enter branch name" />
                <aui:input name="ifscCode" label="IFSC Code" type="text" placeholder="Enter IFSC code" />
            </aui:fieldset>
        </div>

        <div style="text-align:center;margin-top:25px;">
            <aui:button type="submit" value="Save Account" cssClass="btn-primary" />
<%--             <aui:button type="reset" value="Clear Form" cssClass="btn-secondary" />
 --%>       
  </div>
    </aui:form>
</div>

<style>
.account-form-container h2 {
    font-family: 'Segoe UI', sans-serif;
    font-weight: 600;
}

.aui-field-label {
    font-weight: 500;
    color: #333;
}

.aui-field-content input,
.aui-field-content select {
    border-radius: 6px;
    border: 1px solid #ccc;
    padding: 8px;
}

.btn-primary {
    background-color: #0066cc;
    color: #fff;
    border: none;
    padding: 10px 25px;
    border-radius: 6px;
    cursor: pointer;
}

.btn-primary:hover {
    background-color: #004c99;
}

.btn-secondary {
    background-color: #e0e0e0;
    color: #333;
    border: none;
    padding: 10px 25px;
    border-radius: 6px;
    cursor: pointer;
}

.btn-secondary:hover {
    background-color: #c9c9c9;
}
</style>
