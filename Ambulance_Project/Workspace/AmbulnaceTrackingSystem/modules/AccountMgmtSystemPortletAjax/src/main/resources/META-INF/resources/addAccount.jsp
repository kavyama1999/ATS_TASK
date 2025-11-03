<%-- <%@ include file="./init.jsp" %>


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
               
               
                <aui:select name="accountType" label="Account Type" required="true">
                    <aui:option value="">-- Select Account Type --</aui:option>
                    <aui:option value="Savings">Savings</aui:option>
                    <aui:option value="Current">Current</aui:option>
                    <aui:option value="Salary">Salary</aui:option>
                </aui:select>
                
               
               
       <aui:select name="accountType" label="Account Type" required="true">

	<%
	for (AssetCategory assetCategory : assetCategories) {
	%>
      <aui:option value="">-- Select Account Type --</aui:option>
	
	<aui:option value="<%=assetCategory.getCategoryId()%>"><%=assetCategory.getName()%>
	</aui:option>

	<%
	}
	%>
	</aui:select>        
   
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
            <aui:button type="reset" value="Clear Form" cssClass="btn-secondary" />
       
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
 --%>
 
 <%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<portlet:resourceURL id="saveAccount" var="saveAccountURL" />

<div class="account-form-container">
    <h2>Add New Account</h2>

    <form id="accountForm">
          <!--<label>Account ID:</label>
       <input type="text" name="accountId" required><br> -->

        <label>Account Number:</label>
        <input type="text" name="accountNumber" required><br>

        <label>Holder Name:</label>
        <input type="text" name="accountHolderName" required><br>

        <label>Type:</label>
        <input type="text" name="accountType" required><br>

        <label>Balance:</label>
        <input type="number" name="balance" required><br>

        <label>Email:</label>
        <input type="email" name="email" required><br>

        <label>Phone:</label>
        <input type="text" name="phoneNumber" required><br>

        <label>Branch:</label>
        <input type="text" name="branchName" required><br>

        <label>IFSC:</label>
        <input type="text" name="ifscCode" required><br>

        <button type="submit">Save Account</button>
    </form>

    <p id="responseMsg"></p>
</div>

<script>
$(document).ready(function() {
    $("#accountForm").on("submit", function(e) {
        e.preventDefault();

        const formData = {};
        $(this).serializeArray().forEach(field => formData[field.name] = field.value);

        console.log("🚀 Sending:", formData);

        $.ajax({
            url: "<%= saveAccountURL %>",
            type: "POST",
            data: JSON.stringify(formData),
            contentType: "application/json",
            dataType: "json",
            success: function(res) {
                console.log("✅ Response:", res);
                $("#responseMsg").text("✅ Account saved successfully!");
            },
            error: function(err) {
                console.error("❌ Error:", err);
                $("#responseMsg").text("❌ Failed to save account.");
            }
        });
    });
});
</script>

<style>
.account-form-container {
    max-width: 500px;
    margin: 30px auto;
    padding: 20px;
    background: #fff;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    font-family: 'Segoe UI', sans-serif;
}
label {
    display: block;
    margin-top: 10px;
    font-weight: bold;
}
input {
    width: 100%;
    padding: 8px;
    margin-top: 5px;
}
button {
    margin-top: 15px;
    padding: 10px 20px;
    background: #0066cc;
    color: white;
    border: none;
    border-radius: 6px;
}
button:hover {
    background: #004c99;
}
</style>
 