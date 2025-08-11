/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link checkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see checkLocalService
 * @generated
 */
public class checkLocalServiceWrapper
	implements checkLocalService, ServiceWrapper<checkLocalService> {

	public checkLocalServiceWrapper() {
		this(null);
	}

	public checkLocalServiceWrapper(checkLocalService checkLocalService) {
		_checkLocalService = checkLocalService;
	}

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
	@Override
	public checkIndb3.model.check addcheck(checkIndb3.model.check check) {
		return _checkLocalService.addcheck(check);
	}

	/**
	 * Creates a new check with the primary key. Does not add the check to the database.
	 *
	 * @param checkInId the primary key for the new check
	 * @return the new check
	 */
	@Override
	public checkIndb3.model.check createcheck(long checkInId) {
		return _checkLocalService.createcheck(checkInId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public checkIndb3.model.check deletecheck(checkIndb3.model.check check) {
		return _checkLocalService.deletecheck(check);
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
	@Override
	public checkIndb3.model.check deletecheck(long checkInId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkLocalService.deletecheck(checkInId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _checkLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _checkLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _checkLocalService.dynamicQuery();
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

		return _checkLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _checkLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _checkLocalService.dynamicQuery(
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

		return _checkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _checkLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public checkIndb3.model.check fetchcheck(long checkInId) {
		return _checkLocalService.fetchcheck(checkInId);
	}

	/**
	 * Returns the check matching the UUID and group.
	 *
	 * @param uuid the check's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check, or <code>null</code> if a matching check could not be found
	 */
	@Override
	public checkIndb3.model.check fetchcheckByUuidAndGroupId(
		String uuid, long groupId) {

		return _checkLocalService.fetchcheckByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _checkLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the check with the primary key.
	 *
	 * @param checkInId the primary key of the check
	 * @return the check
	 * @throws PortalException if a check with the primary key could not be found
	 */
	@Override
	public checkIndb3.model.check getcheck(long checkInId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkLocalService.getcheck(checkInId);
	}

	/**
	 * Returns the check matching the UUID and group.
	 *
	 * @param uuid the check's UUID
	 * @param groupId the primary key of the group
	 * @return the matching check
	 * @throws PortalException if a matching check could not be found
	 */
	@Override
	public checkIndb3.model.check getcheckByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkLocalService.getcheckByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<checkIndb3.model.check> getchecks(
		int start, int end) {

		return _checkLocalService.getchecks(start, end);
	}

	/**
	 * Returns all the checks matching the UUID and company.
	 *
	 * @param uuid the UUID of the checks
	 * @param companyId the primary key of the company
	 * @return the matching checks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<checkIndb3.model.check> getchecksByUuidAndCompanyId(
		String uuid, long companyId) {

		return _checkLocalService.getchecksByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<checkIndb3.model.check> getchecksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<checkIndb3.model.check>
			orderByComparator) {

		return _checkLocalService.getchecksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of checks.
	 *
	 * @return the number of checks
	 */
	@Override
	public int getchecksCount() {
		return _checkLocalService.getchecksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _checkLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _checkLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public checkIndb3.model.check getInstance() {
		return _checkLocalService.getInstance();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checkLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _checkLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public checkIndb3.model.check updatecheck(checkIndb3.model.check check) {
		return _checkLocalService.updatecheck(check);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _checkLocalService.getBasePersistence();
	}

	@Override
	public checkLocalService getWrappedService() {
		return _checkLocalService;
	}

	@Override
	public void setWrappedService(checkLocalService checkLocalService) {
		_checkLocalService = checkLocalService;
	}

	private checkLocalService _checkLocalService;

}