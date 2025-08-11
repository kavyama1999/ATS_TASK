package library.Portlet.portlet;

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

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import library.Portlet.constants.LibraryPortletKeys;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + LibraryPortletKeys.LIBRARY,
        "mvc.command.name=/check/AuthorUserRole"
    },
    service = MVCResourceCommand.class
)
public class RoleBasedUserResource implements MVCResourceCommand {
    
    private static final Log log = LogFactoryUtil.getLog(RoleBasedUserResource.class);
    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {
        long roleId = ParamUtil.getLong(resourceRequest, "roleId");
        
        log.info("Processing request for roleId 123: " + roleId);
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

        try {
            // First verify the role exists
            try {
                Role role = RoleLocalServiceUtil.getRole(roleId);
                log.info("Found role: " + role.getName());
            } catch (Exception e) {
                jsonObject.put("error", "Role with ID " + roleId + " not found");
                writeResponse(resourceResponse, jsonObject);
                return false;
            }

            // Get users assigned to the role
            List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);
            log.info("Found " + users.size() + " users for roleId: " + roleId);

            // Build JSON array
            com.liferay.portal.kernel.json.JSONArray userArray = JSONFactoryUtil.createJSONArray();
            for (User user : users) {
                JSONObject userJson = JSONFactoryUtil.createJSONObject();
                userJson.put("userId", user.getUserId());
                userJson.put("fullName", user.getFullName());
                userJson.put("screenName", user.getScreenName());
                userJson.put("emailAddress", user.getEmailAddress());
                userArray.put(userJson);
            }
            log.info("4677878787 :"+userArray.length());
            jsonObject.put("users", userArray);
            jsonObject.put("roleId", roleId);
            jsonObject.put("count", users.size());
log.info("11" +jsonObject);
            writeResponse(resourceResponse, jsonObject);
        } catch (Exception e) {
            log.error("Error processing request for roleId: " + roleId, e);
            jsonObject.put("error", "Error processing request: " + e.getMessage());
            try {
				writeResponse(resourceResponse, jsonObject);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }

        return false;
    }

    private void writeResponse(ResourceResponse response, JSONObject json) throws IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(json.toString());
        }
    }
}