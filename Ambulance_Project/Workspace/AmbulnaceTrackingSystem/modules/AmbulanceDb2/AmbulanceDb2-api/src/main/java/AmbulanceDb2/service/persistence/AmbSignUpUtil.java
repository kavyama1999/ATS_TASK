/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service.persistence;

import AmbulanceDb2.model.AmbSignUp;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the amb sign up service. This utility wraps <code>AmbulanceDb2.service.persistence.impl.AmbSignUpPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AmbSignUpPersistence
 * @generated
 */
public class AmbSignUpUtil {

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
	public static void clearCache(AmbSignUp ambSignUp) {
		getPersistence().clearCache(ambSignUp);
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
	public static Map<Serializable, AmbSignUp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AmbSignUp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AmbSignUp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AmbSignUp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AmbSignUp update(AmbSignUp ambSignUp) {
		return getPersistence().update(ambSignUp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AmbSignUp update(
		AmbSignUp ambSignUp, ServiceContext serviceContext) {

		return getPersistence().update(ambSignUp, serviceContext);
	}

	/**
	 * Returns all the amb sign ups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public static AmbSignUp findByUuid_First(
			String uuid, OrderByComparator<AmbSignUp> orderByComparator)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public static AmbSignUp fetchByUuid_First(
		String uuid, OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public static AmbSignUp findByUuid_Last(
			String uuid, OrderByComparator<AmbSignUp> orderByComparator)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public static AmbSignUp fetchByUuid_Last(
		String uuid, OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the amb sign ups before and after the current amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param otpId the primary key of the current amb sign up
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public static AmbSignUp[] findByUuid_PrevAndNext(
			long otpId, String uuid,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByUuid_PrevAndNext(
			otpId, uuid, orderByComparator);
	}

	/**
	 * Removes all the amb sign ups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of amb sign ups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amb sign ups
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAmbSignUpException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public static AmbSignUp findByUUID_G(String uuid, long groupId)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public static AmbSignUp fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public static AmbSignUp fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the amb sign up where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amb sign up that was removed
	 */
	public static AmbSignUp removeByUUID_G(String uuid, long groupId)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of amb sign ups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amb sign ups
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amb sign ups
	 */
	public static List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public static AmbSignUp findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public static AmbSignUp fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	public static AmbSignUp findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public static AmbSignUp fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the amb sign ups before and after the current amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param otpId the primary key of the current amb sign up
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public static AmbSignUp[] findByUuid_C_PrevAndNext(
			long otpId, String uuid, long companyId,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByUuid_C_PrevAndNext(
			otpId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the amb sign ups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amb sign ups
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the amb sign up in the entity cache if it is enabled.
	 *
	 * @param ambSignUp the amb sign up
	 */
	public static void cacheResult(AmbSignUp ambSignUp) {
		getPersistence().cacheResult(ambSignUp);
	}

	/**
	 * Caches the amb sign ups in the entity cache if it is enabled.
	 *
	 * @param ambSignUps the amb sign ups
	 */
	public static void cacheResult(List<AmbSignUp> ambSignUps) {
		getPersistence().cacheResult(ambSignUps);
	}

	/**
	 * Creates a new amb sign up with the primary key. Does not add the amb sign up to the database.
	 *
	 * @param otpId the primary key for the new amb sign up
	 * @return the new amb sign up
	 */
	public static AmbSignUp create(long otpId) {
		return getPersistence().create(otpId);
	}

	/**
	 * Removes the amb sign up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up that was removed
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public static AmbSignUp remove(long otpId)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().remove(otpId);
	}

	public static AmbSignUp updateImpl(AmbSignUp ambSignUp) {
		return getPersistence().updateImpl(ambSignUp);
	}

	/**
	 * Returns the amb sign up with the primary key or throws a <code>NoSuchAmbSignUpException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	public static AmbSignUp findByPrimaryKey(long otpId)
		throws AmbulanceDb2.exception.NoSuchAmbSignUpException {

		return getPersistence().findByPrimaryKey(otpId);
	}

	/**
	 * Returns the amb sign up with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up, or <code>null</code> if a amb sign up with the primary key could not be found
	 */
	public static AmbSignUp fetchByPrimaryKey(long otpId) {
		return getPersistence().fetchByPrimaryKey(otpId);
	}

	/**
	 * Returns all the amb sign ups.
	 *
	 * @return the amb sign ups
	 */
	public static List<AmbSignUp> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of amb sign ups
	 */
	public static List<AmbSignUp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amb sign ups
	 */
	public static List<AmbSignUp> findAll(
		int start, int end, OrderByComparator<AmbSignUp> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amb sign ups
	 */
	public static List<AmbSignUp> findAll(
		int start, int end, OrderByComparator<AmbSignUp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the amb sign ups from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of amb sign ups.
	 *
	 * @return the number of amb sign ups
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AmbSignUpPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(AmbSignUpPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile AmbSignUpPersistence _persistence;

}