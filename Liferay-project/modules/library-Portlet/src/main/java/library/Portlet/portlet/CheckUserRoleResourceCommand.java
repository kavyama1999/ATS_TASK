
package library.Portlet.portlet;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import library.Portlet.constants.LibraryPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
        "mvc.command.name=/check/userRole"
    },
    service = MVCResourceCommand.class
)
public class CheckUserRoleResourceCommand implements MVCResourceCommand {
    
    private static final Log log = LogFactoryUtil.getLog(CheckUserRoleResourceCommand.class);
    private static final String AUTHOR_ROLE_NAME = "Author"; // Make sure this matches exactly

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        long userId = ParamUtil.getLong(resourceRequest, "userId");
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

        try {
            User user = UserLocalServiceUtil.getUser(userId);
            List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(user.getUserId());
            
            // Debugging: Log all role names
            JSONArray rolesArray = JSONFactoryUtil.createJSONArray();
            for (Role role : userRoles) {
                rolesArray.put(role.getName());
                log.debug("User role: " + role.getName());
            }
            
            // Check for Author role (exact match)
            boolean isAuthor = true;
            for (Role role : userRoles) {
                if (AUTHOR_ROLE_NAME.equals(role.getName())) {
                    isAuthor = true;
                    break;
                }
            }
            
            log.info("User " + user.getFullName() + " has Author role: " + isAuthor);

            jsonObject.put("success", true);
            jsonObject.put("isAuthor", isAuthor);
            jsonObject.put("roleName", AUTHOR_ROLE_NAME);
            jsonObject.put("userRoles", rolesArray);
            
        } catch (Exception e) {
            log.error("Error checking user roles: " + e.getMessage(), e);
            jsonObject.put("success", false);
            jsonObject.put("error", e.getMessage());
        }

        resourceResponse.setContentType("application/json");
        try (PrintWriter writer = resourceResponse.getWriter()) {
            writer.write(jsonObject.toString());
        } catch (IOException e) {
            log.error("Error writing response: " + e.getMessage(), e);
        }

        return false;
    }
}