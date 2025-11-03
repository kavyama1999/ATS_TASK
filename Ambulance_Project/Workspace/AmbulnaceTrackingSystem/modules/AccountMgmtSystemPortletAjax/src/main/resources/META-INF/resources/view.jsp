
<!-- AJAX -->
  
<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<!-- ✅ Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- ✅ Create Resource URL -->
<portlet:resourceURL id="getAccounts" var="getAccountsURL" />

<div class="account-container">
    
   <div class="account-header">
    <h2>Account Management System Ajax Call</h2>

        <portlet:renderURL var="addAccountURL">
            <portlet:param name="jspPage" value="/addAccount.jsp" />
        </portlet:renderURL>

        <a href="${addAccountURL}" class="add-btn">+ Add Account</a>
    </div>
    
    <div id="accountList"><p>Loading accounts...</p></div>
</div>

<script>
$(document).ready(function() {
    const resourceURL = '<%= getAccountsURL %>';

    $.ajax({
        url: resourceURL,
        type: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log("✅ API Data:", data);

            let html = `
                <table class="account-table">
                    <thead>
                        <tr>

                            <th>Account ID</th>
                            <th>Account No</th>
                            <th>Holder Name</th>
                            <th>Type</th>
                            <th>Balance</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>Branch</th>
                            <th>IFSC</th>
                        </tr>
                    </thead>
                    <tbody>
            `;

            if (data && data.items && data.items.length > 0) {
                data.items.forEach(function(acc) {
                    html += `
                        <tr>
                            <td>\${acc.accountId || '-'}</td>
                            <td>\${acc.accountNumber || '-'}</td>
                            <td>\${acc.accountHolderName || '-'}</td>
                            <td>\${acc.accountType || '-'}</td>
                            <td>\${acc.balance || '-'}</td>
                            <td>\${acc.email || '-'}</td>
                            <td>\${acc.phoneNumber || '-'}</td>
                            <td>\${acc.branchName || '-'}</td>
                            <td>\${acc.ifscCode || '-'}</td>
                        </tr>
                    `;
                });
            } else {
                html += `<tr><td colspan="9">No accounts found</td></tr>`;
            }

            html += `</tbody></table>`;
            $("#accountList").html(html);
        },
        error: function(err) {
            console.error("❌ Error fetching data:", err);
            $("#accountList").html("<p style='color:red;'>Failed to load accounts.</p>");
        }
    });
});
</script>

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
.account-table {
    width: 100%;
    border-collapse: collapse;
}
.account-table th,
.account-table td {
    border: 1px solid #ddd;
    padding: 10px;
    text-align: center;
}
.account-table th {
    background-color: #0066cc;
    color: white;
}
.account-table tr:nth-child(even) {
    background-color: #f9f9f9;
}

.account-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
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
</style>
