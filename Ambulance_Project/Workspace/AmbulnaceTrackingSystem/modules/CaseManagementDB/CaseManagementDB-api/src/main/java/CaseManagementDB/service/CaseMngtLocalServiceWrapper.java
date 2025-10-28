/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link CaseMngtLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngtLocalService
 * @generated
 */
public class CaseMngtLocalServiceWrapper
	implements CaseMngtLocalService, ServiceWrapper<CaseMngtLocalService> {

	public CaseMngtLocalServiceWrapper() {
		this(null);
	}

	public CaseMngtLocalServiceWrapper(
		CaseMngtLocalService caseMngtLocalService) {

		_caseMngtLocalService = caseMngtLocalService;
	}

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
	@Override
	public CaseManagementDB.model.CaseMngt addCaseMngt(
		CaseManagementDB.model.CaseMngt caseMngt) {

		return _caseMngtLocalService.addCaseMngt(caseMngt);
	}

	/**
	 * Creates a new case mngt with the primary key. Does not add the case mngt to the database.
	 *
	 * @param caseId the primary key for the new case mngt
	 * @return the new case mngt
	 */
	@Override
	public CaseManagementDB.model.CaseMngt createCaseMngt(long caseId) {
		return _caseMngtLocalService.createCaseMngt(caseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseMngtLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public CaseManagementDB.model.CaseMngt deleteCaseMngt(
		CaseManagementDB.model.CaseMngt caseMngt) {

		return _caseMngtLocalService.deleteCaseMngt(caseMngt);
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
	@Override
	public CaseManagementDB.model.CaseMngt deleteCaseMngt(long caseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseMngtLocalService.deleteCaseMngt(caseId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseMngtLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _caseMngtLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _caseMngtLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _caseMngtLocalService.dynamicQuery();
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

		return _caseMngtLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _caseMngtLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _caseMngtLocalService.dynamicQuery(
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

		return _caseMngtLocalService.dynamicQueryCount(dynamicQuery);
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

		return _caseMngtLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public CaseManagementDB.model.CaseMngt fetchCaseMngt(long caseId) {
		return _caseMngtLocalService.fetchCaseMngt(caseId);
	}

	/**
	 * Returns the case mngt matching the UUID and group.
	 *
	 * @param uuid the case mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	@Override
	public CaseManagementDB.model.CaseMngt fetchCaseMngtByUuidAndGroupId(
		String uuid, long groupId) {

		return _caseMngtLocalService.fetchCaseMngtByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _caseMngtLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the case mngt with the primary key.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt
	 * @throws PortalException if a case mngt with the primary key could not be found
	 */
	@Override
	public CaseManagementDB.model.CaseMngt getCaseMngt(long caseId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseMngtLocalService.getCaseMngt(caseId);
	}

	/**
	 * Returns the case mngt matching the UUID and group.
	 *
	 * @param uuid the case mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching case mngt
	 * @throws PortalException if a matching case mngt could not be found
	 */
	@Override
	public CaseManagementDB.model.CaseMngt getCaseMngtByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseMngtLocalService.getCaseMngtByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<CaseManagementDB.model.CaseMngt> getCaseMngts(
		int start, int end) {

		return _caseMngtLocalService.getCaseMngts(start, end);
	}

	/**
	 * Returns all the case mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the case mngts
	 * @param companyId the primary key of the company
	 * @return the matching case mngts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<CaseManagementDB.model.CaseMngt>
		getCaseMngtsByUuidAndCompanyId(String uuid, long companyId) {

		return _caseMngtLocalService.getCaseMngtsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<CaseManagementDB.model.CaseMngt>
		getCaseMngtsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<CaseManagementDB.model.CaseMngt> orderByComparator) {

		return _caseMngtLocalService.getCaseMngtsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of case mngts.
	 *
	 * @return the number of case mngts
	 */
	@Override
	public int getCaseMngtsCount() {
		return _caseMngtLocalService.getCaseMngtsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _caseMngtLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _caseMngtLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _caseMngtLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _caseMngtLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public CaseManagementDB.model.CaseMngt updateCaseMngt(
		CaseManagementDB.model.CaseMngt caseMngt) {

		return _caseMngtLocalService.updateCaseMngt(caseMngt);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _caseMngtLocalService.getBasePersistence();
	}

	@Override
	public CaseMngtLocalService getWrappedService() {
		return _caseMngtLocalService;
	}

	@Override
	public void setWrappedService(CaseMngtLocalService caseMngtLocalService) {
		_caseMngtLocalService = caseMngtLocalService;
	}

	private CaseMngtLocalService _caseMngtLocalService;

}