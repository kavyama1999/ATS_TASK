/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.service.persistence;

import com.ats.bank.exception.NoSuchbankException;
import com.ats.bank.model.bank;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the bank service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see bankUtil
 * @generated
 */
@ProviderType
public interface bankPersistence extends BasePersistence<bank> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link bankUtil} to access the bank persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the banks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching banks
	 */
	public java.util.List<bank> findByUuid(String uuid);

	/**
	 * Returns a range of all the banks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @return the range of matching banks
	 */
	public java.util.List<bank> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the banks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banks
	 */
	public java.util.List<bank> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banks
	 */
	public java.util.List<bank> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank
	 * @throws NoSuchbankException if a matching bank could not be found
	 */
	public bank findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<bank>
				orderByComparator)
		throws NoSuchbankException;

	/**
	 * Returns the first bank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank, or <code>null</code> if a matching bank could not be found
	 */
	public bank fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator);

	/**
	 * Returns the last bank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank
	 * @throws NoSuchbankException if a matching bank could not be found
	 */
	public bank findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<bank>
				orderByComparator)
		throws NoSuchbankException;

	/**
	 * Returns the last bank in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank, or <code>null</code> if a matching bank could not be found
	 */
	public bank fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator);

	/**
	 * Returns the banks before and after the current bank in the ordered set where uuid = &#63;.
	 *
	 * @param bankId the primary key of the current bank
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank
	 * @throws NoSuchbankException if a bank with the primary key could not be found
	 */
	public bank[] findByUuid_PrevAndNext(
			long bankId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<bank>
				orderByComparator)
		throws NoSuchbankException;

	/**
	 * Removes all the banks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of banks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching banks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the bank where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchbankException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank
	 * @throws NoSuchbankException if a matching bank could not be found
	 */
	public bank findByUUID_G(String uuid, long groupId)
		throws NoSuchbankException;

	/**
	 * Returns the bank where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching bank, or <code>null</code> if a matching bank could not be found
	 */
	public bank fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the bank where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching bank, or <code>null</code> if a matching bank could not be found
	 */
	public bank fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the bank where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the bank that was removed
	 */
	public bank removeByUUID_G(String uuid, long groupId)
		throws NoSuchbankException;

	/**
	 * Returns the number of banks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching banks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the banks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching banks
	 */
	public java.util.List<bank> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the banks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @return the range of matching banks
	 */
	public java.util.List<bank> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the banks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching banks
	 */
	public java.util.List<bank> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching banks
	 */
	public java.util.List<bank> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first bank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank
	 * @throws NoSuchbankException if a matching bank could not be found
	 */
	public bank findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<bank>
				orderByComparator)
		throws NoSuchbankException;

	/**
	 * Returns the first bank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching bank, or <code>null</code> if a matching bank could not be found
	 */
	public bank fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator);

	/**
	 * Returns the last bank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank
	 * @throws NoSuchbankException if a matching bank could not be found
	 */
	public bank findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<bank>
				orderByComparator)
		throws NoSuchbankException;

	/**
	 * Returns the last bank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching bank, or <code>null</code> if a matching bank could not be found
	 */
	public bank fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator);

	/**
	 * Returns the banks before and after the current bank in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param bankId the primary key of the current bank
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next bank
	 * @throws NoSuchbankException if a bank with the primary key could not be found
	 */
	public bank[] findByUuid_C_PrevAndNext(
			long bankId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<bank>
				orderByComparator)
		throws NoSuchbankException;

	/**
	 * Removes all the banks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of banks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching banks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the bank in the entity cache if it is enabled.
	 *
	 * @param bank the bank
	 */
	public void cacheResult(bank bank);

	/**
	 * Caches the banks in the entity cache if it is enabled.
	 *
	 * @param banks the banks
	 */
	public void cacheResult(java.util.List<bank> banks);

	/**
	 * Creates a new bank with the primary key. Does not add the bank to the database.
	 *
	 * @param bankId the primary key for the new bank
	 * @return the new bank
	 */
	public bank create(long bankId);

	/**
	 * Removes the bank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param bankId the primary key of the bank
	 * @return the bank that was removed
	 * @throws NoSuchbankException if a bank with the primary key could not be found
	 */
	public bank remove(long bankId) throws NoSuchbankException;

	public bank updateImpl(bank bank);

	/**
	 * Returns the bank with the primary key or throws a <code>NoSuchbankException</code> if it could not be found.
	 *
	 * @param bankId the primary key of the bank
	 * @return the bank
	 * @throws NoSuchbankException if a bank with the primary key could not be found
	 */
	public bank findByPrimaryKey(long bankId) throws NoSuchbankException;

	/**
	 * Returns the bank with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param bankId the primary key of the bank
	 * @return the bank, or <code>null</code> if a bank with the primary key could not be found
	 */
	public bank fetchByPrimaryKey(long bankId);

	/**
	 * Returns all the banks.
	 *
	 * @return the banks
	 */
	public java.util.List<bank> findAll();

	/**
	 * Returns a range of all the banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @return the range of banks
	 */
	public java.util.List<bank> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of banks
	 */
	public java.util.List<bank> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator);

	/**
	 * Returns an ordered range of all the banks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>bankModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of banks
	 * @param end the upper bound of the range of banks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of banks
	 */
	public java.util.List<bank> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<bank>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the banks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of banks.
	 *
	 * @return the number of banks
	 */
	public int countAll();

}