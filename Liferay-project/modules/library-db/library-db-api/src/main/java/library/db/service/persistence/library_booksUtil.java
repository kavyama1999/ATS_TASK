/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import library.db.model.library_books;

/**
 * The persistence utility for the library_books service. This utility wraps <code>library.db.service.persistence.impl.library_booksPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see library_booksPersistence
 * @generated
 */
public class library_booksUtil {

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
	public static void clearCache(library_books library_books) {
		getPersistence().clearCache(library_books);
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
	public static Map<Serializable, library_books> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<library_books> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<library_books> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<library_books> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<library_books> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static library_books update(library_books library_books) {
		return getPersistence().update(library_books);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static library_books update(
		library_books library_books, ServiceContext serviceContext) {

		return getPersistence().update(library_books, serviceContext);
	}

	/**
	 * Returns all the library_bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching library_bookses
	 */
	public static List<library_books> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the library_bookses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @return the range of matching library_bookses
	 */
	public static List<library_books> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the library_bookses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching library_bookses
	 */
	public static List<library_books> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<library_books> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the library_bookses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching library_bookses
	 */
	public static List<library_books> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<library_books> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public static library_books findByUuid_First(
			String uuid, OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByUuid_First(
		String uuid, OrderByComparator<library_books> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public static library_books findByUuid_Last(
			String uuid, OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByUuid_Last(
		String uuid, OrderByComparator<library_books> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the library_bookses before and after the current library_books in the ordered set where uuid = &#63;.
	 *
	 * @param libId the primary key of the current library_books
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library_books
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public static library_books[] findByUuid_PrevAndNext(
			long libId, String uuid,
			OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByUuid_PrevAndNext(
			libId, uuid, orderByComparator);
	}

	/**
	 * Removes all the library_bookses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of library_bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching library_bookses
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the library_books where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchrary_booksException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public static library_books findByUUID_G(String uuid, long groupId)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the library_books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the library_books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the library_books where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the library_books that was removed
	 */
	public static library_books removeByUUID_G(String uuid, long groupId)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of library_bookses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching library_bookses
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the library_bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching library_bookses
	 */
	public static List<library_books> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the library_bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @return the range of matching library_bookses
	 */
	public static List<library_books> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the library_bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching library_bookses
	 */
	public static List<library_books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<library_books> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the library_bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching library_bookses
	 */
	public static List<library_books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<library_books> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public static library_books findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<library_books> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public static library_books findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<library_books> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the library_bookses before and after the current library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param libId the primary key of the current library_books
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library_books
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public static library_books[] findByUuid_C_PrevAndNext(
			long libId, String uuid, long companyId,
			OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByUuid_C_PrevAndNext(
			libId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the library_bookses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of library_bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching library_bookses
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the library_bookses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching library_bookses
	 */
	public static List<library_books> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the library_bookses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @return the range of matching library_bookses
	 */
	public static List<library_books> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the library_bookses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching library_bookses
	 */
	public static List<library_books> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<library_books> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the library_bookses where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching library_bookses
	 */
	public static List<library_books> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<library_books> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public static library_books findByGroupId_First(
			long groupId, OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByGroupId_First(
		long groupId, OrderByComparator<library_books> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public static library_books findByGroupId_Last(
			long groupId, OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchByGroupId_Last(
		long groupId, OrderByComparator<library_books> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the library_bookses before and after the current library_books in the ordered set where groupId = &#63;.
	 *
	 * @param libId the primary key of the current library_books
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library_books
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public static library_books[] findByGroupId_PrevAndNext(
			long libId, long groupId,
			OrderByComparator<library_books> orderByComparator)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByGroupId_PrevAndNext(
			libId, groupId, orderByComparator);
	}

	/**
	 * Removes all the library_bookses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of library_bookses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching library_bookses
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Caches the library_books in the entity cache if it is enabled.
	 *
	 * @param library_books the library_books
	 */
	public static void cacheResult(library_books library_books) {
		getPersistence().cacheResult(library_books);
	}

	/**
	 * Caches the library_bookses in the entity cache if it is enabled.
	 *
	 * @param library_bookses the library_bookses
	 */
	public static void cacheResult(List<library_books> library_bookses) {
		getPersistence().cacheResult(library_bookses);
	}

	/**
	 * Creates a new library_books with the primary key. Does not add the library_books to the database.
	 *
	 * @param libId the primary key for the new library_books
	 * @return the new library_books
	 */
	public static library_books create(long libId) {
		return getPersistence().create(libId);
	}

	/**
	 * Removes the library_books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books that was removed
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public static library_books remove(long libId)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().remove(libId);
	}

	public static library_books updateImpl(library_books library_books) {
		return getPersistence().updateImpl(library_books);
	}

	/**
	 * Returns the library_books with the primary key or throws a <code>NoSuchrary_booksException</code> if it could not be found.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public static library_books findByPrimaryKey(long libId)
		throws library.db.exception.NoSuchrary_booksException {

		return getPersistence().findByPrimaryKey(libId);
	}

	/**
	 * Returns the library_books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books, or <code>null</code> if a library_books with the primary key could not be found
	 */
	public static library_books fetchByPrimaryKey(long libId) {
		return getPersistence().fetchByPrimaryKey(libId);
	}

	/**
	 * Returns all the library_bookses.
	 *
	 * @return the library_bookses
	 */
	public static List<library_books> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the library_bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @return the range of library_bookses
	 */
	public static List<library_books> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the library_bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of library_bookses
	 */
	public static List<library_books> findAll(
		int start, int end,
		OrderByComparator<library_books> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the library_bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of library_bookses
	 */
	public static List<library_books> findAll(
		int start, int end, OrderByComparator<library_books> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the library_bookses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of library_bookses.
	 *
	 * @return the number of library_bookses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static library_booksPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(library_booksPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile library_booksPersistence _persistence;

}