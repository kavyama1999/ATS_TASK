/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.model.impl;

import CaseManagementDB.model.CaseMngt;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CaseMngt in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CaseMngtCacheModel
	implements CacheModel<CaseMngt>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CaseMngtCacheModel)) {
			return false;
		}

		CaseMngtCacheModel caseMngtCacheModel = (CaseMngtCacheModel)object;

		if (caseId == caseMngtCacheModel.caseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, caseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", caseId=");
		sb.append(caseId);
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
		sb.append(", caseNumber=");
		sb.append(caseNumber);
		sb.append(", caseType=");
		sb.append(caseType);
		sb.append(", patientName=");
		sb.append(patientName);
		sb.append(", patientAge=");
		sb.append(patientAge);
		sb.append(", description=");
		sb.append(description);
		sb.append(", patientGender=");
		sb.append(patientGender);
		sb.append(", location=");
		sb.append(location);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CaseMngt toEntityModel() {
		CaseMngtImpl caseMngtImpl = new CaseMngtImpl();

		if (uuid == null) {
			caseMngtImpl.setUuid("");
		}
		else {
			caseMngtImpl.setUuid(uuid);
		}

		caseMngtImpl.setCaseId(caseId);
		caseMngtImpl.setGroupId(groupId);
		caseMngtImpl.setCompanyId(companyId);
		caseMngtImpl.setUserId(userId);

		if (userName == null) {
			caseMngtImpl.setUserName("");
		}
		else {
			caseMngtImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			caseMngtImpl.setCreateDate(null);
		}
		else {
			caseMngtImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			caseMngtImpl.setModifiedDate(null);
		}
		else {
			caseMngtImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (caseNumber == null) {
			caseMngtImpl.setCaseNumber("");
		}
		else {
			caseMngtImpl.setCaseNumber(caseNumber);
		}

		if (caseType == null) {
			caseMngtImpl.setCaseType("");
		}
		else {
			caseMngtImpl.setCaseType(caseType);
		}

		if (patientName == null) {
			caseMngtImpl.setPatientName("");
		}
		else {
			caseMngtImpl.setPatientName(patientName);
		}

		caseMngtImpl.setPatientAge(patientAge);

		if (description == null) {
			caseMngtImpl.setDescription("");
		}
		else {
			caseMngtImpl.setDescription(description);
		}

		if (patientGender == null) {
			caseMngtImpl.setPatientGender("");
		}
		else {
			caseMngtImpl.setPatientGender(patientGender);
		}

		if (location == null) {
			caseMngtImpl.setLocation("");
		}
		else {
			caseMngtImpl.setLocation(location);
		}

		if (contactNumber == null) {
			caseMngtImpl.setContactNumber("");
		}
		else {
			caseMngtImpl.setContactNumber(contactNumber);
		}

		caseMngtImpl.resetOriginalValues();

		return caseMngtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		caseId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		caseNumber = objectInput.readUTF();
		caseType = objectInput.readUTF();
		patientName = objectInput.readUTF();

		patientAge = objectInput.readInt();
		description = objectInput.readUTF();
		patientGender = objectInput.readUTF();
		location = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(caseId);

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

		if (caseNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseNumber);
		}

		if (caseType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(caseType);
		}

		if (patientName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patientName);
		}

		objectOutput.writeInt(patientAge);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (patientGender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(patientGender);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}
	}

	public String uuid;
	public long caseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String caseNumber;
	public String caseType;
	public String patientName;
	public int patientAge;
	public String description;
	public String patientGender;
	public String location;
	public String contactNumber;

}