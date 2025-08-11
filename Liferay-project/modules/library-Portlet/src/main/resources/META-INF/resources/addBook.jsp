
<%@ include file="./init.jsp" %>


<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>

<portlet:actionURL name="/action/books/add" var="addBookActionURL" />


<aui:form action="<%=addBookActionURL%>"  method="post">



<aui:input name="book_name"/>
<aui:input name="author"/>
<aui:input name="title"/>
<aui:input name="publisherd_year"></aui:input>
<aui:input name="category"></aui:input>


    <aui:button type="submit" value="Click to Add Books"/>
</aui:form>

<h2>FETCH USER And author</h2>



<!-- Dropdown to show all Liferay users -->
<aui:select id="userSelect" name="userId" label="Select User">
    <%
        java.util.List<User> allUsers = UserLocalServiceUtil.getUsers(-1, -1);
        for (User user1 : allUsers) {
    %>
        <aui:option value="<%= user1.getUserId() %>"><%= user1.getFullName() %></aui:option>
    <%
        }
    %>
</aui:select>

<!-- Display author name -->
<div id="<portlet:namespace />authorNameContainer" style="margin-top:10px; font-weight:bold;"></div>

<script>
    $(document).ready(function(){
        $('#<portlet:namespace />userSelect').on('change', function(){
            const userId = $(this).val();

            $.ajax({
                url: '<portlet:resourceURL id="/fetch/authorName" />',
                data: {
                    '<portlet:namespace />userId': userId
                },
                type: 'GET',
                success: function(response) {
                    if (response.success) {
                        $('#<portlet:namespace />authorNameContainer')
                          .text("Author Name in Table: " + response.authorName);
                    } else {
                        $('#<portlet:namespace />authorNameContainer')
                          .text("No author name found for this user.");
                    }
                },
                error: function() {
                    $('#<portlet:namespace />authorNameContainer')
                      .text("Error fetching author name.");
                }
            });
        });
    });
</script>
