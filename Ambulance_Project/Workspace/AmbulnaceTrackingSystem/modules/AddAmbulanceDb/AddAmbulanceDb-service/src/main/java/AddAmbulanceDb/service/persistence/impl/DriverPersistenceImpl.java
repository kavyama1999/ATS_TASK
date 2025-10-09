/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence.impl;

import AddAmbulanceDb.exception.NoSuchDriverException;

import AddAmbulanceDb.model.Driver;
import AddAmbulanceDb.model.DriverTable;
import AddAmbulanceDb.model.impl.DriverImpl;
import AddAmbulanceDb.model.impl.DriverModelImpl;

import AddAmbulanceDb.service.persistence.DriverPersistence;
import AddAmbulanceDb.service.persistence.DriverUtil;
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
 * The persistence implementation for the driver service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = DriverPersistence.class)
public class DriverPersistenceImpl
	extends BasePersistenceImpl<Driver> implements DriverPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>DriverUtil</code> to access the driver persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		DriverImpl.class.getName();

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
	 * Returns all the drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching drivers
	 */
	@Override
	public List<Driver> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drivers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of matching drivers
	 */
	@Override
	public List<Driver> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the drivers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drivers
	 */
	@Override
	public List<Driver> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Driver> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drivers where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drivers
	 */
	@Override
	public List<Driver> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean useFinderCache) {

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

		List<Driver> list = null;

		if (useFinderCache) {
			list = (List<Driver>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Driver driver : list) {
					if (!uuid.equals(driver.getUuid())) {
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

			sb.append(_SQL_SELECT_DRIVER_WHERE);

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
				sb.append(DriverModelImpl.ORDER_BY_JPQL);
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

				list = (List<Driver>)QueryUtil.list(
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
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByUuid_First(
			String uuid, OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = fetchByUuid_First(uuid, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDriverException(sb.toString());
	}

	/**
	 * Returns the first driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByUuid_First(
		String uuid, OrderByComparator<Driver> orderByComparator) {

		List<Driver> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByUuid_Last(
			String uuid, OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = fetchByUuid_Last(uuid, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchDriverException(sb.toString());
	}

	/**
	 * Returns the last driver in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByUuid_Last(
		String uuid, OrderByComparator<Driver> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Driver> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the drivers before and after the current driver in the ordered set where uuid = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver[] findByUuid_PrevAndNext(
			long driverId, String uuid,
			OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		uuid = Objects.toString(uuid, "");

		Driver driver = findByPrimaryKey(driverId);

		Session session = null;

		try {
			session = openSession();

			Driver[] array = new DriverImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, driver, uuid, orderByComparator, true);

			array[1] = driver;

			array[2] = getByUuid_PrevAndNext(
				session, driver, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Driver getByUuid_PrevAndNext(
		Session session, Driver driver, String uuid,
		OrderByComparator<Driver> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DRIVER_WHERE);

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
			sb.append(DriverModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(driver)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Driver> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drivers where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Driver driver :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(driver);
		}
	}

	/**
	 * Returns the number of drivers where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching drivers
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DRIVER_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "driver.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(driver.uuid IS NULL OR driver.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByHospitalId;
	private FinderPath _finderPathWithoutPaginationFindByHospitalId;
	private FinderPath _finderPathCountByHospitalId;

	/**
	 * Returns all the drivers where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the matching drivers
	 */
	@Override
	public List<Driver> findByHospitalId(long hospitalId) {
		return findByHospitalId(
			hospitalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drivers where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of matching drivers
	 */
	@Override
	public List<Driver> findByHospitalId(long hospitalId, int start, int end) {
		return findByHospitalId(hospitalId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the drivers where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drivers
	 */
	@Override
	public List<Driver> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Driver> orderByComparator) {

		return findByHospitalId(
			hospitalId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drivers where hospitalId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param hospitalId the hospital ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drivers
	 */
	@Override
	public List<Driver> findByHospitalId(
		long hospitalId, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean useFinderCache) {

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

		List<Driver> list = null;

		if (useFinderCache) {
			list = (List<Driver>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Driver driver : list) {
					if (hospitalId != driver.getHospitalId()) {
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

			sb.append(_SQL_SELECT_DRIVER_WHERE);

			sb.append(_FINDER_COLUMN_HOSPITALID_HOSPITALID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DriverModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(hospitalId);

				list = (List<Driver>)QueryUtil.list(
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
	 * Returns the first driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByHospitalId_First(
			long hospitalId, OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = fetchByHospitalId_First(hospitalId, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hospitalId=");
		sb.append(hospitalId);

		sb.append("}");

		throw new NoSuchDriverException(sb.toString());
	}

	/**
	 * Returns the first driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByHospitalId_First(
		long hospitalId, OrderByComparator<Driver> orderByComparator) {

		List<Driver> list = findByHospitalId(
			hospitalId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByHospitalId_Last(
			long hospitalId, OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = fetchByHospitalId_Last(hospitalId, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("hospitalId=");
		sb.append(hospitalId);

		sb.append("}");

		throw new NoSuchDriverException(sb.toString());
	}

	/**
	 * Returns the last driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByHospitalId_Last(
		long hospitalId, OrderByComparator<Driver> orderByComparator) {

		int count = countByHospitalId(hospitalId);

		if (count == 0) {
			return null;
		}

		List<Driver> list = findByHospitalId(
			hospitalId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the drivers before and after the current driver in the ordered set where hospitalId = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param hospitalId the hospital ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver[] findByHospitalId_PrevAndNext(
			long driverId, long hospitalId,
			OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = findByPrimaryKey(driverId);

		Session session = null;

		try {
			session = openSession();

			Driver[] array = new DriverImpl[3];

			array[0] = getByHospitalId_PrevAndNext(
				session, driver, hospitalId, orderByComparator, true);

			array[1] = driver;

			array[2] = getByHospitalId_PrevAndNext(
				session, driver, hospitalId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Driver getByHospitalId_PrevAndNext(
		Session session, Driver driver, long hospitalId,
		OrderByComparator<Driver> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DRIVER_WHERE);

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
			sb.append(DriverModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(hospitalId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(driver)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Driver> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drivers where hospitalId = &#63; from the database.
	 *
	 * @param hospitalId the hospital ID
	 */
	@Override
	public void removeByHospitalId(long hospitalId) {
		for (Driver driver :
				findByHospitalId(
					hospitalId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(driver);
		}
	}

	/**
	 * Returns the number of drivers where hospitalId = &#63;.
	 *
	 * @param hospitalId the hospital ID
	 * @return the number of matching drivers
	 */
	@Override
	public int countByHospitalId(long hospitalId) {
		FinderPath finderPath = _finderPathCountByHospitalId;

		Object[] finderArgs = new Object[] {hospitalId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DRIVER_WHERE);

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
		"driver.hospitalId = ?";

	private FinderPath _finderPathWithPaginationFindByAmbulanceId;
	private FinderPath _finderPathWithoutPaginationFindByAmbulanceId;
	private FinderPath _finderPathCountByAmbulanceId;

	/**
	 * Returns all the drivers where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @return the matching drivers
	 */
	@Override
	public List<Driver> findByAmbulanceId(long ambulanceId) {
		return findByAmbulanceId(
			ambulanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drivers where ambulanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param ambulanceId the ambulance ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of matching drivers
	 */
	@Override
	public List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end) {

		return findByAmbulanceId(ambulanceId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the drivers where ambulanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param ambulanceId the ambulance ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching drivers
	 */
	@Override
	public List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end,
		OrderByComparator<Driver> orderByComparator) {

		return findByAmbulanceId(
			ambulanceId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drivers where ambulanceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param ambulanceId the ambulance ID
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching drivers
	 */
	@Override
	public List<Driver> findByAmbulanceId(
		long ambulanceId, int start, int end,
		OrderByComparator<Driver> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByAmbulanceId;
				finderArgs = new Object[] {ambulanceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByAmbulanceId;
			finderArgs = new Object[] {
				ambulanceId, start, end, orderByComparator
			};
		}

		List<Driver> list = null;

		if (useFinderCache) {
			list = (List<Driver>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Driver driver : list) {
					if (ambulanceId != driver.getAmbulanceId()) {
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

			sb.append(_SQL_SELECT_DRIVER_WHERE);

			sb.append(_FINDER_COLUMN_AMBULANCEID_AMBULANCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(DriverModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ambulanceId);

				list = (List<Driver>)QueryUtil.list(
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
	 * Returns the first driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByAmbulanceId_First(
			long ambulanceId, OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = fetchByAmbulanceId_First(
			ambulanceId, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ambulanceId=");
		sb.append(ambulanceId);

		sb.append("}");

		throw new NoSuchDriverException(sb.toString());
	}

	/**
	 * Returns the first driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByAmbulanceId_First(
		long ambulanceId, OrderByComparator<Driver> orderByComparator) {

		List<Driver> list = findByAmbulanceId(
			ambulanceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver
	 * @throws NoSuchDriverException if a matching driver could not be found
	 */
	@Override
	public Driver findByAmbulanceId_Last(
			long ambulanceId, OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = fetchByAmbulanceId_Last(ambulanceId, orderByComparator);

		if (driver != null) {
			return driver;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ambulanceId=");
		sb.append(ambulanceId);

		sb.append("}");

		throw new NoSuchDriverException(sb.toString());
	}

	/**
	 * Returns the last driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching driver, or <code>null</code> if a matching driver could not be found
	 */
	@Override
	public Driver fetchByAmbulanceId_Last(
		long ambulanceId, OrderByComparator<Driver> orderByComparator) {

		int count = countByAmbulanceId(ambulanceId);

		if (count == 0) {
			return null;
		}

		List<Driver> list = findByAmbulanceId(
			ambulanceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the drivers before and after the current driver in the ordered set where ambulanceId = &#63;.
	 *
	 * @param driverId the primary key of the current driver
	 * @param ambulanceId the ambulance ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver[] findByAmbulanceId_PrevAndNext(
			long driverId, long ambulanceId,
			OrderByComparator<Driver> orderByComparator)
		throws NoSuchDriverException {

		Driver driver = findByPrimaryKey(driverId);

		Session session = null;

		try {
			session = openSession();

			Driver[] array = new DriverImpl[3];

			array[0] = getByAmbulanceId_PrevAndNext(
				session, driver, ambulanceId, orderByComparator, true);

			array[1] = driver;

			array[2] = getByAmbulanceId_PrevAndNext(
				session, driver, ambulanceId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Driver getByAmbulanceId_PrevAndNext(
		Session session, Driver driver, long ambulanceId,
		OrderByComparator<Driver> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_DRIVER_WHERE);

		sb.append(_FINDER_COLUMN_AMBULANCEID_AMBULANCEID_2);

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
			sb.append(DriverModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(ambulanceId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(driver)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Driver> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the drivers where ambulanceId = &#63; from the database.
	 *
	 * @param ambulanceId the ambulance ID
	 */
	@Override
	public void removeByAmbulanceId(long ambulanceId) {
		for (Driver driver :
				findByAmbulanceId(
					ambulanceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(driver);
		}
	}

	/**
	 * Returns the number of drivers where ambulanceId = &#63;.
	 *
	 * @param ambulanceId the ambulance ID
	 * @return the number of matching drivers
	 */
	@Override
	public int countByAmbulanceId(long ambulanceId) {
		FinderPath finderPath = _finderPathCountByAmbulanceId;

		Object[] finderArgs = new Object[] {ambulanceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_DRIVER_WHERE);

			sb.append(_FINDER_COLUMN_AMBULANCEID_AMBULANCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(ambulanceId);

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

	private static final String _FINDER_COLUMN_AMBULANCEID_AMBULANCEID_2 =
		"driver.ambulanceId = ?";

	public DriverPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Driver.class);

		setModelImplClass(DriverImpl.class);
		setModelPKClass(long.class);

		setTable(DriverTable.INSTANCE);
	}

	/**
	 * Caches the driver in the entity cache if it is enabled.
	 *
	 * @param driver the driver
	 */
	@Override
	public void cacheResult(Driver driver) {
		entityCache.putResult(DriverImpl.class, driver.getPrimaryKey(), driver);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the drivers in the entity cache if it is enabled.
	 *
	 * @param drivers the drivers
	 */
	@Override
	public void cacheResult(List<Driver> drivers) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (drivers.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Driver driver : drivers) {
			if (entityCache.getResult(
					DriverImpl.class, driver.getPrimaryKey()) == null) {

				cacheResult(driver);
			}
		}
	}

	/**
	 * Clears the cache for all drivers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(DriverImpl.class);

		finderCache.clearCache(DriverImpl.class);
	}

	/**
	 * Clears the cache for the driver.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Driver driver) {
		entityCache.removeResult(DriverImpl.class, driver);
	}

	@Override
	public void clearCache(List<Driver> drivers) {
		for (Driver driver : drivers) {
			entityCache.removeResult(DriverImpl.class, driver);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(DriverImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(DriverImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new driver with the primary key. Does not add the driver to the database.
	 *
	 * @param driverId the primary key for the new driver
	 * @return the new driver
	 */
	@Override
	public Driver create(long driverId) {
		Driver driver = new DriverImpl();

		driver.setNew(true);
		driver.setPrimaryKey(driverId);

		String uuid = PortalUUIDUtil.generate();

		driver.setUuid(uuid);

		return driver;
	}

	/**
	 * Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver that was removed
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver remove(long driverId) throws NoSuchDriverException {
		return remove((Serializable)driverId);
	}

	/**
	 * Removes the driver with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the driver
	 * @return the driver that was removed
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver remove(Serializable primaryKey) throws NoSuchDriverException {
		Session session = null;

		try {
			session = openSession();

			Driver driver = (Driver)session.get(DriverImpl.class, primaryKey);

			if (driver == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDriverException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(driver);
		}
		catch (NoSuchDriverException noSuchEntityException) {
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
	protected Driver removeImpl(Driver driver) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(driver)) {
				driver = (Driver)session.get(
					DriverImpl.class, driver.getPrimaryKeyObj());
			}

			if (driver != null) {
				session.delete(driver);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (driver != null) {
			clearCache(driver);
		}

		return driver;
	}

	@Override
	public Driver updateImpl(Driver driver) {
		boolean isNew = driver.isNew();

		if (!(driver instanceof DriverModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(driver.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(driver);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in driver proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Driver implementation " +
					driver.getClass());
		}

		DriverModelImpl driverModelImpl = (DriverModelImpl)driver;

		if (Validator.isNull(driver.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			driver.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (driver.getCreateDate() == null)) {
			if (serviceContext == null) {
				driver.setCreateDate(date);
			}
			else {
				driver.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!driverModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				driver.setModifiedDate(date);
			}
			else {
				driver.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(driver);
			}
			else {
				driver = (Driver)session.merge(driver);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(DriverImpl.class, driverModelImpl, false, true);

		if (isNew) {
			driver.setNew(false);
		}

		driver.resetOriginalValues();

		return driver;
	}

	/**
	 * Returns the driver with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the driver
	 * @return the driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDriverException {

		Driver driver = fetchByPrimaryKey(primaryKey);

		if (driver == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDriverException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return driver;
	}

	/**
	 * Returns the driver with the primary key or throws a <code>NoSuchDriverException</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver
	 * @throws NoSuchDriverException if a driver with the primary key could not be found
	 */
	@Override
	public Driver findByPrimaryKey(long driverId) throws NoSuchDriverException {
		return findByPrimaryKey((Serializable)driverId);
	}

	/**
	 * Returns the driver with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param driverId the primary key of the driver
	 * @return the driver, or <code>null</code> if a driver with the primary key could not be found
	 */
	@Override
	public Driver fetchByPrimaryKey(long driverId) {
		return fetchByPrimaryKey((Serializable)driverId);
	}

	/**
	 * Returns all the drivers.
	 *
	 * @return the drivers
	 */
	@Override
	public List<Driver> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @return the range of drivers
	 */
	@Override
	public List<Driver> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of drivers
	 */
	@Override
	public List<Driver> findAll(
		int start, int end, OrderByComparator<Driver> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the drivers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DriverModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of drivers
	 * @param end the upper bound of the range of drivers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of drivers
	 */
	@Override
	public List<Driver> findAll(
		int start, int end, OrderByComparator<Driver> orderByComparator,
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

		List<Driver> list = null;

		if (useFinderCache) {
			list = (List<Driver>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_DRIVER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_DRIVER;

				sql = sql.concat(DriverModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Driver>)QueryUtil.list(
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
	 * Removes all the drivers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Driver driver : findAll()) {
			remove(driver);
		}
	}

	/**
	 * Returns the number of drivers.
	 *
	 * @return the number of drivers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_DRIVER);

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
		return "driverId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_DRIVER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return DriverModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the driver persistence.
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

		_finderPathWithPaginationFindByAmbulanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAmbulanceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ambulanceId"}, true);

		_finderPathWithoutPaginationFindByAmbulanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAmbulanceId",
			new String[] {Long.class.getName()}, new String[] {"ambulanceId"},
			true);

		_finderPathCountByAmbulanceId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAmbulanceId",
			new String[] {Long.class.getName()}, new String[] {"ambulanceId"},
			false);

		DriverUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		DriverUtil.setPersistence(null);

		entityCache.removeCache(DriverImpl.class.getName());
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

	private static final String _SQL_SELECT_DRIVER =
		"SELECT driver FROM Driver driver";

	private static final String _SQL_SELECT_DRIVER_WHERE =
		"SELECT driver FROM Driver driver WHERE ";

	private static final String _SQL_COUNT_DRIVER =
		"SELECT COUNT(driver) FROM Driver driver";

	private static final String _SQL_COUNT_DRIVER_WHERE =
		"SELECT COUNT(driver) FROM Driver driver WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "driver.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Driver exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Driver exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		DriverPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}