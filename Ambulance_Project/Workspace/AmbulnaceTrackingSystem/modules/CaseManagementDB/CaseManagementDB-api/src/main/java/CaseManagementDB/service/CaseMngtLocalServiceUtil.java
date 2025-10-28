/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service;

import CaseManagementDB.model.CaseMngt;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CaseMngt. This utility wraps
 * <code>CaseManagementDB.service.impl.CaseMngtLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngtLocalService
 * @generated
 */
public class CaseMngtLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>CaseManagementDB.service.impl.CaseMngtLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the case mngt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseMngt the case mngt
	 * @return the case mngt that was added
	 */
	public static CaseMngt addCaseMngt(CaseMngt caseMngt) {
		return getService().addCaseMngt(caseMngt);
	}

	/**
	 * Creates a new case mngt with the primary key. Does not add the case mngt to the database.
	 *
	 * @param caseId the primary key for the new case mngt
	 * @return the new case mngt
	 */
	public static CaseMngt createCaseMngt(long caseId) {
		return getService().createCaseMngt(caseId);
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
	 * Deletes the case mngt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseMngt the case mngt
	 * @return the case mngt that was removed
	 */
	public static CaseMngt deleteCaseMngt(CaseMngt caseMngt) {
		return getService().deleteCaseMngt(caseMngt);
	}

	/**
	 * Deletes the case mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt that was removed
	 * @throws PortalException if a case mngt with the primary key could not be found
	 */
	public static CaseMngt deleteCaseMngt(long caseId) throws PortalException {
		return getService().deleteCaseMngt(caseId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseManagementDB.model.impl.CaseMngtModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseManagementDB.model.impl.CaseMngtModelImpl</code>.
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

	public static CaseMngt fetchCaseMngt(long caseId) {
		return getService().fetchCaseMngt(caseId);
	}

	/**
	 * Returns the case mngt matching the UUID and group.
	 *
	 * @param uuid the case mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public static CaseMngt fetchCaseMngtByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchCaseMngtByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the case mngt with the primary key.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt
	 * @throws PortalException if a case mngt with the primary key could not be found
	 */
	public static CaseMngt getCaseMngt(long caseId) throws PortalException {
		return getService().getCaseMngt(caseId);
	}

	/**
	 * Returns the case mngt matching the UUID and group.
	 *
	 * @param uuid the case mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case mngt
	 * @throws PortalException if a matching case mngt could not be found
	 */
	public static CaseMngt getCaseMngtByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getCaseMngtByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the case mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseManagementDB.model.impl.CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @return the range of case mngts
	 */
	public static List<CaseMngt> getCaseMngts(int start, int end) {
		return getService().getCaseMngts(start, end);
	}

	/**
	 * Returns all the case mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the case mngts
	 * @param companyId the primary key of the company
	 * @return the matching case mngts, or an empty list if no matches were found
	 */
	public static List<CaseMngt> getCaseMngtsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getCaseMngtsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of case mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the case mngts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching case mngts, or an empty list if no matches were found
	 */
	public static List<CaseMngt> getCaseMngtsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator) {

		return getService().getCaseMngtsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of case mngts.
	 *
	 * @return the number of case mngts
	 */
	public static int getCaseMngtsCount() {
		return getService().getCaseMngtsCount();
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
	 * Updates the case mngt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CaseMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseMngt the case mngt
	 * @return the case mngt that was updated
	 */
	public static CaseMngt updateCaseMngt(CaseMngt caseMngt) {
		return getService().updateCaseMngt(caseMngt);
	}

	public static CaseMngtLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<CaseMngtLocalService> _serviceSnapshot =
		new Snapshot<>(
			CaseMngtLocalServiceUtil.class, CaseMngtLocalService.class);

}