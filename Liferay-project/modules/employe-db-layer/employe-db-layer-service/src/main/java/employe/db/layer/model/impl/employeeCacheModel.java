/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package employe.db.layer.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import employe.db.layer.model.employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class employeeCacheModel
	implements CacheModel<employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof employeeCacheModel)) {
			return false;
		}

		employeeCacheModel employeeCacheModel = (employeeCacheModel)object;

		if (empId == employeeCacheModel.empId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, empId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", empId=");
		sb.append(empId);
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
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", age=");
		sb.append(age);
		sb.append(", company=");
		sb.append(company);
		sb.append(", gender=");
		sb.append(gender);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public employee toEntityModel() {
		employeeImpl employeeImpl = new employeeImpl();

		if (uuid == null) {
			employeeImpl.setUuid("");
		}
		else {
			employeeImpl.setUuid(uuid);
		}

		employeeImpl.setEmpId(empId);
		employeeImpl.setGroupId(groupId);
		employeeImpl.setCompanyId(companyId);
		employeeImpl.setUserId(userId);

		if (userName == null) {
			employeeImpl.setUserName("");
		}
		else {
			employeeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			employeeImpl.setCreateDate(null);
		}
		else {
			employeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			employeeImpl.setModifiedDate(null);
		}
		else {
			employeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			employeeImpl.setName("");
		}
		else {
			employeeImpl.setName(name);
		}

		if (salary == null) {
			employeeImpl.setSalary("");
		}
		else {
			employeeImpl.setSalary(salary);
		}

		employeeImpl.setAge(age);

		if (company == null) {
			employeeImpl.setCompany("");
		}
		else {
			employeeImpl.setCompany(company);
		}

		if (gender == null) {
			employeeImpl.setGender("");
		}
		else {
			employeeImpl.setGender(gender);
		}

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		empId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		salary = objectInput.readUTF();

		age = objectInput.readInt();
		company = objectInput.readUTF();
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

		objectOutput.writeLong(empId);

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

		if (salary == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(salary);
		}

		objectOutput.writeInt(age);

		if (company == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (gender == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(gender);
		}
	}

	public String uuid;
	public long empId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String salary;
	public int age;
	public String company;
	public String gender;

}