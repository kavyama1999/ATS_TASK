/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.service;

import checkIndb3.model.check;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for check. This utility wraps
 * <code>checkIndb3.service.impl.checkLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see checkLocalService
 * @generated
 */
public class checkLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>checkIndb3.service.impl.checkLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the check to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect checkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param check the check
	 * @return the check that was added
	 */
	public static check addcheck(check check) {
		return getService().addcheck(check);
	}

	/**
	 * Creates a new check with the primary key. Does not add the check to the database.
	 *
	 * @param checkInId the primary key for the new check
	 * @return the new check
	 */
	public static check createcheck(long checkInId) {
		return getService().createcheck(checkInId);
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
	 * Deletes the check from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect checkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param check the check
	 * @return the check that was removed
	 */
	public static check deletecheck(check check) {
		return getService().deletecheck(check);
	}

	/**
	 * Deletes the check with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect checkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param checkInId the primary key of the check
	 * @return the check that was removed
	 * @throws PortalException if a check with the primary key could not be found
	 */
	public static check deletecheck(long checkInId) throws PortalException {
		return getService().deletecheck(checkInId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkIndb3.model.impl.checkModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkIndb3.model.impl.checkModelImpl</code>.
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

	public static check fetchcheck(long checkInId) {
		return getService().fetchcheck(checkInId);
	}

	/**
	 * Returns the check matching the UUID and group.
	 *
	 * @param uuid the check's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check, or <code>null</code> if a matching check could not be found
	 */
	public static check fetchcheckByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchcheckByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the check with the primary key.
	 *
	 * @param checkInId the primary key of the check
	 * @return the check
	 * @throws PortalException if a check with the primary key could not be found
	 */
	public static check getcheck(long checkInId) throws PortalException {
		return getService().getcheck(checkInId);
	}

	/**
	 * Returns the check matching the UUID and group.
	 *
	 * @param uuid the check's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check
	 * @throws PortalException if a matching check could not be found
	 */
	public static check getcheckByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getcheckByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the checks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkIndb3.model.impl.checkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @return the range of checks
	 */
	public static List<check> getchecks(int start, int end) {
		return getService().getchecks(start, end);
	}

	/**
	 * Returns all the checks matching the UUID and company.
	 *
	 * @param uuid the UUID of the checks
	 * @param companyId the primary key of the company
	 * @return the matching checks, or an empty list if no matches were found
	 */
	public static List<check> getchecksByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getchecksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of checks matching the UUID and company.
	 *
	 * @param uuid the UUID of the checks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching checks, or an empty list if no matches were found
	 */
	public static List<check> getchecksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<check> orderByComparator) {

		return getService().getchecksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of checks.
	 *
	 * @return the number of checks
	 */
	public static int getchecksCount() {
		return getService().getchecksCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static check getInstance() {
		return getService().getInstance();
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
	 * Updates the check in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect checkLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param check the check
	 * @return the check that was updated
	 */
	public static check updatecheck(check check) {
		return getService().updatecheck(check);
	}

	public static checkLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<checkLocalService> _serviceSnapshot =
		new Snapshot<>(checkLocalServiceUtil.class, checkLocalService.class);

}