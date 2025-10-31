/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AccountMngtLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngtLocalService
 * @generated
 */
public class AccountMngtLocalServiceWrapper
	implements AccountMngtLocalService,
			   ServiceWrapper<AccountMngtLocalService> {

	public AccountMngtLocalServiceWrapper() {
		this(null);
	}

	public AccountMngtLocalServiceWrapper(
		AccountMngtLocalService accountMngtLocalService) {

		_accountMngtLocalService = accountMngtLocalService;
	}

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
	@Override
	public AccountMgmtSystemDB.model.AccountMngt addAccountMngt(
		AccountMgmtSystemDB.model.AccountMngt accountMngt) {

		return _accountMngtLocalService.addAccountMngt(accountMngt);
	}

	/**
	 * Creates a new account mngt with the primary key. Does not add the account mngt to the database.
	 *
	 * @param accountId the primary key for the new account mngt
	 * @return the new account mngt
	 */
	@Override
	public AccountMgmtSystemDB.model.AccountMngt createAccountMngt(
		long accountId) {

		return _accountMngtLocalService.createAccountMngt(accountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountMngtLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public AccountMgmtSystemDB.model.AccountMngt deleteAccountMngt(
		AccountMgmtSystemDB.model.AccountMngt accountMngt) {

		return _accountMngtLocalService.deleteAccountMngt(accountMngt);
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
	@Override
	public AccountMgmtSystemDB.model.AccountMngt deleteAccountMngt(
			long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountMngtLocalService.deleteAccountMngt(accountId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountMngtLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _accountMngtLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _accountMngtLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _accountMngtLocalService.dynamicQuery();
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

		return _accountMngtLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _accountMngtLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _accountMngtLocalService.dynamicQuery(
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

		return _accountMngtLocalService.dynamicQueryCount(dynamicQuery);
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

		return _accountMngtLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public AccountMgmtSystemDB.model.AccountMngt fetchAccountMngt(
		long accountId) {

		return _accountMngtLocalService.fetchAccountMngt(accountId);
	}

	/**
	 * Returns the account mngt matching the UUID and group.
	 *
	 * @param uuid the account mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	@Override
	public AccountMgmtSystemDB.model.AccountMngt
		fetchAccountMngtByUuidAndGroupId(String uuid, long groupId) {

		return _accountMngtLocalService.fetchAccountMngtByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns the account mngt with the primary key.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt
	 * @throws PortalException if a account mngt with the primary key could not be found
	 */
	@Override
	public AccountMgmtSystemDB.model.AccountMngt getAccountMngt(long accountId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountMngtLocalService.getAccountMngt(accountId);
	}

	/**
	 * Returns the account mngt matching the UUID and group.
	 *
	 * @param uuid the account mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account mngt
	 * @throws PortalException if a matching account mngt could not be found
	 */
	@Override
	public AccountMgmtSystemDB.model.AccountMngt getAccountMngtByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountMngtLocalService.getAccountMngtByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<AccountMgmtSystemDB.model.AccountMngt>
		getAccountMngts(int start, int end) {

		return _accountMngtLocalService.getAccountMngts(start, end);
	}

	/**
	 * Returns all the account mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the account mngts
	 * @param companyId the primary key of the company
	 * @return the matching account mngts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<AccountMgmtSystemDB.model.AccountMngt>
		getAccountMngtsByUuidAndCompanyId(String uuid, long companyId) {

		return _accountMngtLocalService.getAccountMngtsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<AccountMgmtSystemDB.model.AccountMngt>
		getAccountMngtsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AccountMgmtSystemDB.model.AccountMngt> orderByComparator) {

		return _accountMngtLocalService.getAccountMngtsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of account mngts.
	 *
	 * @return the number of account mngts
	 */
	@Override
	public int getAccountMngtsCount() {
		return _accountMngtLocalService.getAccountMngtsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _accountMngtLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _accountMngtLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _accountMngtLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountMngtLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _accountMngtLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public AccountMgmtSystemDB.model.AccountMngt updateAccountMngt(
		AccountMgmtSystemDB.model.AccountMngt accountMngt) {

		return _accountMngtLocalService.updateAccountMngt(accountMngt);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _accountMngtLocalService.getBasePersistence();
	}

	@Override
	public AccountMngtLocalService getWrappedService() {
		return _accountMngtLocalService;
	}

	@Override
	public void setWrappedService(
		AccountMngtLocalService accountMngtLocalService) {

		_accountMngtLocalService = accountMngtLocalService;
	}

	private AccountMngtLocalService _accountMngtLocalService;

}