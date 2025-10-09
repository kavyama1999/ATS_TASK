/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.model.impl;

import AddAmbulanceDb.model.Hospital;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Hospital in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class HospitalCacheModel
	implements CacheModel<Hospital>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof HospitalCacheModel)) {
			return false;
		}

		HospitalCacheModel hospitalCacheModel = (HospitalCacheModel)object;

		if (hospitalId == hospitalCacheModel.hospitalId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, hospitalId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", hospitalId=");
		sb.append(hospitalId);
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
		sb.append(", hospitalName=");
		sb.append(hospitalName);
		sb.append(", location=");
		sb.append(location);
		sb.append(", address=");
		sb.append(address);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Hospital toEntityModel() {
		HospitalImpl hospitalImpl = new HospitalImpl();

		if (uuid == null) {
			hospitalImpl.setUuid("");
		}
		else {
			hospitalImpl.setUuid(uuid);
		}

		hospitalImpl.setHospitalId(hospitalId);
		hospitalImpl.setGroupId(groupId);
		hospitalImpl.setCompanyId(companyId);
		hospitalImpl.setUserId(userId);

		if (userName == null) {
			hospitalImpl.setUserName("");
		}
		else {
			hospitalImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			hospitalImpl.setCreateDate(null);
		}
		else {
			hospitalImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			hospitalImpl.setModifiedDate(null);
		}
		else {
			hospitalImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (hospitalName == null) {
			hospitalImpl.setHospitalName("");
		}
		else {
			hospitalImpl.setHospitalName(hospitalName);
		}

		if (location == null) {
			hospitalImpl.setLocation("");
		}
		else {
			hospitalImpl.setLocation(location);
		}

		if (address == null) {
			hospitalImpl.setAddress("");
		}
		else {
			hospitalImpl.setAddress(address);
		}

		if (contactNumber == null) {
			hospitalImpl.setContactNumber("");
		}
		else {
			hospitalImpl.setContactNumber(contactNumber);
		}

		hospitalImpl.resetOriginalValues();

		return hospitalImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		hospitalId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		hospitalName = objectInput.readUTF();
		location = objectInput.readUTF();
		address = objectInput.readUTF();
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

		objectOutput.writeLong(hospitalId);

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

		if (hospitalName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(hospitalName);
		}

		if (location == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}
	}

	public String uuid;
	public long hospitalId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String hospitalName;
	public String location;
	public String address;
	public String contactNumber;

}