/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service.persistence;

import com.liferay.exception.NoSuchcustomer_tableException;
import com.liferay.model.customer_table;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the customer_table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see customer_tableUtil
 * @generated
 */
@ProviderType
public interface customer_tablePersistence
	extends BasePersistence<customer_table> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link customer_tableUtil} to access the customer_table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the customer_tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid(String uuid);

	/**
	 * Returns a range of all the customer_tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @return the range of matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid(
		String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the customer_tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator);

	/**
	 * Returns an ordered range of all the customer_tables where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	public customer_table findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<customer_table>
				orderByComparator)
		throws NoSuchcustomer_tableException;

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	public customer_table fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator);

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	public customer_table findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<customer_table>
				orderByComparator)
		throws NoSuchcustomer_tableException;

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	public customer_table fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator);

	/**
	 * Returns the customer_tables before and after the current customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param custId the primary key of the current customer_table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer_table
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	public customer_table[] findByUuid_PrevAndNext(
			long custId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<customer_table>
				orderByComparator)
		throws NoSuchcustomer_tableException;

	/**
	 * Removes all the customer_tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of customer_tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching customer_tables
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the customer_table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchcustomer_tableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	public customer_table findByUUID_G(String uuid, long groupId)
		throws NoSuchcustomer_tableException;

	/**
	 * Returns the customer_table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	public customer_table fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the customer_table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	public customer_table fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the customer_table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the customer_table that was removed
	 */
	public customer_table removeByUUID_G(String uuid, long groupId)
		throws NoSuchcustomer_tableException;

	/**
	 * Returns the number of customer_tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching customer_tables
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the customer_tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid_C(
		String uuid, long companyId);

	/**
	 * Returns a range of all the customer_tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @return the range of matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the customer_tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator);

	/**
	 * Returns an ordered range of all the customer_tables where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer_tables
	 */
	public java.util.List<customer_table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	public customer_table findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<customer_table>
				orderByComparator)
		throws NoSuchcustomer_tableException;

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	public customer_table fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator);

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	public customer_table findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<customer_table>
				orderByComparator)
		throws NoSuchcustomer_tableException;

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	public customer_table fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator);

	/**
	 * Returns the customer_tables before and after the current customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param custId the primary key of the current customer_table
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer_table
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	public customer_table[] findByUuid_C_PrevAndNext(
			long custId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<customer_table>
				orderByComparator)
		throws NoSuchcustomer_tableException;

	/**
	 * Removes all the customer_tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of customer_tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching customer_tables
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the customer_table in the entity cache if it is enabled.
	 *
	 * @param customer_table the customer_table
	 */
	public void cacheResult(customer_table customer_table);

	/**
	 * Caches the customer_tables in the entity cache if it is enabled.
	 *
	 * @param customer_tables the customer_tables
	 */
	public void cacheResult(java.util.List<customer_table> customer_tables);

	/**
	 * Creates a new customer_table with the primary key. Does not add the customer_table to the database.
	 *
	 * @param custId the primary key for the new customer_table
	 * @return the new customer_table
	 */
	public customer_table create(long custId);

	/**
	 * Removes the customer_table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table that was removed
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	public customer_table remove(long custId)
		throws NoSuchcustomer_tableException;

	public customer_table updateImpl(customer_table customer_table);

	/**
	 * Returns the customer_table with the primary key or throws a <code>NoSuchcustomer_tableException</code> if it could not be found.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	public customer_table findByPrimaryKey(long custId)
		throws NoSuchcustomer_tableException;

	/**
	 * Returns the customer_table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table, or <code>null</code> if a customer_table with the primary key could not be found
	 */
	public customer_table fetchByPrimaryKey(long custId);

	/**
	 * Returns all the customer_tables.
	 *
	 * @return the customer_tables
	 */
	public java.util.List<customer_table> findAll();

	/**
	 * Returns a range of all the customer_tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @return the range of customer_tables
	 */
	public java.util.List<customer_table> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the customer_tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer_tables
	 */
	public java.util.List<customer_table> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator);

	/**
	 * Returns an ordered range of all the customer_tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>customer_tableModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer_tables
	 * @param end the upper bound of the range of customer_tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customer_tables
	 */
	public java.util.List<customer_table> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<customer_table>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the customer_tables from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of customer_tables.
	 *
	 * @return the number of customer_tables
	 */
	public int countAll();

}