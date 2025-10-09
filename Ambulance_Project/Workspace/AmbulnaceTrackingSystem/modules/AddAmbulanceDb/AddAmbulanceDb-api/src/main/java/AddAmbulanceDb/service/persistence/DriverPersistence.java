/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence;

import AddAmbulanceDb.exception.NoSuchDriverException;

import AddAmbulanceDb.model.Driver;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the driver service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverUtil
 * @generated
 */
@ProviderType
public interface DriverPersistence extends BasePersistence<Driver> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DriverUtil} to access the driver persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching drivers
	 */
	public java.util.List<Driver> findByUuid(String uuid);

	/**
	 * Returns a range of all the drivers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of matching drivers
	 */
	public java.util.List<Driver> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the drivers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns an ordered range of all the drivers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the drivers before and after the current driver in the ordered set where uuid = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver[] findByUuid_PrevAndNext(
			long driverId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Removes all the drivers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching drivers
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the drivers where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the matching drivers
	 */
	public java.util.List<Driver> findByHospitalId(long hospitalId);

	/**
	 * Returns a range of all the drivers where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of matching drivers
	 */
	public java.util.List<Driver> findByHospitalId(
		long hospitalId, int start, int end);

	/**
	 * Returns an ordered range of all the drivers where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByHospitalId(
		long hospitalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns an ordered range of all the drivers where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByHospitalId(
		long hospitalId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByHospitalId_First(
			long hospitalId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the first driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByHospitalId_First(
		long hospitalId,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the last driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByHospitalId_Last(
			long hospitalId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the last driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByHospitalId_Last(
		long hospitalId,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the drivers before and after the current driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver[] findByHospitalId_PrevAndNext(
			long driverId, long hospitalId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Removes all the drivers where hospitalId = &#63; from the database.
	 *
	 * @param hospitalId the hospital ID
	 */
	public void removeByHospitalId(long hospitalId);

	/**
	 * Returns the number of drivers where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the number of matching drivers
	 */
	public int countByHospitalId(long hospitalId);

	/**
	 * Returns all the drivers where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @return the matching drivers
	 */
	public java.util.List<Driver> findByAmbulanceId(long ambulanceId);

	/**
	 * Returns a range of all the drivers where ambulanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param ambulanceId the ambulance ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of matching drivers
	 */
	public java.util.List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end);

	/**
	 * Returns an ordered range of all the drivers where ambulanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param ambulanceId the ambulance ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns an ordered range of all the drivers where ambulanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param ambulanceId the ambulance ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drivers
	 */
	public java.util.List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByAmbulanceId_First(
			long ambulanceId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the first driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByAmbulanceId_First(
		long ambulanceId,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the last driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public Driver findByAmbulanceId_Last(
			long ambulanceId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Returns the last driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public Driver fetchByAmbulanceId_Last(
		long ambulanceId,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns the drivers before and after the current driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver[] findByAmbulanceId_PrevAndNext(
			long driverId, long ambulanceId,
			com.liferay.portal.kernel.util.OrderByComparator<Driver>
				orderByComparator)
		throws NoSuchDriverException;

	/**
	 * Removes all the drivers where ambulanceId = &#63; from the database.
	 *
	 * @param ambulanceId the ambulance ID
	 */
	public void removeByAmbulanceId(long ambulanceId);

	/**
	 * Returns the number of drivers where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @return the number of matching drivers
	 */
	public int countByAmbulanceId(long ambulanceId);

	/**
	 * Caches the driver in the entity cache if it is enabled.
	 *
	 * @param driver the driver
	 */
	public void cacheResult(Driver driver);

	/**
	 * Caches the drivers in the entity cache if it is enabled.
	 *
	 * @param drivers the drivers
	 */
	public void cacheResult(java.util.List<Driver> drivers);

	/**
	 * Creates a new driver with the primary key. Does not add the driver to the database.
	 *
	 * @param driverId the primary key for the new driver
	 * @return the new driver
	 */
	public Driver create(long driverId);

	/**
	 * Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver that was removed
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver remove(long driverId) throws NoSuchDriverException;

	public Driver updateImpl(Driver driver);

	/**
	 * Returns the driver with the primary key or throws a <code>NoSuchDriverException</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public Driver findByPrimaryKey(long driverId) throws NoSuchDriverException;

	/**
	 * Returns the driver with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver, or <code>null</code> if a driver with the primary key could not be found
	 */
	public Driver fetchByPrimaryKey(long driverId);

	/**
	 * Returns all the drivers.
	 *
	 * @return the drivers
	 */
	public java.util.List<Driver> findAll();

	/**
	 * Returns a range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of drivers
	 */
	public java.util.List<Driver> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of drivers
	 */
	public java.util.List<Driver> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator);

	/**
	 * Returns an ordered range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of drivers
	 */
	public java.util.List<Driver> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Driver>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the drivers from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of drivers.
	 *
	 * @return the number of drivers
	 */
	public int countAll();

}