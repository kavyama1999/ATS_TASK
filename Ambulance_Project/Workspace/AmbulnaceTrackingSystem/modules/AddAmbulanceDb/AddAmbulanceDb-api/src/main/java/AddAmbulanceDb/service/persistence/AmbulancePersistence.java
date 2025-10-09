/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence;

import AddAmbulanceDb.exception.NoSuchAmbulanceException;

import AddAmbulanceDb.model.Ambulance;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the ambulance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmbulanceUtil
 * @generated
 */
@ProviderType
public interface AmbulancePersistence extends BasePersistence<Ambulance> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AmbulanceUtil} to access the ambulance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the ambulances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ambulances
	 */
	public java.util.List<Ambulance> findByUuid(String uuid);

	/**
	 * Returns a range of all the ambulances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @return the range of matching ambulances
	 */
	public java.util.List<Ambulance> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the ambulances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ambulances
	 */
	public java.util.List<Ambulance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ambulances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ambulances
	 */
	public java.util.List<Ambulance> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public Ambulance findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
				orderByComparator)
		throws NoSuchAmbulanceException;

	/**
	 * Returns the first ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public Ambulance fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator);

	/**
	 * Returns the last ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public Ambulance findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
				orderByComparator)
		throws NoSuchAmbulanceException;

	/**
	 * Returns the last ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public Ambulance fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator);

	/**
	 * Returns the ambulances before and after the current ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param ambulanceId the primary key of the current ambulance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public Ambulance[] findByUuid_PrevAndNext(
			long ambulanceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
				orderByComparator)
		throws NoSuchAmbulanceException;

	/**
	 * Removes all the ambulances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of ambulances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ambulances
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the ambulances where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the matching ambulances
	 */
	public java.util.List<Ambulance> findByHospitalId(long hospitalId);

	/**
	 * Returns a range of all the ambulances where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @return the range of matching ambulances
	 */
	public java.util.List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end);

	/**
	 * Returns an ordered range of all the ambulances where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ambulances
	 */
	public java.util.List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ambulances where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ambulances
	 */
	public java.util.List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public Ambulance findByHospitalId_First(
			long hospitalId,
			com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
				orderByComparator)
		throws NoSuchAmbulanceException;

	/**
	 * Returns the first ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public Ambulance fetchByHospitalId_First(
		long hospitalId,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator);

	/**
	 * Returns the last ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public Ambulance findByHospitalId_Last(
			long hospitalId,
			com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
				orderByComparator)
		throws NoSuchAmbulanceException;

	/**
	 * Returns the last ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public Ambulance fetchByHospitalId_Last(
		long hospitalId,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator);

	/**
	 * Returns the ambulances before and after the current ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param ambulanceId the primary key of the current ambulance
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public Ambulance[] findByHospitalId_PrevAndNext(
			long ambulanceId, long hospitalId,
			com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
				orderByComparator)
		throws NoSuchAmbulanceException;

	/**
	 * Removes all the ambulances where hospitalId = &#63; from the database.
	 *
	 * @param hospitalId the hospital ID
	 */
	public void removeByHospitalId(long hospitalId);

	/**
	 * Returns the number of ambulances where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the number of matching ambulances
	 */
	public int countByHospitalId(long hospitalId);

	/**
	 * Caches the ambulance in the entity cache if it is enabled.
	 *
	 * @param ambulance the ambulance
	 */
	public void cacheResult(Ambulance ambulance);

	/**
	 * Caches the ambulances in the entity cache if it is enabled.
	 *
	 * @param ambulances the ambulances
	 */
	public void cacheResult(java.util.List<Ambulance> ambulances);

	/**
	 * Creates a new ambulance with the primary key. Does not add the ambulance to the database.
	 *
	 * @param ambulanceId the primary key for the new ambulance
	 * @return the new ambulance
	 */
	public Ambulance create(long ambulanceId);

	/**
	 * Removes the ambulance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance that was removed
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public Ambulance remove(long ambulanceId) throws NoSuchAmbulanceException;

	public Ambulance updateImpl(Ambulance ambulance);

	/**
	 * Returns the ambulance with the primary key or throws a <code>NoSuchAmbulanceException</code> if it could not be found.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public Ambulance findByPrimaryKey(long ambulanceId)
		throws NoSuchAmbulanceException;

	/**
	 * Returns the ambulance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance, or <code>null</code> if a ambulance with the primary key could not be found
	 */
	public Ambulance fetchByPrimaryKey(long ambulanceId);

	/**
	 * Returns all the ambulances.
	 *
	 * @return the ambulances
	 */
	public java.util.List<Ambulance> findAll();

	/**
	 * Returns a range of all the ambulances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @return the range of ambulances
	 */
	public java.util.List<Ambulance> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the ambulances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ambulances
	 */
	public java.util.List<Ambulance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator);

	/**
	 * Returns an ordered range of all the ambulances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ambulances
	 */
	public java.util.List<Ambulance> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Ambulance>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the ambulances from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of ambulances.
	 *
	 * @return the number of ambulances
	 */
	public int countAll();

}