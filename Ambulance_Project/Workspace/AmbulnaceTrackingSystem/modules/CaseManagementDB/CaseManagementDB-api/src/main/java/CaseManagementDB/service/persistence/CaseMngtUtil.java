/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service.persistence;

import CaseManagementDB.model.CaseMngt;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the case mngt service. This utility wraps <code>CaseManagementDB.service.persistence.impl.CaseMngtPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngtPersistence
 * @generated
 */
public class CaseMngtUtil {

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
	public static void clearCache(CaseMngt caseMngt) {
		getPersistence().clearCache(caseMngt);
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
	public static Map<Serializable, CaseMngt> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CaseMngt> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CaseMngt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CaseMngt> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CaseMngt update(CaseMngt caseMngt) {
		return getPersistence().update(caseMngt);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CaseMngt update(
		CaseMngt caseMngt, ServiceContext serviceContext) {

		return getPersistence().update(caseMngt, serviceContext);
	}

	/**
	 * Returns all the case mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching case mngts
	 */
	public static List<CaseMngt> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<CaseMngt> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<CaseMngt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<CaseMngt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public static CaseMngt findByUuid_First(
			String uuid, OrderByComparator<CaseMngt> orderByComparator)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public static CaseMngt fetchByUuid_First(
		String uuid, OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public static CaseMngt findByUuid_Last(
			String uuid, OrderByComparator<CaseMngt> orderByComparator)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public static CaseMngt fetchByUuid_Last(
		String uuid, OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the case mngts before and after the current case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param caseId the primary key of the current case mngt
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next case mngt
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	public static CaseMngt[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			OrderByComparator<CaseMngt> orderByComparator)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_PrevAndNext(
			caseId, uuid, orderByComparator);
	}

	/**
	 * Removes all the case mngts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of case mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching case mngts
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public static CaseMngt findByUUID_G(String uuid, long groupId)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public static CaseMngt fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public static CaseMngt fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the case mngt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the case mngt that was removed
	 */
	public static CaseMngt removeByUUID_G(String uuid, long groupId)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of case mngts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching case mngts
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching case mngts
	 */
	public static List<CaseMngt> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public static CaseMngt findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CaseMngt> orderByComparator)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public static CaseMngt fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	public static CaseMngt findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CaseMngt> orderByComparator)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	public static CaseMngt fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static CaseMngt[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			OrderByComparator<CaseMngt> orderByComparator)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByUuid_C_PrevAndNext(
			caseId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the case mngts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching case mngts
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Caches the case mngt in the entity cache if it is enabled.
	 *
	 * @param caseMngt the case mngt
	 */
	public static void cacheResult(CaseMngt caseMngt) {
		getPersistence().cacheResult(caseMngt);
	}

	/**
	 * Caches the case mngts in the entity cache if it is enabled.
	 *
	 * @param caseMngts the case mngts
	 */
	public static void cacheResult(List<CaseMngt> caseMngts) {
		getPersistence().cacheResult(caseMngts);
	}

	/**
	 * Creates a new case mngt with the primary key. Does not add the case mngt to the database.
	 *
	 * @param caseId the primary key for the new case mngt
	 * @return the new case mngt
	 */
	public static CaseMngt create(long caseId) {
		return getPersistence().create(caseId);
	}

	/**
	 * Removes the case mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt that was removed
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	public static CaseMngt remove(long caseId)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().remove(caseId);
	}

	public static CaseMngt updateImpl(CaseMngt caseMngt) {
		return getPersistence().updateImpl(caseMngt);
	}

	/**
	 * Returns the case mngt with the primary key or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	public static CaseMngt findByPrimaryKey(long caseId)
		throws CaseManagementDB.exception.NoSuchMngtException {

		return getPersistence().findByPrimaryKey(caseId);
	}

	/**
	 * Returns the case mngt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt, or <code>null</code> if a case mngt with the primary key could not be found
	 */
	public static CaseMngt fetchByPrimaryKey(long caseId) {
		return getPersistence().fetchByPrimaryKey(caseId);
	}

	/**
	 * Returns all the case mngts.
	 *
	 * @return the case mngts
	 */
	public static List<CaseMngt> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<CaseMngt> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<CaseMngt> findAll(
		int start, int end, OrderByComparator<CaseMngt> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<CaseMngt> findAll(
		int start, int end, OrderByComparator<CaseMngt> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the case mngts from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of case mngts.
	 *
	 * @return the number of case mngts
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CaseMngtPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(CaseMngtPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile CaseMngtPersistence _persistence;

}