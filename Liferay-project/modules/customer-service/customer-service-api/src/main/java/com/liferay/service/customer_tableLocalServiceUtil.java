/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service;

import com.liferay.model.customer_table;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for customer_table. This utility wraps
 * <code>com.liferay.service.impl.customer_tableLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see customer_tableLocalService
 * @generated
 */
public class customer_tableLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.service.impl.customer_tableLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static customer_table addcustomer_table(
		customer_table customer_table) {

		return getService().addcustomer_table(customer_table);
	}

	/**
	 * Creates a new customer_table with the primary key. Does not add the customer_table to the database.
	 *
	 * @param custId the primary key for the new customer_table
	 * @return the new customer_table
	 */
	public static customer_table createcustomer_table(long custId) {
		return getService().createcustomer_table(custId);
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
	 * Deletes the customer_table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect customer_tableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer_table the customer_table
	 * @return the customer_table that was removed
	 */
	public static customer_table deletecustomer_table(
		customer_table customer_table) {

		return getService().deletecustomer_table(customer_table);
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
	public static customer_table deletecustomer_table(long custId)
		throws PortalException {

		return getService().deletecustomer_table(custId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.model.impl.customer_tableModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.model.impl.customer_tableModelImpl</code>.
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

	public static customer_table fetchcustomer_table(long custId) {
		return getService().fetchcustomer_table(custId);
	}

	/**
	 * Returns the customer_table matching the UUID and group.
	 *
	 * @param uuid the customer_table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	public static customer_table fetchcustomer_tableByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchcustomer_tableByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the customer_table with the primary key.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table
	 * @throws PortalException if a customer_table with the primary key could not be found
	 */
	public static customer_table getcustomer_table(long custId)
		throws PortalException {

		return getService().getcustomer_table(custId);
	}

	/**
	 * Returns the customer_table matching the UUID and group.
	 *
	 * @param uuid the customer_table's UUID
	 * @param groupId the primary key of the group
	 * @return the matching customer_table
	 * @throws PortalException if a matching customer_table could not be found
	 */
	public static customer_table getcustomer_tableByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getcustomer_tableByUuidAndGroupId(uuid, groupId);
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
	public static List<customer_table> getcustomer_tables(int start, int end) {
		return getService().getcustomer_tables(start, end);
	}

	/**
	 * Returns all the customer_tables matching the UUID and company.
	 *
	 * @param uuid the UUID of the customer_tables
	 * @param companyId the primary key of the company
	 * @return the matching customer_tables, or an empty list if no matches were found
	 */
	public static List<customer_table> getcustomer_tablesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getcustomer_tablesByUuidAndCompanyId(
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
	public static List<customer_table> getcustomer_tablesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<customer_table> orderByComparator) {

		return getService().getcustomer_tablesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of customer_tables.
	 *
	 * @return the number of customer_tables
	 */
	public static int getcustomer_tablesCount() {
		return getService().getcustomer_tablesCount();
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
	 * Updates the customer_table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect customer_tableLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param customer_table the customer_table
	 * @return the customer_table that was updated
	 */
	public static customer_table updatecustomer_table(
		customer_table customer_table) {

		return getService().updatecustomer_table(customer_table);
	}

	public static customer_tableLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<customer_tableLocalService> _serviceSnapshot =
		new Snapshot<>(
			customer_tableLocalServiceUtil.class,
			customer_tableLocalService.class);

}