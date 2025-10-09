/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Hospital}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Hospital
 * @generated
 */
public class HospitalWrapper
	extends BaseModelWrapper<Hospital>
	implements Hospital, ModelWrapper<Hospital> {

	public HospitalWrapper(Hospital hospital) {
		super(hospital);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("hospitalId", getHospitalId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("hospitalName", getHospitalName());
		attributes.put("location", getLocation());
		attributes.put("address", getAddress());
		attributes.put("contactNumber", getContactNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long hospitalId = (Long)attributes.get("hospitalId");

		if (hospitalId != null) {
			setHospitalId(hospitalId);
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

		String hospitalName = (String)attributes.get("hospitalName");

		if (hospitalName != null) {
			setHospitalName(hospitalName);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}
	}

	@Override
	public Hospital cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this hospital.
	 *
	 * @return the address of this hospital
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the company ID of this hospital.
	 *
	 * @return the company ID of this hospital
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact number of this hospital.
	 *
	 * @return the contact number of this hospital
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the create date of this hospital.
	 *
	 * @return the create date of this hospital
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this hospital.
	 *
	 * @return the group ID of this hospital
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the hospital ID of this hospital.
	 *
	 * @return the hospital ID of this hospital
	 */
	@Override
	public long getHospitalId() {
		return model.getHospitalId();
	}

	/**
	 * Returns the hospital name of this hospital.
	 *
	 * @return the hospital name of this hospital
	 */
	@Override
	public String getHospitalName() {
		return model.getHospitalName();
	}

	/**
	 * Returns the location of this hospital.
	 *
	 * @return the location of this hospital
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this hospital.
	 *
	 * @return the modified date of this hospital
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this hospital.
	 *
	 * @return the primary key of this hospital
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this hospital.
	 *
	 * @return the user ID of this hospital
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this hospital.
	 *
	 * @return the user name of this hospital
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this hospital.
	 *
	 * @return the user uuid of this hospital
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this hospital.
	 *
	 * @return the uuid of this hospital
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
	 * Sets the address of this hospital.
	 *
	 * @param address the address of this hospital
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the company ID of this hospital.
	 *
	 * @param companyId the company ID of this hospital
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact number of this hospital.
	 *
	 * @param contactNumber the contact number of this hospital
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the create date of this hospital.
	 *
	 * @param createDate the create date of this hospital
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this hospital.
	 *
	 * @param groupId the group ID of this hospital
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the hospital ID of this hospital.
	 *
	 * @param hospitalId the hospital ID of this hospital
	 */
	@Override
	public void setHospitalId(long hospitalId) {
		model.setHospitalId(hospitalId);
	}

	/**
	 * Sets the hospital name of this hospital.
	 *
	 * @param hospitalName the hospital name of this hospital
	 */
	@Override
	public void setHospitalName(String hospitalName) {
		model.setHospitalName(hospitalName);
	}

	/**
	 * Sets the location of this hospital.
	 *
	 * @param location the location of this hospital
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this hospital.
	 *
	 * @param modifiedDate the modified date of this hospital
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this hospital.
	 *
	 * @param primaryKey the primary key of this hospital
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this hospital.
	 *
	 * @param userId the user ID of this hospital
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this hospital.
	 *
	 * @param userName the user name of this hospital
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this hospital.
	 *
	 * @param userUuid the user uuid of this hospital
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this hospital.
	 *
	 * @param uuid the uuid of this hospital
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
	protected HospitalWrapper wrap(Hospital hospital) {
		return new HospitalWrapper(hospital);
	}

}