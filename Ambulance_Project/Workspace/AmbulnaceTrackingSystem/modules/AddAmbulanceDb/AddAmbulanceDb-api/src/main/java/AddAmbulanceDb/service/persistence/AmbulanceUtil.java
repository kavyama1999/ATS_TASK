/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence;

import AddAmbulanceDb.model.Ambulance;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the ambulance service. This utility wraps <code>AddAmbulanceDb.service.persistence.impl.AmbulancePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmbulancePersistence
 * @generated
 */
public class AmbulanceUtil {

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
	public static void clearCache(Ambulance ambulance) {
		getPersistence().clearCache(ambulance);
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
	public static Map<Serializable, Ambulance> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Ambulance> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ambulance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ambulance> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Ambulance update(Ambulance ambulance) {
		return getPersistence().update(ambulance);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Ambulance update(
		Ambulance ambulance, ServiceContext serviceContext) {

		return getPersistence().update(ambulance, serviceContext);
	}

	/**
	 * Returns all the ambulances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ambulances
	 */
	public static List<Ambulance> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Ambulance> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Ambulance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Ambulance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ambulance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public static Ambulance findByUuid_First(
			String uuid, OrderByComparator<Ambulance> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public static Ambulance fetchByUuid_First(
		String uuid, OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public static Ambulance findByUuid_Last(
			String uuid, OrderByComparator<Ambulance> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public static Ambulance fetchByUuid_Last(
		String uuid, OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the ambulances before and after the current ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param ambulanceId the primary key of the current ambulance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public static Ambulance[] findByUuid_PrevAndNext(
			long ambulanceId, String uuid,
			OrderByComparator<Ambulance> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().findByUuid_PrevAndNext(
			ambulanceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the ambulances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of ambulances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ambulances
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the ambulances where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the matching ambulances
	 */
	public static List<Ambulance> findByHospitalId(long hospitalId) {
		return getPersistence().findByHospitalId(hospitalId);
	}

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
	public static List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end) {

		return getPersistence().findByHospitalId(hospitalId, start, end);
	}

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
	public static List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().findByHospitalId(
			hospitalId, start, end, orderByComparator);
	}

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
	public static List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Ambulance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByHospitalId(
			hospitalId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public static Ambulance findByHospitalId_First(
			long hospitalId, OrderByComparator<Ambulance> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().findByHospitalId_First(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the first ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public static Ambulance fetchByHospitalId_First(
		long hospitalId, OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().fetchByHospitalId_First(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the last ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	public static Ambulance findByHospitalId_Last(
			long hospitalId, OrderByComparator<Ambulance> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().findByHospitalId_Last(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the last ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	public static Ambulance fetchByHospitalId_Last(
		long hospitalId, OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().fetchByHospitalId_Last(
			hospitalId, orderByComparator);
	}

	/**
	 * Returns the ambulances before and after the current ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param ambulanceId the primary key of the current ambulance
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public static Ambulance[] findByHospitalId_PrevAndNext(
			long ambulanceId, long hospitalId,
			OrderByComparator<Ambulance> orderByComparator)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().findByHospitalId_PrevAndNext(
			ambulanceId, hospitalId, orderByComparator);
	}

	/**
	 * Removes all the ambulances where hospitalId = &#63; from the database.
	 *
	 * @param hospitalId the hospital ID
	 */
	public static void removeByHospitalId(long hospitalId) {
		getPersistence().removeByHospitalId(hospitalId);
	}

	/**
	 * Returns the number of ambulances where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the number of matching ambulances
	 */
	public static int countByHospitalId(long hospitalId) {
		return getPersistence().countByHospitalId(hospitalId);
	}

	/**
	 * Caches the ambulance in the entity cache if it is enabled.
	 *
	 * @param ambulance the ambulance
	 */
	public static void cacheResult(Ambulance ambulance) {
		getPersistence().cacheResult(ambulance);
	}

	/**
	 * Caches the ambulances in the entity cache if it is enabled.
	 *
	 * @param ambulances the ambulances
	 */
	public static void cacheResult(List<Ambulance> ambulances) {
		getPersistence().cacheResult(ambulances);
	}

	/**
	 * Creates a new ambulance with the primary key. Does not add the ambulance to the database.
	 *
	 * @param ambulanceId the primary key for the new ambulance
	 * @return the new ambulance
	 */
	public static Ambulance create(long ambulanceId) {
		return getPersistence().create(ambulanceId);
	}

	/**
	 * Removes the ambulance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance that was removed
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public static Ambulance remove(long ambulanceId)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().remove(ambulanceId);
	}

	public static Ambulance updateImpl(Ambulance ambulance) {
		return getPersistence().updateImpl(ambulance);
	}

	/**
	 * Returns the ambulance with the primary key or throws a <code>NoSuchAmbulanceException</code> if it could not be found.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	public static Ambulance findByPrimaryKey(long ambulanceId)
		throws AddAmbulanceDb.exception.NoSuchAmbulanceException {

		return getPersistence().findByPrimaryKey(ambulanceId);
	}

	/**
	 * Returns the ambulance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance, or <code>null</code> if a ambulance with the primary key could not be found
	 */
	public static Ambulance fetchByPrimaryKey(long ambulanceId) {
		return getPersistence().fetchByPrimaryKey(ambulanceId);
	}

	/**
	 * Returns all the ambulances.
	 *
	 * @return the ambulances
	 */
	public static List<Ambulance> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Ambulance> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Ambulance> findAll(
		int start, int end, OrderByComparator<Ambulance> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Ambulance> findAll(
		int start, int end, OrderByComparator<Ambulance> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the ambulances from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of ambulances.
	 *
	 * @return the number of ambulances
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmbulancePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AmbulancePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AmbulancePersistence _persistence;

}