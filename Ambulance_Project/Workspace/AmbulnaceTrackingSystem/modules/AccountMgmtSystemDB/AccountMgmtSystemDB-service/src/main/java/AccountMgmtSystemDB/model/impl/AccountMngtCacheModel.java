/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.model.impl;

import AccountMgmtSystemDB.model.AccountMngt;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AccountMngt in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AccountMngtCacheModel
	implements CacheModel<AccountMngt>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountMngtCacheModel)) {
			return false;
		}

		AccountMngtCacheModel accountMngtCacheModel =
			(AccountMngtCacheModel)object;

		if (accountId == accountMngtCacheModel.accountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, accountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", accountNumber=");
		sb.append(accountNumber);
		sb.append(", accountHolderName=");
		sb.append(accountHolderName);
		sb.append(", accountType=");
		sb.append(accountType);
		sb.append(", email=");
		sb.append(email);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append(", branchName=");
		sb.append(branchName);
		sb.append(", balance=");
		sb.append(balance);
		sb.append(", ifscCode=");
		sb.append(ifscCode);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AccountMngt toEntityModel() {
		AccountMngtImpl accountMngtImpl = new AccountMngtImpl();

		if (uuid == null) {
			accountMngtImpl.setUuid("");
		}
		else {
			accountMngtImpl.setUuid(uuid);
		}

		accountMngtImpl.setAccountId(accountId);
		accountMngtImpl.setGroupId(groupId);
		accountMngtImpl.setCompanyId(companyId);
		accountMngtImpl.setUserId(userId);

		if (userName == null) {
			accountMngtImpl.setUserName("");
		}
		else {
			accountMngtImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			accountMngtImpl.setCreateDate(null);
		}
		else {
			accountMngtImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountMngtImpl.setModifiedDate(null);
		}
		else {
			accountMngtImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (accountNumber == null) {
			accountMngtImpl.setAccountNumber("");
		}
		else {
			accountMngtImpl.setAccountNumber(accountNumber);
		}

		if (accountHolderName == null) {
			accountMngtImpl.setAccountHolderName("");
		}
		else {
			accountMngtImpl.setAccountHolderName(accountHolderName);
		}

		if (accountType == null) {
			accountMngtImpl.setAccountType("");
		}
		else {
			accountMngtImpl.setAccountType(accountType);
		}

		if (email == null) {
			accountMngtImpl.setEmail("");
		}
		else {
			accountMngtImpl.setEmail(email);
		}

		if (phoneNumber == null) {
			accountMngtImpl.setPhoneNumber("");
		}
		else {
			accountMngtImpl.setPhoneNumber(phoneNumber);
		}

		if (branchName == null) {
			accountMngtImpl.setBranchName("");
		}
		else {
			accountMngtImpl.setBranchName(branchName);
		}

		accountMngtImpl.setBalance(balance);

		if (ifscCode == null) {
			accountMngtImpl.setIfscCode("");
		}
		else {
			accountMngtImpl.setIfscCode(ifscCode);
		}

		accountMngtImpl.resetOriginalValues();

		return accountMngtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		accountId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		accountNumber = objectInput.readUTF();
		accountHolderName = objectInput.readUTF();
		accountType = objectInput.readUTF();
		email = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
		branchName = objectInput.readUTF();

		balance = objectInput.readDouble();
		ifscCode = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(accountId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (accountNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountNumber);
		}

		if (accountHolderName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountHolderName);
		}

		if (accountType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accountType);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}

		if (branchName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(branchName);
		}

		objectOutput.writeDouble(balance);

		if (ifscCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ifscCode);
		}
	}

	public String uuid;
	public long accountId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String accountNumber;
	public String accountHolderName;
	public String accountType;
	public String email;
	public String phoneNumber;
	public String branchName;
	public double balance;
	public String ifscCode;

}