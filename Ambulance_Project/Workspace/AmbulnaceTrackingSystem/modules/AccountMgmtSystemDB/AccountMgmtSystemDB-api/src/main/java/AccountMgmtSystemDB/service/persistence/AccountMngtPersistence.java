/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.service.persistence;

import AccountMgmtSystemDB.exception.NoSuchMngtException;

import AccountMgmtSystemDB.model.AccountMngt;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the account mngt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngtUtil
 * @generated
 */
@ProviderType
public interface AccountMngtPersistence extends BasePersistence<AccountMngt> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountMngtUtil} to access the account mngt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the account mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching account mngts
	 */
	public java.util.List<AccountMngt> findByUuid(String uuid);

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
	public java.util.List<AccountMngt> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<AccountMngt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator);

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
	public java.util.List<AccountMngt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public AccountMngt findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public AccountMngt fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator);

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public AccountMngt findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public AccountMngt fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator);

	/**
	 * Returns the account mngts before and after the current account mngt in the ordered set where uuid = &#63;.
	 *
	 * @param accountId the primary key of the current account mngt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account mngt
	 * @throws NoSuchMngtException if a account mngt with the primary key could not be found
	 */
	public AccountMngt[] findByUuid_PrevAndNext(
			long accountId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Removes all the account mngts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of account mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching account mngts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the account mngt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public AccountMngt findByUUID_G(String uuid, long groupId)
		throws NoSuchMngtException;

	/**
	 * Returns the account mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public AccountMngt fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the account mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public AccountMngt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the account mngt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the account mngt that was removed
	 */
	public AccountMngt removeByUUID_G(String uuid, long groupId)
		throws NoSuchMngtException;

	/**
	 * Returns the number of account mngts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching account mngts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the account mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching account mngts
	 */
	public java.util.List<AccountMngt> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<AccountMngt> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<AccountMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator);

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
	public java.util.List<AccountMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public AccountMngt findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the first account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public AccountMngt fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator);

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt
	 * @throws NoSuchMngtException if a matching account mngt could not be found
	 */
	public AccountMngt findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the last account mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	public AccountMngt fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator);

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
	public AccountMngt[] findByUuid_C_PrevAndNext(
			long accountId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Removes all the account mngts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of account mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching account mngts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the account mngt in the entity cache if it is enabled.
	 *
	 * @param accountMngt the account mngt
	 */
	public void cacheResult(AccountMngt accountMngt);

	/**
	 * Caches the account mngts in the entity cache if it is enabled.
	 *
	 * @param accountMngts the account mngts
	 */
	public void cacheResult(java.util.List<AccountMngt> accountMngts);

	/**
	 * Creates a new account mngt with the primary key. Does not add the account mngt to the database.
	 *
	 * @param accountId the primary key for the new account mngt
	 * @return the new account mngt
	 */
	public AccountMngt create(long accountId);

	/**
	 * Removes the account mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt that was removed
	 * @throws NoSuchMngtException if a account mngt with the primary key could not be found
	 */
	public AccountMngt remove(long accountId) throws NoSuchMngtException;

	public AccountMngt updateImpl(AccountMngt accountMngt);

	/**
	 * Returns the account mngt with the primary key or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt
	 * @throws NoSuchMngtException if a account mngt with the primary key could not be found
	 */
	public AccountMngt findByPrimaryKey(long accountId)
		throws NoSuchMngtException;

	/**
	 * Returns the account mngt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt, or <code>null</code> if a account mngt with the primary key could not be found
	 */
	public AccountMngt fetchByPrimaryKey(long accountId);

	/**
	 * Returns all the account mngts.
	 *
	 * @return the account mngts
	 */
	public java.util.List<AccountMngt> findAll();

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
	public java.util.List<AccountMngt> findAll(int start, int end);

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
	public java.util.List<AccountMngt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator);

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
	public java.util.List<AccountMngt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AccountMngt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the account mngts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of account mngts.
	 *
	 * @return the number of account mngts
	 */
	public int countAll();

}