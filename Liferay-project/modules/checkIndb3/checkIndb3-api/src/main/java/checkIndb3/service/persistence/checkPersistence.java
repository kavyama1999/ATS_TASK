/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.service.persistence;

import checkIndb3.exception.NoSuchcheckException;

import checkIndb3.model.check;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the check service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see checkUtil
 * @generated
 */
@ProviderType
public interface checkPersistence extends BasePersistence<check> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link checkUtil} to access the check persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the checks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching checks
	 */
	public java.util.List<check> findByUuid(String uuid);

	/**
	 * Returns a range of all the checks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @return the range of matching checks
	 */
	public java.util.List<check> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the checks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checks
	 */
	public java.util.List<check> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checks where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checks
	 */
	public java.util.List<check> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first check in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check
	 * @throws NoSuchcheckException if a matching check could not be found
	 */
	public check findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<check>
				orderByComparator)
		throws NoSuchcheckException;

	/**
	 * Returns the first check in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check, or <code>null</code> if a matching check could not be found
	 */
	public check fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator);

	/**
	 * Returns the last check in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check
	 * @throws NoSuchcheckException if a matching check could not be found
	 */
	public check findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<check>
				orderByComparator)
		throws NoSuchcheckException;

	/**
	 * Returns the last check in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check, or <code>null</code> if a matching check could not be found
	 */
	public check fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator);

	/**
	 * Returns the checks before and after the current check in the ordered set where uuid = &#63;.
	 *
	 * @param checkInId the primary key of the current check
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next check
	 * @throws NoSuchcheckException if a check with the primary key could not be found
	 */
	public check[] findByUuid_PrevAndNext(
			long checkInId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<check>
				orderByComparator)
		throws NoSuchcheckException;

	/**
	 * Removes all the checks where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of checks where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching checks
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the check where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchcheckException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check
	 * @throws NoSuchcheckException if a matching check could not be found
	 */
	public check findByUUID_G(String uuid, long groupId)
		throws NoSuchcheckException;

	/**
	 * Returns the check where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching check, or <code>null</code> if a matching check could not be found
	 */
	public check fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the check where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching check, or <code>null</code> if a matching check could not be found
	 */
	public check fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the check where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the check that was removed
	 */
	public check removeByUUID_G(String uuid, long groupId)
		throws NoSuchcheckException;

	/**
	 * Returns the number of checks where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching checks
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the checks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching checks
	 */
	public java.util.List<check> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the checks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @return the range of matching checks
	 */
	public java.util.List<check> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the checks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching checks
	 */
	public java.util.List<check> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checks where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching checks
	 */
	public java.util.List<check> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first check in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check
	 * @throws NoSuchcheckException if a matching check could not be found
	 */
	public check findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<check>
				orderByComparator)
		throws NoSuchcheckException;

	/**
	 * Returns the first check in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching check, or <code>null</code> if a matching check could not be found
	 */
	public check fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator);

	/**
	 * Returns the last check in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check
	 * @throws NoSuchcheckException if a matching check could not be found
	 */
	public check findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<check>
				orderByComparator)
		throws NoSuchcheckException;

	/**
	 * Returns the last check in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching check, or <code>null</code> if a matching check could not be found
	 */
	public check fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator);

	/**
	 * Returns the checks before and after the current check in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param checkInId the primary key of the current check
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next check
	 * @throws NoSuchcheckException if a check with the primary key could not be found
	 */
	public check[] findByUuid_C_PrevAndNext(
			long checkInId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<check>
				orderByComparator)
		throws NoSuchcheckException;

	/**
	 * Removes all the checks where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of checks where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching checks
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the check in the entity cache if it is enabled.
	 *
	 * @param check the check
	 */
	public void cacheResult(check check);

	/**
	 * Caches the checks in the entity cache if it is enabled.
	 *
	 * @param checks the checks
	 */
	public void cacheResult(java.util.List<check> checks);

	/**
	 * Creates a new check with the primary key. Does not add the check to the database.
	 *
	 * @param checkInId the primary key for the new check
	 * @return the new check
	 */
	public check create(long checkInId);

	/**
	 * Removes the check with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param checkInId the primary key of the check
	 * @return the check that was removed
	 * @throws NoSuchcheckException if a check with the primary key could not be found
	 */
	public check remove(long checkInId) throws NoSuchcheckException;

	public check updateImpl(check check);

	/**
	 * Returns the check with the primary key or throws a <code>NoSuchcheckException</code> if it could not be found.
	 *
	 * @param checkInId the primary key of the check
	 * @return the check
	 * @throws NoSuchcheckException if a check with the primary key could not be found
	 */
	public check findByPrimaryKey(long checkInId) throws NoSuchcheckException;

	/**
	 * Returns the check with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param checkInId the primary key of the check
	 * @return the check, or <code>null</code> if a check with the primary key could not be found
	 */
	public check fetchByPrimaryKey(long checkInId);

	/**
	 * Returns all the checks.
	 *
	 * @return the checks
	 */
	public java.util.List<check> findAll();

	/**
	 * Returns a range of all the checks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @return the range of checks
	 */
	public java.util.List<check> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the checks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of checks
	 */
	public java.util.List<check> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator);

	/**
	 * Returns an ordered range of all the checks.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>checkModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of checks
	 * @param end the upper bound of the range of checks (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of checks
	 */
	public java.util.List<check> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<check>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the checks from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of checks.
	 *
	 * @return the number of checks
	 */
	public int countAll();

}