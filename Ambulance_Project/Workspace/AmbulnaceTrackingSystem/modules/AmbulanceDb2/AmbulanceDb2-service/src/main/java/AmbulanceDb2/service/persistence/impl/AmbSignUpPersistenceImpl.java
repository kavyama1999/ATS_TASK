/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service.persistence.impl;

import AmbulanceDb2.exception.NoSuchAmbSignUpException;

import AmbulanceDb2.model.AmbSignUp;
import AmbulanceDb2.model.AmbSignUpTable;
import AmbulanceDb2.model.impl.AmbSignUpImpl;
import AmbulanceDb2.model.impl.AmbSignUpModelImpl;

import AmbulanceDb2.service.persistence.AmbSignUpPersistence;
import AmbulanceDb2.service.persistence.AmbSignUpUtil;
import AmbulanceDb2.service.persistence.impl.constants.AMBPersistenceConstants;

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
 * The persistence implementation for the amb sign up service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AmbSignUpPersistence.class)
public class AmbSignUpPersistenceImpl
	extends BasePersistenceImpl<AmbSignUp> implements AmbSignUpPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AmbSignUpUtil</code> to access the amb sign up persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AmbSignUpImpl.class.getName();

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
	 * Returns all the amb sign ups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator,
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

		List<AmbSignUp> list = null;

		if (useFinderCache) {
			list = (List<AmbSignUp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmbSignUp ambSignUp : list) {
					if (!uuid.equals(ambSignUp.getUuid())) {
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

			sb.append(_SQL_SELECT_AMBSIGNUP_WHERE);

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
				sb.append(AmbSignUpModelImpl.ORDER_BY_JPQL);
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

				list = (List<AmbSignUp>)QueryUtil.list(
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
	 * Returns the first amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp findByUuid_First(
			String uuid, OrderByComparator<AmbSignUp> orderByComparator)
		throws NoSuchAmbSignUpException {

		AmbSignUp ambSignUp = fetchByUuid_First(uuid, orderByComparator);

		if (ambSignUp != null) {
			return ambSignUp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAmbSignUpException(sb.toString());
	}

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp fetchByUuid_First(
		String uuid, OrderByComparator<AmbSignUp> orderByComparator) {

		List<AmbSignUp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp findByUuid_Last(
			String uuid, OrderByComparator<AmbSignUp> orderByComparator)
		throws NoSuchAmbSignUpException {

		AmbSignUp ambSignUp = fetchByUuid_Last(uuid, orderByComparator);

		if (ambSignUp != null) {
			return ambSignUp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAmbSignUpException(sb.toString());
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp fetchByUuid_Last(
		String uuid, OrderByComparator<AmbSignUp> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<AmbSignUp> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amb sign ups before and after the current amb sign up in the ordered set where uuid = &#63;.
	 *
	 * @param otpId the primary key of the current amb sign up
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbSignUp[] findByUuid_PrevAndNext(
			long otpId, String uuid,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws NoSuchAmbSignUpException {

		uuid = Objects.toString(uuid, "");

		AmbSignUp ambSignUp = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			AmbSignUp[] array = new AmbSignUpImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ambSignUp, uuid, orderByComparator, true);

			array[1] = ambSignUp;

			array[2] = getByUuid_PrevAndNext(
				session, ambSignUp, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmbSignUp getByUuid_PrevAndNext(
		Session session, AmbSignUp ambSignUp, String uuid,
		OrderByComparator<AmbSignUp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMBSIGNUP_WHERE);

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
			sb.append(AmbSignUpModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ambSignUp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AmbSignUp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amb sign ups where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (AmbSignUp ambSignUp :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ambSignUp);
		}
	}

	/**
	 * Returns the number of amb sign ups where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching amb sign ups
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMBSIGNUP_WHERE);

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
		"ambSignUp.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ambSignUp.uuid IS NULL OR ambSignUp.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchAmbSignUpException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp findByUUID_G(String uuid, long groupId)
		throws NoSuchAmbSignUpException {

		AmbSignUp ambSignUp = fetchByUUID_G(uuid, groupId);

		if (ambSignUp == null) {
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

			throw new NoSuchAmbSignUpException(sb.toString());
		}

		return ambSignUp;
	}

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the amb sign up where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp fetchByUUID_G(
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

		if (result instanceof AmbSignUp) {
			AmbSignUp ambSignUp = (AmbSignUp)result;

			if (!Objects.equals(uuid, ambSignUp.getUuid()) ||
				(groupId != ambSignUp.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_AMBSIGNUP_WHERE);

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

				List<AmbSignUp> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					AmbSignUp ambSignUp = list.get(0);

					result = ambSignUp;

					cacheResult(ambSignUp);
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
			return (AmbSignUp)result;
		}
	}

	/**
	 * Removes the amb sign up where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the amb sign up that was removed
	 */
	@Override
	public AmbSignUp removeByUUID_G(String uuid, long groupId)
		throws NoSuchAmbSignUpException {

		AmbSignUp ambSignUp = findByUUID_G(uuid, groupId);

		return remove(ambSignUp);
	}

	/**
	 * Returns the number of amb sign ups where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching amb sign ups
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		AmbSignUp ambSignUp = fetchByUUID_G(uuid, groupId);

		if (ambSignUp == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"ambSignUp.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(ambSignUp.uuid IS NULL OR ambSignUp.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"ambSignUp.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching amb sign ups
	 */
	@Override
	public List<AmbSignUp> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator,
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

		List<AmbSignUp> list = null;

		if (useFinderCache) {
			list = (List<AmbSignUp>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AmbSignUp ambSignUp : list) {
					if (!uuid.equals(ambSignUp.getUuid()) ||
						(companyId != ambSignUp.getCompanyId())) {

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

			sb.append(_SQL_SELECT_AMBSIGNUP_WHERE);

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
				sb.append(AmbSignUpModelImpl.ORDER_BY_JPQL);
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

				list = (List<AmbSignUp>)QueryUtil.list(
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
	 * Returns the first amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws NoSuchAmbSignUpException {

		AmbSignUp ambSignUp = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (ambSignUp != null) {
			return ambSignUp;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAmbSignUpException(sb.toString());
	}

	/**
	 * Returns the first amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<AmbSignUp> orderByComparator) {

		List<AmbSignUp> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up
	 * @throws NoSuchAmbSignUpException if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws NoSuchAmbSignUpException {

		AmbSignUp ambSignUp = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (ambSignUp != null) {
			return ambSignUp;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchAmbSignUpException(sb.toString());
	}

	/**
	 * Returns the last amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	@Override
	public AmbSignUp fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<AmbSignUp> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<AmbSignUp> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the amb sign ups before and after the current amb sign up in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param otpId the primary key of the current amb sign up
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbSignUp[] findByUuid_C_PrevAndNext(
			long otpId, String uuid, long companyId,
			OrderByComparator<AmbSignUp> orderByComparator)
		throws NoSuchAmbSignUpException {

		uuid = Objects.toString(uuid, "");

		AmbSignUp ambSignUp = findByPrimaryKey(otpId);

		Session session = null;

		try {
			session = openSession();

			AmbSignUp[] array = new AmbSignUpImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, ambSignUp, uuid, companyId, orderByComparator, true);

			array[1] = ambSignUp;

			array[2] = getByUuid_C_PrevAndNext(
				session, ambSignUp, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected AmbSignUp getByUuid_C_PrevAndNext(
		Session session, AmbSignUp ambSignUp, String uuid, long companyId,
		OrderByComparator<AmbSignUp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_AMBSIGNUP_WHERE);

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
			sb.append(AmbSignUpModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ambSignUp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<AmbSignUp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the amb sign ups where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (AmbSignUp ambSignUp :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(ambSignUp);
		}
	}

	/**
	 * Returns the number of amb sign ups where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching amb sign ups
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_AMBSIGNUP_WHERE);

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
		"ambSignUp.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(ambSignUp.uuid IS NULL OR ambSignUp.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"ambSignUp.companyId = ?";

	public AmbSignUpPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(AmbSignUp.class);

		setModelImplClass(AmbSignUpImpl.class);
		setModelPKClass(long.class);

		setTable(AmbSignUpTable.INSTANCE);
	}

	/**
	 * Caches the amb sign up in the entity cache if it is enabled.
	 *
	 * @param ambSignUp the amb sign up
	 */
	@Override
	public void cacheResult(AmbSignUp ambSignUp) {
		entityCache.putResult(
			AmbSignUpImpl.class, ambSignUp.getPrimaryKey(), ambSignUp);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {ambSignUp.getUuid(), ambSignUp.getGroupId()},
			ambSignUp);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the amb sign ups in the entity cache if it is enabled.
	 *
	 * @param ambSignUps the amb sign ups
	 */
	@Override
	public void cacheResult(List<AmbSignUp> ambSignUps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ambSignUps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (AmbSignUp ambSignUp : ambSignUps) {
			if (entityCache.getResult(
					AmbSignUpImpl.class, ambSignUp.getPrimaryKey()) == null) {

				cacheResult(ambSignUp);
			}
		}
	}

	/**
	 * Clears the cache for all amb sign ups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmbSignUpImpl.class);

		finderCache.clearCache(AmbSignUpImpl.class);
	}

	/**
	 * Clears the cache for the amb sign up.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AmbSignUp ambSignUp) {
		entityCache.removeResult(AmbSignUpImpl.class, ambSignUp);
	}

	@Override
	public void clearCache(List<AmbSignUp> ambSignUps) {
		for (AmbSignUp ambSignUp : ambSignUps) {
			entityCache.removeResult(AmbSignUpImpl.class, ambSignUp);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AmbSignUpImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AmbSignUpImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		AmbSignUpModelImpl ambSignUpModelImpl) {

		Object[] args = new Object[] {
			ambSignUpModelImpl.getUuid(), ambSignUpModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, ambSignUpModelImpl);
	}

	/**
	 * Creates a new amb sign up with the primary key. Does not add the amb sign up to the database.
	 *
	 * @param otpId the primary key for the new amb sign up
	 * @return the new amb sign up
	 */
	@Override
	public AmbSignUp create(long otpId) {
		AmbSignUp ambSignUp = new AmbSignUpImpl();

		ambSignUp.setNew(true);
		ambSignUp.setPrimaryKey(otpId);

		String uuid = PortalUUIDUtil.generate();

		ambSignUp.setUuid(uuid);

		ambSignUp.setCompanyId(CompanyThreadLocal.getCompanyId());

		return ambSignUp;
	}

	/**
	 * Removes the amb sign up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up that was removed
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbSignUp remove(long otpId) throws NoSuchAmbSignUpException {
		return remove((Serializable)otpId);
	}

	/**
	 * Removes the amb sign up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the amb sign up
	 * @return the amb sign up that was removed
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbSignUp remove(Serializable primaryKey)
		throws NoSuchAmbSignUpException {

		Session session = null;

		try {
			session = openSession();

			AmbSignUp ambSignUp = (AmbSignUp)session.get(
				AmbSignUpImpl.class, primaryKey);

			if (ambSignUp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmbSignUpException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ambSignUp);
		}
		catch (NoSuchAmbSignUpException noSuchEntityException) {
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
	protected AmbSignUp removeImpl(AmbSignUp ambSignUp) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ambSignUp)) {
				ambSignUp = (AmbSignUp)session.get(
					AmbSignUpImpl.class, ambSignUp.getPrimaryKeyObj());
			}

			if (ambSignUp != null) {
				session.delete(ambSignUp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ambSignUp != null) {
			clearCache(ambSignUp);
		}

		return ambSignUp;
	}

	@Override
	public AmbSignUp updateImpl(AmbSignUp ambSignUp) {
		boolean isNew = ambSignUp.isNew();

		if (!(ambSignUp instanceof AmbSignUpModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ambSignUp.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ambSignUp);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ambSignUp proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom AmbSignUp implementation " +
					ambSignUp.getClass());
		}

		AmbSignUpModelImpl ambSignUpModelImpl = (AmbSignUpModelImpl)ambSignUp;

		if (Validator.isNull(ambSignUp.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ambSignUp.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ambSignUp.getCreateDate() == null)) {
			if (serviceContext == null) {
				ambSignUp.setCreateDate(date);
			}
			else {
				ambSignUp.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!ambSignUpModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ambSignUp.setModifiedDate(date);
			}
			else {
				ambSignUp.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ambSignUp);
			}
			else {
				ambSignUp = (AmbSignUp)session.merge(ambSignUp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AmbSignUpImpl.class, ambSignUpModelImpl, false, true);

		cacheUniqueFindersCache(ambSignUpModelImpl);

		if (isNew) {
			ambSignUp.setNew(false);
		}

		ambSignUp.resetOriginalValues();

		return ambSignUp;
	}

	/**
	 * Returns the amb sign up with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the amb sign up
	 * @return the amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbSignUp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmbSignUpException {

		AmbSignUp ambSignUp = fetchByPrimaryKey(primaryKey);

		if (ambSignUp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmbSignUpException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ambSignUp;
	}

	/**
	 * Returns the amb sign up with the primary key or throws a <code>NoSuchAmbSignUpException</code> if it could not be found.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up
	 * @throws NoSuchAmbSignUpException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbSignUp findByPrimaryKey(long otpId)
		throws NoSuchAmbSignUpException {

		return findByPrimaryKey((Serializable)otpId);
	}

	/**
	 * Returns the amb sign up with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up, or <code>null</code> if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbSignUp fetchByPrimaryKey(long otpId) {
		return fetchByPrimaryKey((Serializable)otpId);
	}

	/**
	 * Returns all the amb sign ups.
	 *
	 * @return the amb sign ups
	 */
	@Override
	public List<AmbSignUp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of amb sign ups
	 */
	@Override
	public List<AmbSignUp> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of amb sign ups
	 */
	@Override
	public List<AmbSignUp> findAll(
		int start, int end, OrderByComparator<AmbSignUp> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of amb sign ups
	 */
	@Override
	public List<AmbSignUp> findAll(
		int start, int end, OrderByComparator<AmbSignUp> orderByComparator,
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

		List<AmbSignUp> list = null;

		if (useFinderCache) {
			list = (List<AmbSignUp>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMBSIGNUP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMBSIGNUP;

				sql = sql.concat(AmbSignUpModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<AmbSignUp>)QueryUtil.list(
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
	 * Removes all the amb sign ups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AmbSignUp ambSignUp : findAll()) {
			remove(ambSignUp);
		}
	}

	/**
	 * Returns the number of amb sign ups.
	 *
	 * @return the number of amb sign ups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMBSIGNUP);

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
		return "otpId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMBSIGNUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AmbSignUpModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the amb sign up persistence.
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

		AmbSignUpUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AmbSignUpUtil.setPersistence(null);

		entityCache.removeCache(AmbSignUpImpl.class.getName());
	}

	@Override
	@Reference(
		target = AMBPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AMBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AMBPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AMBSIGNUP =
		"SELECT ambSignUp FROM AmbSignUp ambSignUp";

	private static final String _SQL_SELECT_AMBSIGNUP_WHERE =
		"SELECT ambSignUp FROM AmbSignUp ambSignUp WHERE ";

	private static final String _SQL_COUNT_AMBSIGNUP =
		"SELECT COUNT(ambSignUp) FROM AmbSignUp ambSignUp";

	private static final String _SQL_COUNT_AMBSIGNUP_WHERE =
		"SELECT COUNT(ambSignUp) FROM AmbSignUp ambSignUp WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ambSignUp.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No AmbSignUp exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No AmbSignUp exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AmbSignUpPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}