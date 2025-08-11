<%@ include file="./init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>

<portlet:defineObjects />

<%
// Get the resource URL passed from view.jsp
String resourceURL = ParamUtil.getString(renderRequest, "resourceURL", "");
System.out.println("Resource URL received: " + resourceURL); // Debug log
%>

<div class="container">
    <h2>View Users by Role</h2>
    
    <div class="role-selection">
        <aui:select name="roleId" label="Select Role" id="roleSelect">
            <aui:option value="">-- Select a Role --</aui:option>
            <%
            java.util.List<Role> allRoles = RoleLocalServiceUtil.getRoles(themeDisplay.getCompanyId());
                for (Role role : allRoles) {
            %>
                <aui:option value="<%= role.getRoleId() %>"><%= role.getName() %></aui:option>
            <%
                }
            %>
        </aui:select>
    </div>
    
    <div id="<portlet:namespace />roleUsers" class="user-results"></div>
</div>

<script>
AUI().use('aui-base', 'aui-io-request', function(A) {
    var roleSelect = A.one('#<portlet:namespace />roleSelect');
    var roleUsersDiv = A.one('#<portlet:namespace />roleUsers');
    
    roleSelect.on('change', function() {
        var roleId = this.get('value');
        
        if (!roleId) {
            roleUsersDiv.html('');
            return;
        }
        
        roleUsersDiv.html('<div class="loading">Loading users...</div>');
        
        
        /* ===resourceURL= */
        A.io.request('<%= resourceURL %>', {
            method: 'POST',
            dataType: 'json',
            data: {
                '<portlet:namespace />roleId': roleId
            },
            on: {
                success: function() {
                    try {
                        var response = this.get('responseData');
                        console.log('Full response:', response); // Debug log
                        
                        if (!response) {
                            roleUsersDiv.html('<div class="alert error">No response from server</div>');
                            return;
                        }
                        
                        if (response.error || !response.success) {
                            var errorMsg = response.error || 'Unknown error occurred';
                            roleUsersDiv.html('<div class="alert error">' + errorMsg + '</div>');
                            return;
                        }
                        
                        var users = response.users || [];
                        var html = '<h3>Users with this role:</h3><ul class="user-list">';
                        
                        if (users.length > 0) {
                            users.forEach(function(user) {
                                html += '<li>' + 
                                    user.fullName + 
                                    ' (' + user.screenName + ')' +
                                    ' - ' + user.emailAddress +
                                    '</li>';
                            });
                        } else {
                            html += '<li class="alert info">No users assigned to this role</li>';
                        }
                        
                        html += '</ul>';
                        roleUsersDiv.html(html);
                        
                    } catch(e) {
                        console.error('Error:', e);
                        roleUsersDiv.html('<div class="alert error">Error processing data</div>');
                    }
                },
                failure: function() {
                    roleUsersDiv.html('<div class="alert error">Failed to load data</div>');
                }
            }
        });
    });
});
</script>

<style>
.container {
    max-width: 800px;
    margin: 20px auto;
    padding: 20px;
    background: #fff;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0,0,0,0.1);
}

.role-selection {
    margin-bottom: 20px;
}

.user-results {
    margin-top: 20px;
    padding: 15px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.loading {
    color: #666;
    font-style: italic;
}

.alert {
    padding: 10px;
    margin: 5px 0;
    border-radius: 4px;
}

.alert.error {
    background: #ffebee;
    color: #c62828;
    border-left: 4px solid #ef5350;
}

.alert.info {
    background: #e8f5e9;
    color: #2e7d32;
    border-left: 4px solid #4caf50;
}

.user-list {
    list-style: none;
    padding: 0;
}

.user-list li {
    padding: 8px 0;
    border-bottom: 1px solid #eee;
}
</style>