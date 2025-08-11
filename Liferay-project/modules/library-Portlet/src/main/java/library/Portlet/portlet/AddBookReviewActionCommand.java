package library.Portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import library.Portlet.constants.LibraryPortletKeys;
import library.db.model.book_review;
import library.db.model.library_books;
import library.db.service.book_reviewLocalServiceUtil;
import library.db.service.library_booksLocalServiceUtil;

@Component(immediate = true, property = 
{ "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
		"mvc.command.name=/action/books/addBookReview" }, 
service = MVCActionCommand.class)

public class AddBookReviewActionCommand implements MVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(AddBookActionCommand.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		log.info("Add Book Review");

		// Get service context
        try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
			    library_books.class.getName(), actionRequest);
		
		
	    long libId = ParamUtil.getLong(actionRequest, "libId"); // ✅ Get libId

		
		String reviewerName = ParamUtil.getString(actionRequest, "reviewerName");
		Date reviewDate = ParamUtil.getDate(actionRequest, "reviewDate", null);

		int rating = ParamUtil.getInteger(actionRequest, "rating");
		String comment = ParamUtil.getString(actionRequest, "comment");

		boolean approved = ParamUtil.getBoolean(actionRequest, "approved");

		book_review bookReview = book_reviewLocalServiceUtil.getInstance();
		bookReview.setLibId(libId);
		bookReview.setReviewerName(reviewerName);
		bookReview.setReviewDate(reviewDate);
		bookReview.setRating(rating);
		bookReview.setComment(comment);
		bookReview.setApproved(approved);

		
		// Set audit fields from service context
		bookReview.setGroupId(serviceContext.getScopeGroupId());
		bookReview.setCompanyId(serviceContext.getCompanyId());
		bookReview.setUserId(serviceContext.getUserId());

		book_review savedBookReview = book_reviewLocalServiceUtil.addbook_review(bookReview);
		log.info("SavedBoooks***** : " + savedBookReview);

		return true;
        } catch (Exception e) {
			log.error("Error while saving book: ", e);

			e.printStackTrace();
		}
		return false;
	}

}

