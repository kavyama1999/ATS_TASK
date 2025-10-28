/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service.persistence;

import CaseManagementDB.exception.NoSuchMngtException;

import CaseManagementDB.model.CaseMngt;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the case mngt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngtUtil
 * @generated
 */
@ProviderType
public interface CaseMngtPersistence extends BasePersistence<CaseMngt> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CaseMngtUtil} to access the case mngt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the case mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid(String uuid);

	/**
	 * Returns a range of all the case mngts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @return the range of matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the case mngts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the case mngts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public CaseMngt findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public CaseMngt fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator);

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public CaseMngt findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public CaseMngt fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator);

	/**
	 * Returns the case mngts before and after the current case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param caseId the primary key of the current case mngt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case mngt
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	public CaseMngt[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Removes all the case mngts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of case mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching case mngts
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public CaseMngt findByUUID_G(String uuid, long groupId)
		throws NoSuchMngtException;

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public CaseMngt fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public CaseMngt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the case mngt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the case mngt that was removed
	 */
	public CaseMngt removeByUUID_G(String uuid, long groupId)
		throws NoSuchMngtException;

	/**
	 * Returns the number of case mngts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching case mngts
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @return the range of matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching case mngts
	 */
	public java.util.List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public CaseMngt findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public CaseMngt fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator);

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public CaseMngt findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public CaseMngt fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator);

	/**
	 * Returns the case mngts before and after the current case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param caseId the primary key of the current case mngt
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case mngt
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	public CaseMngt[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
				orderByComparator)
		throws NoSuchMngtException;

	/**
	 * Removes all the case mngts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching case mngts
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the case mngt in the entity cache if it is enabled.
	 *
	 * @param caseMngt the case mngt
	 */
	public void cacheResult(CaseMngt caseMngt);

	/**
	 * Caches the case mngts in the entity cache if it is enabled.
	 *
	 * @param caseMngts the case mngts
	 */
	public void cacheResult(java.util.List<CaseMngt> caseMngts);

	/**
	 * Creates a new case mngt with the primary key. Does not add the case mngt to the database.
	 *
	 * @param caseId the primary key for the new case mngt
	 * @return the new case mngt
	 */
	public CaseMngt create(long caseId);

	/**
	 * Removes the case mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt that was removed
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	public CaseMngt remove(long caseId) throws NoSuchMngtException;

	public CaseMngt updateImpl(CaseMngt caseMngt);

	/**
	 * Returns the case mngt with the primary key or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	public CaseMngt findByPrimaryKey(long caseId) throws NoSuchMngtException;

	/**
	 * Returns the case mngt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt, or <code>null</code> if a case mngt with the primary key could not be found
	 */
	public CaseMngt fetchByPrimaryKey(long caseId);

	/**
	 * Returns all the case mngts.
	 *
	 * @return the case mngts
	 */
	public java.util.List<CaseMngt> findAll();

	/**
	 * Returns a range of all the case mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @return the range of case mngts
	 */
	public java.util.List<CaseMngt> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the case mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of case mngts
	 */
	public java.util.List<CaseMngt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator);

	/**
	 * Returns an ordered range of all the case mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CaseMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of case mngts
	 * @param end the upper bound of the range of case mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of case mngts
	 */
	public java.util.List<CaseMngt> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CaseMngt>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the case mngts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of case mngts.
	 *
	 * @return the number of case mngts
	 */
	public int countAll();

}