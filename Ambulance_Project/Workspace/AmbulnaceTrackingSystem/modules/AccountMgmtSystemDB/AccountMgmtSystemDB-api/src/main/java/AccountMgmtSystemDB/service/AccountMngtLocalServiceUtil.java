/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.service;

import AccountMgmtSystemDB.model.AccountMngt;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AccountMngt. This utility wraps
 * <code>AccountMgmtSystemDB.service.impl.AccountMngtLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngtLocalService
 * @generated
 */
public class AccountMngtLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>AccountMgmtSystemDB.service.impl.AccountMngtLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the account mngt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountMngt the account mngt
	 * @return the account mngt that was added
	 */
	public static AccountMngt addAccountMngt(AccountMngt accountMngt) {
		return getService().addAccountMngt(accountMngt);
	}

	/**
	 * Creates a new account mngt with the primary key. Does not add the account mngt to the database.
	 *
	 * @param accountId the primary key for the new account mngt
	 * @return the new account mngt
	 */
	public static AccountMngt createAccountMngt(long accountId) {
		return getService().createAccountMngt(accountId);
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
	 * Deletes the account mngt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountMngt the account mngt
	 * @return the account mngt that was removed
	 */
	public static AccountMngt deleteAccountMngt(AccountMngt accountMngt) {
		return getService().deleteAccountMngt(accountMngt);
	}

	/**
	 * Deletes the account mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt that was removed
	 * @throws PortalException if a account mngt with the primary key could not be found
	 */
	public static AccountMngt deleteAccountMngt(long accountId)
		throws PortalException {

		return getService().deleteAccountMngt(accountId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMgmtSystemDB.model.impl.AccountMngtModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMgmtSystemDB.model.impl.AccountMngtModelImpl</code>.
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

	public static AccountMngt fetchAccountMngt(long accountId) {
		return getService().fetchAccountMngt(accountId);
	}

	/**
	 * Returns the account mngt matching the UUID and group.
	 *
	 * @param uuid the account mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public static AccountMngt fetchAccountMngtByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAccountMngtByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns the account mngt with the primary key.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt
	 * @throws PortalException if a account mngt with the primary key could not be found
	 */
	public static AccountMngt getAccountMngt(long accountId)
		throws PortalException {

		return getService().getAccountMngt(accountId);
	}

	/**
	 * Returns the account mngt matching the UUID and group.
	 *
	 * @param uuid the account mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account mngt
	 * @throws PortalException if a matching account mngt could not be found
	 */
	public static AccountMngt getAccountMngtByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAccountMngtByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the account mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMgmtSystemDB.model.impl.AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @return the range of account mngts
	 */
	public static List<AccountMngt> getAccountMngts(int start, int end) {
		return getService().getAccountMngts(start, end);
	}

	/**
	 * Returns all the account mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the account mngts
	 * @param companyId the primary key of the company
	 * @return the matching account mngts, or an empty list if no matches were found
	 */
	public static List<AccountMngt> getAccountMngtsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAccountMngtsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of account mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the account mngts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching account mngts, or an empty list if no matches were found
	 */
	public static List<AccountMngt> getAccountMngtsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountMngt> orderByComparator) {

		return getService().getAccountMngtsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account mngts.
	 *
	 * @return the number of account mngts
	 */
	public static int getAccountMngtsCount() {
		return getService().getAccountMngtsCount();
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
	 * Updates the account mngt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountMngt the account mngt
	 * @return the account mngt that was updated
	 */
	public static AccountMngt updateAccountMngt(AccountMngt accountMngt) {
		return getService().updateAccountMngt(accountMngt);
	}

	public static AccountMngtLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AccountMngtLocalService> _serviceSnapshot =
		new Snapshot<>(
			AccountMngtLocalServiceUtil.class, AccountMngtLocalService.class);

}