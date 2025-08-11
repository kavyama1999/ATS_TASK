/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.model.impl;

import com.ats.bank.model.bank;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing bank in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class bankCacheModel implements CacheModel<bank>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof bankCacheModel)) {
			return false;
		}

		bankCacheModel bankCacheModel = (bankCacheModel)object;

		if (bankId == bankCacheModel.bankId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, bankId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", bankId=");
		sb.append(bankId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public bank toEntityModel() {
		bankImpl bankImpl = new bankImpl();

		if (uuid == null) {
			bankImpl.setUuid("");
		}
		else {
			bankImpl.setUuid(uuid);
		}

		bankImpl.setBankId(bankId);
		bankImpl.setGroupId(groupId);
		bankImpl.setCompanyId(companyId);
		bankImpl.setUserId(userId);

		if (userName == null) {
			bankImpl.setUserName("");
		}
		else {
			bankImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			bankImpl.setCreateDate(null);
		}
		else {
			bankImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			bankImpl.setModifiedDate(null);
		}
		else {
			bankImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			bankImpl.setName("");
		}
		else {
			bankImpl.setName(name);
		}

		if (address == null) {
			bankImpl.setAddress("");
		}
		else {
			bankImpl.setAddress(address);
		}

		bankImpl.resetOriginalValues();

		return bankImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		bankId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		address = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(bankId);

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

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public String uuid;
	public long bankId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String address;

}