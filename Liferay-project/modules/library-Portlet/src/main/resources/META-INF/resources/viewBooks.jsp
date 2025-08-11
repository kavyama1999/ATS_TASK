<%@ include file="./init.jsp"%>
<!-- JSTL Core Tag -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<aui:fieldset>
	<h2>Library Bookstt</h2>


	<table class="table table-bordered table-hover">


		<thead>


			<tr>
				<th>LibId</th>
				<th>BookName</th>
				<th>Author</th>

				<th>Title</th>
				<th>PublishedYear</th>

				<th>Category</th>



			</tr>

		</thead>


		<tbody>
			<c:forEach var="book" items="${getAllBooks}">
				<tr>
					<td>${book.libId}</td>
					<td>${book.book_name}</td>
					<td>${book.author}</td>
					<td>${book.title}</td>
					<td>${book.publisherd_year}</td>
					<td>${book.category}</td>

					<td><portlet:renderURL var="editBooksURL">
							<portlet:param name="jspPage" value="/EditBookDetails.jsp" />
							<portlet:param name="libId" value="${book.libId}" />
						</portlet:renderURL> <a href="${editBooksURL}">Edit Book Details</a></td>
<!-- <DELETE>
 -->					
              <td>
					<%-- <portlet:renderURL var="deleteBooksURL">
					<portlet:param name="mvcActionCommandName" value="/action/books/delete" />
			</portlet:renderURL> 
			<a href="${deleteBooksURL}">Delete </a> --%>
			
			
			<portlet:actionURL var="deleteBooksURL">
               <portlet:param name="javax.portlet.action" value="/action/books/delete" />
          <portlet:param name="lobId" value="${book.libId}" />
      </portlet:actionURL>


<a href="${deleteBooksURL}" 
       onclick="return confirm('Are you sure you want to delete this book?');">
        Delete Book			
	</td>


<!-- Link to add review -->
        <td>
            <portlet:renderURL var="reviewPageURL">
                <portlet:param name="jspPage" value="/ReviewBook.jsp" />
                <portlet:param name="libId" value="${book.libId}" />
            </portlet:renderURL>

            <a href="${reviewPageURL}">Add Review</a>
        </td>

				</tr>
			</c:forEach>
		</tbody>

	</table>

</aui:fieldset>



<%-- <td>
               <portlet:actionURL name="/delete/book" var="deleteBooksURL">
                <portlet:param name="bookId" value="${book.bookId}" />
               </portlet:actionURL>

             <a href="${deleteBooksURL}" 
       onclick="return confirm('Are you sure you want to delete this book?');">
        Delete Book
    </a>

               </td> --%>