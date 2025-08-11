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

import library.db.model.book_review;

/**
 * The persistence utility for the book_review service. This utility wraps <code>library.db.service.persistence.impl.book_reviewPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see book_reviewPersistence
 * @generated
 */
public class book_reviewUtil {

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
	public static void clearCache(book_review book_review) {
		getPersistence().clearCache(book_review);
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
	public static Map<Serializable, book_review> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<book_review> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<book_review> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<book_review> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static book_review update(book_review book_review) {
		return getPersistence().update(book_review);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static book_review update(
		book_review book_review, ServiceContext serviceContext) {

		return getPersistence().update(book_review, serviceContext);
	}

	/**
	 * Returns all the book_reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book_reviews
	 */
	public static List<book_review> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the book_reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @return the range of matching book_reviews
	 */
	public static List<book_review> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the book_reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book_reviews
	 */
	public static List<book_review> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book_reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book_reviews
	 */
	public static List<book_review> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<book_review> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public static book_review findByUuid_First(
			String uuid, OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByUuid_First(
		String uuid, OrderByComparator<book_review> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public static book_review findByUuid_Last(
			String uuid, OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByUuid_Last(
		String uuid, OrderByComparator<book_review> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the book_reviews before and after the current book_review in the ordered set where uuid = &#63;.
	 *
	 * @param reviewId the primary key of the current book_review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public static book_review[] findByUuid_PrevAndNext(
			long reviewId, String uuid,
			OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByUuid_PrevAndNext(
			reviewId, uuid, orderByComparator);
	}

	/**
	 * Removes all the book_reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of book_reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book_reviews
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchbook_reviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public static book_review findByUUID_G(String uuid, long groupId)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the book_review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book_review that was removed
	 */
	public static book_review removeByUUID_G(String uuid, long groupId)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of book_reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book_reviews
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book_reviews
	 */
	public static List<book_review> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @return the range of matching book_reviews
	 */
	public static List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book_reviews
	 */
	public static List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book_reviews
	 */
	public static List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<book_review> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public static book_review findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<book_review> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public static book_review findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<book_review> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the book_reviews before and after the current book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param reviewId the primary key of the current book_review
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public static book_review[] findByUuid_C_PrevAndNext(
			long reviewId, String uuid, long companyId,
			OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByUuid_C_PrevAndNext(
			reviewId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the book_reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book_reviews
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the book_reviews where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @return the matching book_reviews
	 */
	public static List<book_review> findByLibId(long libId) {
		return getPersistence().findByLibId(libId);
	}

	/**
	 * Returns a range of all the book_reviews where libId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param libId the lib ID
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @return the range of matching book_reviews
	 */
	public static List<book_review> findByLibId(
		long libId, int start, int end) {

		return getPersistence().findByLibId(libId, start, end);
	}

	/**
	 * Returns an ordered range of all the book_reviews where libId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param libId the lib ID
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book_reviews
	 */
	public static List<book_review> findByLibId(
		long libId, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return getPersistence().findByLibId(
			libId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book_reviews where libId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param libId the lib ID
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book_reviews
	 */
	public static List<book_review> findByLibId(
		long libId, int start, int end,
		OrderByComparator<book_review> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByLibId(
			libId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public static book_review findByLibId_First(
			long libId, OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByLibId_First(libId, orderByComparator);
	}

	/**
	 * Returns the first book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByLibId_First(
		long libId, OrderByComparator<book_review> orderByComparator) {

		return getPersistence().fetchByLibId_First(libId, orderByComparator);
	}

	/**
	 * Returns the last book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public static book_review findByLibId_Last(
			long libId, OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByLibId_Last(libId, orderByComparator);
	}

	/**
	 * Returns the last book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchByLibId_Last(
		long libId, OrderByComparator<book_review> orderByComparator) {

		return getPersistence().fetchByLibId_Last(libId, orderByComparator);
	}

	/**
	 * Returns the book_reviews before and after the current book_review in the ordered set where libId = &#63;.
	 *
	 * @param reviewId the primary key of the current book_review
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public static book_review[] findByLibId_PrevAndNext(
			long reviewId, long libId,
			OrderByComparator<book_review> orderByComparator)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByLibId_PrevAndNext(
			reviewId, libId, orderByComparator);
	}

	/**
	 * Removes all the book_reviews where libId = &#63; from the database.
	 *
	 * @param libId the lib ID
	 */
	public static void removeByLibId(long libId) {
		getPersistence().removeByLibId(libId);
	}

	/**
	 * Returns the number of book_reviews where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @return the number of matching book_reviews
	 */
	public static int countByLibId(long libId) {
		return getPersistence().countByLibId(libId);
	}

	/**
	 * Caches the book_review in the entity cache if it is enabled.
	 *
	 * @param book_review the book_review
	 */
	public static void cacheResult(book_review book_review) {
		getPersistence().cacheResult(book_review);
	}

	/**
	 * Caches the book_reviews in the entity cache if it is enabled.
	 *
	 * @param book_reviews the book_reviews
	 */
	public static void cacheResult(List<book_review> book_reviews) {
		getPersistence().cacheResult(book_reviews);
	}

	/**
	 * Creates a new book_review with the primary key. Does not add the book_review to the database.
	 *
	 * @param reviewId the primary key for the new book_review
	 * @return the new book_review
	 */
	public static book_review create(long reviewId) {
		return getPersistence().create(reviewId);
	}

	/**
	 * Removes the book_review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review that was removed
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public static book_review remove(long reviewId)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().remove(reviewId);
	}

	public static book_review updateImpl(book_review book_review) {
		return getPersistence().updateImpl(book_review);
	}

	/**
	 * Returns the book_review with the primary key or throws a <code>NoSuchbook_reviewException</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public static book_review findByPrimaryKey(long reviewId)
		throws library.db.exception.NoSuchbook_reviewException {

		return getPersistence().findByPrimaryKey(reviewId);
	}

	/**
	 * Returns the book_review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review, or <code>null</code> if a book_review with the primary key could not be found
	 */
	public static book_review fetchByPrimaryKey(long reviewId) {
		return getPersistence().fetchByPrimaryKey(reviewId);
	}

	/**
	 * Returns all the book_reviews.
	 *
	 * @return the book_reviews
	 */
	public static List<book_review> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the book_reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @return the range of book_reviews
	 */
	public static List<book_review> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the book_reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of book_reviews
	 */
	public static List<book_review> findAll(
		int start, int end, OrderByComparator<book_review> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the book_reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of book_reviews
	 */
	public static List<book_review> findAll(
		int start, int end, OrderByComparator<book_review> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the book_reviews from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of book_reviews.
	 *
	 * @return the number of book_reviews
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static book_reviewPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(book_reviewPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile book_reviewPersistence _persistence;

}