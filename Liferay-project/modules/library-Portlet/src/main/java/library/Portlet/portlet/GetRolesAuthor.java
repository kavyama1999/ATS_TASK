package library.Portlet.portlet;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import library.Portlet.constants.LibraryPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
        "mvc.command.name=/check/AuthorRole"
    },
    service = MVCResourceCommand.class
)
public class GetRolesAuthor implements MVCResourceCommand {
	
	
    private static final Log log = LogFactoryUtil.getLog(GetRolesAuthor.class);


    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {
        long roleId = ParamUtil.getLong(resourceRequest, "roleId");
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

        try {
            // Get users assigned to the role
            List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);
            log.info("Users :" +users);
            System.out.println("Found " + users.size() + " users for roleId: " + roleId); // Debug log

            // Build JSON array
            com.liferay.portal.kernel.json.JSONArray userArray = JSONFactoryUtil.createJSONArray();
            for (User user : users) {
                JSONObject userJson = JSONFactoryUtil.createJSONObject();
                userJson.put("fullName", user.getFullName());
                userJson.put("screenName", user.getScreenName());
                userJson.put("emailAddress", user.getEmailAddress()); // Added for debugging
                userArray.put(userJson);
            }
            jsonObject.put("users", userArray);

            resourceResponse.setContentType("application/json");
            resourceResponse.setCharacterEncoding("UTF-8");
            
            try (PrintWriter writer = resourceResponse.getWriter()) {
                writer.write(jsonObject.toString());
                System.out.println("JSON Response: " + jsonObject.toString()); // Debug log
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsonObject.put("error", "Unable to fetch users: " + e.getMessage());
            try {
                resourceResponse.getWriter().write(jsonObject.toString());
            } catch (IOException ex) {
                throw new PortletException(ex);
            }
        }

        return false;
    }
}