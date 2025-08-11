/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link check}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see check
 * @generated
 */
public class checkWrapper
	extends BaseModelWrapper<check> implements check, ModelWrapper<check> {

	public checkWrapper(check check) {
		super(check);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("checkInId", getCheckInId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("date", getDate());
		attributes.put("day", getDay());
		attributes.put("checkInTime", getCheckInTime());
		attributes.put("checkOutTime", getCheckOutTime());
		attributes.put("totalHours", getTotalHours());
		attributes.put("createdAt", getCreatedAt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long checkInId = (Long)attributes.get("checkInId");

		if (checkInId != null) {
			setCheckInId(checkInId);
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

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String day = (String)attributes.get("day");

		if (day != null) {
			setDay(day);
		}

		Date checkInTime = (Date)attributes.get("checkInTime");

		if (checkInTime != null) {
			setCheckInTime(checkInTime);
		}

		Date checkOutTime = (Date)attributes.get("checkOutTime");

		if (checkOutTime != null) {
			setCheckOutTime(checkOutTime);
		}

		String totalHours = (String)attributes.get("totalHours");

		if (totalHours != null) {
			setTotalHours(totalHours);
		}

		Date createdAt = (Date)attributes.get("createdAt");

		if (createdAt != null) {
			setCreatedAt(createdAt);
		}
	}

	@Override
	public check cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the check in ID of this check.
	 *
	 * @return the check in ID of this check
	 */
	@Override
	public long getCheckInId() {
		return model.getCheckInId();
	}

	/**
	 * Returns the check in time of this check.
	 *
	 * @return the check in time of this check
	 */
	@Override
	public Date getCheckInTime() {
		return model.getCheckInTime();
	}

	/**
	 * Returns the check out time of this check.
	 *
	 * @return the check out time of this check
	 */
	@Override
	public Date getCheckOutTime() {
		return model.getCheckOutTime();
	}

	/**
	 * Returns the company ID of this check.
	 *
	 * @return the company ID of this check
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the created at of this check.
	 *
	 * @return the created at of this check
	 */
	@Override
	public Date getCreatedAt() {
		return model.getCreatedAt();
	}

	/**
	 * Returns the create date of this check.
	 *
	 * @return the create date of this check
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the date of this check.
	 *
	 * @return the date of this check
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the day of this check.
	 *
	 * @return the day of this check
	 */
	@Override
	public String getDay() {
		return model.getDay();
	}

	/**
	 * Returns the group ID of this check.
	 *
	 * @return the group ID of this check
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this check.
	 *
	 * @return the modified date of this check
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this check.
	 *
	 * @return the primary key of this check
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the total hours of this check.
	 *
	 * @return the total hours of this check
	 */
	@Override
	public String getTotalHours() {
		return model.getTotalHours();
	}

	/**
	 * Returns the user ID of this check.
	 *
	 * @return the user ID of this check
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this check.
	 *
	 * @return the user name of this check
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this check.
	 *
	 * @return the user uuid of this check
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this check.
	 *
	 * @return the uuid of this check
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
	 * Sets the check in ID of this check.
	 *
	 * @param checkInId the check in ID of this check
	 */
	@Override
	public void setCheckInId(long checkInId) {
		model.setCheckInId(checkInId);
	}

	/**
	 * Sets the check in time of this check.
	 *
	 * @param checkInTime the check in time of this check
	 */
	@Override
	public void setCheckInTime(Date checkInTime) {
		model.setCheckInTime(checkInTime);
	}

	/**
	 * Sets the check out time of this check.
	 *
	 * @param checkOutTime the check out time of this check
	 */
	@Override
	public void setCheckOutTime(Date checkOutTime) {
		model.setCheckOutTime(checkOutTime);
	}

	/**
	 * Sets the company ID of this check.
	 *
	 * @param companyId the company ID of this check
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the created at of this check.
	 *
	 * @param createdAt the created at of this check
	 */
	@Override
	public void setCreatedAt(Date createdAt) {
		model.setCreatedAt(createdAt);
	}

	/**
	 * Sets the create date of this check.
	 *
	 * @param createDate the create date of this check
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the date of this check.
	 *
	 * @param date the date of this check
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the day of this check.
	 *
	 * @param day the day of this check
	 */
	@Override
	public void setDay(String day) {
		model.setDay(day);
	}

	/**
	 * Sets the group ID of this check.
	 *
	 * @param groupId the group ID of this check
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this check.
	 *
	 * @param modifiedDate the modified date of this check
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this check.
	 *
	 * @param primaryKey the primary key of this check
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total hours of this check.
	 *
	 * @param totalHours the total hours of this check
	 */
	@Override
	public void setTotalHours(String totalHours) {
		model.setTotalHours(totalHours);
	}

	/**
	 * Sets the user ID of this check.
	 *
	 * @param userId the user ID of this check
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this check.
	 *
	 * @param userName the user name of this check
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this check.
	 *
	 * @param userUuid the user uuid of this check
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this check.
	 *
	 * @param uuid the uuid of this check
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
	protected checkWrapper wrap(check check) {
		return new checkWrapper(check);
	}

}