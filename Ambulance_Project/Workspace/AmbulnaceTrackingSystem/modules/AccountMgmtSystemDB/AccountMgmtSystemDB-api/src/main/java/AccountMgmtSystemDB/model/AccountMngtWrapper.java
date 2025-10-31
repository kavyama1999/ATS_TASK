/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AccountMngt}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngt
 * @generated
 */
public class AccountMngtWrapper
	extends BaseModelWrapper<AccountMngt>
	implements AccountMngt, ModelWrapper<AccountMngt> {

	public AccountMngtWrapper(AccountMngt accountMngt) {
		super(accountMngt);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accountId", getAccountId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("accountNumber", getAccountNumber());
		attributes.put("accountHolderName", getAccountHolderName());
		attributes.put("accountType", getAccountType());
		attributes.put("email", getEmail());
		attributes.put("phoneNumber", getPhoneNumber());
		attributes.put("branchName", getBranchName());
		attributes.put("balance", getBalance());
		attributes.put("ifscCode", getIfscCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long accountId = (Long)attributes.get("accountId");

		if (accountId != null) {
			setAccountId(accountId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String accountNumber = (String)attributes.get("accountNumber");

		if (accountNumber != null) {
			setAccountNumber(accountNumber);
		}

		String accountHolderName = (String)attributes.get("accountHolderName");

		if (accountHolderName != null) {
			setAccountHolderName(accountHolderName);
		}

		String accountType = (String)attributes.get("accountType");

		if (accountType != null) {
			setAccountType(accountType);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}

		String branchName = (String)attributes.get("branchName");

		if (branchName != null) {
			setBranchName(branchName);
		}

		Double balance = (Double)attributes.get("balance");

		if (balance != null) {
			setBalance(balance);
		}

		String ifscCode = (String)attributes.get("ifscCode");

		if (ifscCode != null) {
			setIfscCode(ifscCode);
		}
	}

	@Override
	public AccountMngt cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the account holder name of this account mngt.
	 *
	 * @return the account holder name of this account mngt
	 */
	@Override
	public String getAccountHolderName() {
		return model.getAccountHolderName();
	}

	/**
	 * Returns the account ID of this account mngt.
	 *
	 * @return the account ID of this account mngt
	 */
	@Override
	public long getAccountId() {
		return model.getAccountId();
	}

	/**
	 * Returns the account number of this account mngt.
	 *
	 * @return the account number of this account mngt
	 */
	@Override
	public String getAccountNumber() {
		return model.getAccountNumber();
	}

	/**
	 * Returns the account type of this account mngt.
	 *
	 * @return the account type of this account mngt
	 */
	@Override
	public String getAccountType() {
		return model.getAccountType();
	}

	/**
	 * Returns the balance of this account mngt.
	 *
	 * @return the balance of this account mngt
	 */
	@Override
	public double getBalance() {
		return model.getBalance();
	}

	/**
	 * Returns the branch name of this account mngt.
	 *
	 * @return the branch name of this account mngt
	 */
	@Override
	public String getBranchName() {
		return model.getBranchName();
	}

	/**
	 * Returns the company ID of this account mngt.
	 *
	 * @return the company ID of this account mngt
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this account mngt.
	 *
	 * @return the create date of this account mngt
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the email of this account mngt.
	 *
	 * @return the email of this account mngt
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the group ID of this account mngt.
	 *
	 * @return the group ID of this account mngt
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the ifsc code of this account mngt.
	 *
	 * @return the ifsc code of this account mngt
	 */
	@Override
	public String getIfscCode() {
		return model.getIfscCode();
	}

	/**
	 * Returns the modified date of this account mngt.
	 *
	 * @return the modified date of this account mngt
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the phone number of this account mngt.
	 *
	 * @return the phone number of this account mngt
	 */
	@Override
	public String getPhoneNumber() {
		return model.getPhoneNumber();
	}

	/**
	 * Returns the primary key of this account mngt.
	 *
	 * @return the primary key of this account mngt
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this account mngt.
	 *
	 * @return the user ID of this account mngt
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this account mngt.
	 *
	 * @return the user name of this account mngt
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this account mngt.
	 *
	 * @return the user uuid of this account mngt
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this account mngt.
	 *
	 * @return the uuid of this account mngt
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the account holder name of this account mngt.
	 *
	 * @param accountHolderName the account holder name of this account mngt
	 */
	@Override
	public void setAccountHolderName(String accountHolderName) {
		model.setAccountHolderName(accountHolderName);
	}

	/**
	 * Sets the account ID of this account mngt.
	 *
	 * @param accountId the account ID of this account mngt
	 */
	@Override
	public void setAccountId(long accountId) {
		model.setAccountId(accountId);
	}

	/**
	 * Sets the account number of this account mngt.
	 *
	 * @param accountNumber the account number of this account mngt
	 */
	@Override
	public void setAccountNumber(String accountNumber) {
		model.setAccountNumber(accountNumber);
	}

	/**
	 * Sets the account type of this account mngt.
	 *
	 * @param accountType the account type of this account mngt
	 */
	@Override
	public void setAccountType(String accountType) {
		model.setAccountType(accountType);
	}

	/**
	 * Sets the balance of this account mngt.
	 *
	 * @param balance the balance of this account mngt
	 */
	@Override
	public void setBalance(double balance) {
		model.setBalance(balance);
	}

	/**
	 * Sets the branch name of this account mngt.
	 *
	 * @param branchName the branch name of this account mngt
	 */
	@Override
	public void setBranchName(String branchName) {
		model.setBranchName(branchName);
	}

	/**
	 * Sets the company ID of this account mngt.
	 *
	 * @param companyId the company ID of this account mngt
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this account mngt.
	 *
	 * @param createDate the create date of this account mngt
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the email of this account mngt.
	 *
	 * @param email the email of this account mngt
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the group ID of this account mngt.
	 *
	 * @param groupId the group ID of this account mngt
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the ifsc code of this account mngt.
	 *
	 * @param ifscCode the ifsc code of this account mngt
	 */
	@Override
	public void setIfscCode(String ifscCode) {
		model.setIfscCode(ifscCode);
	}

	/**
	 * Sets the modified date of this account mngt.
	 *
	 * @param modifiedDate the modified date of this account mngt
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the phone number of this account mngt.
	 *
	 * @param phoneNumber the phone number of this account mngt
	 */
	@Override
	public void setPhoneNumber(String phoneNumber) {
		model.setPhoneNumber(phoneNumber);
	}

	/**
	 * Sets the primary key of this account mngt.
	 *
	 * @param primaryKey the primary key of this account mngt
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this account mngt.
	 *
	 * @param userId the user ID of this account mngt
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this account mngt.
	 *
	 * @param userName the user name of this account mngt
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this account mngt.
	 *
	 * @param userUuid the user uuid of this account mngt
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this account mngt.
	 *
	 * @param uuid the uuid of this account mngt
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected AccountMngtWrapper wrap(AccountMngt accountMngt) {
		return new AccountMngtWrapper(accountMngt);
	}

}