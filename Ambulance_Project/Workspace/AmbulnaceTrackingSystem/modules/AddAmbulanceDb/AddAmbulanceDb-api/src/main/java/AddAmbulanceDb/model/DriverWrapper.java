/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Driver}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Driver
 * @generated
 */
public class DriverWrapper
	extends BaseModelWrapper<Driver> implements Driver, ModelWrapper<Driver> {

	public DriverWrapper(Driver driver) {
		super(driver);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("driverId", getDriverId());
		attributes.put("hospitalId", getHospitalId());
		attributes.put("ambulanceId", getAmbulanceId());
		attributes.put("driverName", getDriverName());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("email", getEmail());
		attributes.put("address", getAddress());
		attributes.put("experienceYears", getExperienceYears());
		attributes.put("status", getStatus());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		Long hospitalId = (Long)attributes.get("hospitalId");

		if (hospitalId != null) {
			setHospitalId(hospitalId);
		}

		Long ambulanceId = (Long)attributes.get("ambulanceId");

		if (ambulanceId != null) {
			setAmbulanceId(ambulanceId);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		Integer experienceYears = (Integer)attributes.get("experienceYears");

		if (experienceYears != null) {
			setExperienceYears(experienceYears);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public Driver cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this driver.
	 *
	 * @return the address of this driver
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the ambulance ID of this driver.
	 *
	 * @return the ambulance ID of this driver
	 */
	@Override
	public long getAmbulanceId() {
		return model.getAmbulanceId();
	}

	/**
	 * Returns the contact number of this driver.
	 *
	 * @return the contact number of this driver
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the create date of this driver.
	 *
	 * @return the create date of this driver
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the driver ID of this driver.
	 *
	 * @return the driver ID of this driver
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the driver name of this driver.
	 *
	 * @return the driver name of this driver
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the email of this driver.
	 *
	 * @return the email of this driver
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the experience years of this driver.
	 *
	 * @return the experience years of this driver
	 */
	@Override
	public int getExperienceYears() {
		return model.getExperienceYears();
	}

	/**
	 * Returns the hospital ID of this driver.
	 *
	 * @return the hospital ID of this driver
	 */
	@Override
	public long getHospitalId() {
		return model.getHospitalId();
	}

	/**
	 * Returns the modified date of this driver.
	 *
	 * @return the modified date of this driver
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this driver.
	 *
	 * @return the primary key of this driver
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this driver.
	 *
	 * @return the status of this driver
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this driver.
	 *
	 * @return the uuid of this driver
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
	 * Sets the address of this driver.
	 *
	 * @param address the address of this driver
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the ambulance ID of this driver.
	 *
	 * @param ambulanceId the ambulance ID of this driver
	 */
	@Override
	public void setAmbulanceId(long ambulanceId) {
		model.setAmbulanceId(ambulanceId);
	}

	/**
	 * Sets the contact number of this driver.
	 *
	 * @param contactNumber the contact number of this driver
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the create date of this driver.
	 *
	 * @param createDate the create date of this driver
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the driver ID of this driver.
	 *
	 * @param driverId the driver ID of this driver
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the driver name of this driver.
	 *
	 * @param driverName the driver name of this driver
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the email of this driver.
	 *
	 * @param email the email of this driver
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the experience years of this driver.
	 *
	 * @param experienceYears the experience years of this driver
	 */
	@Override
	public void setExperienceYears(int experienceYears) {
		model.setExperienceYears(experienceYears);
	}

	/**
	 * Sets the hospital ID of this driver.
	 *
	 * @param hospitalId the hospital ID of this driver
	 */
	@Override
	public void setHospitalId(long hospitalId) {
		model.setHospitalId(hospitalId);
	}

	/**
	 * Sets the modified date of this driver.
	 *
	 * @param modifiedDate the modified date of this driver
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this driver.
	 *
	 * @param primaryKey the primary key of this driver
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this driver.
	 *
	 * @param status the status of this driver
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this driver.
	 *
	 * @param uuid the uuid of this driver
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
	protected DriverWrapper wrap(Driver driver) {
		return new DriverWrapper(driver);
	}

}