
<%@page import="library.db.model.library_books"%>
<%@page import="library.db.service.library_booksLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="./init.jsp"%>

<portlet:actionURL name="/action/books/edit" var="editBookActionURL" />

<%
long getUserId = ParamUtil.getLong(renderRequest, "libId");

library_books fetchBookDetails = library_booksLocalServiceUtil.fetchlibrary_books(getUserId);
%>

<aui:form action="<%=editBookActionURL%>" method="post">


	<aui:input type="hidden" name="libId" value="<%=fetchBookDetails.getLibId()%>">
	</aui:input>

	<aui:input name="book_name" value="<%=fetchBookDetails.getBook_name()%>" />
	<aui:input name="author" value="<%=fetchBookDetails.getAuthor()%>"/>
	<aui:input name="title" value="<%=fetchBookDetails.getTitle()%>"/>
	<aui:input name="publisherd_year" value="<%=fetchBookDetails.getPublisherd_year()%>"></aui:input>
	<aui:input name="category" value="<%=fetchBookDetails.getCategory()%>"></aui:input>

	<aui:button type="submit" value="Click to Books" />
</aui:form>