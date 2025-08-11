
<%@ include file="./init.jsp"%>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="library.db.model.library_books"%>
<%@page import="library.db.service.library_booksLocalServiceUtil"%>


<h2>Fetch User ROles</h2>
 
 <%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<portlet:resourceURL id="/check/userRole" var="checkUserRoleURL" />

<div style="padding:15px; border:1px solid #ccc; width:450px; background:#fafafa;">
    <h3 style="margin-bottom:10px;">Select a Liferay User</h3>

    <!-- User Dropdown -->
    <aui:select name="userId" label="Users" id="userSelect">
        <%
            java.util.List<User> allUsers = UserLocalServiceUtil.getUsers(-1, -1);
            for (User user1 : allUsers) {
        %>
            <aui:option value="<%= user1.getUserId() %>"><%= user1.getFullName() %></aui:option>
        <%
            }
        %>
    </aui:select>

    <!-- Role Result Display -->
    <div id="<portlet:namespace />roleResult" 
         style="margin-top:20px; padding:10px; border:1px dashed #999; min-height:30px; font-weight:bold; background:#fff;">
        Please select a user to view their Author role status.
    </div>
</div>

<script>
AUI().use('aui-base', 'aui-io-request', function(A){
    A.one('#<portlet:namespace />roleSelect').on('change', function(){
        var roleId = this.get('value');
        var roleUsersDiv = A.one('#<portlet:namespace />roleUsers');
        
        if (!roleId) {
            roleUsersDiv.html('');
            return;
        }
        
        roleUsersDiv.html('<div class="loading-animation">Loading users...</div>');
        
        A.io.request('<%= checkUserRoleURL %>', {
            method: 'POST',
            dataType: 'json',
            data: {
                '<portlet:namespace />roleId': roleId
            },
            on: {
                success: function() {
                    try {
                        var responseData = this.get('responseData');
                        console.log('Response data:', responseData); // Debug log
                        
                        if (!responseData) {
                            roleUsersDiv.html('<div class="alert alert-error">Error: No response data</div>');
                            return;
                        }
                        
                        if (responseData.error) {
                            roleUsersDiv.html('<div class="alert alert-error">' + responseData.error + '</div>');
                            return;
                        }
                        
                        var users = responseData.users || [];
                        var html = '<h4>Users with selected role:</h4><ul>';
                        
                        if (users.length > 0) {
                            for (var i = 0; i < users.length; i++) {
                                var user = users[i];
                                html += '<li>' + 
                                    (user.fullName || 'No name') + 
                                   /*  ' (' + (user.screenName || 'No screen name') + ')' +
                                    ' - ' + (user.emailAddress || '') + */
                                    '</li>';
                            }
                        } else {
                            html += '<li class="alert alert-info">No users assigned to this role.</li>';
                        }
                        html += '</ul>';
                        roleUsersDiv.html(html);
                    } catch(e) {
                        console.error('Error processing response:', e);
                        roleUsersDiv.html('<div class="alert alert-error">Error processing response</div>');
                    }
                },
                failure: function() {
                    console.error('Request failed');
                    roleUsersDiv.html('<div class="alert alert-error">Request failed</div>');
                }
            }
        });
    });
});
</script>

<style>
.loading-animation {
    color: #666;
    font-style: italic;
}
.alert {
    padding: 8px 12px;
    border-radius: 4px;
    margin: 5px 0;
}
.alert-error {
    background-color: #fdd;
    border: 1px solid #f99;
    color: #900;
}
.alert-info {
    background-color: #eef;
    border: 1px solid #99f;
    color: #009;
}
</style>

 
