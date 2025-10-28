/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CaseMngt}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngt
 * @generated
 */
public class CaseMngtWrapper
	extends BaseModelWrapper<CaseMngt>
	implements CaseMngt, ModelWrapper<CaseMngt> {

	public CaseMngtWrapper(CaseMngt caseMngt) {
		super(caseMngt);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("caseId", getCaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("caseNumber", getCaseNumber());
		attributes.put("caseType", getCaseType());
		attributes.put("patientName", getPatientName());
		attributes.put("patientAge", getPatientAge());
		attributes.put("description", getDescription());
		attributes.put("patientGender", getPatientGender());
		attributes.put("location", getLocation());
		attributes.put("contactNumber", getContactNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long caseId = (Long)attributes.get("caseId");

		if (caseId != null) {
			setCaseId(caseId);
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

		String caseNumber = (String)attributes.get("caseNumber");

		if (caseNumber != null) {
			setCaseNumber(caseNumber);
		}

		String caseType = (String)attributes.get("caseType");

		if (caseType != null) {
			setCaseType(caseType);
		}

		String patientName = (String)attributes.get("patientName");

		if (patientName != null) {
			setPatientName(patientName);
		}

		Integer patientAge = (Integer)attributes.get("patientAge");

		if (patientAge != null) {
			setPatientAge(patientAge);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String patientGender = (String)attributes.get("patientGender");

		if (patientGender != null) {
			setPatientGender(patientGender);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}
	}

	@Override
	public CaseMngt cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the case ID of this case mngt.
	 *
	 * @return the case ID of this case mngt
	 */
	@Override
	public long getCaseId() {
		return model.getCaseId();
	}

	/**
	 * Returns the case number of this case mngt.
	 *
	 * @return the case number of this case mngt
	 */
	@Override
	public String getCaseNumber() {
		return model.getCaseNumber();
	}

	/**
	 * Returns the case type of this case mngt.
	 *
	 * @return the case type of this case mngt
	 */
	@Override
	public String getCaseType() {
		return model.getCaseType();
	}

	/**
	 * Returns the company ID of this case mngt.
	 *
	 * @return the company ID of this case mngt
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the contact number of this case mngt.
	 *
	 * @return the contact number of this case mngt
	 */
	@Override
	public String getContactNumber() {
		return model.getContactNumber();
	}

	/**
	 * Returns the create date of this case mngt.
	 *
	 * @return the create date of this case mngt
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this case mngt.
	 *
	 * @return the description of this case mngt
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the group ID of this case mngt.
	 *
	 * @return the group ID of this case mngt
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the location of this case mngt.
	 *
	 * @return the location of this case mngt
	 */
	@Override
	public String getLocation() {
		return model.getLocation();
	}

	/**
	 * Returns the modified date of this case mngt.
	 *
	 * @return the modified date of this case mngt
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the patient age of this case mngt.
	 *
	 * @return the patient age of this case mngt
	 */
	@Override
	public int getPatientAge() {
		return model.getPatientAge();
	}

	/**
	 * Returns the patient gender of this case mngt.
	 *
	 * @return the patient gender of this case mngt
	 */
	@Override
	public String getPatientGender() {
		return model.getPatientGender();
	}

	/**
	 * Returns the patient name of this case mngt.
	 *
	 * @return the patient name of this case mngt
	 */
	@Override
	public String getPatientName() {
		return model.getPatientName();
	}

	/**
	 * Returns the primary key of this case mngt.
	 *
	 * @return the primary key of this case mngt
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this case mngt.
	 *
	 * @return the user ID of this case mngt
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this case mngt.
	 *
	 * @return the user name of this case mngt
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this case mngt.
	 *
	 * @return the user uuid of this case mngt
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this case mngt.
	 *
	 * @return the uuid of this case mngt
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
	 * Sets the case ID of this case mngt.
	 *
	 * @param caseId the case ID of this case mngt
	 */
	@Override
	public void setCaseId(long caseId) {
		model.setCaseId(caseId);
	}

	/**
	 * Sets the case number of this case mngt.
	 *
	 * @param caseNumber the case number of this case mngt
	 */
	@Override
	public void setCaseNumber(String caseNumber) {
		model.setCaseNumber(caseNumber);
	}

	/**
	 * Sets the case type of this case mngt.
	 *
	 * @param caseType the case type of this case mngt
	 */
	@Override
	public void setCaseType(String caseType) {
		model.setCaseType(caseType);
	}

	/**
	 * Sets the company ID of this case mngt.
	 *
	 * @param companyId the company ID of this case mngt
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the contact number of this case mngt.
	 *
	 * @param contactNumber the contact number of this case mngt
	 */
	@Override
	public void setContactNumber(String contactNumber) {
		model.setContactNumber(contactNumber);
	}

	/**
	 * Sets the create date of this case mngt.
	 *
	 * @param createDate the create date of this case mngt
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this case mngt.
	 *
	 * @param description the description of this case mngt
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the group ID of this case mngt.
	 *
	 * @param groupId the group ID of this case mngt
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the location of this case mngt.
	 *
	 * @param location the location of this case mngt
	 */
	@Override
	public void setLocation(String location) {
		model.setLocation(location);
	}

	/**
	 * Sets the modified date of this case mngt.
	 *
	 * @param modifiedDate the modified date of this case mngt
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the patient age of this case mngt.
	 *
	 * @param patientAge the patient age of this case mngt
	 */
	@Override
	public void setPatientAge(int patientAge) {
		model.setPatientAge(patientAge);
	}

	/**
	 * Sets the patient gender of this case mngt.
	 *
	 * @param patientGender the patient gender of this case mngt
	 */
	@Override
	public void setPatientGender(String patientGender) {
		model.setPatientGender(patientGender);
	}

	/**
	 * Sets the patient name of this case mngt.
	 *
	 * @param patientName the patient name of this case mngt
	 */
	@Override
	public void setPatientName(String patientName) {
		model.setPatientName(patientName);
	}

	/**
	 * Sets the primary key of this case mngt.
	 *
	 * @param primaryKey the primary key of this case mngt
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this case mngt.
	 *
	 * @param userId the user ID of this case mngt
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this case mngt.
	 *
	 * @param userName the user name of this case mngt
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this case mngt.
	 *
	 * @param userUuid the user uuid of this case mngt
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this case mngt.
	 *
	 * @param uuid the uuid of this case mngt
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
	protected CaseMngtWrapper wrap(CaseMngt caseMngt) {
		return new CaseMngtWrapper(caseMngt);
	}

}