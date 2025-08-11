/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link customer_table}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see customer_table
 * @generated
 */
public class customer_tableWrapper
	extends BaseModelWrapper<customer_table>
	implements customer_table, ModelWrapper<customer_table> {

	public customer_tableWrapper(customer_table customer_table) {
		super(customer_table);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("custId", getCustId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("custName", getCustName());
		attributes.put("age", getAge());
		attributes.put("salary", getSalary());
		attributes.put("gender", getGender());
		attributes.put("address", getAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long custId = (Long)attributes.get("custId");

		if (custId != null) {
			setCustId(custId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String custName = (String)attributes.get("custName");

		if (custName != null) {
			setCustName(custName);
		}

		String age = (String)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		Long salary = (Long)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	@Override
	public customer_table cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this customer_table.
	 *
	 * @return the address of this customer_table
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the age of this customer_table.
	 *
	 * @return the age of this customer_table
	 */
	@Override
	public String getAge() {
		return model.getAge();
	}

	/**
	 * Returns the company ID of this customer_table.
	 *
	 * @return the company ID of this customer_table
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this customer_table.
	 *
	 * @return the create date of this customer_table
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the cust ID of this customer_table.
	 *
	 * @return the cust ID of this customer_table
	 */
	@Override
	public long getCustId() {
		return model.getCustId();
	}

	/**
	 * Returns the cust name of this customer_table.
	 *
	 * @return the cust name of this customer_table
	 */
	@Override
	public String getCustName() {
		return model.getCustName();
	}

	/**
	 * Returns the gender of this customer_table.
	 *
	 * @return the gender of this customer_table
	 */
	@Override
	public String getGender() {
		return model.getGender();
	}

	/**
	 * Returns the group ID of this customer_table.
	 *
	 * @return the group ID of this customer_table
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this customer_table.
	 *
	 * @return the modified date of this customer_table
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this customer_table.
	 *
	 * @return the primary key of this customer_table
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the salary of this customer_table.
	 *
	 * @return the salary of this customer_table
	 */
	@Override
	public long getSalary() {
		return model.getSalary();
	}

	/**
	 * Returns the user ID of this customer_table.
	 *
	 * @return the user ID of this customer_table
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this customer_table.
	 *
	 * @return the user name of this customer_table
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this customer_table.
	 *
	 * @return the user uuid of this customer_table
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this customer_table.
	 *
	 * @return the uuid of this customer_table
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this customer_table.
	 *
	 * @param address the address of this customer_table
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the age of this customer_table.
	 *
	 * @param age the age of this customer_table
	 */
	@Override
	public void setAge(String age) {
		model.setAge(age);
	}

	/**
	 * Sets the company ID of this customer_table.
	 *
	 * @param companyId the company ID of this customer_table
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this customer_table.
	 *
	 * @param createDate the create date of this customer_table
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the cust ID of this customer_table.
	 *
	 * @param custId the cust ID of this customer_table
	 */
	@Override
	public void setCustId(long custId) {
		model.setCustId(custId);
	}

	/**
	 * Sets the cust name of this customer_table.
	 *
	 * @param custName the cust name of this customer_table
	 */
	@Override
	public void setCustName(String custName) {
		model.setCustName(custName);
	}

	/**
	 * Sets the gender of this customer_table.
	 *
	 * @param gender the gender of this customer_table
	 */
	@Override
	public void setGender(String gender) {
		model.setGender(gender);
	}

	/**
	 * Sets the group ID of this customer_table.
	 *
	 * @param groupId the group ID of this customer_table
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this customer_table.
	 *
	 * @param modifiedDate the modified date of this customer_table
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this customer_table.
	 *
	 * @param primaryKey the primary key of this customer_table
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the salary of this customer_table.
	 *
	 * @param salary the salary of this customer_table
	 */
	@Override
	public void setSalary(long salary) {
		model.setSalary(salary);
	}

	/**
	 * Sets the user ID of this customer_table.
	 *
	 * @param userId the user ID of this customer_table
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this customer_table.
	 *
	 * @param userName the user name of this customer_table
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this customer_table.
	 *
	 * @param userUuid the user uuid of this customer_table
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this customer_table.
	 *
	 * @param uuid the uuid of this customer_table
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected customer_tableWrapper wrap(customer_table customer_table) {
		return new customer_tableWrapper(customer_table);
	}

}