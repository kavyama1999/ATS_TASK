package library.Portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import library.Portlet.constants.LibraryPortletKeys;
import library.db.model.library_books;
import library.db.service.library_booksLocalServiceUtil;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
		"mvc.command.name=/view/books" }, service = MVCRenderCommand.class)

public class ViewBookRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(ViewBookRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		log.info("List of books");

		List<library_books> getBooks = library_booksLocalServiceUtil.getlibrary_bookses(-1, -1);

		renderRequest.setAttribute("getAllBooks", getBooks);

//	return null;
		return "/viewBooks.jsp";
	}

}
