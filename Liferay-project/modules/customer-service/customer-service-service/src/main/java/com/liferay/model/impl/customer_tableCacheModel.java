/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.model.impl;

import com.liferay.model.customer_table;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing customer_table in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class customer_tableCacheModel
	implements CacheModel<customer_table>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof customer_tableCacheModel)) {
			return false;
		}

		customer_tableCacheModel customer_tableCacheModel =
			(customer_tableCacheModel)object;

		if (custId == customer_tableCacheModel.custId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, custId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", custId=");
		sb.append(custId);
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
		sb.append(", custName=");
		sb.append(custName);
		sb.append(", age=");
		sb.append(age);
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", address=");
		sb.append(address);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public customer_table toEntityModel() {
		customer_tableImpl customer_tableImpl = new customer_tableImpl();

		if (uuid == null) {
			customer_tableImpl.setUuid("");
		}
		else {
			customer_tableImpl.setUuid(uuid);
		}

		customer_tableImpl.setCustId(custId);
		customer_tableImpl.setGroupId(groupId);
		customer_tableImpl.setCompanyId(companyId);
		customer_tableImpl.setUserId(userId);

		if (userName == null) {
			customer_tableImpl.setUserName("");
		}
		else {
			customer_tableImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			customer_tableImpl.setCreateDate(null);
		}
		else {
			customer_tableImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			customer_tableImpl.setModifiedDate(null);
		}
		else {
			customer_tableImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (custName == null) {
			customer_tableImpl.setCustName("");
		}
		else {
			customer_tableImpl.setCustName(custName);
		}

		if (age == null) {
			customer_tableImpl.setAge("");
		}
		else {
			customer_tableImpl.setAge(age);
		}

		customer_tableImpl.setSalary(salary);

		if (gender == null) {
			customer_tableImpl.setGender("");
		}
		else {
			customer_tableImpl.setGender(gender);
		}

		if (address == null) {
			customer_tableImpl.setAddress("");
		}
		else {
			customer_tableImpl.setAddress(address);
		}

		customer_tableImpl.resetOriginalValues();

		return customer_tableImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		custId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		custName = objectInput.readUTF();
		age = objectInput.readUTF();

		salary = objectInput.readLong();
		gender = objectInput.readUTF();
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

		objectOutput.writeLong(custId);

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

		if (custName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(custName);
		}

		if (age == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(age);
		}

		objectOutput.writeLong(salary);

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}
	}

	public String uuid;
	public long custId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String custName;
	public String age;
	public long salary;
	public String gender;
	public String address;

}