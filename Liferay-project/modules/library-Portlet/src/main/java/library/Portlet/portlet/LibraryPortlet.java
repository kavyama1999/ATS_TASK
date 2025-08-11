package library.Portlet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import java.io.IOException;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import library.Portlet.constants.LibraryPortletKeys;
import library.db.model.book_review;
import library.db.model.library_books;
import library.db.service.book_reviewLocalServiceUtil;
import library.db.service.library_booksLocalServiceUtil;

@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Library",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class LibraryPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		// TODO Auto-generated method stub
		super.doView(renderRequest, renderResponse);
		User user;
		try {
			user = UserLocalServiceUtil.getUser(1);
			user.getExpandoBridge().getAttribute("blood group");
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	/*
	 * @Override public void serveResource(ResourceRequest resourceRequest,
	 * ResourceResponse resourceResponse) throws IOException, PortletException {
	 * 
	 * long libId = ParamUtil.getLong(resourceRequest, "libId");
	 * 
	 * JSONObject resultJson = JSONFactoryUtil.createJSONObject();
	 * 
	 * try { // Get book details library_books book =
	 * library_booksLocalServiceUtil.fetchlibrary_books(libId);
	 * 
	 * if (book != null) { JSONObject bookJson = JSONFactoryUtil.createJSONObject();
	 * bookJson.put("book_name", book.getBook_name()); bookJson.put("author",
	 * book.getAuthor()); bookJson.put("title", book.getTitle());
	 * bookJson.put("publisherd_year", book.getPublisherd_year());
	 * bookJson.put("category", book.getCategory());
	 * 
	 * resultJson.put("book", bookJson); }
	 * 
	 * // Get reviews List<book_review> reviews =
	 * book_reviewLocalServiceUtil.findBylibId(libId); JSONArray reviewArray =
	 * JSONFactoryUtil.createJSONArray();
	 * 
	 * for (book_review review : reviews) { JSONObject reviewJson =
	 * JSONFactoryUtil.createJSONObject(); reviewJson.put("reviewerName",
	 * review.getReviewerName()); reviewJson.put("reviewDate",
	 * review.getReviewDate().toString()); reviewJson.put("rating",
	 * review.getRating()); reviewJson.put("comment", review.getComment());
	 * reviewJson.put("approved", review.getApproved());
	 * 
	 * reviewArray.put(reviewJson); }
	 * 
	 * resultJson.put("reviews", reviewArray);
	 * 
	 * } catch (Exception e) { resultJson.put("error", e.getMessage()); }
	 * 
	 * resourceResponse.setContentType("application/json");
	 * resourceResponse.getWriter().write(resultJson.toString()); }
	 */
}
