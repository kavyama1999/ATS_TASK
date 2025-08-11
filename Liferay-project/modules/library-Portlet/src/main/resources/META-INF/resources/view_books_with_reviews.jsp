<%@ include file="./init.jsp" %>

<%
    long groupId = themeDisplay.getScopeGroupId();
String booksWithReviewsURL11 = request.getParameter("booksWithReviewsURL");
%>
<portlet:resourceURL id="/books/reviews" var="booksWithReviewsResourceURL" escapeXml="false">
    <portlet:param name="groupId" value="<%= String.valueOf(groupId) %>" />
</portlet:resourceURL>

<%= booksWithReviewsURL11%>

<button id="<portlet:namespace />viewBooksBtn">View Books & Reviews</button>


<aui:select id="viewBooksBtnSort" name="sortBy">
    <aui:option value="bookName" selected="true">book_name</aui:option>
    <aui:option value="author">author</aui:option>
    <aui:option value="title">title</aui:option>
</aui:select>

<aui:input type="text" name="search"/>

<!-- ============================================================================ -->

<div id="<portlet:namespace />booksContainer"></div>

<!-- ============================================================================ -->



<!-- Optional styling -->
<style>
    #booksContainer div {
        border: 1px solid #ccc;
        margin: 10px 0;
        padding: 10px;
        background: #f9f9f9;
    }

    #booksContainer ul {
        padding-left: 20px;
    }
</style>

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
    $(document).ready(function () {
        $('#<portlet:namespace />viewBooksBtn').on('click', function () {
        	
        	console.log("hdfghdgfhgfh");
            const sortBy = $('#<portlet:namespace />viewBooksBtnSort').val();
            /* const search = $('#<portlet:namespace />search').val(); */

            $.ajax({
                url: '<%= booksWithReviewsURL11.toString() %>',
                type: 'GET',
                data: {
                    '<portlet:namespace/>sortBy': sortBy,
                    /* '<portlet:namespace/>search': search */
                },
                success: function (response) {
                    console.log(response);
                    if (response.success) {
                        const books = response.data;
                        let html = "<h3>Books with Reviews</h3>";

                        books.forEach(function (book) {
                            html += "<div>";
                            html += "<strong>Book Name:</strong> " + book.bookName + "<br/>";
                            html += "<strong>Author:</strong> " + book.author + "<br/>";
                            html += "<strong>Title:</strong> " + book.title + "<br/>";
                            html += "<strong>Published Year:</strong> " + book.publisherYear + "<br/>";
                            html += "<strong>Category:</strong> " + book.category + "<br/>";

                            if (book.reviews && book.reviews.length > 0) {
                                html += "<strong>Reviews:</strong><ul>";                    
                                book.reviews.forEach(function (review) {
                                    html += "<li>" +
                                        "Reviewer: " + review.reviewerName + ", " +
                                        "Rating: " + review.rating + ", " +
                                        "Comment: " + review.comment + ", " +
                                        "Approved: " + (review.approved ? "Yes" : "No") +
                                        "</li>";
                                });
                                html += "</ul>";
                            } else {
                                html += "<em>No reviews found.</em>";
                            }

                            html += "</div>";
                        });

                        $('#<portlet:namespace />booksContainer').html(html);
                    } else {
                        alert("Error: " + response.message);
                    }
                },
                error: function (xhr, status, error) {
                    console.error("AJAX Error: ", status, error);
                    alert("Failed to load book data. Please try again.");
                }
            });
        });
    });
</script>
