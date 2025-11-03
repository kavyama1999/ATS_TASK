//package AccountMgmtSystemPortletAjax.portlet;
//
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
//import com.liferay.portal.kernel.util.Base64;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.PortalUtil;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.ProtocolException;
//import java.net.URL;
//
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//import javax.servlet.http.HttpServletRequest;
//
//import org.osgi.service.component.annotations.Component;
//
//import AccountMgmtSystemPortletAjax.constants.AccountMgmtSystemPortletAjaxPortletKeys;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + AccountMgmtSystemPortletAjaxPortletKeys.ACCOUNTMGMTSYSTEMPORTLETAJAX,
//        "mvc.command.name=deleteAccount"
//    },
//    service = MVCResourceCommand.class
//)
//public class DeleteAccountMVCResourceCommand implements MVCResourceCommand {
//
//    private static final Log log = LogFactoryUtil.getLog(DeleteAccountMVCResourceCommand.class);
//
//    @Override
//    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//
//        log.info("🗑️ DeleteAccountMVCResourceCommand triggered");
//
//        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(resourceRequest);
//
//        // ✅ Get CSRF Token
//        String csrfToken = AuthTokenUtil.getToken(httpRequest);
//
//        // ✅ Get accountId from AJAX request
//        long accountId = ParamUtil.getLong(resourceRequest, "accountId");
//        log.info("🔹 Account ID to delete: " + accountId);
//
//        // ✅ Construct API URL
//        String apiUrl = PortalUtil.getPortalURL(resourceRequest)
//                + "/o/AccountMgmtSystem-Headless_API/v1.0/delete-account?accountId=" + accountId;
//
//        log.info("🌐 Calling Headless API: " + apiUrl);
//
//        // ✅ Setup HTTP connection
//        URL url;
//		try {
//			url = new URL(apiUrl);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        HttpURLConnection con = (HttpURLConnection) url.openConnection();
//        try {
//			con.setRequestMethod("DELETE");
//		} catch (ProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        con.setRequestProperty("Accept", "application/json");
//        con.setRequestProperty("x-csrf-token", csrfToken);
//        con.setRequestProperty("Cookie", httpRequest.getHeader("Cookie"));
//
//        // ✅ Basic Authentication (use your correct credentials)
//        String login = "test@liferay.com:test";
//        String basicAuth = "Basic " + Base64.encode(login.getBytes());
//        con.setRequestProperty("Authorization", basicAuth);
//
//        // ✅ Read Response
//        int responseCode;
//		try {
//			responseCode = con.getResponseCode();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        log.info("🔸 Response Code: " + responseCode);
//
//        StringBuilder response = new StringBuilder();
//        try (BufferedReader in = new BufferedReader(
//                new InputStreamReader(
//                        responseCode == 200 ? con.getInputStream() : con.getErrorStream(),
//                        "UTF-8"))) {
//            String line;
//            while ((line = in.readLine()) != null) {
//                response.append(line);
//            }
//        }
//
//        // ✅ Return response to AJAX
//        resourceResponse.setContentType("application/json");
//        PrintWriter writer = resourceResponse.getWriter();
//        writer.write(response.toString());
//        writer.flush();
//
//        log.info("✅ Delete response sent to JSP successfully");
//        return false; // Important: don't trigger view.jsp render
//    }
//}
