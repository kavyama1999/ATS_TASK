/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import library.db.exception.NoSuchrary_booksException;
import library.db.model.library_books;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the library_books service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see library_booksUtil
 * @generated
 */
@ProviderType
public interface library_booksPersistence
	extends BasePersistence<library_books> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link library_booksUtil} to access the library_books persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the library_bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching library_bookses
	 */
	public java.util.List<library_books> findByUuid(String uuid);

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
	public java.util.List<library_books> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<library_books> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

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
	public java.util.List<library_books> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public library_books findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public library_books findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

	/**
	 * Returns the library_bookses before and after the current library_books in the ordered set where uuid = &#63;.
	 *
	 * @param libId the primary key of the current library_books
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library_books
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public library_books[] findByUuid_PrevAndNext(
			long libId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Removes all the library_bookses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of library_bookses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching library_bookses
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the library_books where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchrary_booksException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public library_books findByUUID_G(String uuid, long groupId)
		throws NoSuchrary_booksException;

	/**
	 * Returns the library_books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the library_books where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the library_books where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the library_books that was removed
	 */
	public library_books removeByUUID_G(String uuid, long groupId)
		throws NoSuchrary_booksException;

	/**
	 * Returns the number of library_bookses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching library_bookses
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the library_bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching library_bookses
	 */
	public java.util.List<library_books> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<library_books> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<library_books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

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
	public java.util.List<library_books> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public library_books findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Returns the first library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public library_books findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Returns the last library_books in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

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
	public library_books[] findByUuid_C_PrevAndNext(
			long libId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Removes all the library_bookses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of library_bookses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching library_bookses
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the library_bookses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching library_bookses
	 */
	public java.util.List<library_books> findByGroupId(long groupId);

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
	public java.util.List<library_books> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<library_books> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

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
	public java.util.List<library_books> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public library_books findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Returns the first library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

	/**
	 * Returns the last library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books
	 * @throws NoSuchrary_booksException if a matching library_books could not be found
	 */
	public library_books findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Returns the last library_books in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public library_books fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

	/**
	 * Returns the library_bookses before and after the current library_books in the ordered set where groupId = &#63;.
	 *
	 * @param libId the primary key of the current library_books
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library_books
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public library_books[] findByGroupId_PrevAndNext(
			long libId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<library_books>
				orderByComparator)
		throws NoSuchrary_booksException;

	/**
	 * Removes all the library_bookses where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of library_bookses where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching library_bookses
	 */
	public int countByGroupId(long groupId);

	/**
	 * Caches the library_books in the entity cache if it is enabled.
	 *
	 * @param library_books the library_books
	 */
	public void cacheResult(library_books library_books);

	/**
	 * Caches the library_bookses in the entity cache if it is enabled.
	 *
	 * @param library_bookses the library_bookses
	 */
	public void cacheResult(java.util.List<library_books> library_bookses);

	/**
	 * Creates a new library_books with the primary key. Does not add the library_books to the database.
	 *
	 * @param libId the primary key for the new library_books
	 * @return the new library_books
	 */
	public library_books create(long libId);

	/**
	 * Removes the library_books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books that was removed
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public library_books remove(long libId) throws NoSuchrary_booksException;

	public library_books updateImpl(library_books library_books);

	/**
	 * Returns the library_books with the primary key or throws a <code>NoSuchrary_booksException</code> if it could not be found.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books
	 * @throws NoSuchrary_booksException if a library_books with the primary key could not be found
	 */
	public library_books findByPrimaryKey(long libId)
		throws NoSuchrary_booksException;

	/**
	 * Returns the library_books with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books, or <code>null</code> if a library_books with the primary key could not be found
	 */
	public library_books fetchByPrimaryKey(long libId);

	/**
	 * Returns all the library_bookses.
	 *
	 * @return the library_bookses
	 */
	public java.util.List<library_books> findAll();

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
	public java.util.List<library_books> findAll(int start, int end);

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
	public java.util.List<library_books> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator);

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
	public java.util.List<library_books> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<library_books>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the library_bookses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of library_bookses.
	 *
	 * @return the number of library_bookses
	 */
	public int countAll();

}