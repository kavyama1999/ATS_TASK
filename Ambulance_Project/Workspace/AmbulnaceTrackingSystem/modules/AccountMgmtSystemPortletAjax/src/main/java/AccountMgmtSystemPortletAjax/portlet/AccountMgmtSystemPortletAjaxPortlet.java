package AccountMgmtSystemPortletAjax.portlet;

import AccountMgmtSystemPortletAjax.constants.AccountMgmtSystemPortletAjaxPortletKeys;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

//import AccountMgmtSystemPortlet.portlet.AccountMgmtSystemPortlet;

//import AccountMgmtSystemPortlet.portlet.AccountMgmtSystemPortlet;

/**
 * @author Kavya
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AccountMgmtSystemPortletAjax",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AccountMgmtSystemPortletAjaxPortletKeys.ACCOUNTMGMTSYSTEMPORTLETAJAX,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)


public class AccountMgmtSystemPortletAjaxPortlet extends MVCPortlet {

    private static final Log log = LogFactoryUtil.getLog(AccountMgmtSystemPortletAjaxPortlet.class);

    
    //AJAX Call
//    @Override
//    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//            throws IOException, PortletException {
//    log.info("Now Ajax Calling ");
//        Log log = LogFactoryUtil.getLog(AccountMgmtSystemPortletAjaxPortlet.class);
//        log.info("🔹 serveResource() called");
//
//        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
//        String csrfToken = AuthTokenUtil.getToken(httpRequest);
//
//        // ✅ Your Headless API URL
//        String apiUrl = PortalUtil.getPortalURL(resourceRequest)
//                + "/o/AccountMgmtSystem-Headless_API/v1.0/get-accounts";
//
//        log.info("🌐 Calling Headless API: " + apiUrl);
//
//        URL url = new URL(apiUrl);
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setRequestProperty("Accept", "application/json");
//        con.setRequestProperty("x-csrf-token", csrfToken);
//        con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
//
//        // ✅ Optional authentication (only if needed)
//        String login = "test@liferay.com:test";
//        String basicAuth = "Basic " + Base64.encode(login.getBytes());
//        con.setRequestProperty("Authorization", basicAuth);
//
//        int responseCode = con.getResponseCode();
//        log.info("🔸 Response Code: " + responseCode);
//
//        StringBuilder response = new StringBuilder();
//        try (BufferedReader in = new BufferedReader(new InputStreamReader(
//                responseCode == 200 ? con.getInputStream() : con.getErrorStream(), "UTF-8"))) {
//            String line;
//            while ((line = in.readLine()) != null) {
//                response.append(line);
//            }
//        }
//
//        // ✅ Don't reparse or rebuild JSON — return directly
//        resourceResponse.setContentType("application/json");
//        PrintWriter writer = resourceResponse.getWriter();
//        writer.write(response.toString());
//        writer.flush();
//
//        log.info("✅ JSON data sent to JSP successfully");
//    }
    
    /* @Override YESTERDAY
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException, PortletException {

        Log log = LogFactoryUtil.getLog(AccountMgmtSystemPortletAjaxPortlet.class);
        String resourceId = resourceRequest.getResourceID();
        log.info("🔹 Resource called: " + resourceId);

        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        String csrfToken = AuthTokenUtil.getToken(httpRequest);
        String baseUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/AccountMgmtSystem-Headless_API/v1.0";

        if ("getAccounts".equals(resourceId)) {
            // ✅ Existing GET logic
            String apiUrl = baseUrl + "/get-accounts";
            sendHttpRequest(apiUrl, "GET", null, csrfToken, httpRequest, resourceResponse, log);

        } else if ("saveAccount".equals(resourceId)) {
            // ✅ Handle POST save
            String apiUrl = baseUrl + "/add-account";
            String jsonData = new BufferedReader(new InputStreamReader(resourceRequest.getPortletInputStream()))
                    .lines().reduce("", (acc, line) -> acc + line);
            log.info("📦 Saved Data: " + jsonData);

            log.info("📦 Received JSON: " + jsonData);
            sendHttpRequest(apiUrl, "POST", jsonData, csrfToken, httpRequest, resourceResponse, log);
        }
     
        //Ajax Delete
        else if ("deleteAccount".equals(resourceId)) {
            // ✅ Delete account
            long accountId = ParamUtil.getLong(resourceRequest, "accountId");
            log.info("🗑 Deleting Account ID: " + accountId);
            String apiUrl = baseUrl + "/delete-account?accountId=" + accountId;
            sendHttpRequest(apiUrl, "DELETE", null, csrfToken, httpRequest, resourceResponse, log);
        }  
        
    }

    // ✅ Helper Method
    private void sendHttpRequest(String apiUrl, String method, String body, String csrfToken,
                                 HttpServletRequest httpRequest, ResourceResponse resourceResponse, Log log) throws IOException {

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-csrf-token", csrfToken);
        con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
        con.setRequestProperty("Authorization", "Basic " + Base64.encode("test@liferay.com:test".getBytes()));

        if ("POST".equalsIgnoreCase(method)) {
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.getOutputStream().write(body.getBytes("UTF-8"));
        }

        int responseCode = con.getResponseCode();
        log.info("🔸 Response Code: " + responseCode);

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                responseCode == 200 ? con.getInputStream() : con.getErrorStream(), "UTF-8"))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        }

        resourceResponse.setContentType("application/json");
        PrintWriter writer = resourceResponse.getWriter();
        writer.write(response.toString());
        writer.flush();

        log.info("✅ Response sent back to JSP");
    }

}*/
    
    
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws IOException, PortletException {

        Log log = LogFactoryUtil.getLog(AccountMgmtSystemPortletAjaxPortlet.class);
        String resourceId = resourceRequest.getResourceID();
        log.info("🔹 Resource called: " + resourceId);

        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        String csrfToken = AuthTokenUtil.getToken(httpRequest);
        String baseUrl = PortalUtil.getPortalURL(resourceRequest) + "/o/AccountMgmtSystem-Headless_API/v1.0";

        if ("getAccounts".equals(resourceId)) {
            // ✅ Existing GET logic
            String apiUrl = baseUrl + "/get-accounts";
            sendHttpRequest(apiUrl, "GET", null, csrfToken, httpRequest, resourceResponse, log);

        } else if ("saveAccount".equals(resourceId)) {
            // ✅ Handle POST save
            String apiUrl = baseUrl + "/add-account";
            String jsonData = new BufferedReader(new InputStreamReader(resourceRequest.getPortletInputStream()))
                    .lines().reduce("", (acc, line) -> acc + line);
            log.info("📦 Received JSON: " + jsonData);
            sendHttpRequest(apiUrl, "POST", jsonData, csrfToken, httpRequest, resourceResponse, log);
        }

        // ✅ NEW: AJAX Delete logic added here
        else if ("deleteAccount".equals(resourceId)) {
            // ✅ Handle delete
            long accountId = ParamUtil.getLong(resourceRequest, "accountId");
            log.info("🗑 Deleting Account ID: " + accountId);

            // ✅ Use REST path style
            String apiUrl = baseUrl + "/delete-account/" + accountId;

            sendHttpRequest(apiUrl, "DELETE", null, csrfToken, httpRequest, resourceResponse, log);
        }
    }

    // ✅ Common HTTP request helper
    private void sendHttpRequest(String apiUrl, String method, String body, String csrfToken,
                                 HttpServletRequest httpRequest, ResourceResponse resourceResponse, Log log) throws IOException {

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod(method);
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("x-csrf-token", csrfToken);
        con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
        con.setRequestProperty("Authorization", "Basic " + Base64.encode("test@liferay.com:test".getBytes()));

        // ✅ Allow sending data for POST requests only
        if ("POST".equalsIgnoreCase(method)) {
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json");
            con.getOutputStream().write(body.getBytes("UTF-8"));
        }

        int responseCode = con.getResponseCode();
        log.info("🔸 Response Code: " + responseCode);

        StringBuilder response = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(
                responseCode >= 200 && responseCode < 300 ? con.getInputStream() : con.getErrorStream(), "UTF-8"))) {
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
        }

        resourceResponse.setContentType("application/json");
        PrintWriter writer = resourceResponse.getWriter();
        writer.write(response.toString());
        writer.flush();

        log.info("✅ Response sent back to JSP");
    }
}