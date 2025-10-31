/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.service.persistence;

import AccountMgmtSystemDB.model.AccountMngt;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the account mngt service. This utility wraps <code>AccountMgmtSystemDB.service.persistence.impl.AccountMngtPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngtPersistence
 * @generated
 */
public class AccountMngtUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AccountMngt accountMngt) {
		getPersistence().clearCache(accountMngt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AccountMngt> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AccountMngt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AccountMngt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AccountMngt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AccountMngt update(AccountMngt accountMngt) {
		return getPersistence().update(accountMngt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AccountMngt update(
		AccountMngt accountMngt, ServiceContext serviceContext) {

		return getPersistence().update(accountMngt, serviceContext);
	}

	/**
	 * Returns all the account mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account mngts
	 */
	public static List<AccountMngt> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the account mngts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @return the range of matching account mngts
	 */
	public static List<AccountMngt> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the account mngts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account mngts
	 */
	public static List<AccountMngt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account mngts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account mngts
	 */
	public static List<AccountMngt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AccountMngt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public static AccountMngt findByUuid_First(
			String uuid, OrderByComparator<AccountMngt> orderByComparator)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public static AccountMngt fetchByUuid_First(
		String uuid, OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public static AccountMngt findByUuid_Last(
			String uuid, OrderByComparator<AccountMngt> orderByComparator)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public static AccountMngt fetchByUuid_Last(
		String uuid, OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the account mngts before and after the current account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param accountId the primary key of the current account mngt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account mngt
	 * @throws NoSuchMngtException if a account mngt with the primary key could not be found
	 */
	public static AccountMngt[] findByUuid_PrevAndNext(
			long accountId, String uuid,
			OrderByComparator<AccountMngt> orderByComparator)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_PrevAndNext(
			accountId, uuid, orderByComparator);
	}

	/**
	 * Removes all the account mngts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of account mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account mngts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the account mngt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public static AccountMngt findByUUID_G(String uuid, long groupId)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the account mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public static AccountMngt fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the account mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public static AccountMngt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the account mngt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the account mngt that was removed
	 */
	public static AccountMngt removeByUUID_G(String uuid, long groupId)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of account mngts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching account mngts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the account mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account mngts
	 */
	public static List<AccountMngt> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the account mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @return the range of matching account mngts
	 */
	public static List<AccountMngt> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the account mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching account mngts
	 */
	public static List<AccountMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching account mngts
	 */
	public static List<AccountMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountMngt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public static AccountMngt findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AccountMngt> orderByComparator)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public static AccountMngt fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public static AccountMngt findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AccountMngt> orderByComparator)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public static AccountMngt fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the account mngts before and after the current account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param accountId the primary key of the current account mngt
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account mngt
	 * @throws NoSuchMngtException if a account mngt with the primary key could not be found
	 */
	public static AccountMngt[] findByUuid_C_PrevAndNext(
			long accountId, String uuid, long companyId,
			OrderByComparator<AccountMngt> orderByComparator)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_C_PrevAndNext(
			accountId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the account mngts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of account mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account mngts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the account mngt in the entity cache if it is enabled.
	 *
	 * @param accountMngt the account mngt
	 */
	public static void cacheResult(AccountMngt accountMngt) {
		getPersistence().cacheResult(accountMngt);
	}

	/**
	 * Caches the account mngts in the entity cache if it is enabled.
	 *
	 * @param accountMngts the account mngts
	 */
	public static void cacheResult(List<AccountMngt> accountMngts) {
		getPersistence().cacheResult(accountMngts);
	}

	/**
	 * Creates a new account mngt with the primary key. Does not add the account mngt to the database.
	 *
	 * @param accountId the primary key for the new account mngt
	 * @return the new account mngt
	 */
	public static AccountMngt create(long accountId) {
		return getPersistence().create(accountId);
	}

	/**
	 * Removes the account mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt that was removed
	 * @throws NoSuchMngtException if a account mngt with the primary key could not be found
	 */
	public static AccountMngt remove(long accountId)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().remove(accountId);
	}

	public static AccountMngt updateImpl(AccountMngt accountMngt) {
		return getPersistence().updateImpl(accountMngt);
	}

	/**
	 * Returns the account mngt with the primary key or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt
	 * @throws NoSuchMngtException if a account mngt with the primary key could not be found
	 */
	public static AccountMngt findByPrimaryKey(long accountId)
		throws AccountMgmtSystemDB.exception.NoSuchMngtException {

		return getPersistence().findByPrimaryKey(accountId);
	}

	/**
	 * Returns the account mngt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt, or <code>null</code> if a account mngt with the primary key could not be found
	 */
	public static AccountMngt fetchByPrimaryKey(long accountId) {
		return getPersistence().fetchByPrimaryKey(accountId);
	}

	/**
	 * Returns all the account mngts.
	 *
	 * @return the account mngts
	 */
	public static List<AccountMngt> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the account mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @return the range of account mngts
	 */
	public static List<AccountMngt> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the account mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of account mngts
	 */
	public static List<AccountMngt> findAll(
		int start, int end, OrderByComparator<AccountMngt> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the account mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of account mngts
	 */
	public static List<AccountMngt> findAll(
		int start, int end, OrderByComparator<AccountMngt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the account mngts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of account mngts.
	 *
	 * @return the number of account mngts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AccountMngtPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AccountMngtPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AccountMngtPersistence _persistence;

}