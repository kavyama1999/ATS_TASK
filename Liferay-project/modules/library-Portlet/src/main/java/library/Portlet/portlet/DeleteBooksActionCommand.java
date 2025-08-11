package library.Portlet.portlet;

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

@Component(

		immediate = true, property = { "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
				"mvc.command.name=/action/books/delete" }, service = MVCActionCommand.class)

public class DeleteBooksActionCommand implements MVCActionCommand {
	private static final Log log = LogFactoryUtil.getLog(AddBookActionCommand.class);

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		log.info("Delete method");

		long libraryId = ParamUtil.getLong(actionRequest, "lobId");
		log.info("Deleted ID :" + libraryId);

		library_books deleteBooks = library_booksLocalServiceUtil.fetchlibrary_books(libraryId);

		library_books deletedBook = library_booksLocalServiceUtil.deletelibrary_books(deleteBooks);

		log.info("DeletedBooks----.....---- ; " + deleteBooks);
		return false;
	}

}