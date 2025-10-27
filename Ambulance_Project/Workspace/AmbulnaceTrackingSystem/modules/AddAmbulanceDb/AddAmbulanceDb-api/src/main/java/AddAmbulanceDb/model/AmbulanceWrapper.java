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
 * This class is a wrapper for {@link Ambulance}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Ambulance
 * @generated
 */
public class AmbulanceWrapper
	extends BaseModelWrapper<Ambulance>
	implements Ambulance, ModelWrapper<Ambulance> {

	public AmbulanceWrapper(Ambulance ambulance) {
		super(ambulance);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ambulanceId", getAmbulanceId());
		attributes.put("hospitalId", getHospitalId());
		attributes.put("driverId", getDriverId());
		attributes.put("driverName", getDriverName());
		attributes.put("ambulanceNumber", getAmbulanceNumber());
		attributes.put("vehicleType", getVehicleType());
		attributes.put("status", getStatus());
		attributes.put("location", getLocation());
		attributes.put("contactNumber", getContactNumber());
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

		Long ambulanceId = (Long)attributes.get("ambulanceId");

		if (ambulanceId != null) {
			setAmbulanceId(ambulanceId);
		}

		Long hospitalId = (Long)attributes.get("hospitalId");

		if (hospitalId != null) {
			setHospitalId(hospitalId);
		}

		Long driverId = (Long)attributes.get("driverId");

		if (driverId != null) {
			setDriverId(driverId);
		}

		String driverName = (String)attributes.get("driverName");

		if (driverName != null) {
			setDriverName(driverName);
		}

		String ambulanceNumber = (String)attributes.get("ambulanceNumber");

		if (ambulanceNumber != null) {
			setAmbulanceNumber(ambulanceNumber);
		}

		String vehicleType = (String)attributes.get("vehicleType");

		if (vehicleType != null) {
			setVehicleType(vehicleType);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
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
	public Ambulance cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ambulance ID of this ambulance.
	 *
	 * @return the ambulance ID of this ambulance
	 */
	@Override
	public long getAmbulanceId() {
		return model.getAmbulanceId();
	}

	/**
	 * Returns the ambulance number of this ambulance.
	 *
	 * @return the ambulance number of this ambulance
	 */
	@Override
	public String getAmbulanceNumber() {
		return model.getAmbulanceNumber();
	}

	/**
	 * Returns the contact number of this ambulance.
	 *
	 * @return the contact number of this ambulance
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the create date of this ambulance.
	 *
	 * @return the create date of this ambulance
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the driver ID of this ambulance.
	 *
	 * @return the driver ID of this ambulance
	 */
	@Override
	public long getDriverId() {
		return model.getDriverId();
	}

	/**
	 * Returns the driver name of this ambulance.
	 *
	 * @return the driver name of this ambulance
	 */
	@Override
	public String getDriverName() {
		return model.getDriverName();
	}

	/**
	 * Returns the hospital ID of this ambulance.
	 *
	 * @return the hospital ID of this ambulance
	 */
	@Override
	public long getHospitalId() {
		return model.getHospitalId();
	}

	/**
	 * Returns the location of this ambulance.
	 *
	 * @return the location of this ambulance
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this ambulance.
	 *
	 * @return the modified date of this ambulance
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this ambulance.
	 *
	 * @return the primary key of this ambulance
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this ambulance.
	 *
	 * @return the status of this ambulance
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the uuid of this ambulance.
	 *
	 * @return the uuid of this ambulance
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the vehicle type of this ambulance.
	 *
	 * @return the vehicle type of this ambulance
	 */
	@Override
	public String getVehicleType() {
		return model.getVehicleType();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the ambulance ID of this ambulance.
	 *
	 * @param ambulanceId the ambulance ID of this ambulance
	 */
	@Override
	public void setAmbulanceId(long ambulanceId) {
		model.setAmbulanceId(ambulanceId);
	}

	/**
	 * Sets the ambulance number of this ambulance.
	 *
	 * @param ambulanceNumber the ambulance number of this ambulance
	 */
	@Override
	public void setAmbulanceNumber(String ambulanceNumber) {
		model.setAmbulanceNumber(ambulanceNumber);
	}

	/**
	 * Sets the contact number of this ambulance.
	 *
	 * @param contactNumber the contact number of this ambulance
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the create date of this ambulance.
	 *
	 * @param createDate the create date of this ambulance
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the driver ID of this ambulance.
	 *
	 * @param driverId the driver ID of this ambulance
	 */
	@Override
	public void setDriverId(long driverId) {
		model.setDriverId(driverId);
	}

	/**
	 * Sets the driver name of this ambulance.
	 *
	 * @param driverName the driver name of this ambulance
	 */
	@Override
	public void setDriverName(String driverName) {
		model.setDriverName(driverName);
	}

	/**
	 * Sets the hospital ID of this ambulance.
	 *
	 * @param hospitalId the hospital ID of this ambulance
	 */
	@Override
	public void setHospitalId(long hospitalId) {
		model.setHospitalId(hospitalId);
	}

	/**
	 * Sets the location of this ambulance.
	 *
	 * @param location the location of this ambulance
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this ambulance.
	 *
	 * @param modifiedDate the modified date of this ambulance
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this ambulance.
	 *
	 * @param primaryKey the primary key of this ambulance
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this ambulance.
	 *
	 * @param status the status of this ambulance
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the uuid of this ambulance.
	 *
	 * @param uuid the uuid of this ambulance
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the vehicle type of this ambulance.
	 *
	 * @param vehicleType the vehicle type of this ambulance
	 */
	@Override
	public void setVehicleType(String vehicleType) {
		model.setVehicleType(vehicleType);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AmbulanceWrapper wrap(Ambulance ambulance) {
		return new AmbulanceWrapper(ambulance);
	}

}