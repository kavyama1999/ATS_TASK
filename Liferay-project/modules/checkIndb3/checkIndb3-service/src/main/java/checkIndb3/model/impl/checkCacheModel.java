/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.model.impl;

import checkIndb3.model.check;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing check in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class checkCacheModel implements CacheModel<check>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof checkCacheModel)) {
			return false;
		}

		checkCacheModel checkCacheModel = (checkCacheModel)object;

		if (checkInId == checkCacheModel.checkInId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, checkInId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", checkInId=");
		sb.append(checkInId);
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
		sb.append(", date=");
		sb.append(date);
		sb.append(", day=");
		sb.append(day);
		sb.append(", checkInTime=");
		sb.append(checkInTime);
		sb.append(", checkOutTime=");
		sb.append(checkOutTime);
		sb.append(", totalHours=");
		sb.append(totalHours);
		sb.append(", createdAt=");
		sb.append(createdAt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public check toEntityModel() {
		checkImpl checkImpl = new checkImpl();

		if (uuid == null) {
			checkImpl.setUuid("");
		}
		else {
			checkImpl.setUuid(uuid);
		}

		checkImpl.setCheckInId(checkInId);
		checkImpl.setGroupId(groupId);
		checkImpl.setCompanyId(companyId);
		checkImpl.setUserId(userId);

		if (userName == null) {
			checkImpl.setUserName("");
		}
		else {
			checkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			checkImpl.setCreateDate(null);
		}
		else {
			checkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			checkImpl.setModifiedDate(null);
		}
		else {
			checkImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (date == Long.MIN_VALUE) {
			checkImpl.setDate(null);
		}
		else {
			checkImpl.setDate(new Date(date));
		}

		if (day == null) {
			checkImpl.setDay("");
		}
		else {
			checkImpl.setDay(day);
		}

		if (checkInTime == Long.MIN_VALUE) {
			checkImpl.setCheckInTime(null);
		}
		else {
			checkImpl.setCheckInTime(new Date(checkInTime));
		}

		if (checkOutTime == Long.MIN_VALUE) {
			checkImpl.setCheckOutTime(null);
		}
		else {
			checkImpl.setCheckOutTime(new Date(checkOutTime));
		}

		if (totalHours == null) {
			checkImpl.setTotalHours("");
		}
		else {
			checkImpl.setTotalHours(totalHours);
		}

		if (createdAt == Long.MIN_VALUE) {
			checkImpl.setCreatedAt(null);
		}
		else {
			checkImpl.setCreatedAt(new Date(createdAt));
		}

		checkImpl.resetOriginalValues();

		return checkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		checkInId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		date = objectInput.readLong();
		day = objectInput.readUTF();
		checkInTime = objectInput.readLong();
		checkOutTime = objectInput.readLong();
		totalHours = objectInput.readUTF();
		createdAt = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(checkInId);

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
		objectOutput.writeLong(date);

		if (day == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(day);
		}

		objectOutput.writeLong(checkInTime);
		objectOutput.writeLong(checkOutTime);

		if (totalHours == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(totalHours);
		}

		objectOutput.writeLong(createdAt);
	}

	public String uuid;
	public long checkInId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long date;
	public String day;
	public long checkInTime;
	public long checkOutTime;
	public String totalHours;
	public long createdAt;

}