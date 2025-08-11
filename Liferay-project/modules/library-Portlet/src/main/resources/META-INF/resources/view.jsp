

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="library.db.model.library_books"%>
<%@page import="library.db.service.library_booksLocalServiceUtil"%>
<%@ include file="./init.jsp"%>


<h2>MVC ACTION COMMAND SAVE OPERATION</h2>


<%
    long groupId = themeDisplay.getScopeGroupId();
%>
<portlet:renderURL var="addPageURL">
	<portlet:param name="jspPage" value="/addBook.jsp" />
</portlet:renderURL>


<a href="${addPageURL }">Add Books</a>
<br>



<%-- 
This is for if we use MVC
<portlet:param name="jspPage" value="/viewBooks.jsp" />
 --%>


<portlet:renderURL var="viewBooksURL">
    <portlet:param name="mvcRenderCommandName" value="/view/books" />
</portlet:renderURL>

<a href="${viewBooksURL}">View Book List</a><br>


<!-- ================================================================ -->

<portlet:renderURL var="reviewBookURL">
    <portlet:param name="jspPage" value="/ReviewBook.jsp" />
</portlet:renderURL>

<a href="${reviewBookURL}">Add Book Reviw 1</a><br>

<!-- ================================================================ -->


<portlet:renderURL var="fetchAuthorRoleURL">
    <portlet:param name="jspPage" value="/fetchingAuthorRole.jsp" />
</portlet:renderURL>

<a href="${fetchAuthorRoleURL}">Fetch </a><br>

<!-- =============================================================
 For Dynamic Query-->

<portlet:renderURL var="viewQueryPageURL">
    <portlet:param name="jspPage" value="/dynamicQuerySearch.jsp" />
</portlet:renderURL>

<a href="${viewQueryPageURL}">Dynamic Query</a><br>

<!-- =========================================================================
 --><portlet:resourceURL id="/books/reviews" var="booksWithReviewsResourceURL" escapeXml="false">
    <portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
</portlet:resourceURL>

 <portlet:renderURL var="booksWithReviewsURL" >
    <portlet:param name="jspPage" value="/view_books_with_reviews.jsp" />
    <portlet:param name="booksWithReviewsURL" value="<%=booksWithReviewsResourceURL%>" />
</portlet:renderURL>

<%=booksWithReviewsResourceURL %>
<a href="${booksWithReviewsURL}">View Books with Reviews </a><br>
<!-- 
==========================================
for cheking liferayUser assiging roles
===================================================== -->
 
 
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
AUI().use('aui-node', 'aui-io-request', function(A) {
    var dropdown = A.one('select[name="<portlet:namespace />userId"]');
    var resultDiv = A.one('#<portlet:namespace />roleResult');

    dropdown.on('change', function() {
        var userId = dropdown.val();
        resultDiv.html("<em>Checking roles...</em>");

        A.io.request('<%= checkUserRoleURL %>', {
            method: 'GET',
            dataType: 'json',
            data: {
                '<portlet:namespace />userId': userId
            },
            on: {
                success: function() {
                    var response = this.get('responseData');
                    console.log("Full response:", response); // Debug logging

                    if (response.success) {
                        if (response.isAuthor) {
                            resultDiv.html(
                                "<span style='color:green;'>✔ User has the <b>" + response.roleName + "</b> role.</span>" +
                                (response.userRoles ? "<br><br>User's roles: " + response.userRoles.join(", ") : "")
                            );
                        } else {
                            resultDiv.html(
                                "<span style='color:red;'>✖ User does NOT have the <b>" + response.roleName + "</b> role.</span>" +
                                (response.userRoles ? "<br><br>User's actual roles: " + response.userRoles.join(", ") : "")
                            );
                        }
                    } else {
                        resultDiv.html("<span style='color:red;'>Error checking role: " + response.error + "</span>");
                    }
                },
                failure: function() {
                    resultDiv.html("<span style='color:red;'>AJAX error while fetching role.</span>");
                }
            }
        });
    });
});
</script>

<!-- ========================================================================
=======================Getting Liferay Roles============================ -->

<%@ page import="com.liferay.portal.kernel.model.Role" %>
<%@ page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil" %>

<portlet:defineObjects />

<portlet:resourceURL id="/check/AuthorRole" var="getRolesURL" />
<h2>Getting Liferay Roles........</h2>

<div style="padding:15px; border:1px solid #ccc; width:450px; background:#fafafa;">
    <h3 style="margin-bottom:10px;">Select a Liferay Role</h3>

    <!-- Role Dropdown -->
    <aui:select name="roleId" label="Roles" id="roleSelect">
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
    
    <div id="<portlet:namespace />roleUsers" style="margin-top:20px;"></div>
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
        
        A.io.request('<%= getRolesURL %>', {
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



 <%-- <portlet:defineObjects /> --%>
 
<%-- <%-- First declare your resource URL 
<portlet:resourceURL var="fetchbooksWithReviewsResourceURL" id="/check/AuthorRole" />

Then create the render URL
<portlet:renderURL var="fetchRoleURL">
    <portlet:param name="jspPage" value="/getRoleAndUserAjax.jsp" />
    <portlet:param name="resourceURL" value="${fetchbooksWithReviewsResourceURL}" />
</portlet:renderURL>

<a href="${fetchRoleURL}">View Books with Reviews (Author Role)</a><br>
  --%>
  
  
  
  
  <portlet:renderURL var="fetchRoleURL">
	<portlet:param name="MVCResourceCommand" value="/getRoleAndUserAjax.jsp" />
</portlet:renderURL>

<a href="${fetchRoleURL}">View Books with Reviews 11(Author Role)</a><br>

<!-- use cmds don't use mvcPath
 --> 