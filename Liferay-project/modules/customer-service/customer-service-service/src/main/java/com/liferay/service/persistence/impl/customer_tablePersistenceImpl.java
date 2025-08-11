/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service.persistence.impl;

import com.liferay.exception.NoSuchcustomer_tableException;
import com.liferay.model.customer_table;
import com.liferay.model.customer_tableTable;
import com.liferay.model.impl.customer_tableImpl;
import com.liferay.model.impl.customer_tableModelImpl;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.service.persistence.customer_tablePersistence;
import com.liferay.service.persistence.customer_tableUtil;
import com.liferay.service.persistence.impl.constants.FOOPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the customer_table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = customer_tablePersistence.class)
public class customer_tablePersistenceImpl
	extends BasePersistenceImpl<customer_table>
	implements customer_tablePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>customer_tableUtil</code> to access the customer_table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		customer_tableImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the customer_tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching customer_tables
	 */
	@Override
	public List<customer_table> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<customer_table> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<customer_table> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<customer_table> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<customer_table> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<customer_table> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<customer_table> list = null;

		if (useFinderCache) {
			list = (List<customer_table>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (customer_table customer_table : list) {
					if (!uuid.equals(customer_table.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CUSTOMER_TABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(customer_tableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<customer_table>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	@Override
	public customer_table findByUuid_First(
			String uuid, OrderByComparator<customer_table> orderByComparator)
		throws NoSuchcustomer_tableException {

		customer_table customer_table = fetchByUuid_First(
			uuid, orderByComparator);

		if (customer_table != null) {
			return customer_table;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchcustomer_tableException(sb.toString());
	}

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	@Override
	public customer_table fetchByUuid_First(
		String uuid, OrderByComparator<customer_table> orderByComparator) {

		List<customer_table> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	@Override
	public customer_table findByUuid_Last(
			String uuid, OrderByComparator<customer_table> orderByComparator)
		throws NoSuchcustomer_tableException {

		customer_table customer_table = fetchByUuid_Last(
			uuid, orderByComparator);

		if (customer_table != null) {
			return customer_table;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchcustomer_tableException(sb.toString());
	}

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	@Override
	public customer_table fetchByUuid_Last(
		String uuid, OrderByComparator<customer_table> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<customer_table> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the customer_tables before and after the current customer_table in the ordered set where uuid = &#63;.
	 *
	 * @param custId the primary key of the current customer_table
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer_table
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	@Override
	public customer_table[] findByUuid_PrevAndNext(
			long custId, String uuid,
			OrderByComparator<customer_table> orderByComparator)
		throws NoSuchcustomer_tableException {

		uuid = Objects.toString(uuid, "");

		customer_table customer_table = findByPrimaryKey(custId);

		Session session = null;

		try {
			session = openSession();

			customer_table[] array = new customer_tableImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, customer_table, uuid, orderByComparator, true);

			array[1] = customer_table;

			array[2] = getByUuid_PrevAndNext(
				session, customer_table, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected customer_table getByUuid_PrevAndNext(
		Session session, customer_table customer_table, String uuid,
		OrderByComparator<customer_table> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CUSTOMER_TABLE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(customer_tableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customer_table)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<customer_table> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customer_tables where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (customer_table customer_table :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customer_table);
		}
	}

	/**
	 * Returns the number of customer_tables where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching customer_tables
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMER_TABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"customer_table.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(customer_table.uuid IS NULL OR customer_table.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the customer_table where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchcustomer_tableException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	@Override
	public customer_table findByUUID_G(String uuid, long groupId)
		throws NoSuchcustomer_tableException {

		customer_table customer_table = fetchByUUID_G(uuid, groupId);

		if (customer_table == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchcustomer_tableException(sb.toString());
		}

		return customer_table;
	}

	/**
	 * Returns the customer_table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	@Override
	public customer_table fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the customer_table where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	@Override
	public customer_table fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof customer_table) {
			customer_table customer_table = (customer_table)result;

			if (!Objects.equals(uuid, customer_table.getUuid()) ||
				(groupId != customer_table.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CUSTOMER_TABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<customer_table> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					customer_table customer_table = list.get(0);

					result = customer_table;

					cacheResult(customer_table);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (customer_table)result;
		}
	}

	/**
	 * Removes the customer_table where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the customer_table that was removed
	 */
	@Override
	public customer_table removeByUUID_G(String uuid, long groupId)
		throws NoSuchcustomer_tableException {

		customer_table customer_table = findByUUID_G(uuid, groupId);

		return remove(customer_table);
	}

	/**
	 * Returns the number of customer_tables where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching customer_tables
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		customer_table customer_table = fetchByUUID_G(uuid, groupId);

		if (customer_table == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"customer_table.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(customer_table.uuid IS NULL OR customer_table.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"customer_table.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the customer_tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching customer_tables
	 */
	@Override
	public List<customer_table> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<customer_table> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<customer_table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<customer_table> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<customer_table> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<customer_table> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<customer_table> list = null;

		if (useFinderCache) {
			list = (List<customer_table>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (customer_table customer_table : list) {
					if (!uuid.equals(customer_table.getUuid()) ||
						(companyId != customer_table.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CUSTOMER_TABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(customer_tableModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<customer_table>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	@Override
	public customer_table findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<customer_table> orderByComparator)
		throws NoSuchcustomer_tableException {

		customer_table customer_table = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (customer_table != null) {
			return customer_table;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchcustomer_tableException(sb.toString());
	}

	/**
	 * Returns the first customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	@Override
	public customer_table fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<customer_table> orderByComparator) {

		List<customer_table> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table
	 * @throws NoSuchcustomer_tableException if a matching customer_table could not be found
	 */
	@Override
	public customer_table findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<customer_table> orderByComparator)
		throws NoSuchcustomer_tableException {

		customer_table customer_table = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (customer_table != null) {
			return customer_table;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchcustomer_tableException(sb.toString());
	}

	/**
	 * Returns the last customer_table in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer_table, or <code>null</code> if a matching customer_table could not be found
	 */
	@Override
	public customer_table fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<customer_table> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<customer_table> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public customer_table[] findByUuid_C_PrevAndNext(
			long custId, String uuid, long companyId,
			OrderByComparator<customer_table> orderByComparator)
		throws NoSuchcustomer_tableException {

		uuid = Objects.toString(uuid, "");

		customer_table customer_table = findByPrimaryKey(custId);

		Session session = null;

		try {
			session = openSession();

			customer_table[] array = new customer_tableImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, customer_table, uuid, companyId, orderByComparator,
				true);

			array[1] = customer_table;

			array[2] = getByUuid_C_PrevAndNext(
				session, customer_table, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected customer_table getByUuid_C_PrevAndNext(
		Session session, customer_table customer_table, String uuid,
		long companyId, OrderByComparator<customer_table> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CUSTOMER_TABLE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(customer_tableModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						customer_table)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<customer_table> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customer_tables where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (customer_table customer_table :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(customer_table);
		}
	}

	/**
	 * Returns the number of customer_tables where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching customer_tables
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMER_TABLE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"customer_table.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(customer_table.uuid IS NULL OR customer_table.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"customer_table.companyId = ?";

	public customer_tablePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(customer_table.class);

		setModelImplClass(customer_tableImpl.class);
		setModelPKClass(long.class);

		setTable(customer_tableTable.INSTANCE);
	}

	/**
	 * Caches the customer_table in the entity cache if it is enabled.
	 *
	 * @param customer_table the customer_table
	 */
	@Override
	public void cacheResult(customer_table customer_table) {
		entityCache.putResult(
			customer_tableImpl.class, customer_table.getPrimaryKey(),
			customer_table);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				customer_table.getUuid(), customer_table.getGroupId()
			},
			customer_table);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the customer_tables in the entity cache if it is enabled.
	 *
	 * @param customer_tables the customer_tables
	 */
	@Override
	public void cacheResult(List<customer_table> customer_tables) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (customer_tables.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (customer_table customer_table : customer_tables) {
			if (entityCache.getResult(
					customer_tableImpl.class, customer_table.getPrimaryKey()) ==
						null) {

				cacheResult(customer_table);
			}
		}
	}

	/**
	 * Clears the cache for all customer_tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(customer_tableImpl.class);

		finderCache.clearCache(customer_tableImpl.class);
	}

	/**
	 * Clears the cache for the customer_table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(customer_table customer_table) {
		entityCache.removeResult(customer_tableImpl.class, customer_table);
	}

	@Override
	public void clearCache(List<customer_table> customer_tables) {
		for (customer_table customer_table : customer_tables) {
			entityCache.removeResult(customer_tableImpl.class, customer_table);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(customer_tableImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(customer_tableImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		customer_tableModelImpl customer_tableModelImpl) {

		Object[] args = new Object[] {
			customer_tableModelImpl.getUuid(),
			customer_tableModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, customer_tableModelImpl);
	}

	/**
	 * Creates a new customer_table with the primary key. Does not add the customer_table to the database.
	 *
	 * @param custId the primary key for the new customer_table
	 * @return the new customer_table
	 */
	@Override
	public customer_table create(long custId) {
		customer_table customer_table = new customer_tableImpl();

		customer_table.setNew(true);
		customer_table.setPrimaryKey(custId);

		String uuid = PortalUUIDUtil.generate();

		customer_table.setUuid(uuid);

		customer_table.setCompanyId(CompanyThreadLocal.getCompanyId());

		return customer_table;
	}

	/**
	 * Removes the customer_table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table that was removed
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	@Override
	public customer_table remove(long custId)
		throws NoSuchcustomer_tableException {

		return remove((Serializable)custId);
	}

	/**
	 * Removes the customer_table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer_table
	 * @return the customer_table that was removed
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	@Override
	public customer_table remove(Serializable primaryKey)
		throws NoSuchcustomer_tableException {

		Session session = null;

		try {
			session = openSession();

			customer_table customer_table = (customer_table)session.get(
				customer_tableImpl.class, primaryKey);

			if (customer_table == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchcustomer_tableException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customer_table);
		}
		catch (NoSuchcustomer_tableException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected customer_table removeImpl(customer_table customer_table) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customer_table)) {
				customer_table = (customer_table)session.get(
					customer_tableImpl.class,
					customer_table.getPrimaryKeyObj());
			}

			if (customer_table != null) {
				session.delete(customer_table);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customer_table != null) {
			clearCache(customer_table);
		}

		return customer_table;
	}

	@Override
	public customer_table updateImpl(customer_table customer_table) {
		boolean isNew = customer_table.isNew();

		if (!(customer_table instanceof customer_tableModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customer_table.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					customer_table);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customer_table proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom customer_table implementation " +
					customer_table.getClass());
		}

		customer_tableModelImpl customer_tableModelImpl =
			(customer_tableModelImpl)customer_table;

		if (Validator.isNull(customer_table.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			customer_table.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (customer_table.getCreateDate() == null)) {
			if (serviceContext == null) {
				customer_table.setCreateDate(date);
			}
			else {
				customer_table.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!customer_tableModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				customer_table.setModifiedDate(date);
			}
			else {
				customer_table.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customer_table);
			}
			else {
				customer_table = (customer_table)session.merge(customer_table);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			customer_tableImpl.class, customer_tableModelImpl, false, true);

		cacheUniqueFindersCache(customer_tableModelImpl);

		if (isNew) {
			customer_table.setNew(false);
		}

		customer_table.resetOriginalValues();

		return customer_table;
	}

	/**
	 * Returns the customer_table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer_table
	 * @return the customer_table
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	@Override
	public customer_table findByPrimaryKey(Serializable primaryKey)
		throws NoSuchcustomer_tableException {

		customer_table customer_table = fetchByPrimaryKey(primaryKey);

		if (customer_table == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchcustomer_tableException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customer_table;
	}

	/**
	 * Returns the customer_table with the primary key or throws a <code>NoSuchcustomer_tableException</code> if it could not be found.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table
	 * @throws NoSuchcustomer_tableException if a customer_table with the primary key could not be found
	 */
	@Override
	public customer_table findByPrimaryKey(long custId)
		throws NoSuchcustomer_tableException {

		return findByPrimaryKey((Serializable)custId);
	}

	/**
	 * Returns the customer_table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param custId the primary key of the customer_table
	 * @return the customer_table, or <code>null</code> if a customer_table with the primary key could not be found
	 */
	@Override
	public customer_table fetchByPrimaryKey(long custId) {
		return fetchByPrimaryKey((Serializable)custId);
	}

	/**
	 * Returns all the customer_tables.
	 *
	 * @return the customer_tables
	 */
	@Override
	public List<customer_table> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<customer_table> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<customer_table> findAll(
		int start, int end,
		OrderByComparator<customer_table> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<customer_table> findAll(
		int start, int end, OrderByComparator<customer_table> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<customer_table> list = null;

		if (useFinderCache) {
			list = (List<customer_table>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMER_TABLE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMER_TABLE;

				sql = sql.concat(customer_tableModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<customer_table>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the customer_tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (customer_table customer_table : findAll()) {
			remove(customer_table);
		}
	}

	/**
	 * Returns the number of customer_tables.
	 *
	 * @return the number of customer_tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMER_TABLE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "custId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMER_TABLE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return customer_tableModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the customer_table persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		customer_tableUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		customer_tableUtil.setPersistence(null);

		entityCache.removeCache(customer_tableImpl.class.getName());
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = FOOPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CUSTOMER_TABLE =
		"SELECT customer_table FROM customer_table customer_table";

	private static final String _SQL_SELECT_CUSTOMER_TABLE_WHERE =
		"SELECT customer_table FROM customer_table customer_table WHERE ";

	private static final String _SQL_COUNT_CUSTOMER_TABLE =
		"SELECT COUNT(customer_table) FROM customer_table customer_table";

	private static final String _SQL_COUNT_CUSTOMER_TABLE_WHERE =
		"SELECT COUNT(customer_table) FROM customer_table customer_table WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customer_table.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No customer_table exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No customer_table exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		customer_tablePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}