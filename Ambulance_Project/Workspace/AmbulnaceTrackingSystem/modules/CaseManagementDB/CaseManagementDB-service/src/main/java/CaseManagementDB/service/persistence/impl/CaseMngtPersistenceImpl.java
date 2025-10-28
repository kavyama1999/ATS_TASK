/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service.persistence.impl;

import CaseManagementDB.exception.NoSuchMngtException;

import CaseManagementDB.model.CaseMngt;
import CaseManagementDB.model.CaseMngtTable;
import CaseManagementDB.model.impl.CaseMngtImpl;
import CaseManagementDB.model.impl.CaseMngtModelImpl;

import CaseManagementDB.service.persistence.CaseMngtPersistence;
import CaseManagementDB.service.persistence.CaseMngtUtil;
import CaseManagementDB.service.persistence.impl.constants.CasePersistenceConstants;

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
 * The persistence implementation for the case mngt service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CaseMngtPersistence.class)
public class CaseMngtPersistenceImpl
	extends BasePersistenceImpl<CaseMngt> implements CaseMngtPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CaseMngtUtil</code> to access the case mngt persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CaseMngtImpl.class.getName();

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
	 * Returns all the case mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching case mngts
	 */
	@Override
	public List<CaseMngt> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CaseMngt> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<CaseMngt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<CaseMngt> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator, boolean useFinderCache) {

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

		List<CaseMngt> list = null;

		if (useFinderCache) {
			list = (List<CaseMngt>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseMngt caseMngt : list) {
					if (!uuid.equals(caseMngt.getUuid())) {
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

			sb.append(_SQL_SELECT_CASEMNGT_WHERE);

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
				sb.append(CaseMngtModelImpl.ORDER_BY_JPQL);
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

				list = (List<CaseMngt>)QueryUtil.list(
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
	 * Returns the first case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt findByUuid_First(
			String uuid, OrderByComparator<CaseMngt> orderByComparator)
		throws NoSuchMngtException {

		CaseMngt caseMngt = fetchByUuid_First(uuid, orderByComparator);

		if (caseMngt != null) {
			return caseMngt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMngtException(sb.toString());
	}

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt fetchByUuid_First(
		String uuid, OrderByComparator<CaseMngt> orderByComparator) {

		List<CaseMngt> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt findByUuid_Last(
			String uuid, OrderByComparator<CaseMngt> orderByComparator)
		throws NoSuchMngtException {

		CaseMngt caseMngt = fetchByUuid_Last(uuid, orderByComparator);

		if (caseMngt != null) {
			return caseMngt;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMngtException(sb.toString());
	}

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt fetchByUuid_Last(
		String uuid, OrderByComparator<CaseMngt> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<CaseMngt> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CaseMngt[] findByUuid_PrevAndNext(
			long caseId, String uuid,
			OrderByComparator<CaseMngt> orderByComparator)
		throws NoSuchMngtException {

		uuid = Objects.toString(uuid, "");

		CaseMngt caseMngt = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			CaseMngt[] array = new CaseMngtImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, caseMngt, uuid, orderByComparator, true);

			array[1] = caseMngt;

			array[2] = getByUuid_PrevAndNext(
				session, caseMngt, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseMngt getByUuid_PrevAndNext(
		Session session, CaseMngt caseMngt, String uuid,
		OrderByComparator<CaseMngt> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CASEMNGT_WHERE);

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
			sb.append(CaseMngtModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(caseMngt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseMngt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case mngts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (CaseMngt caseMngt :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(caseMngt);
		}
	}

	/**
	 * Returns the number of case mngts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching case mngts
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CASEMNGT_WHERE);

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
		"caseMngt.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(caseMngt.uuid IS NULL OR caseMngt.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt findByUUID_G(String uuid, long groupId)
		throws NoSuchMngtException {

		CaseMngt caseMngt = fetchByUUID_G(uuid, groupId);

		if (caseMngt == null) {
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

			throw new NoSuchMngtException(sb.toString());
		}

		return caseMngt;
	}

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the case mngt where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt fetchByUUID_G(
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

		if (result instanceof CaseMngt) {
			CaseMngt caseMngt = (CaseMngt)result;

			if (!Objects.equals(uuid, caseMngt.getUuid()) ||
				(groupId != caseMngt.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CASEMNGT_WHERE);

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

				List<CaseMngt> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					CaseMngt caseMngt = list.get(0);

					result = caseMngt;

					cacheResult(caseMngt);
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
			return (CaseMngt)result;
		}
	}

	/**
	 * Removes the case mngt where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the case mngt that was removed
	 */
	@Override
	public CaseMngt removeByUUID_G(String uuid, long groupId)
		throws NoSuchMngtException {

		CaseMngt caseMngt = findByUUID_G(uuid, groupId);

		return remove(caseMngt);
	}

	/**
	 * Returns the number of case mngts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching case mngts
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		CaseMngt caseMngt = fetchByUUID_G(uuid, groupId);

		if (caseMngt == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"caseMngt.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(caseMngt.uuid IS NULL OR caseMngt.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"caseMngt.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching case mngts
	 */
	@Override
	public List<CaseMngt> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<CaseMngt> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<CaseMngt> orderByComparator, boolean useFinderCache) {

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

		List<CaseMngt> list = null;

		if (useFinderCache) {
			list = (List<CaseMngt>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CaseMngt caseMngt : list) {
					if (!uuid.equals(caseMngt.getUuid()) ||
						(companyId != caseMngt.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CASEMNGT_WHERE);

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
				sb.append(CaseMngtModelImpl.ORDER_BY_JPQL);
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

				list = (List<CaseMngt>)QueryUtil.list(
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
	 * Returns the first case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt
	 * @throws NoSuchMngtException if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<CaseMngt> orderByComparator)
		throws NoSuchMngtException {

		CaseMngt caseMngt = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (caseMngt != null) {
			return caseMngt;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMngtException(sb.toString());
	}

	/**
	 * Returns the first case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<CaseMngt> orderByComparator) {

		List<CaseMngt> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CaseMngt findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<CaseMngt> orderByComparator)
		throws NoSuchMngtException {

		CaseMngt caseMngt = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (caseMngt != null) {
			return caseMngt;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMngtException(sb.toString());
	}

	/**
	 * Returns the last case mngt in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching case mngt, or <code>null</code> if a matching case mngt could not be found
	 */
	@Override
	public CaseMngt fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<CaseMngt> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<CaseMngt> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public CaseMngt[] findByUuid_C_PrevAndNext(
			long caseId, String uuid, long companyId,
			OrderByComparator<CaseMngt> orderByComparator)
		throws NoSuchMngtException {

		uuid = Objects.toString(uuid, "");

		CaseMngt caseMngt = findByPrimaryKey(caseId);

		Session session = null;

		try {
			session = openSession();

			CaseMngt[] array = new CaseMngtImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, caseMngt, uuid, companyId, orderByComparator, true);

			array[1] = caseMngt;

			array[2] = getByUuid_C_PrevAndNext(
				session, caseMngt, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CaseMngt getByUuid_C_PrevAndNext(
		Session session, CaseMngt caseMngt, String uuid, long companyId,
		OrderByComparator<CaseMngt> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CASEMNGT_WHERE);

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
			sb.append(CaseMngtModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(caseMngt)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CaseMngt> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the case mngts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (CaseMngt caseMngt :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(caseMngt);
		}
	}

	/**
	 * Returns the number of case mngts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching case mngts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CASEMNGT_WHERE);

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
		"caseMngt.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(caseMngt.uuid IS NULL OR caseMngt.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"caseMngt.companyId = ?";

	public CaseMngtPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(CaseMngt.class);

		setModelImplClass(CaseMngtImpl.class);
		setModelPKClass(long.class);

		setTable(CaseMngtTable.INSTANCE);
	}

	/**
	 * Caches the case mngt in the entity cache if it is enabled.
	 *
	 * @param caseMngt the case mngt
	 */
	@Override
	public void cacheResult(CaseMngt caseMngt) {
		entityCache.putResult(
			CaseMngtImpl.class, caseMngt.getPrimaryKey(), caseMngt);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {caseMngt.getUuid(), caseMngt.getGroupId()}, caseMngt);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the case mngts in the entity cache if it is enabled.
	 *
	 * @param caseMngts the case mngts
	 */
	@Override
	public void cacheResult(List<CaseMngt> caseMngts) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (caseMngts.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (CaseMngt caseMngt : caseMngts) {
			if (entityCache.getResult(
					CaseMngtImpl.class, caseMngt.getPrimaryKey()) == null) {

				cacheResult(caseMngt);
			}
		}
	}

	/**
	 * Clears the cache for all case mngts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CaseMngtImpl.class);

		finderCache.clearCache(CaseMngtImpl.class);
	}

	/**
	 * Clears the cache for the case mngt.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CaseMngt caseMngt) {
		entityCache.removeResult(CaseMngtImpl.class, caseMngt);
	}

	@Override
	public void clearCache(List<CaseMngt> caseMngts) {
		for (CaseMngt caseMngt : caseMngts) {
			entityCache.removeResult(CaseMngtImpl.class, caseMngt);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(CaseMngtImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CaseMngtImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CaseMngtModelImpl caseMngtModelImpl) {

		Object[] args = new Object[] {
			caseMngtModelImpl.getUuid(), caseMngtModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, caseMngtModelImpl);
	}

	/**
	 * Creates a new case mngt with the primary key. Does not add the case mngt to the database.
	 *
	 * @param caseId the primary key for the new case mngt
	 * @return the new case mngt
	 */
	@Override
	public CaseMngt create(long caseId) {
		CaseMngt caseMngt = new CaseMngtImpl();

		caseMngt.setNew(true);
		caseMngt.setPrimaryKey(caseId);

		String uuid = PortalUUIDUtil.generate();

		caseMngt.setUuid(uuid);

		caseMngt.setCompanyId(CompanyThreadLocal.getCompanyId());

		return caseMngt;
	}

	/**
	 * Removes the case mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt that was removed
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	@Override
	public CaseMngt remove(long caseId) throws NoSuchMngtException {
		return remove((Serializable)caseId);
	}

	/**
	 * Removes the case mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the case mngt
	 * @return the case mngt that was removed
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	@Override
	public CaseMngt remove(Serializable primaryKey) throws NoSuchMngtException {
		Session session = null;

		try {
			session = openSession();

			CaseMngt caseMngt = (CaseMngt)session.get(
				CaseMngtImpl.class, primaryKey);

			if (caseMngt == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMngtException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(caseMngt);
		}
		catch (NoSuchMngtException noSuchEntityException) {
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
	protected CaseMngt removeImpl(CaseMngt caseMngt) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(caseMngt)) {
				caseMngt = (CaseMngt)session.get(
					CaseMngtImpl.class, caseMngt.getPrimaryKeyObj());
			}

			if (caseMngt != null) {
				session.delete(caseMngt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (caseMngt != null) {
			clearCache(caseMngt);
		}

		return caseMngt;
	}

	@Override
	public CaseMngt updateImpl(CaseMngt caseMngt) {
		boolean isNew = caseMngt.isNew();

		if (!(caseMngt instanceof CaseMngtModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(caseMngt.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(caseMngt);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in caseMngt proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CaseMngt implementation " +
					caseMngt.getClass());
		}

		CaseMngtModelImpl caseMngtModelImpl = (CaseMngtModelImpl)caseMngt;

		if (Validator.isNull(caseMngt.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			caseMngt.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (caseMngt.getCreateDate() == null)) {
			if (serviceContext == null) {
				caseMngt.setCreateDate(date);
			}
			else {
				caseMngt.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!caseMngtModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				caseMngt.setModifiedDate(date);
			}
			else {
				caseMngt.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(caseMngt);
			}
			else {
				caseMngt = (CaseMngt)session.merge(caseMngt);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CaseMngtImpl.class, caseMngtModelImpl, false, true);

		cacheUniqueFindersCache(caseMngtModelImpl);

		if (isNew) {
			caseMngt.setNew(false);
		}

		caseMngt.resetOriginalValues();

		return caseMngt;
	}

	/**
	 * Returns the case mngt with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the case mngt
	 * @return the case mngt
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	@Override
	public CaseMngt findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMngtException {

		CaseMngt caseMngt = fetchByPrimaryKey(primaryKey);

		if (caseMngt == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMngtException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return caseMngt;
	}

	/**
	 * Returns the case mngt with the primary key or throws a <code>NoSuchMngtException</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt
	 * @throws NoSuchMngtException if a case mngt with the primary key could not be found
	 */
	@Override
	public CaseMngt findByPrimaryKey(long caseId) throws NoSuchMngtException {
		return findByPrimaryKey((Serializable)caseId);
	}

	/**
	 * Returns the case mngt with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param caseId the primary key of the case mngt
	 * @return the case mngt, or <code>null</code> if a case mngt with the primary key could not be found
	 */
	@Override
	public CaseMngt fetchByPrimaryKey(long caseId) {
		return fetchByPrimaryKey((Serializable)caseId);
	}

	/**
	 * Returns all the case mngts.
	 *
	 * @return the case mngts
	 */
	@Override
	public List<CaseMngt> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<CaseMngt> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<CaseMngt> findAll(
		int start, int end, OrderByComparator<CaseMngt> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<CaseMngt> findAll(
		int start, int end, OrderByComparator<CaseMngt> orderByComparator,
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

		List<CaseMngt> list = null;

		if (useFinderCache) {
			list = (List<CaseMngt>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CASEMNGT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CASEMNGT;

				sql = sql.concat(CaseMngtModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CaseMngt>)QueryUtil.list(
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
	 * Removes all the case mngts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CaseMngt caseMngt : findAll()) {
			remove(caseMngt);
		}
	}

	/**
	 * Returns the number of case mngts.
	 *
	 * @return the number of case mngts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CASEMNGT);

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
		return "caseId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CASEMNGT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CaseMngtModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the case mngt persistence.
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

		CaseMngtUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		CaseMngtUtil.setPersistence(null);

		entityCache.removeCache(CaseMngtImpl.class.getName());
	}

	@Override
	@Reference(
		target = CasePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CasePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CasePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CASEMNGT =
		"SELECT caseMngt FROM CaseMngt caseMngt";

	private static final String _SQL_SELECT_CASEMNGT_WHERE =
		"SELECT caseMngt FROM CaseMngt caseMngt WHERE ";

	private static final String _SQL_COUNT_CASEMNGT =
		"SELECT COUNT(caseMngt) FROM CaseMngt caseMngt";

	private static final String _SQL_COUNT_CASEMNGT_WHERE =
		"SELECT COUNT(caseMngt) FROM CaseMngt caseMngt WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "caseMngt.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CaseMngt exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CaseMngt exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CaseMngtPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}