<%-- <%@ include file="./init.jsp" %>


<portlet:actionURL name="/action/books/addBookReview" var="addReviewBookActionURL" />

<aui:form action="<%=addReviewBookActionURL%>"  method="post">

 <aui:input name="libId" type="hidden" value="${libId}" />

    <aui:input name="reviewerName" label="Reviewer Name" />
    <aui:input name="reviewDate" label="Review Date" type="date" />
    <aui:input name="rating" label="Rating" type="number" />
    <aui:input name="comment" label="Comment" type="textarea" />
    <aui:input name="approved" label="Approved" type="checkbox" />

    <aui:button type="submit" value="Submit Review" />
</aui:form> --%>

 
<%@ include file="./init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%
    long libId = ParamUtil.getLong(request, "libId");
    request.setAttribute("libId", libId); // Required for EL or AUI input
%>

<portlet:actionURL name="/action/books/addBookReview" var="addReviewBookActionURL" />

<aui:form action="<%= addReviewBookActionURL %>" method="post">
    <aui:input name="libId" type="hidden" value="<%= libId %>" />

    <aui:input name="reviewerName" label="Reviewer Name" />
    <aui:input name="reviewDate" label="Review Date" type="date" />
    <aui:input name="rating" label="Rating" type="number" />
    <aui:input name="comment" label="Comment" type="textarea" />
    <aui:input name="approved" label="Approved" type="checkbox" />

    <aui:button type="submit" value="Submit Review" />
</aui:form>
