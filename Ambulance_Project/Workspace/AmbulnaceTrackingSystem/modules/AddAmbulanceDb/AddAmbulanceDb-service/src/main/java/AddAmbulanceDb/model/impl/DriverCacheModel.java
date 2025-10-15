/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.model.impl;

import AddAmbulanceDb.model.Driver;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Driver in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DriverCacheModel implements CacheModel<Driver>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DriverCacheModel)) {
			return false;
		}

		DriverCacheModel driverCacheModel = (DriverCacheModel)object;

		if (driverId == driverCacheModel.driverId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, driverId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", hospitalId=");
		sb.append(hospitalId);
		sb.append(", ambulanceId=");
		sb.append(ambulanceId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", driverName=");
		sb.append(driverName);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", email=");
		sb.append(email);
		sb.append(", address=");
		sb.append(address);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Driver toEntityModel() {
		DriverImpl driverImpl = new DriverImpl();

		if (uuid == null) {
			driverImpl.setUuid("");
		}
		else {
			driverImpl.setUuid(uuid);
		}

		driverImpl.setDriverId(driverId);
		driverImpl.setHospitalId(hospitalId);
		driverImpl.setAmbulanceId(ambulanceId);
		driverImpl.setUserId(userId);

		if (driverName == null) {
			driverImpl.setDriverName("");
		}
		else {
			driverImpl.setDriverName(driverName);
		}

		if (contactNumber == null) {
			driverImpl.setContactNumber("");
		}
		else {
			driverImpl.setContactNumber(contactNumber);
		}

		if (email == null) {
			driverImpl.setEmail("");
		}
		else {
			driverImpl.setEmail(email);
		}

		if (address == null) {
			driverImpl.setAddress("");
		}
		else {
			driverImpl.setAddress(address);
		}

		if (status == null) {
			driverImpl.setStatus("");
		}
		else {
			driverImpl.setStatus(status);
		}

		if (createDate == Long.MIN_VALUE) {
			driverImpl.setCreateDate(null);
		}
		else {
			driverImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			driverImpl.setModifiedDate(null);
		}
		else {
			driverImpl.setModifiedDate(new Date(modifiedDate));
		}

		driverImpl.resetOriginalValues();

		return driverImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		driverId = objectInput.readLong();

		hospitalId = objectInput.readLong();

		ambulanceId = objectInput.readLong();

		userId = objectInput.readLong();
		driverName = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		email = objectInput.readUTF();
		address = objectInput.readUTF();
		status = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(driverId);

		objectOutput.writeLong(hospitalId);

		objectOutput.writeLong(ambulanceId);

		objectOutput.writeLong(userId);

		if (driverName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverName);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (address == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long driverId;
	public long hospitalId;
	public long ambulanceId;
	public long userId;
	public String driverName;
	public String contactNumber;
	public String email;
	public String address;
	public String status;
	public long createDate;
	public long modifiedDate;

}