/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence;

import AddAmbulanceDb.model.Driver;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the driver service. This utility wraps <code>AddAmbulanceDb.service.persistence.impl.DriverPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DriverPersistence
 * @generated
 */
public class DriverUtil {

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
	public static void clearCache(Driver driver) {
		getPersistence().clearCache(driver);
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
	public static Map<Serializable, Driver> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Driver> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Driver> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Driver> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Driver> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Driver update(Driver driver) {
		return getPersistence().update(driver);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Driver update(Driver driver, ServiceContext serviceContext) {
		return getPersistence().update(driver, serviceContext);
	}

	/**
	 * Returns all the drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching drivers
	 */
	public static List<Driver> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Driver> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Driver> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Driver> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Driver> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public static Driver findByUuid_First(
			String uuid, OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public static Driver fetchByUuid_First(
		String uuid, OrderByComparator<Driver> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public static Driver findByUuid_Last(
			String uuid, OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public static Driver fetchByUuid_Last(
		String uuid, OrderByComparator<Driver> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the drivers before and after the current driver in the ordered set where uuid = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public static Driver[] findByUuid_PrevAndNext(
			long driverId, String uuid,
			OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByUuid_PrevAndNext(
			driverId, uuid, orderByComparator);
	}

	/**
	 * Removes all the drivers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching drivers
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the drivers where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the matching drivers
	 */
	public static List<Driver> findByHospitalId(long hospitalId) {
		return getPersistence().findByHospitalId(hospitalId);
	}

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
	public static List<Driver> findByHospitalId(
		long hospitalId, int start, int end) {

		return getPersistence().findByHospitalId(hospitalId, start, end);
	}

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
	public static List<Driver> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Driver> orderByComparator) {

		return getPersistence().findByHospitalId(
			hospitalId, start, end, orderByComparator);
	}

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
	public static List<Driver> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByHospitalId(
			hospitalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public static Driver findByHospitalId_First(
			long hospitalId, OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByHospitalId_First(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the first driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public static Driver fetchByHospitalId_First(
		long hospitalId, OrderByComparator<Driver> orderByComparator) {

		return getPersistence().fetchByHospitalId_First(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the last driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public static Driver findByHospitalId_Last(
			long hospitalId, OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByHospitalId_Last(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the last driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public static Driver fetchByHospitalId_Last(
		long hospitalId, OrderByComparator<Driver> orderByComparator) {

		return getPersistence().fetchByHospitalId_Last(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the drivers before and after the current driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public static Driver[] findByHospitalId_PrevAndNext(
			long driverId, long hospitalId,
			OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByHospitalId_PrevAndNext(
			driverId, hospitalId, orderByComparator);
	}

	/**
	 * Removes all the drivers where hospitalId = &#63; from the database.
	 *
	 * @param hospitalId the hospital ID
	 */
	public static void removeByHospitalId(long hospitalId) {
		getPersistence().removeByHospitalId(hospitalId);
	}

	/**
	 * Returns the number of drivers where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the number of matching drivers
	 */
	public static int countByHospitalId(long hospitalId) {
		return getPersistence().countByHospitalId(hospitalId);
	}

	/**
	 * Returns all the drivers where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @return the matching drivers
	 */
	public static List<Driver> findByAmbulanceId(long ambulanceId) {
		return getPersistence().findByAmbulanceId(ambulanceId);
	}

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
	public static List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end) {

		return getPersistence().findByAmbulanceId(ambulanceId, start, end);
	}

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
	public static List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end,
		OrderByComparator<Driver> orderByComparator) {

		return getPersistence().findByAmbulanceId(
			ambulanceId, start, end, orderByComparator);
	}

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
	public static List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByAmbulanceId(
			ambulanceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public static Driver findByAmbulanceId_First(
			long ambulanceId, OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByAmbulanceId_First(
			ambulanceId, orderByComparator);
	}

	/**
	 * Returns the first driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public static Driver fetchByAmbulanceId_First(
		long ambulanceId, OrderByComparator<Driver> orderByComparator) {

		return getPersistence().fetchByAmbulanceId_First(
			ambulanceId, orderByComparator);
	}

	/**
	 * Returns the last driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	public static Driver findByAmbulanceId_Last(
			long ambulanceId, OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByAmbulanceId_Last(
			ambulanceId, orderByComparator);
	}

	/**
	 * Returns the last driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	public static Driver fetchByAmbulanceId_Last(
		long ambulanceId, OrderByComparator<Driver> orderByComparator) {

		return getPersistence().fetchByAmbulanceId_Last(
			ambulanceId, orderByComparator);
	}

	/**
	 * Returns the drivers before and after the current driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public static Driver[] findByAmbulanceId_PrevAndNext(
			long driverId, long ambulanceId,
			OrderByComparator<Driver> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByAmbulanceId_PrevAndNext(
			driverId, ambulanceId, orderByComparator);
	}

	/**
	 * Removes all the drivers where ambulanceId = &#63; from the database.
	 *
	 * @param ambulanceId the ambulance ID
	 */
	public static void removeByAmbulanceId(long ambulanceId) {
		getPersistence().removeByAmbulanceId(ambulanceId);
	}

	/**
	 * Returns the number of drivers where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @return the number of matching drivers
	 */
	public static int countByAmbulanceId(long ambulanceId) {
		return getPersistence().countByAmbulanceId(ambulanceId);
	}

	/**
	 * Caches the driver in the entity cache if it is enabled.
	 *
	 * @param driver the driver
	 */
	public static void cacheResult(Driver driver) {
		getPersistence().cacheResult(driver);
	}

	/**
	 * Caches the drivers in the entity cache if it is enabled.
	 *
	 * @param drivers the drivers
	 */
	public static void cacheResult(List<Driver> drivers) {
		getPersistence().cacheResult(drivers);
	}

	/**
	 * Creates a new driver with the primary key. Does not add the driver to the database.
	 *
	 * @param driverId the primary key for the new driver
	 * @return the new driver
	 */
	public static Driver create(long driverId) {
		return getPersistence().create(driverId);
	}

	/**
	 * Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver that was removed
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public static Driver remove(long driverId)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().remove(driverId);
	}

	public static Driver updateImpl(Driver driver) {
		return getPersistence().updateImpl(driver);
	}

	/**
	 * Returns the driver with the primary key or throws a <code>NoSuchDriverException</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	public static Driver findByPrimaryKey(long driverId)
		throws AddAmbulanceDb.exception.NoSuchDriverException {

		return getPersistence().findByPrimaryKey(driverId);
	}

	/**
	 * Returns the driver with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver, or <code>null</code> if a driver with the primary key could not be found
	 */
	public static Driver fetchByPrimaryKey(long driverId) {
		return getPersistence().fetchByPrimaryKey(driverId);
	}

	/**
	 * Returns all the drivers.
	 *
	 * @return the drivers
	 */
	public static List<Driver> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Driver> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Driver> findAll(
		int start, int end, OrderByComparator<Driver> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Driver> findAll(
		int start, int end, OrderByComparator<Driver> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the drivers from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of drivers.
	 *
	 * @return the number of drivers
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static DriverPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(DriverPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile DriverPersistence _persistence;

}