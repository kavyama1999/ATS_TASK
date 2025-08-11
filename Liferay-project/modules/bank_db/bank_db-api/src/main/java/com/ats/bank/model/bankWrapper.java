/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link bank}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bank
 * @generated
 */
public class bankWrapper
	extends BaseModelWrapper<bank> implements bank, ModelWrapper<bank> {

	public bankWrapper(bank bank) {
		super(bank);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("bankId", getBankId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("address", getAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long bankId = (Long)attributes.get("bankId");

		if (bankId != null) {
			setBankId(bankId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}
	}

	@Override
	public bank cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this bank.
	 *
	 * @return the address of this bank
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the bank ID of this bank.
	 *
	 * @return the bank ID of this bank
	 */
	@Override
	public long getBankId() {
		return model.getBankId();
	}

	/**
	 * Returns the company ID of this bank.
	 *
	 * @return the company ID of this bank
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this bank.
	 *
	 * @return the create date of this bank
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this bank.
	 *
	 * @return the group ID of this bank
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this bank.
	 *
	 * @return the modified date of this bank
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this bank.
	 *
	 * @return the name of this bank
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this bank.
	 *
	 * @return the primary key of this bank
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this bank.
	 *
	 * @return the user ID of this bank
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this bank.
	 *
	 * @return the user name of this bank
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this bank.
	 *
	 * @return the user uuid of this bank
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this bank.
	 *
	 * @return the uuid of this bank
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
	 * Sets the address of this bank.
	 *
	 * @param address the address of this bank
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the bank ID of this bank.
	 *
	 * @param bankId the bank ID of this bank
	 */
	@Override
	public void setBankId(long bankId) {
		model.setBankId(bankId);
	}

	/**
	 * Sets the company ID of this bank.
	 *
	 * @param companyId the company ID of this bank
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this bank.
	 *
	 * @param createDate the create date of this bank
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this bank.
	 *
	 * @param groupId the group ID of this bank
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this bank.
	 *
	 * @param modifiedDate the modified date of this bank
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this bank.
	 *
	 * @param name the name of this bank
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this bank.
	 *
	 * @param primaryKey the primary key of this bank
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this bank.
	 *
	 * @param userId the user ID of this bank
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this bank.
	 *
	 * @param userName the user name of this bank
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this bank.
	 *
	 * @param userUuid the user uuid of this bank
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this bank.
	 *
	 * @param uuid the uuid of this bank
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
	protected bankWrapper wrap(bank bank) {
		return new bankWrapper(bank);
	}

}