//package AccountMgmtSystemPortlet.portlet;
//
//
//import AccountMgmtSystemPortlet.constants.AccountMgmtSystemPortletKeys;
//import AccountMgmtSystemDB.model.AccountMngt;
//import AccountMgmtSystemDB.service.AccountMngtLocalServiceUtil;
//
//import com.liferay.portal.kernel.json.JSONArray;
//import com.liferay.portal.kernel.json.JSONFactoryUtil;
//import com.liferay.portal.kernel.json.JSONObject;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
//
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//import java.io.PrintWriter;
//import java.util.List;
//
//import org.osgi.service.component.annotations.Component;
//
//@Component(
//    immediate = true,
//    property = {
//        "javax.portlet.name=" + AccountMgmtSystemPortletKeys.ACCOUNTMGMTSYSTEM,
//        "mvc.command.name=/fetch/accounts"
//    },
//    service = MVCResourceCommand.class
//)
//public class FetchAccountsResourceCommand implements MVCResourceCommand {
//
//    @Override
//    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
//        try {
//            List<AccountMngt> accounts = AccountMngtLocalServiceUtil.getAccountMngts(-1, -1);
//
//            JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
//
//            for (AccountMngt acc : accounts) {
//                JSONObject json = JSONFactoryUtil.createJSONObject();
//                json.put("accountHolderName", acc.getAccountHolderName());
//                json.put("accountNumber", acc.getAccountNumber());
//                json.put("accountType", acc.getAccountType());
//                json.put("balance", acc.getBalance());
//                json.put("branchName", acc.getBranchName());
//                json.put("email", acc.getEmail());
//                json.put("ifscCode", acc.getIfscCode());
//                json.put("phoneNumber", acc.getPhoneNumber());
//                jsonArray.put(json);
//            }
//
//            resourceResponse.setContentType("application/json");
//            PrintWriter writer = resourceResponse.getWriter();
//            writer.write(jsonArray.toString());
//            writer.flush();
//            writer.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return false;
//    }
//}
