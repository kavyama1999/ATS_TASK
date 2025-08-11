package library.Portlet.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import library.Portlet.constants.LibraryPortletKeys;
import library.db.model.library_books;
import library.db.service.library_booksLocalServiceUtil;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
        "mvc.command.name=/action/books/add"
    },
    service = MVCActionCommand.class
)
public class AddBookActionCommand implements MVCActionCommand {

    private static final Log log = LogFactoryUtil.getLog(AddBookActionCommand.class);

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException {

        try {
        	
        	
            log.info("MVC Action Command Triggered");

            ServiceContext serviceContext = ServiceContextFactory.getInstance(
                    library_books.class.getName(), actionRequest);

            String bookName = ParamUtil.getString(actionRequest, "book_name");
            int title = ParamUtil.getInteger(actionRequest, "title");
            int publishedYear = ParamUtil.getInteger(actionRequest, "publisherd_year");
            String category = ParamUtil.getString(actionRequest, "category");

            // Get selected author user
            long authorId = ParamUtil.getLong(actionRequest, "authorId");
            String authorName = "";
            if (authorId > 0) {
                User authorUser = UserLocalServiceUtil.getUser(authorId);
                authorName = authorUser.getFullName();
            }

            // Get logged-in user details
            ThemeDisplay themeDisplay =
                    (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long userId = themeDisplay.getUserId();
            String userName = "Guest";
            if (userId > 0) {
                User user = UserLocalServiceUtil.getUser(userId);
                userName = user.getFullName();
            } else {
                log.error("User is not logged in. Assigning Guest User as default.");
            }

            // Create primary key and save
            long bookId = CounterLocalServiceUtil.increment(library_books.class.getName());
            library_books saveBooks = library_booksLocalServiceUtil.createlibrary_books(bookId);

            saveBooks.setBook_name(bookName);
            saveBooks.setAuthor(authorName);  // <-- use author from dropdown
            saveBooks.setTitle(title);
            saveBooks.setPublisherd_year(publishedYear);
            saveBooks.setCategory(category);

            // Audit fields
            saveBooks.setGroupId(serviceContext.getScopeGroupId());
            saveBooks.setCompanyId(serviceContext.getCompanyId());
            saveBooks.setUserId(userId);   // <-- correct value, not 0
            saveBooks.setUserName(userName);

            library_books data = library_booksLocalServiceUtil.addlibrary_books(saveBooks);
            log.info("Saved Book Data: " + data);

            return true;
        } catch (Exception e) {
            log.error("Error while saving book: ", e);
            throw new PortletException(e);
        }
    }
}
