/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service;

import AddAmbulanceDb.model.Hospital;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Hospital. This utility wraps
 * <code>AddAmbulanceDb.service.impl.HospitalLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see HospitalLocalService
 * @generated
 */
public class HospitalLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>AddAmbulanceDb.service.impl.HospitalLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static Hospital addHospital(Hospital hospital) {
		return getService().addHospital(hospital);
	}

	/**
	 * Creates a new hospital with the primary key. Does not add the hospital to the database.
	 *
	 * @param hospitalId the primary key for the new hospital
	 * @return the new hospital
	 */
	public static Hospital createHospital(long hospitalId) {
		return getService().createHospital(hospitalId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static Hospital deleteHospital(Hospital hospital) {
		return getService().deleteHospital(hospital);
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
	public static Hospital deleteHospital(long hospitalId)
		throws PortalException {

		return getService().deleteHospital(hospitalId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Hospital fetchHospital(long hospitalId) {
		return getService().fetchHospital(hospitalId);
	}

	/**
	 * Returns the hospital matching the UUID and group.
	 *
	 * @param uuid the hospital's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	public static Hospital fetchHospitalByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchHospitalByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the hospital with the primary key.
	 *
	 * @param hospitalId the primary key of the hospital
	 * @return the hospital
	 * @throws PortalException if a hospital with the primary key could not be found
	 */
	public static Hospital getHospital(long hospitalId) throws PortalException {
		return getService().getHospital(hospitalId);
	}

	/**
	 * Returns the hospital matching the UUID and group.
	 *
	 * @param uuid the hospital's UUID
	 * @param groupId the primary key of the group
	 * @return the matching hospital
	 * @throws PortalException if a matching hospital could not be found
	 */
	public static Hospital getHospitalByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getHospitalByUuidAndGroupId(uuid, groupId);
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
	public static List<Hospital> getHospitals(int start, int end) {
		return getService().getHospitals(start, end);
	}

	/**
	 * Returns all the hospitals matching the UUID and company.
	 *
	 * @param uuid the UUID of the hospitals
	 * @param companyId the primary key of the company
	 * @return the matching hospitals, or an empty list if no matches were found
	 */
	public static List<Hospital> getHospitalsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getHospitalsByUuidAndCompanyId(uuid, companyId);
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
	public static List<Hospital> getHospitalsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Hospital> orderByComparator) {

		return getService().getHospitalsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of hospitals.
	 *
	 * @return the number of hospitals
	 */
	public static int getHospitalsCount() {
		return getService().getHospitalsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static Hospital updateHospital(Hospital hospital) {
		return getService().updateHospital(hospital);
	}

	public static HospitalLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<HospitalLocalService> _serviceSnapshot =
		new Snapshot<>(
			HospitalLocalServiceUtil.class, HospitalLocalService.class);

}