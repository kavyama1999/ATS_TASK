/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.model.impl;

import AmbulanceDb2.model.AmbSignUp;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AmbSignUp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AmbSignUpCacheModel
	implements CacheModel<AmbSignUp>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AmbSignUpCacheModel)) {
			return false;
		}

		AmbSignUpCacheModel ambSignUpCacheModel = (AmbSignUpCacheModel)object;

		if (otpId == ambSignUpCacheModel.otpId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, otpId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", otpId=");
		sb.append(otpId);
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
		sb.append(", email=");
		sb.append(email);
		sb.append(", OTP=");
		sb.append(OTP);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AmbSignUp toEntityModel() {
		AmbSignUpImpl ambSignUpImpl = new AmbSignUpImpl();

		if (uuid == null) {
			ambSignUpImpl.setUuid("");
		}
		else {
			ambSignUpImpl.setUuid(uuid);
		}

		ambSignUpImpl.setOtpId(otpId);
		ambSignUpImpl.setGroupId(groupId);
		ambSignUpImpl.setCompanyId(companyId);
		ambSignUpImpl.setUserId(userId);

		if (userName == null) {
			ambSignUpImpl.setUserName("");
		}
		else {
			ambSignUpImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ambSignUpImpl.setCreateDate(null);
		}
		else {
			ambSignUpImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ambSignUpImpl.setModifiedDate(null);
		}
		else {
			ambSignUpImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (email == null) {
			ambSignUpImpl.setEmail("");
		}
		else {
			ambSignUpImpl.setEmail(email);
		}

		if (OTP == null) {
			ambSignUpImpl.setOTP("");
		}
		else {
			ambSignUpImpl.setOTP(OTP);
		}

		ambSignUpImpl.setStatus(status);

		ambSignUpImpl.resetOriginalValues();

		return ambSignUpImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		otpId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		email = objectInput.readUTF();
		OTP = objectInput.readUTF();

		status = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(otpId);

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

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (OTP == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(OTP);
		}

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long otpId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String email;

	public String OTP;

	public boolean status;

}