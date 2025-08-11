/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.model.impl;

import com.liferay.model.student;
import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class studentCacheModel implements CacheModel<student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof studentCacheModel)) {
			return false;
		}

		studentCacheModel studentCacheModel = (studentCacheModel)object;

		if (studentId == studentCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", studentId=");
		sb.append(studentId);
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
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", fees=");
		sb.append(fees);
		sb.append(", address=");
		sb.append(address);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public student toEntityModel() {
		studentImpl studentImpl = new studentImpl();

		if (uuid == null) {
			studentImpl.setUuid("");
		}
		else {
			studentImpl.setUuid(uuid);
		}

		studentImpl.setStudentId(studentId);
		studentImpl.setGroupId(groupId);
		studentImpl.setCompanyId(companyId);
		studentImpl.setUserId(userId);

		if (userName == null) {
			studentImpl.setUserName("");
		}
		else {
			studentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			studentImpl.setCreateDate(null);
		}
		else {
			studentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentImpl.setModifiedDate(null);
		}
		else {
			studentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			studentImpl.setName("");
		}
		else {
			studentImpl.setName(name);
		}

		if (qualification == null) {
			studentImpl.setQualification("");
		}
		else {
			studentImpl.setQualification(qualification);
		}

		studentImpl.setFees(fees);

		if (address == null) {
			studentImpl.setAddress("");
		}
		else {
			studentImpl.setAddress(address);
		}

		if (gender == null) {
			studentImpl.setGender("");
		}
		else {
			studentImpl.setGender(gender);
		}

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		studentId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		qualification = objectInput.readUTF();

		fees = objectInput.readLong();
		address = objectInput.readUTF();
		gender = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(studentId);

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

		if (qualification == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(qualification);
		}

		objectOutput.writeLong(fees);

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}
	}

	public String uuid;
	public long studentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String qualification;
	public long fees;
	public String address;
	public String gender;

}