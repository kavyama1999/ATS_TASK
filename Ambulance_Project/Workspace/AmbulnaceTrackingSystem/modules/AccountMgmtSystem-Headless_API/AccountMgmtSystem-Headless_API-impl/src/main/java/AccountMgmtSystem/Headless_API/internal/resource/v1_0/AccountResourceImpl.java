//package AccountMgmtSystem.Headless_API.internal.resource.v1_0;
//
//import AccountMgmtSystem.Headless_API.dto.v1_0.AccountMngt;
//import AccountMgmtSystem.Headless_API.resource.v1_0.AccountResource;
//
//import com.liferay.petra.function.UnsafeBiConsumer;
//import com.liferay.petra.function.UnsafeFunction;
//
//import java.util.Collection;
//
//import org.osgi.service.component.annotations.Component;
//import org.osgi.service.component.annotations.ServiceScope;
//
///**
// * @author Admin
// */
//@Component(
//	properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
//	scope = ServiceScope.PROTOTYPE, service = AccountResource.class
//)
//public class AccountResourceImpl extends BaseAccountResourceImpl {
//
//	
//}

package AccountMgmtSystem.Headless_API.internal.resource.v1_0;

import AccountMgmtSystem.Headless_API.dto.v1_0.AccountMngt;
import AccountMgmtSystem.Headless_API.resource.v1_0.AccountResource;

//import AccountMgmtSystemDB.model.AccountMngt as AccountMngtModel;
import AccountMgmtSystemDB.service.AccountMngtLocalServiceUtil;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.function.UnsafeBiConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * ✅ Headless API for Account Management
 * Supports: GET all, POST, PUT, DELETE
 * @author Kavya
 */
@Component(
    properties = "OSGI-INF/liferay/rest/v1_0/account.properties",
    scope = ServiceScope.PROTOTYPE,
    service = AccountResource.class
)
public class AccountResourceImpl extends BaseAccountResourceImpl {

    private static final Log _log = LogFactoryUtil.getLog(AccountResourceImpl.class);

    // ✅ GET - Fetch all accounts
    @Override
    public Page<AccountMngt> getAccounts() throws Exception {
        _log.info("Fetching all account records from database...");

        List<AccountMgmtSystemDB.model.AccountMngt> accountList =
                AccountMngtLocalServiceUtil.getAccountMngts(-1, -1);
        List<AccountMngt> dtoList = new ArrayList<>();

        for (AccountMgmtSystemDB.model.AccountMngt account : accountList) {
            dtoList.add(toDTO(account));
        }

        _log.debug("Total accounts found: " + dtoList.size());
        return Page.of(dtoList);
    }

    
    // ✅ POST - Add new account
    @Override
    public AccountMngt addAccount(AccountMngt dto) throws Exception {
        _log.info("Adding new account for holder: " + dto.getAccountHolderName());

        long accountId = CounterLocalServiceUtil.increment(
                AccountMgmtSystemDB.model.AccountMngt.class.getName());

        AccountMgmtSystemDB.model.AccountMngt account =
                AccountMngtLocalServiceUtil.createAccountMngt(accountId);

        account.setAccountNumber(dto.getAccountNumber());
        account.setAccountHolderName(dto.getAccountHolderName());
        account.setAccountType(dto.getAccountType());
        account.setEmail(dto.getEmail());
        account.setPhoneNumber(dto.getPhoneNumber());
        account.setBranchName(dto.getBranchName());
        account.setBalance(dto.getBalance());
        account.setIfscCode(dto.getIfscCode());

        AccountMgmtSystemDB.model.AccountMngt saved =
                AccountMngtLocalServiceUtil.addAccountMngt(account);

        _log.debug("Account added successfully with ID=" + saved.getAccountId());
        return toDTO(saved);
    }

    // ✅ PUT - Update account
    @Override
    public AccountMngt updateAccount(AccountMngt dto) throws Exception {
        if (Validator.isNull(dto.getAccountId())) {
            _log.error("Account ID is missing for update operation.");
            throw new PortalException("Account ID is required for update.");
        }

        _log.info("Updating account with ID=" + dto.getAccountId());

        AccountMgmtSystemDB.model.AccountMngt existing =
                AccountMngtLocalServiceUtil.getAccountMngt(dto.getAccountId());

        existing.setAccountNumber(dto.getAccountNumber());
        existing.setAccountHolderName(dto.getAccountHolderName());
        existing.setAccountType(dto.getAccountType());
        existing.setEmail(dto.getEmail());
        existing.setPhoneNumber(dto.getPhoneNumber());
        existing.setBranchName(dto.getBranchName());
        existing.setBalance(dto.getBalance());
        existing.setIfscCode(dto.getIfscCode());

        AccountMgmtSystemDB.model.AccountMngt updated =
                AccountMngtLocalServiceUtil.updateAccountMngt(existing);

        _log.debug("Account updated successfully for ID=" + updated.getAccountId());
        return toDTO(updated);
    }

    // ✅ DELETE - Delete account by ID
    @Override
    public AccountMngt deleteAccount(Long accountId) throws Exception {
        _log.info("Deleting account with ID=" + accountId);

        AccountMgmtSystemDB.model.AccountMngt deleted =
                AccountMngtLocalServiceUtil.deleteAccountMngt(accountId);

        _log.debug("Account deleted successfully for ID=" + accountId);
        return toDTO(deleted);
    }

    // ✅ Helper: Convert entity model → DTO
    private AccountMngt toDTO(AccountMgmtSystemDB.model.AccountMngt model) {
        AccountMngt dto = new AccountMngt();

        dto.setAccountId(model.getAccountId());
        dto.setAccountNumber(model.getAccountNumber());
        dto.setAccountHolderName(model.getAccountHolderName());
        dto.setAccountType(model.getAccountType());
        dto.setEmail(model.getEmail());
        dto.setPhoneNumber(model.getPhoneNumber());
        dto.setBranchName(model.getBranchName());
        dto.setBalance(model.getBalance());
        dto.setIfscCode(model.getIfscCode());

        return dto;
    }

//    @Override
//    public void setContextBatchUnsafeBiConsumer(
//            UnsafeBiConsumer<Collection<AccountMngt>, UnsafeFunction<AccountMngt, AccountMngt, Exception>, Exception>
//                    contextBatchUnsafeBiConsumer) {
//        // Not used in this API
//    }
}
