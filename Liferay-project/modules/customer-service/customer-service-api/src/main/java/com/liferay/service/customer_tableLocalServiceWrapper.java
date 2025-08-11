/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link customer_tableLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see customer_tableLocalService
 * @generated
 */
public class customer_tableLocalServiceWrapper
	implements customer_tableLocalService,
			   ServiceWrapper<customer_tableLocalService> {

	public customer_tableLocalServiceWrapper() {
		this(null);
	}

	public customer_tableLocalServiceWrapper(
		customer_tableLocalService customer_tableLocalService) {

		_customer_tableLocalService = customer_tableLocalService;
	}

	/**
	 * Adds the customer_table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect customer_tableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer_table the customer_table
	 * @return the customer_table that was added
	 */
	@Override
	public com.liferay.model.customer_table addcustomer_table(
		com.liferay.model.customer_table customer_table) {

		return _customer_tableLocalService.addcustomer_table(customer_table);
	}

	/**
	 * Creates a new customer_table with the primary key. Does not add the customer_table to the database.
	 *
	 * @param custId the primary key for the new customer_table
	 * @return the new customer_table
	 */
	@Override
	public com.liferay.model.customer_table createcustomer_table(long custId) {
		return _customer_tableLocalService.createcustomer_table(custId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customer_tableLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the customer_table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect customer_tableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer_table the customer_table
	 * @return the customer_table that was removed
	 */
	@Override
	public com.liferay.model.customer_table deletecustomer_table(
		com.liferay.model.customer_table customer_table) {

		return _customer_tableLocalService.deletecustomer_table(customer_table);
	}

	/**
	 * Deletes the customer_table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect customer_tableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table that was removed
	 * @throws PortalException if a customer_table with the primary key could not be found
	 */
	@Override
	public com.liferay.model.customer_table deletecustomer_table(long custId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customer_tableLocalService.deletecustomer_table(custId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customer_tableLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _customer_tableLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _customer_tableLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _customer_tableLocalService.dynamicQuery();
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

		return _customer_tableLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.model.impl.customer_tableModelImpl</code>.
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

		return _customer_tableLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.model.impl.customer_tableModelImpl</code>.
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

		return _customer_tableLocalService.dynamicQuery(
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

		return _customer_tableLocalService.dynamicQueryCount(dynamicQuery);
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

		return _customer_tableLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.liferay.model.customer_table fetchcustomer_table(long custId) {
		return _customer_tableLocalService.fetchcustomer_table(custId);
	}

	/**
	 * Returns the customer_table matching the UUID and group.
	 *
	 * @param uuid the customer_table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	@Override
	public com.liferay.model.customer_table fetchcustomer_tableByUuidAndGroupId(
		String uuid, long groupId) {

		return _customer_tableLocalService.fetchcustomer_tableByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _customer_tableLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the customer_table with the primary key.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table
	 * @throws PortalException if a customer_table with the primary key could not be found
	 */
	@Override
	public com.liferay.model.customer_table getcustomer_table(long custId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customer_tableLocalService.getcustomer_table(custId);
	}

	/**
	 * Returns the customer_table matching the UUID and group.
	 *
	 * @param uuid the customer_table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching customer_table
	 * @throws PortalException if a matching customer_table could not be found
	 */
	@Override
	public com.liferay.model.customer_table getcustomer_tableByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customer_tableLocalService.getcustomer_tableByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the customer_tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.model.impl.customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @return the range of customer_tables
	 */
	@Override
	public java.util.List<com.liferay.model.customer_table> getcustomer_tables(
		int start, int end) {

		return _customer_tableLocalService.getcustomer_tables(start, end);
	}

	/**
	 * Returns all the customer_tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the customer_tables
	 * @param companyId the primary key of the company
	 * @return the matching customer_tables, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.model.customer_table>
		getcustomer_tablesByUuidAndCompanyId(String uuid, long companyId) {

		return _customer_tableLocalService.getcustomer_tablesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of customer_tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the customer_tables
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching customer_tables, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.model.customer_table>
		getcustomer_tablesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.model.customer_table> orderByComparator) {

		return _customer_tableLocalService.getcustomer_tablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of customer_tables.
	 *
	 * @return the number of customer_tables
	 */
	@Override
	public int getcustomer_tablesCount() {
		return _customer_tableLocalService.getcustomer_tablesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _customer_tableLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _customer_tableLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customer_tableLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _customer_tableLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the customer_table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect customer_tableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer_table the customer_table
	 * @return the customer_table that was updated
	 */
	@Override
	public com.liferay.model.customer_table updatecustomer_table(
		com.liferay.model.customer_table customer_table) {

		return _customer_tableLocalService.updatecustomer_table(customer_table);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _customer_tableLocalService.getBasePersistence();
	}

	@Override
	public customer_tableLocalService getWrappedService() {
		return _customer_tableLocalService;
	}

	@Override
	public void setWrappedService(
		customer_tableLocalService customer_tableLocalService) {

		_customer_tableLocalService = customer_tableLocalService;
	}

	private customer_tableLocalService _customer_tableLocalService;

}