/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import library.db.exception.NoSuchbook_reviewException;
import library.db.model.book_review;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the book_review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see book_reviewUtil
 * @generated
 */
@ProviderType
public interface book_reviewPersistence extends BasePersistence<book_review> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link book_reviewUtil} to access the book_review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the book_reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book_reviews
	 */
	public java.util.List<book_review> findByUuid(String uuid);

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
	public java.util.List<book_review> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<book_review> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

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
	public java.util.List<book_review> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public book_review findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public book_review findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

	/**
	 * Returns the book_reviews before and after the current book_review in the ordered set where uuid = &#63;.
	 *
	 * @param reviewId the primary key of the current book_review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public book_review[] findByUuid_PrevAndNext(
			long reviewId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Removes all the book_reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of book_reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book_reviews
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchbook_reviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public book_review findByUUID_G(String uuid, long groupId)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the book_review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book_review that was removed
	 */
	public book_review removeByUUID_G(String uuid, long groupId)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the number of book_reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book_reviews
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book_reviews
	 */
	public java.util.List<book_review> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

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
	public java.util.List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public book_review findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public book_review findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

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
	public book_review[] findByUuid_C_PrevAndNext(
			long reviewId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Removes all the book_reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book_reviews
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the book_reviews where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @return the matching book_reviews
	 */
	public java.util.List<book_review> findByLibId(long libId);

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
	public java.util.List<book_review> findByLibId(
		long libId, int start, int end);

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
	public java.util.List<book_review> findByLibId(
		long libId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

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
	public java.util.List<book_review> findByLibId(
		long libId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public book_review findByLibId_First(
			long libId,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the first book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByLibId_First(
		long libId,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

	/**
	 * Returns the last book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	public book_review findByLibId_Last(
			long libId,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the last book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public book_review fetchByLibId_Last(
		long libId,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

	/**
	 * Returns the book_reviews before and after the current book_review in the ordered set where libId = &#63;.
	 *
	 * @param reviewId the primary key of the current book_review
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public book_review[] findByLibId_PrevAndNext(
			long reviewId, long libId,
			com.liferay.portal.kernel.util.OrderByComparator<book_review>
				orderByComparator)
		throws NoSuchbook_reviewException;

	/**
	 * Removes all the book_reviews where libId = &#63; from the database.
	 *
	 * @param libId the lib ID
	 */
	public void removeByLibId(long libId);

	/**
	 * Returns the number of book_reviews where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @return the number of matching book_reviews
	 */
	public int countByLibId(long libId);

	/**
	 * Caches the book_review in the entity cache if it is enabled.
	 *
	 * @param book_review the book_review
	 */
	public void cacheResult(book_review book_review);

	/**
	 * Caches the book_reviews in the entity cache if it is enabled.
	 *
	 * @param book_reviews the book_reviews
	 */
	public void cacheResult(java.util.List<book_review> book_reviews);

	/**
	 * Creates a new book_review with the primary key. Does not add the book_review to the database.
	 *
	 * @param reviewId the primary key for the new book_review
	 * @return the new book_review
	 */
	public book_review create(long reviewId);

	/**
	 * Removes the book_review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review that was removed
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public book_review remove(long reviewId) throws NoSuchbook_reviewException;

	public book_review updateImpl(book_review book_review);

	/**
	 * Returns the book_review with the primary key or throws a <code>NoSuchbook_reviewException</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	public book_review findByPrimaryKey(long reviewId)
		throws NoSuchbook_reviewException;

	/**
	 * Returns the book_review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review, or <code>null</code> if a book_review with the primary key could not be found
	 */
	public book_review fetchByPrimaryKey(long reviewId);

	/**
	 * Returns all the book_reviews.
	 *
	 * @return the book_reviews
	 */
	public java.util.List<book_review> findAll();

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
	public java.util.List<book_review> findAll(int start, int end);

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
	public java.util.List<book_review> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator);

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
	public java.util.List<book_review> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<book_review>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the book_reviews from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of book_reviews.
	 *
	 * @return the number of book_reviews
	 */
	public int countAll();

}