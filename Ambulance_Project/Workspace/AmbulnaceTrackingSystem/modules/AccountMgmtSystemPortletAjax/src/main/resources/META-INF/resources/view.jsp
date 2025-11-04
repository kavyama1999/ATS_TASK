<%--  <!-- AJAX -->
<%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>



<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">


<!-- ✅ Include jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- ✅ Create Resource URL -->
<portlet:resourceURL id="getAccounts" var="getAccountsURL" />
<portlet:actionURL name="deleteAccount" var="deleteAccountURL" />

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
    const deleteURL = '<%= deleteAccountURL %>';

    // ✅ Fetch and display accounts
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
                            <th>Actions</th>
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
                            <td>
                                <button class="edit-btn" data-id="\${acc.accountId}">✏️ Edit</button>
                                <button class="delete-btn" data-id="\${acc.accountId}">🗑 Delete</button>
                            </td>
                        </tr>
                    `;
                });
            } else {
                html += `<tr><td colspan="10">No accounts found</td></tr>`;
            }

            html += `</tbody></table>`;
            $("#accountList").html(html);
        },
        error: function(err) {
            console.error("❌ Error fetching data:", err);
            $("#accountList").html("<p style='color:red;'>Failed to load accounts.</p>");
        }
    });

    // 🗑 Handle Delete button click
    $(document).on("click", ".delete-btn", function() {
        const accId = $(this).data("id");
        if (confirm("Are you sure you want to delete account ID " + accId + "?")) {
            $.ajax({
                url: deleteURL,
                type: "POST",
                data: { accountId: accId },
                success: function() {
                    alert("✅ Account deleted successfully!");
                    location.reload(); // reload after delete
                },
                error: function(err) {
                    console.error("❌ Delete failed:", err);
                    alert("Failed to delete account.");
                }
            });
        }
    });

    // ✏️ Handle Edit button click
    $(document).on("click", ".edit-btn", function() {
        const accId = $(this).data("id");

        // Redirect to edit JSP page with accountId param
        const editURL = '<portlet:renderURL var="editAccountURL"><portlet:param name="jspPage" value="/editAccount.jsp" /><portlet:param name="accountId" value="__ID__" /></portlet:renderURL>';
        const finalURL = editURL.replace("__ID__", accId);
        window.location.href = finalURL;
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
.edit-btn, .delete-btn {
    padding: 6px 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin: 0 3px;
    font-size: 14px;
}
.edit-btn {
    background-color: #007bff;
}


.edit-btn:hover {
    background-color: #e6b800;
}
.delete-btn {
    background-color: #ff4444;
    color: white;
}
.delete-btn:hover {
    background-color: #cc0000;
}
</style>
 
 
   --%>
   
   
   
   <%@ include file="./init.jsp" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">

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

    // ✅ Fetch and display accounts
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
                            <th>Actions</th>
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
                            <td>
                                <button class="edit-btn" data-id="\${acc.accountId}">✏️ Edit</button>
                                <button class="delete-btn" data-id="\${acc.accountId}">🗑 Delete</button>
                            </td>
                        </tr>
                    `;
                });
            } else {
                html += `<tr><td colspan="10">No accounts found</td></tr>`;
            }

            html += `</tbody></table>`;
            $("#accountList").html(html);
        },
        error: function(err) {
            console.error("❌ Error fetching data:", err);
            $("#accountList").html("<p style='color:red;'>Failed to load accounts.</p>");
        }
    });
 // 🗑 Handle Delete button click (via Liferay ResourceCommand)
    $(document).on("click", ".delete-btn", function() {
        const accId = $(this).data("id");

        if (confirm("Are you sure you want to delete account ID " + accId + "?")) {

            // ✅ Create the Liferay Resource URL dynamically
            const deleteURL = '<portlet:resourceURL id="deleteAccount" />' + '&accountId=' + accId;

            $.ajax({
                url: deleteURL,
                type: "POST", // ✅ Liferay requires POST for resource requests
                headers: {
                    "Accept": "application/json",
                    "x-csrf-token": Liferay.authToken
                },
                success: function() {
                    alert("✅ Account deleted successfully!");
                    location.reload();
                },
                error: function(err) {
                    console.error("❌ Delete failed:", err);
                    alert("❌ Failed to delete account. Check console for details.");
                }
            });
        }
    });


    // ✏️ Handle Edit button click
    $(document).on("click", ".edit-btn", function() {
        const accId = $(this).data("id");

        // Redirect to edit JSP page with accountId param
        const editURL = '<portlet:renderURL var="editAccountURL"><portlet:param name="jspPage" value="/editAccount.jsp" /><portlet:param name="accountId" value="__ID__" /></portlet:renderURL>';
        const finalURL = editURL.replace("__ID__", accId);
        window.location.href = finalURL;
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
.edit-btn, .delete-btn {
    padding: 6px 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    margin: 0 3px;
    font-size: 14px;
}
.edit-btn {
    background-color: #007bff;
    color: white;
}
.edit-btn:hover {
    background-color: #0056b3;
}
.delete-btn {
    background-color: #ff4444;
    color: white;
}
.delete-btn:hover {
    background-color: #cc0000;
}
</style>
   