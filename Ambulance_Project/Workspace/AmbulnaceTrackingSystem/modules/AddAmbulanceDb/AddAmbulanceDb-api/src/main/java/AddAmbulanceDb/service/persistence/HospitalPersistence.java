/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence;

import AddAmbulanceDb.exception.NoSuchHospitalException;

import AddAmbulanceDb.model.Hospital;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the hospital service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see HospitalUtil
 * @generated
 */
@ProviderType
public interface HospitalPersistence extends BasePersistence<Hospital> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link HospitalUtil} to access the hospital persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the hospitals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching hospitals
	 */
	public java.util.List<Hospital> findByUuid(String uuid);

	/**
	 * Returns a range of all the hospitals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @return the range of matching hospitals
	 */
	public java.util.List<Hospital> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the hospitals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hospitals
	 */
	public java.util.List<Hospital> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hospitals where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hospitals
	 */
	public java.util.List<Hospital> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first hospital in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hospital
	 * @throws NoSuchHospitalException if a matching hospital could not be found
	 */
	public Hospital findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Hospital>
				orderByComparator)
		throws NoSuchHospitalException;

	/**
	 * Returns the first hospital in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	public Hospital fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator);

	/**
	 * Returns the last hospital in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hospital
	 * @throws NoSuchHospitalException if a matching hospital could not be found
	 */
	public Hospital findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Hospital>
				orderByComparator)
		throws NoSuchHospitalException;

	/**
	 * Returns the last hospital in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	public Hospital fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator);

	/**
	 * Returns the hospitals before and after the current hospital in the ordered set where uuid = &#63;.
	 *
	 * @param hospitalId the primary key of the current hospital
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hospital
	 * @throws NoSuchHospitalException if a hospital with the primary key could not be found
	 */
	public Hospital[] findByUuid_PrevAndNext(
			long hospitalId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Hospital>
				orderByComparator)
		throws NoSuchHospitalException;

	/**
	 * Removes all the hospitals where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of hospitals where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching hospitals
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the hospital where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchHospitalException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hospital
	 * @throws NoSuchHospitalException if a matching hospital could not be found
	 */
	public Hospital findByUUID_G(String uuid, long groupId)
		throws NoSuchHospitalException;

	/**
	 * Returns the hospital where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	public Hospital fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the hospital where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	public Hospital fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the hospital where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the hospital that was removed
	 */
	public Hospital removeByUUID_G(String uuid, long groupId)
		throws NoSuchHospitalException;

	/**
	 * Returns the number of hospitals where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching hospitals
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the hospitals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching hospitals
	 */
	public java.util.List<Hospital> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the hospitals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @return the range of matching hospitals
	 */
	public java.util.List<Hospital> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the hospitals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching hospitals
	 */
	public java.util.List<Hospital> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hospitals where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching hospitals
	 */
	public java.util.List<Hospital> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first hospital in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hospital
	 * @throws NoSuchHospitalException if a matching hospital could not be found
	 */
	public Hospital findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Hospital>
				orderByComparator)
		throws NoSuchHospitalException;

	/**
	 * Returns the first hospital in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	public Hospital fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator);

	/**
	 * Returns the last hospital in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hospital
	 * @throws NoSuchHospitalException if a matching hospital could not be found
	 */
	public Hospital findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Hospital>
				orderByComparator)
		throws NoSuchHospitalException;

	/**
	 * Returns the last hospital in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching hospital, or <code>null</code> if a matching hospital could not be found
	 */
	public Hospital fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator);

	/**
	 * Returns the hospitals before and after the current hospital in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param hospitalId the primary key of the current hospital
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next hospital
	 * @throws NoSuchHospitalException if a hospital with the primary key could not be found
	 */
	public Hospital[] findByUuid_C_PrevAndNext(
			long hospitalId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Hospital>
				orderByComparator)
		throws NoSuchHospitalException;

	/**
	 * Removes all the hospitals where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of hospitals where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching hospitals
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the hospital in the entity cache if it is enabled.
	 *
	 * @param hospital the hospital
	 */
	public void cacheResult(Hospital hospital);

	/**
	 * Caches the hospitals in the entity cache if it is enabled.
	 *
	 * @param hospitals the hospitals
	 */
	public void cacheResult(java.util.List<Hospital> hospitals);

	/**
	 * Creates a new hospital with the primary key. Does not add the hospital to the database.
	 *
	 * @param hospitalId the primary key for the new hospital
	 * @return the new hospital
	 */
	public Hospital create(long hospitalId);

	/**
	 * Removes the hospital with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param hospitalId the primary key of the hospital
	 * @return the hospital that was removed
	 * @throws NoSuchHospitalException if a hospital with the primary key could not be found
	 */
	public Hospital remove(long hospitalId) throws NoSuchHospitalException;

	public Hospital updateImpl(Hospital hospital);

	/**
	 * Returns the hospital with the primary key or throws a <code>NoSuchHospitalException</code> if it could not be found.
	 *
	 * @param hospitalId the primary key of the hospital
	 * @return the hospital
	 * @throws NoSuchHospitalException if a hospital with the primary key could not be found
	 */
	public Hospital findByPrimaryKey(long hospitalId)
		throws NoSuchHospitalException;

	/**
	 * Returns the hospital with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param hospitalId the primary key of the hospital
	 * @return the hospital, or <code>null</code> if a hospital with the primary key could not be found
	 */
	public Hospital fetchByPrimaryKey(long hospitalId);

	/**
	 * Returns all the hospitals.
	 *
	 * @return the hospitals
	 */
	public java.util.List<Hospital> findAll();

	/**
	 * Returns a range of all the hospitals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @return the range of hospitals
	 */
	public java.util.List<Hospital> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the hospitals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of hospitals
	 */
	public java.util.List<Hospital> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator);

	/**
	 * Returns an ordered range of all the hospitals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>HospitalModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of hospitals
	 * @param end the upper bound of the range of hospitals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of hospitals
	 */
	public java.util.List<Hospital> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Hospital>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the hospitals from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of hospitals.
	 *
	 * @return the number of hospitals
	 */
	public int countAll();

}