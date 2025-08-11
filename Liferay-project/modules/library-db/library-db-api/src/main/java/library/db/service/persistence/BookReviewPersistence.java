/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import library.db.exception.NoSuchBookReviewException;
import library.db.model.BookReview;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the book review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BookReviewUtil
 * @generated
 */
@ProviderType
public interface BookReviewPersistence extends BasePersistence<BookReview> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link BookReviewUtil} to access the book review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the book reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book reviews
	 */
	public java.util.List<BookReview> findByUuid(String uuid);

	/**
	 * Returns a range of all the book reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @return the range of matching book reviews
	 */
	public java.util.List<BookReview> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the book reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book reviews
	 */
	public java.util.List<BookReview> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator);

	/**
	 * Returns an ordered range of all the book reviews where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book reviews
	 */
	public java.util.List<BookReview> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	public BookReview findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookReview>
				orderByComparator)
		throws NoSuchBookReviewException;

	/**
	 * Returns the first book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review, or <code>null</code> if a matching book review could not be found
	 */
	public BookReview fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator);

	/**
	 * Returns the last book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	public BookReview findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookReview>
				orderByComparator)
		throws NoSuchBookReviewException;

	/**
	 * Returns the last book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review, or <code>null</code> if a matching book review could not be found
	 */
	public BookReview fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator);

	/**
	 * Returns the book reviews before and after the current book review in the ordered set where uuid = &#63;.
	 *
	 * @param reviewId the primary key of the current book review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book review
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	public BookReview[] findByUuid_PrevAndNext(
			long reviewId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<BookReview>
				orderByComparator)
		throws NoSuchBookReviewException;

	/**
	 * Removes all the book reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of book reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book reviews
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the book review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookReviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	public BookReview findByUUID_G(String uuid, long groupId)
		throws NoSuchBookReviewException;

	/**
	 * Returns the book review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book review, or <code>null</code> if a matching book review could not be found
	 */
	public BookReview fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the book review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book review, or <code>null</code> if a matching book review could not be found
	 */
	public BookReview fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the book review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book review that was removed
	 */
	public BookReview removeByUUID_G(String uuid, long groupId)
		throws NoSuchBookReviewException;

	/**
	 * Returns the number of book reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book reviews
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the book reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book reviews
	 */
	public java.util.List<BookReview> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the book reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @return the range of matching book reviews
	 */
	public java.util.List<BookReview> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the book reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching book reviews
	 */
	public java.util.List<BookReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator);

	/**
	 * Returns an ordered range of all the book reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching book reviews
	 */
	public java.util.List<BookReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	public BookReview findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookReview>
				orderByComparator)
		throws NoSuchBookReviewException;

	/**
	 * Returns the first book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review, or <code>null</code> if a matching book review could not be found
	 */
	public BookReview fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator);

	/**
	 * Returns the last book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	public BookReview findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookReview>
				orderByComparator)
		throws NoSuchBookReviewException;

	/**
	 * Returns the last book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review, or <code>null</code> if a matching book review could not be found
	 */
	public BookReview fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator);

	/**
	 * Returns the book reviews before and after the current book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param reviewId the primary key of the current book review
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book review
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	public BookReview[] findByUuid_C_PrevAndNext(
			long reviewId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<BookReview>
				orderByComparator)
		throws NoSuchBookReviewException;

	/**
	 * Removes all the book reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of book reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book reviews
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the book review in the entity cache if it is enabled.
	 *
	 * @param bookReview the book review
	 */
	public void cacheResult(BookReview bookReview);

	/**
	 * Caches the book reviews in the entity cache if it is enabled.
	 *
	 * @param bookReviews the book reviews
	 */
	public void cacheResult(java.util.List<BookReview> bookReviews);

	/**
	 * Creates a new book review with the primary key. Does not add the book review to the database.
	 *
	 * @param reviewId the primary key for the new book review
	 * @return the new book review
	 */
	public BookReview create(long reviewId);

	/**
	 * Removes the book review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review that was removed
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	public BookReview remove(long reviewId) throws NoSuchBookReviewException;

	public BookReview updateImpl(BookReview bookReview);

	/**
	 * Returns the book review with the primary key or throws a <code>NoSuchBookReviewException</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	public BookReview findByPrimaryKey(long reviewId)
		throws NoSuchBookReviewException;

	/**
	 * Returns the book review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review, or <code>null</code> if a book review with the primary key could not be found
	 */
	public BookReview fetchByPrimaryKey(long reviewId);

	/**
	 * Returns all the book reviews.
	 *
	 * @return the book reviews
	 */
	public java.util.List<BookReview> findAll();

	/**
	 * Returns a range of all the book reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @return the range of book reviews
	 */
	public java.util.List<BookReview> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the book reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of book reviews
	 */
	public java.util.List<BookReview> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator);

	/**
	 * Returns an ordered range of all the book reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of book reviews
	 */
	public java.util.List<BookReview> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<BookReview>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the book reviews from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of book reviews.
	 *
	 * @return the number of book reviews
	 */
	public int countAll();

}