package library.Portlet.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import library.Portlet.constants.LibraryPortletKeys;
import library.db.model.book_review;
import library.db.model.library_books;
import library.db.service.book_reviewLocalService;
import library.db.service.book_reviewLocalServiceUtil;
import library.db.service.library_booksLocalService;
import library.db.service.library_booksLocalServiceUtil;

@Component(
    property = {
        "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
        "mvc.command.name=/books/reviews"
    },
    service = MVCResourceCommand.class
)
public class BooksWithReviewsResourceCommand implements MVCResourceCommand {

    private static final Log _log = LogFactoryUtil.getLog(BooksWithReviewsResourceCommand.class);
    
    @Reference
    private library_booksLocalService _libraryBooksLocalService;
    @Reference
    private book_reviewLocalService _bookReviewLocalService;

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        try {
            long groupId = ParamUtil.getLong(resourceRequest, "groupId");
            
            String sortBy = ParamUtil.getString(resourceRequest, "sortBy", "book_name"); // default book_name

            String search = ParamUtil.getString(resourceRequest, "search", "book_name");
            _log.info(">>>> groupId received: " + groupId);
            _log.info(">>>> groupId search: " + search);

            if (groupId <= 0) {
                _log.error("Invalid or missing groupId.");
                return false;
           
            }

          // List<library_books> books = _libraryBooksLocalService.findByGroupId(groupId);
            JSONArray booksArray = JSONFactoryUtil.createJSONArray();
            
//            _log.info("Books: " + books);

//            =============================================
            
            DynamicQuery dy = _libraryBooksLocalService.dynamicQuery();
           List<library_books> books = new ArrayList<>(_libraryBooksLocalService.findByGroupId(groupId));

            
         // Sorting based on dropdown selection
           
         if ("author".equalsIgnoreCase(sortBy)) {
        	dy.addOrder(OrderFactoryUtil.asc("author"));
          books.sort(Comparator.comparing(library_books::getAuthor, String.CASE_INSENSITIVE_ORDER));
         } else if ("title".equalsIgnoreCase(sortBy)) {
        	 dy.addOrder(OrderFactoryUtil.asc("title"));
             books.sort(Comparator.comparingInt(library_books::getPublisherd_year));
         } else {
         dy.addOrder(OrderFactoryUtil.asc("title"));
       books.sort(Comparator.comparing(library_books::getBook_name, String.CASE_INSENSITIVE_ORDER));
         }
        
// =================================================================
         
         dy.add(RestrictionsFactoryUtil.eq("title", search));
         dy.add(RestrictionsFactoryUtil.ilike("book_name", search));
         dy.add(RestrictionsFactoryUtil.ilike("Author", search));
//         List<library_books> books  = _libraryBooksLocalService.dynamicQuery(dy,0,3);

         
//         ==================================================================================
            for (library_books book : books) {
                JSONObject bookJSON = JSONFactoryUtil.createJSONObject();
                bookJSON.put("bookName", book.getBook_name());
                bookJSON.put("author", book.getAuthor());
                bookJSON.put("title", book.getTitle());
                bookJSON.put("publisherYear", book.getPublisherd_year());
                bookJSON.put("category", book.getCategory());

                List<book_review> reviews = _bookReviewLocalService.findByLibId(book.getLibId());
                JSONArray reviewsArray = JSONFactoryUtil.createJSONArray();

               _log.info(">>>> Reviews: " + reviews);

                for (book_review review : reviews) {
                    JSONObject reviewJSON = JSONFactoryUtil.createJSONObject();
                    reviewJSON.put("reviewerName", review.getReviewerName());
                    reviewJSON.put("reviewDate", String.valueOf(review.getReviewDate()));
                    reviewJSON.put("rating", review.getRating());
                    reviewJSON.put("comment", review.getComment());
                    reviewJSON.put("approved", review.getApproved());
                    reviewsArray.put(reviewJSON);
                }

                bookJSON.put("reviews", reviewsArray);
                booksArray.put(bookJSON);
            }

            JSONObject result = JSONFactoryUtil.createJSONObject();
            result.put("success", true);
            result.put("data", booksArray);

            _log.info("Result: ---"+result);
            resourceResponse.setContentType("application/json"); // ✅ IMPORTANT
            PrintWriter writer = resourceResponse.getWriter();
            writer.write(result.toString()); // ✅ result is JSON, not a stringified string

            return true;
        } catch (Exception e) {
            _log.error("Error in BooksWithReviewsResourceCommand: ", e);
            return false;
        }
    }
}
