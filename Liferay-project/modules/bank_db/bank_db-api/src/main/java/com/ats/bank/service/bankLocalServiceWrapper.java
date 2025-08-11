/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link bankLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see bankLocalService
 * @generated
 */
public class bankLocalServiceWrapper
	implements bankLocalService, ServiceWrapper<bankLocalService> {

	public bankLocalServiceWrapper() {
		this(null);
	}

	public bankLocalServiceWrapper(bankLocalService bankLocalService) {
		_bankLocalService = bankLocalService;
	}

	/**
	 * Adds the bank to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect bankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bank the bank
	 * @return the bank that was added
	 */
	@Override
	public com.ats.bank.model.bank addbank(com.ats.bank.model.bank bank) {
		return _bankLocalService.addbank(bank);
	}

	/**
	 * Creates a new bank with the primary key. Does not add the bank to the database.
	 *
	 * @param bankId the primary key for the new bank
	 * @return the new bank
	 */
	@Override
	public com.ats.bank.model.bank createbank(long bankId) {
		return _bankLocalService.createbank(bankId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the bank from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect bankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bank the bank
	 * @return the bank that was removed
	 */
	@Override
	public com.ats.bank.model.bank deletebank(com.ats.bank.model.bank bank) {
		return _bankLocalService.deletebank(bank);
	}

	/**
	 * Deletes the bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect bankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bankId the primary key of the bank
	 * @return the bank that was removed
	 * @throws PortalException if a bank with the primary key could not be found
	 */
	@Override
	public com.ats.bank.model.bank deletebank(long bankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankLocalService.deletebank(bankId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bankLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bankLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bankLocalService.dynamicQuery();
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

		return _bankLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.bank.model.impl.bankModelImpl</code>.
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

		return _bankLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.bank.model.impl.bankModelImpl</code>.
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

		return _bankLocalService.dynamicQuery(
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

		return _bankLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bankLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ats.bank.model.bank fetchbank(long bankId) {
		return _bankLocalService.fetchbank(bankId);
	}

	/**
	 * Returns the bank matching the UUID and group.
	 *
	 * @param uuid the bank's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank, or <code>null</code> if a matching bank could not be found
	 */
	@Override
	public com.ats.bank.model.bank fetchbankByUuidAndGroupId(
		String uuid, long groupId) {

		return _bankLocalService.fetchbankByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bankLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the bank with the primary key.
	 *
	 * @param bankId the primary key of the bank
	 * @return the bank
	 * @throws PortalException if a bank with the primary key could not be found
	 */
	@Override
	public com.ats.bank.model.bank getbank(long bankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankLocalService.getbank(bankId);
	}

	/**
	 * Returns the bank matching the UUID and group.
	 *
	 * @param uuid the bank's UUID
	 * @param groupId the primary key of the group
	 * @return the matching bank
	 * @throws PortalException if a matching bank could not be found
	 */
	@Override
	public com.ats.bank.model.bank getbankByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankLocalService.getbankByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ats.bank.model.impl.bankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @return the range of banks
	 */
	@Override
	public java.util.List<com.ats.bank.model.bank> getbanks(
		int start, int end) {

		return _bankLocalService.getbanks(start, end);
	}

	/**
	 * Returns all the banks matching the UUID and company.
	 *
	 * @param uuid the UUID of the banks
	 * @param companyId the primary key of the company
	 * @return the matching banks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ats.bank.model.bank> getbanksByUuidAndCompanyId(
		String uuid, long companyId) {

		return _bankLocalService.getbanksByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of banks matching the UUID and company.
	 *
	 * @param uuid the UUID of the banks
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching banks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ats.bank.model.bank> getbanksByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.ats.bank.model.bank> orderByComparator) {

		return _bankLocalService.getbanksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of banks.
	 *
	 * @return the number of banks
	 */
	@Override
	public int getbanksCount() {
		return _bankLocalService.getbanksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bankLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bankLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public com.ats.bank.model.bank getInstance() {
		return _bankLocalService.getInstance();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bankLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the bank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect bankLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bank the bank
	 * @return the bank that was updated
	 */
	@Override
	public com.ats.bank.model.bank updatebank(com.ats.bank.model.bank bank) {
		return _bankLocalService.updatebank(bank);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bankLocalService.getBasePersistence();
	}

	@Override
	public bankLocalService getWrappedService() {
		return _bankLocalService;
	}

	@Override
	public void setWrappedService(bankLocalService bankLocalService) {
		_bankLocalService = bankLocalService;
	}

	private bankLocalService _bankLocalService;

}