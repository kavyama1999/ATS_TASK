package library.Portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import library.Portlet.constants.LibraryPortletKeys;
import library.db.model.library_books;
import library.db.service.library_booksLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
		"mvc.command.name=/action/books/edit" }, service = MVCActionCommand.class)

public class EditBookActionCommand implements MVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(AddBookActionCommand.class);

	@Override

	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		log.info("MVC Action Command Triggered");

		long libraryId = ParamUtil.getLong(actionRequest, "libId");
		log.info("LibId : " + libraryId);

		String bookName = ParamUtil.getString(actionRequest, "book_name");
		String author = ParamUtil.getString(actionRequest, "author");
		int title = ParamUtil.getInteger(actionRequest, "title");
		int publishedYear = ParamUtil.getInteger(actionRequest, "publisherd_year");
		String category = ParamUtil.getString(actionRequest, "category");

//		long libId = CounterLocalServiceUtil.increment(library_books.class.getName());
//
//		library_books editedBooks = library_booksLocalServiceUtil.createlibrary_books(libId);

		library_books editedBooks = library_booksLocalServiceUtil.fetchlibrary_books(libraryId);

		editedBooks.setBook_name(bookName);
		editedBooks.setAuthor(author);
		editedBooks.setTitle(title);
		editedBooks.setPublisherd_year(publishedYear);
		editedBooks.setCategory(category);

		library_books edited = library_booksLocalServiceUtil.updatelibrary_books(editedBooks);
		log.info("Updated List : " + edited);

		return true;

	}
}