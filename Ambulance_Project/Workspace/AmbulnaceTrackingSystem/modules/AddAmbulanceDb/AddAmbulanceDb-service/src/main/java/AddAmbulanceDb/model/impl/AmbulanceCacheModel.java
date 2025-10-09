/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.model.impl;

import AddAmbulanceDb.model.Ambulance;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Ambulance in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AmbulanceCacheModel
	implements CacheModel<Ambulance>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AmbulanceCacheModel)) {
			return false;
		}

		AmbulanceCacheModel ambulanceCacheModel = (AmbulanceCacheModel)object;

		if (ambulanceId == ambulanceCacheModel.ambulanceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ambulanceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ambulanceId=");
		sb.append(ambulanceId);
		sb.append(", hospitalId=");
		sb.append(hospitalId);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", ambulanceNumber=");
		sb.append(ambulanceNumber);
		sb.append(", vehicleType=");
		sb.append(vehicleType);
		sb.append(", status=");
		sb.append(status);
		sb.append(", location=");
		sb.append(location);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Ambulance toEntityModel() {
		AmbulanceImpl ambulanceImpl = new AmbulanceImpl();

		if (uuid == null) {
			ambulanceImpl.setUuid("");
		}
		else {
			ambulanceImpl.setUuid(uuid);
		}

		ambulanceImpl.setAmbulanceId(ambulanceId);
		ambulanceImpl.setHospitalId(hospitalId);
		ambulanceImpl.setDriverId(driverId);

		if (ambulanceNumber == null) {
			ambulanceImpl.setAmbulanceNumber("");
		}
		else {
			ambulanceImpl.setAmbulanceNumber(ambulanceNumber);
		}

		if (vehicleType == null) {
			ambulanceImpl.setVehicleType("");
		}
		else {
			ambulanceImpl.setVehicleType(vehicleType);
		}

		if (status == null) {
			ambulanceImpl.setStatus("");
		}
		else {
			ambulanceImpl.setStatus(status);
		}

		if (location == null) {
			ambulanceImpl.setLocation("");
		}
		else {
			ambulanceImpl.setLocation(location);
		}

		if (contactNumber == null) {
			ambulanceImpl.setContactNumber("");
		}
		else {
			ambulanceImpl.setContactNumber(contactNumber);
		}

		if (createDate == Long.MIN_VALUE) {
			ambulanceImpl.setCreateDate(null);
		}
		else {
			ambulanceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ambulanceImpl.setModifiedDate(null);
		}
		else {
			ambulanceImpl.setModifiedDate(new Date(modifiedDate));
		}

		ambulanceImpl.resetOriginalValues();

		return ambulanceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ambulanceId = objectInput.readLong();

		hospitalId = objectInput.readLong();

		driverId = objectInput.readLong();
		ambulanceNumber = objectInput.readUTF();
		vehicleType = objectInput.readUTF();
		status = objectInput.readUTF();
		location = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
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

		objectOutput.writeLong(ambulanceId);

		objectOutput.writeLong(hospitalId);

		objectOutput.writeLong(driverId);

		if (ambulanceNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ambulanceNumber);
		}

		if (vehicleType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehicleType);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
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

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long ambulanceId;
	public long hospitalId;
	public long driverId;
	public String ambulanceNumber;
	public String vehicleType;
	public String status;
	public String location;
	public String contactNumber;
	public long createDate;
	public long modifiedDate;

}