package AccountMgmtSystemPortlet.portlet;

import AccountMgmtSystemPortlet.constants.AccountMgmtSystemPortletKeys;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.headless.admin.user.dto.v1_0.Account;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

import AccountMgmtSystemDB.model.AccountMngt;
import AccountMgmtSystemDB.service.AccountMngtLocalServiceUtil;

/**
 * @author Admin
 */
@Component(
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AccountMgmtSystem",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AccountMgmtSystemPortletKeys.ACCOUNTMGMTSYSTEM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AccountMgmtSystemPortlet extends MVCPortlet {
	
    private static final Log log = LogFactoryUtil.getLog(AccountMgmtSystemPortlet.class);
    
    public void addAccount(ActionRequest actionRequest, ActionResponse actionResponse)
    			throws IOException, PortletException {
    	
    	log.info("Add Account Method");
    	
    	try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			// Get form fields
			String accountNumber = ParamUtil.getString(actionRequest, "accountNumber");
			String accountHolderName = ParamUtil.getString(actionRequest, "accountHolderName");
			String accountType = ParamUtil.getString(actionRequest, "accountType");
			double balance = ParamUtil.getDouble(actionRequest, "balance");
			String email = ParamUtil.getString(actionRequest, "email");
			String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber");
			String branchName = ParamUtil.getString(actionRequest, "branchName");
			String ifscCode = ParamUtil.getString(actionRequest, "ifscCode");

			// Create Account object

			long accountId = CounterLocalServiceUtil.increment(Account.class.getName());
			AccountMngt account = AccountMngtLocalServiceUtil.createAccountMngt(accountId);

			// Set values
			account.setAccountNumber(accountNumber);
			account.setAccountHolderName(accountHolderName);
			account.setAccountType(accountType);
			account.setBalance(balance);
			account.setEmail(email);
			account.setPhoneNumber(phoneNumber);
			account.setBranchName(branchName);
			account.setIfscCode(ifscCode);

			// Liferay standard audit fields
			account.setCompanyId(themeDisplay.getCompanyId());
			account.setGroupId(themeDisplay.getScopeGroupId());
			account.setUserId(themeDisplay.getUserId());
			account.setUserName(themeDisplay.getUser().getFullName());
			account.setCreateDate(new Date());
			account.setModifiedDate(new Date());

			// Save to database
			AccountMngtLocalServiceUtil.addAccountMngt(account);

			log.info("✅ Account added successfully for: " + accountHolderName);

		} catch (Exception e) {
			log.error("❌ Error while adding account", e);
		}
	}
    	
    
    
    //update
    
    public void updateAccount(ActionRequest actionRequest, ActionResponse actionResponse)
    		throws IOException, PortletException {
    	log.info("Inside Update Method");
    	
    	try {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

            long accountId = ParamUtil.getLong(actionRequest, "accountId");
            String accountNumber = ParamUtil.getString(actionRequest, "accountNumber");
            String accountHolderName = ParamUtil.getString(actionRequest, "accountHolderName");
            String accountType = ParamUtil.getString(actionRequest, "accountType");
            double balance = ParamUtil.getDouble(actionRequest, "balance");
            String email = ParamUtil.getString(actionRequest, "email");
            String phoneNumber = ParamUtil.getString(actionRequest, "phoneNumber");
            String branchName = ParamUtil.getString(actionRequest, "branchName");
            String ifscCode = ParamUtil.getString(actionRequest, "ifscCode");

            AccountMngt account = AccountMngtLocalServiceUtil.fetchAccountMngt(accountId);

            if (account != null) {
                account.setAccountNumber(accountNumber);
                account.setAccountHolderName(accountHolderName);
                account.setAccountType(accountType);
                account.setBalance(balance);
                account.setEmail(email);
                account.setPhoneNumber(phoneNumber);
                account.setBranchName(branchName);
                account.setIfscCode(ifscCode);
//                account.setModifiedDate(new Date());
//                account.setUserId(themeDisplay.getUserId());
//                account.setUserName(themeDisplay.getUser().getFullName());

                AccountMngtLocalServiceUtil.updateAccountMngt(account);

                log.info("✅ Account updated successfully for: " + accountHolderName);
            } else {
                log.error("❌ Account not found with ID: " + accountId);
            }

            // Redirect back to view.jsp
            actionResponse.setRenderParameter("jspPage", "/view.jsp");

        } catch (Exception e) {
            log.error("❌ Error while updating account", e);
        }
    	
    }
    
    
    //delete
    
//    public void deleteAccount(ActionRequest actionRequest, ActionResponse actionResponse)
//    		throws IOException, PortletException {
//    	log.info("Inside Delete method");
//    	
//    	try {
//            // Get accountId from the request
//            long accountId = ParamUtil.getLong(actionRequest, "accountId");
//
//            if (accountId > 0) {
//                // Delete from database using Service Builder’s util class
//                AccountMngtLocalServiceUtil.deleteAccountMngt(accountId);
//
//                log.info("✅ Account deleted successfully. ID: " + accountId);
//            } else {
//                log.warn("⚠️ Invalid Account ID for deletion");
//            }
//
////            // Redirect back to view.jsp
////            actionResponse.sendRedirect("/web" + actionRequest.getContextPath() + "/view.jsp");
//
//        } catch (Exception e) {
//            log.error("❌ Error while deleting account", e);
//        }
//    	
//    }
//   }
    
    public void deleteAccount(ActionRequest actionRequest, ActionResponse actionResponse)
            throws IOException, PortletException {

        try {
            long accountId = ParamUtil.getLong(actionRequest, "accountId");

            if (accountId > 0) {
                AccountMngtLocalServiceUtil.deleteAccountMngt(accountId);
                log.info("✅ Account deleted successfully. ID: " + accountId);
            } else {
                log.warn("⚠️ Invalid Account ID for deletion");
            }

            // ✅ Redirect back to view.jsp safely within the same portlet
            actionResponse.setRenderParameter("mvcPath", "/view.jsp");

        } catch (Exception e) {
            log.error("❌ Error while deleting account", e);
        }
    }
}

////Delete
//public void deleteEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
//        throws IOException, PortletException, PortalException {
//
//    long employeeId = ParamUtil.getLong(actionRequest, "empId");
//
//    employee emp = employeeLocalServiceUtil.fetchemployee(employeeId);
//
//    if (emp != null) {
//        employeeLocalServiceUtil.deleteemployee(emp);
//    }
//}
