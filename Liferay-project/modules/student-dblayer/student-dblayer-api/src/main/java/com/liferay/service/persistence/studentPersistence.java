/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service.persistence;

import com.liferay.exception.NoSuchstudentException;
import com.liferay.model.student;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see studentUtil
 * @generated
 */
@ProviderType
public interface studentPersistence extends BasePersistence<student> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link studentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the students where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching students
	 */
	public java.util.List<student> findByUuid(String uuid);

	/**
	 * Returns a range of all the students where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 */
	public java.util.List<student> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the students where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 */
	public java.util.List<student> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator);

	/**
	 * Returns an ordered range of all the students where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching students
	 */
	public java.util.List<student> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchstudentException if a matching student could not be found
	 */
	public student findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<student>
				orderByComparator)
		throws NoSuchstudentException;

	/**
	 * Returns the first student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	public student fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator);

	/**
	 * Returns the last student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchstudentException if a matching student could not be found
	 */
	public student findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<student>
				orderByComparator)
		throws NoSuchstudentException;

	/**
	 * Returns the last student in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	public student fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator);

	/**
	 * Returns the students before and after the current student in the ordered set where uuid = &#63;.
	 *
	 * @param studentId the primary key of the current student
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws NoSuchstudentException if a student with the primary key could not be found
	 */
	public student[] findByUuid_PrevAndNext(
			long studentId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<student>
				orderByComparator)
		throws NoSuchstudentException;

	/**
	 * Removes all the students where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of students where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching students
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the student where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchstudentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student
	 * @throws NoSuchstudentException if a matching student could not be found
	 */
	public student findByUUID_G(String uuid, long groupId)
		throws NoSuchstudentException;

	/**
	 * Returns the student where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching student, or <code>null</code> if a matching student could not be found
	 */
	public student fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the student where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching student, or <code>null</code> if a matching student could not be found
	 */
	public student fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the student where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the student that was removed
	 */
	public student removeByUUID_G(String uuid, long groupId)
		throws NoSuchstudentException;

	/**
	 * Returns the number of students where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching students
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching students
	 */
	public java.util.List<student> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of matching students
	 */
	public java.util.List<student> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching students
	 */
	public java.util.List<student> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator);

	/**
	 * Returns an ordered range of all the students where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching students
	 */
	public java.util.List<student> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student
	 * @throws NoSuchstudentException if a matching student could not be found
	 */
	public student findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<student>
				orderByComparator)
		throws NoSuchstudentException;

	/**
	 * Returns the first student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 */
	public student fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator);

	/**
	 * Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student
	 * @throws NoSuchstudentException if a matching student could not be found
	 */
	public student findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<student>
				orderByComparator)
		throws NoSuchstudentException;

	/**
	 * Returns the last student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 */
	public student fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator);

	/**
	 * Returns the students before and after the current student in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param studentId the primary key of the current student
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next student
	 * @throws NoSuchstudentException if a student with the primary key could not be found
	 */
	public student[] findByUuid_C_PrevAndNext(
			long studentId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<student>
				orderByComparator)
		throws NoSuchstudentException;

	/**
	 * Removes all the students where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of students where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching students
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	public void cacheResult(student student);

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	public void cacheResult(java.util.List<student> students);

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	public student create(long studentId);

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws NoSuchstudentException if a student with the primary key could not be found
	 */
	public student remove(long studentId) throws NoSuchstudentException;

	public student updateImpl(student student);

	/**
	 * Returns the student with the primary key or throws a <code>NoSuchstudentException</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws NoSuchstudentException if a student with the primary key could not be found
	 */
	public student findByPrimaryKey(long studentId)
		throws NoSuchstudentException;

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 */
	public student fetchByPrimaryKey(long studentId);

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 */
	public java.util.List<student> findAll();

	/**
	 * Returns a range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @return the range of students
	 */
	public java.util.List<student> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of students
	 */
	public java.util.List<student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator);

	/**
	 * Returns an ordered range of all the students.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>studentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of students
	 * @param end the upper bound of the range of students (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of students
	 */
	public java.util.List<student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<student>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the students from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 */
	public int countAll();

}