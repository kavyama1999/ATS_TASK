/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link HospitalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HospitalLocalService
 * @generated
 */
public class HospitalLocalServiceWrapper
	implements HospitalLocalService, ServiceWrapper<HospitalLocalService> {

	public HospitalLocalServiceWrapper() {
		this(null);
	}

	public HospitalLocalServiceWrapper(
		HospitalLocalService hospitalLocalService) {

		_hospitalLocalService = hospitalLocalService;
	}

	/**
	 * Adds the hospital to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HospitalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hospital the hospital
	 * @return the hospital that was added
	 */
	@Override
	public AddAmbulanceDb.model.Hospital addHospital(
		AddAmbulanceDb.model.Hospital hospital) {

		return _hospitalLocalService.addHospital(hospital);
	}

	/**
	 * Creates a new hospital with the primary key. Does not add the hospital to the database.
	 *
	 * @param hospitalId the primary key for the new hospital
	 * @return the new hospital
	 */
	@Override
	public AddAmbulanceDb.model.Hospital createHospital(long hospitalId) {
		return _hospitalLocalService.createHospital(hospitalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hospitalLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the hospital from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HospitalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hospital the hospital
	 * @return the hospital that was removed
	 */
	@Override
	public AddAmbulanceDb.model.Hospital deleteHospital(
		AddAmbulanceDb.model.Hospital hospital) {

		return _hospitalLocalService.deleteHospital(hospital);
	}

	/**
	 * Deletes the hospital with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HospitalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hospitalId the primary key of the hospital
	 * @return the hospital that was removed
	 * @throws PortalException if a hospital with the primary key could not be found
	 */
	@Override
	public AddAmbulanceDb.model.Hospital deleteHospital(long hospitalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hospitalLocalService.deleteHospital(hospitalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hospitalLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _hospitalLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _hospitalLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _hospitalLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _hospitalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddAmbulanceDb.model.impl.HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _hospitalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddAmbulanceDb.model.impl.HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _hospitalLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _hospitalLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _hospitalLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public AddAmbulanceDb.model.Hospital fetchHospital(long hospitalId) {
		return _hospitalLocalService.fetchHospital(hospitalId);
	}

	/**
	 * Returns the hospital matching the UUID and group.
	 *
	 * @param uuid the hospital's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	@Override
	public AddAmbulanceDb.model.Hospital fetchHospitalByUuidAndGroupId(
		String uuid, long groupId) {

		return _hospitalLocalService.fetchHospitalByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _hospitalLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _hospitalLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the hospital with the primary key.
	 *
	 * @param hospitalId the primary key of the hospital
	 * @return the hospital
	 * @throws PortalException if a hospital with the primary key could not be found
	 */
	@Override
	public AddAmbulanceDb.model.Hospital getHospital(long hospitalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hospitalLocalService.getHospital(hospitalId);
	}

	/**
	 * Returns the hospital matching the UUID and group.
	 *
	 * @param uuid the hospital's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hospital
	 * @throws PortalException if a matching hospital could not be found
	 */
	@Override
	public AddAmbulanceDb.model.Hospital getHospitalByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hospitalLocalService.getHospitalByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the hospitals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddAmbulanceDb.model.impl.HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @return the range of hospitals
	 */
	@Override
	public java.util.List<AddAmbulanceDb.model.Hospital> getHospitals(
		int start, int end) {

		return _hospitalLocalService.getHospitals(start, end);
	}

	/**
	 * Returns all the hospitals matching the UUID and company.
	 *
	 * @param uuid the UUID of the hospitals
	 * @param companyId the primary key of the company
	 * @return the matching hospitals, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<AddAmbulanceDb.model.Hospital>
		getHospitalsByUuidAndCompanyId(String uuid, long companyId) {

		return _hospitalLocalService.getHospitalsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of hospitals matching the UUID and company.
	 *
	 * @param uuid the UUID of the hospitals
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching hospitals, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<AddAmbulanceDb.model.Hospital>
		getHospitalsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AddAmbulanceDb.model.Hospital> orderByComparator) {

		return _hospitalLocalService.getHospitalsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of hospitals.
	 *
	 * @return the number of hospitals
	 */
	@Override
	public int getHospitalsCount() {
		return _hospitalLocalService.getHospitalsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _hospitalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hospitalLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _hospitalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the hospital in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect HospitalLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param hospital the hospital
	 * @return the hospital that was updated
	 */
	@Override
	public AddAmbulanceDb.model.Hospital updateHospital(
		AddAmbulanceDb.model.Hospital hospital) {

		return _hospitalLocalService.updateHospital(hospital);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _hospitalLocalService.getBasePersistence();
	}

	@Override
	public HospitalLocalService getWrappedService() {
		return _hospitalLocalService;
	}

	@Override
	public void setWrappedService(HospitalLocalService hospitalLocalService) {
		_hospitalLocalService = hospitalLocalService;
	}

	private HospitalLocalService _hospitalLocalService;

}