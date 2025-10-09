/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence.impl;

import AddAmbulanceDb.exception.NoSuchAmbulanceException;

import AddAmbulanceDb.model.Ambulance;
import AddAmbulanceDb.model.AmbulanceTable;
import AddAmbulanceDb.model.impl.AmbulanceImpl;
import AddAmbulanceDb.model.impl.AmbulanceModelImpl;

import AddAmbulanceDb.service.persistence.AmbulancePersistence;
import AddAmbulanceDb.service.persistence.AmbulanceUtil;
import AddAmbulanceDb.service.persistence.impl.constants.HSPPersistenceConstants;

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
 * The persistence implementation for the ambulance service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = AmbulancePersistence.class)
public class AmbulancePersistenceImpl
	extends BasePersistenceImpl<Ambulance> implements AmbulancePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>AmbulanceUtil</code> to access the ambulance persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		AmbulanceImpl.class.getName();

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
	 * Returns all the ambulances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching ambulances
	 */
	@Override
	public List<Ambulance> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ambulances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @return the range of matching ambulances
	 */
	@Override
	public List<Ambulance> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ambulances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ambulances
	 */
	@Override
	public List<Ambulance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ambulance> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ambulances where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ambulances
	 */
	@Override
	public List<Ambulance> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Ambulance> orderByComparator,
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

		List<Ambulance> list = null;

		if (useFinderCache) {
			list = (List<Ambulance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ambulance ambulance : list) {
					if (!uuid.equals(ambulance.getUuid())) {
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

			sb.append(_SQL_SELECT_AMBULANCE_WHERE);

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
				sb.append(AmbulanceModelImpl.ORDER_BY_JPQL);
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

				list = (List<Ambulance>)QueryUtil.list(
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
	 * Returns the first ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	@Override
	public Ambulance findByUuid_First(
			String uuid, OrderByComparator<Ambulance> orderByComparator)
		throws NoSuchAmbulanceException {

		Ambulance ambulance = fetchByUuid_First(uuid, orderByComparator);

		if (ambulance != null) {
			return ambulance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAmbulanceException(sb.toString());
	}

	/**
	 * Returns the first ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	@Override
	public Ambulance fetchByUuid_First(
		String uuid, OrderByComparator<Ambulance> orderByComparator) {

		List<Ambulance> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	@Override
	public Ambulance findByUuid_Last(
			String uuid, OrderByComparator<Ambulance> orderByComparator)
		throws NoSuchAmbulanceException {

		Ambulance ambulance = fetchByUuid_Last(uuid, orderByComparator);

		if (ambulance != null) {
			return ambulance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchAmbulanceException(sb.toString());
	}

	/**
	 * Returns the last ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	@Override
	public Ambulance fetchByUuid_Last(
		String uuid, OrderByComparator<Ambulance> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Ambulance> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ambulances before and after the current ambulance in the ordered set where uuid = &#63;.
	 *
	 * @param ambulanceId the primary key of the current ambulance
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	@Override
	public Ambulance[] findByUuid_PrevAndNext(
			long ambulanceId, String uuid,
			OrderByComparator<Ambulance> orderByComparator)
		throws NoSuchAmbulanceException {

		uuid = Objects.toString(uuid, "");

		Ambulance ambulance = findByPrimaryKey(ambulanceId);

		Session session = null;

		try {
			session = openSession();

			Ambulance[] array = new AmbulanceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, ambulance, uuid, orderByComparator, true);

			array[1] = ambulance;

			array[2] = getByUuid_PrevAndNext(
				session, ambulance, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ambulance getByUuid_PrevAndNext(
		Session session, Ambulance ambulance, String uuid,
		OrderByComparator<Ambulance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMBULANCE_WHERE);

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
			sb.append(AmbulanceModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(ambulance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ambulance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ambulances where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Ambulance ambulance :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ambulance);
		}
	}

	/**
	 * Returns the number of ambulances where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching ambulances
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMBULANCE_WHERE);

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
		"ambulance.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(ambulance.uuid IS NULL OR ambulance.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByHospitalId;
	private FinderPath _finderPathWithoutPaginationFindByHospitalId;
	private FinderPath _finderPathCountByHospitalId;

	/**
	 * Returns all the ambulances where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the matching ambulances
	 */
	@Override
	public List<Ambulance> findByHospitalId(long hospitalId) {
		return findByHospitalId(
			hospitalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ambulances where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @return the range of matching ambulances
	 */
	@Override
	public List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end) {

		return findByHospitalId(hospitalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the ambulances where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching ambulances
	 */
	@Override
	public List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Ambulance> orderByComparator) {

		return findByHospitalId(
			hospitalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ambulances where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching ambulances
	 */
	@Override
	public List<Ambulance> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Ambulance> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByHospitalId;
				finderArgs = new Object[] {hospitalId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByHospitalId;
			finderArgs = new Object[] {
				hospitalId, start, end, orderByComparator
			};
		}

		List<Ambulance> list = null;

		if (useFinderCache) {
			list = (List<Ambulance>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Ambulance ambulance : list) {
					if (hospitalId != ambulance.getHospitalId()) {
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

			sb.append(_SQL_SELECT_AMBULANCE_WHERE);

			sb.append(_FINDER_COLUMN_HOSPITALID_HOSPITALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(AmbulanceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hospitalId);

				list = (List<Ambulance>)QueryUtil.list(
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
	 * Returns the first ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	@Override
	public Ambulance findByHospitalId_First(
			long hospitalId, OrderByComparator<Ambulance> orderByComparator)
		throws NoSuchAmbulanceException {

		Ambulance ambulance = fetchByHospitalId_First(
			hospitalId, orderByComparator);

		if (ambulance != null) {
			return ambulance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hospitalId=");
		sb.append(hospitalId);

		sb.append("}");

		throw new NoSuchAmbulanceException(sb.toString());
	}

	/**
	 * Returns the first ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	@Override
	public Ambulance fetchByHospitalId_First(
		long hospitalId, OrderByComparator<Ambulance> orderByComparator) {

		List<Ambulance> list = findByHospitalId(
			hospitalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance
	 * @throws NoSuchAmbulanceException if a matching ambulance could not be found
	 */
	@Override
	public Ambulance findByHospitalId_Last(
			long hospitalId, OrderByComparator<Ambulance> orderByComparator)
		throws NoSuchAmbulanceException {

		Ambulance ambulance = fetchByHospitalId_Last(
			hospitalId, orderByComparator);

		if (ambulance != null) {
			return ambulance;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hospitalId=");
		sb.append(hospitalId);

		sb.append("}");

		throw new NoSuchAmbulanceException(sb.toString());
	}

	/**
	 * Returns the last ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ambulance, or <code>null</code> if a matching ambulance could not be found
	 */
	@Override
	public Ambulance fetchByHospitalId_Last(
		long hospitalId, OrderByComparator<Ambulance> orderByComparator) {

		int count = countByHospitalId(hospitalId);

		if (count == 0) {
			return null;
		}

		List<Ambulance> list = findByHospitalId(
			hospitalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the ambulances before and after the current ambulance in the ordered set where hospitalId = &#63;.
	 *
	 * @param ambulanceId the primary key of the current ambulance
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	@Override
	public Ambulance[] findByHospitalId_PrevAndNext(
			long ambulanceId, long hospitalId,
			OrderByComparator<Ambulance> orderByComparator)
		throws NoSuchAmbulanceException {

		Ambulance ambulance = findByPrimaryKey(ambulanceId);

		Session session = null;

		try {
			session = openSession();

			Ambulance[] array = new AmbulanceImpl[3];

			array[0] = getByHospitalId_PrevAndNext(
				session, ambulance, hospitalId, orderByComparator, true);

			array[1] = ambulance;

			array[2] = getByHospitalId_PrevAndNext(
				session, ambulance, hospitalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Ambulance getByHospitalId_PrevAndNext(
		Session session, Ambulance ambulance, long hospitalId,
		OrderByComparator<Ambulance> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_AMBULANCE_WHERE);

		sb.append(_FINDER_COLUMN_HOSPITALID_HOSPITALID_2);

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
			sb.append(AmbulanceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(hospitalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(ambulance)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Ambulance> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the ambulances where hospitalId = &#63; from the database.
	 *
	 * @param hospitalId the hospital ID
	 */
	@Override
	public void removeByHospitalId(long hospitalId) {
		for (Ambulance ambulance :
				findByHospitalId(
					hospitalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(ambulance);
		}
	}

	/**
	 * Returns the number of ambulances where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the number of matching ambulances
	 */
	@Override
	public int countByHospitalId(long hospitalId) {
		FinderPath finderPath = _finderPathCountByHospitalId;

		Object[] finderArgs = new Object[] {hospitalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_AMBULANCE_WHERE);

			sb.append(_FINDER_COLUMN_HOSPITALID_HOSPITALID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hospitalId);

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

	private static final String _FINDER_COLUMN_HOSPITALID_HOSPITALID_2 =
		"ambulance.hospitalId = ?";

	public AmbulancePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Ambulance.class);

		setModelImplClass(AmbulanceImpl.class);
		setModelPKClass(long.class);

		setTable(AmbulanceTable.INSTANCE);
	}

	/**
	 * Caches the ambulance in the entity cache if it is enabled.
	 *
	 * @param ambulance the ambulance
	 */
	@Override
	public void cacheResult(Ambulance ambulance) {
		entityCache.putResult(
			AmbulanceImpl.class, ambulance.getPrimaryKey(), ambulance);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the ambulances in the entity cache if it is enabled.
	 *
	 * @param ambulances the ambulances
	 */
	@Override
	public void cacheResult(List<Ambulance> ambulances) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (ambulances.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Ambulance ambulance : ambulances) {
			if (entityCache.getResult(
					AmbulanceImpl.class, ambulance.getPrimaryKey()) == null) {

				cacheResult(ambulance);
			}
		}
	}

	/**
	 * Clears the cache for all ambulances.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AmbulanceImpl.class);

		finderCache.clearCache(AmbulanceImpl.class);
	}

	/**
	 * Clears the cache for the ambulance.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ambulance ambulance) {
		entityCache.removeResult(AmbulanceImpl.class, ambulance);
	}

	@Override
	public void clearCache(List<Ambulance> ambulances) {
		for (Ambulance ambulance : ambulances) {
			entityCache.removeResult(AmbulanceImpl.class, ambulance);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(AmbulanceImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(AmbulanceImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new ambulance with the primary key. Does not add the ambulance to the database.
	 *
	 * @param ambulanceId the primary key for the new ambulance
	 * @return the new ambulance
	 */
	@Override
	public Ambulance create(long ambulanceId) {
		Ambulance ambulance = new AmbulanceImpl();

		ambulance.setNew(true);
		ambulance.setPrimaryKey(ambulanceId);

		String uuid = PortalUUIDUtil.generate();

		ambulance.setUuid(uuid);

		return ambulance;
	}

	/**
	 * Removes the ambulance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance that was removed
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	@Override
	public Ambulance remove(long ambulanceId) throws NoSuchAmbulanceException {
		return remove((Serializable)ambulanceId);
	}

	/**
	 * Removes the ambulance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ambulance
	 * @return the ambulance that was removed
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	@Override
	public Ambulance remove(Serializable primaryKey)
		throws NoSuchAmbulanceException {

		Session session = null;

		try {
			session = openSession();

			Ambulance ambulance = (Ambulance)session.get(
				AmbulanceImpl.class, primaryKey);

			if (ambulance == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAmbulanceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(ambulance);
		}
		catch (NoSuchAmbulanceException noSuchEntityException) {
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
	protected Ambulance removeImpl(Ambulance ambulance) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ambulance)) {
				ambulance = (Ambulance)session.get(
					AmbulanceImpl.class, ambulance.getPrimaryKeyObj());
			}

			if (ambulance != null) {
				session.delete(ambulance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (ambulance != null) {
			clearCache(ambulance);
		}

		return ambulance;
	}

	@Override
	public Ambulance updateImpl(Ambulance ambulance) {
		boolean isNew = ambulance.isNew();

		if (!(ambulance instanceof AmbulanceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(ambulance.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(ambulance);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in ambulance proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Ambulance implementation " +
					ambulance.getClass());
		}

		AmbulanceModelImpl ambulanceModelImpl = (AmbulanceModelImpl)ambulance;

		if (Validator.isNull(ambulance.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			ambulance.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (ambulance.getCreateDate() == null)) {
			if (serviceContext == null) {
				ambulance.setCreateDate(date);
			}
			else {
				ambulance.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!ambulanceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				ambulance.setModifiedDate(date);
			}
			else {
				ambulance.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(ambulance);
			}
			else {
				ambulance = (Ambulance)session.merge(ambulance);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			AmbulanceImpl.class, ambulanceModelImpl, false, true);

		if (isNew) {
			ambulance.setNew(false);
		}

		ambulance.resetOriginalValues();

		return ambulance;
	}

	/**
	 * Returns the ambulance with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ambulance
	 * @return the ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	@Override
	public Ambulance findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAmbulanceException {

		Ambulance ambulance = fetchByPrimaryKey(primaryKey);

		if (ambulance == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAmbulanceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return ambulance;
	}

	/**
	 * Returns the ambulance with the primary key or throws a <code>NoSuchAmbulanceException</code> if it could not be found.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance
	 * @throws NoSuchAmbulanceException if a ambulance with the primary key could not be found
	 */
	@Override
	public Ambulance findByPrimaryKey(long ambulanceId)
		throws NoSuchAmbulanceException {

		return findByPrimaryKey((Serializable)ambulanceId);
	}

	/**
	 * Returns the ambulance with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance, or <code>null</code> if a ambulance with the primary key could not be found
	 */
	@Override
	public Ambulance fetchByPrimaryKey(long ambulanceId) {
		return fetchByPrimaryKey((Serializable)ambulanceId);
	}

	/**
	 * Returns all the ambulances.
	 *
	 * @return the ambulances
	 */
	@Override
	public List<Ambulance> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the ambulances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @return the range of ambulances
	 */
	@Override
	public List<Ambulance> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the ambulances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of ambulances
	 */
	@Override
	public List<Ambulance> findAll(
		int start, int end, OrderByComparator<Ambulance> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the ambulances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of ambulances
	 */
	@Override
	public List<Ambulance> findAll(
		int start, int end, OrderByComparator<Ambulance> orderByComparator,
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

		List<Ambulance> list = null;

		if (useFinderCache) {
			list = (List<Ambulance>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_AMBULANCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_AMBULANCE;

				sql = sql.concat(AmbulanceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Ambulance>)QueryUtil.list(
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
	 * Removes all the ambulances from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Ambulance ambulance : findAll()) {
			remove(ambulance);
		}
	}

	/**
	 * Returns the number of ambulances.
	 *
	 * @return the number of ambulances
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_AMBULANCE);

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
		return "ambulanceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_AMBULANCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return AmbulanceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the ambulance persistence.
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

		_finderPathWithPaginationFindByHospitalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByHospitalId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"hospitalId"}, true);

		_finderPathWithoutPaginationFindByHospitalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByHospitalId",
			new String[] {Long.class.getName()}, new String[] {"hospitalId"},
			true);

		_finderPathCountByHospitalId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByHospitalId",
			new String[] {Long.class.getName()}, new String[] {"hospitalId"},
			false);

		AmbulanceUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		AmbulanceUtil.setPersistence(null);

		entityCache.removeCache(AmbulanceImpl.class.getName());
	}

	@Override
	@Reference(
		target = HSPPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = HSPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = HSPPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_AMBULANCE =
		"SELECT ambulance FROM Ambulance ambulance";

	private static final String _SQL_SELECT_AMBULANCE_WHERE =
		"SELECT ambulance FROM Ambulance ambulance WHERE ";

	private static final String _SQL_COUNT_AMBULANCE =
		"SELECT COUNT(ambulance) FROM Ambulance ambulance";

	private static final String _SQL_COUNT_AMBULANCE_WHERE =
		"SELECT COUNT(ambulance) FROM Ambulance ambulance WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "ambulance.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Ambulance exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Ambulance exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		AmbulancePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}