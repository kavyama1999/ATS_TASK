/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.persistence.impl;

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

import library.db.exception.NoSuchbook_reviewException;
import library.db.model.book_review;
import library.db.model.book_reviewTable;
import library.db.model.impl.book_reviewImpl;
import library.db.model.impl.book_reviewModelImpl;
import library.db.service.persistence.book_reviewPersistence;
import library.db.service.persistence.book_reviewUtil;
import library.db.service.persistence.impl.constants.libPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the book_review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = book_reviewPersistence.class)
public class book_reviewPersistenceImpl
	extends BasePersistenceImpl<book_review> implements book_reviewPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>book_reviewUtil</code> to access the book_review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		book_reviewImpl.class.getName();

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
	 * Returns all the book_reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book_reviews
	 */
	@Override
	public List<book_review> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<book_review> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<book_review> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<book_review> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<book_review> orderByComparator,
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

		List<book_review> list = null;

		if (useFinderCache) {
			list = (List<book_review>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (book_review book_review : list) {
					if (!uuid.equals(book_review.getUuid())) {
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

			sb.append(_SQL_SELECT_BOOK_REVIEW_WHERE);

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
				sb.append(book_reviewModelImpl.ORDER_BY_JPQL);
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

				list = (List<book_review>)QueryUtil.list(
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
	 * Returns the first book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	@Override
	public book_review findByUuid_First(
			String uuid, OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByUuid_First(uuid, orderByComparator);

		if (book_review != null) {
			return book_review;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchbook_reviewException(sb.toString());
	}

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByUuid_First(
		String uuid, OrderByComparator<book_review> orderByComparator) {

		List<book_review> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	@Override
	public book_review findByUuid_Last(
			String uuid, OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByUuid_Last(uuid, orderByComparator);

		if (book_review != null) {
			return book_review;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchbook_reviewException(sb.toString());
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByUuid_Last(
		String uuid, OrderByComparator<book_review> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<book_review> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the book_reviews before and after the current book_review in the ordered set where uuid = &#63;.
	 *
	 * @param reviewId the primary key of the current book_review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	@Override
	public book_review[] findByUuid_PrevAndNext(
			long reviewId, String uuid,
			OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		uuid = Objects.toString(uuid, "");

		book_review book_review = findByPrimaryKey(reviewId);

		Session session = null;

		try {
			session = openSession();

			book_review[] array = new book_reviewImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, book_review, uuid, orderByComparator, true);

			array[1] = book_review;

			array[2] = getByUuid_PrevAndNext(
				session, book_review, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected book_review getByUuid_PrevAndNext(
		Session session, book_review book_review, String uuid,
		OrderByComparator<book_review> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOK_REVIEW_WHERE);

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
			sb.append(book_reviewModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(book_review)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<book_review> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book_reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (book_review book_review :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(book_review);
		}
	}

	/**
	 * Returns the number of book_reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book_reviews
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOK_REVIEW_WHERE);

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
		"book_review.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(book_review.uuid IS NULL OR book_review.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchbook_reviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	@Override
	public book_review findByUUID_G(String uuid, long groupId)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByUUID_G(uuid, groupId);

		if (book_review == null) {
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

			throw new NoSuchbook_reviewException(sb.toString());
		}

		return book_review;
	}

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the book_review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByUUID_G(
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

		if (result instanceof book_review) {
			book_review book_review = (book_review)result;

			if (!Objects.equals(uuid, book_review.getUuid()) ||
				(groupId != book_review.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BOOK_REVIEW_WHERE);

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

				List<book_review> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					book_review book_review = list.get(0);

					result = book_review;

					cacheResult(book_review);
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
			return (book_review)result;
		}
	}

	/**
	 * Removes the book_review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book_review that was removed
	 */
	@Override
	public book_review removeByUUID_G(String uuid, long groupId)
		throws NoSuchbook_reviewException {

		book_review book_review = findByUUID_G(uuid, groupId);

		return remove(book_review);
	}

	/**
	 * Returns the number of book_reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book_reviews
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		book_review book_review = fetchByUUID_G(uuid, groupId);

		if (book_review == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"book_review.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(book_review.uuid IS NULL OR book_review.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"book_review.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book_reviews
	 */
	@Override
	public List<book_review> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<book_review> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<book_review> orderByComparator,
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

		List<book_review> list = null;

		if (useFinderCache) {
			list = (List<book_review>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (book_review book_review : list) {
					if (!uuid.equals(book_review.getUuid()) ||
						(companyId != book_review.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BOOK_REVIEW_WHERE);

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
				sb.append(book_reviewModelImpl.ORDER_BY_JPQL);
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

				list = (List<book_review>)QueryUtil.list(
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
	 * Returns the first book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	@Override
	public book_review findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (book_review != null) {
			return book_review;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchbook_reviewException(sb.toString());
	}

	/**
	 * Returns the first book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<book_review> orderByComparator) {

		List<book_review> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	@Override
	public book_review findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (book_review != null) {
			return book_review;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchbook_reviewException(sb.toString());
	}

	/**
	 * Returns the last book_review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<book_review> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<book_review> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public book_review[] findByUuid_C_PrevAndNext(
			long reviewId, String uuid, long companyId,
			OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		uuid = Objects.toString(uuid, "");

		book_review book_review = findByPrimaryKey(reviewId);

		Session session = null;

		try {
			session = openSession();

			book_review[] array = new book_reviewImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, book_review, uuid, companyId, orderByComparator, true);

			array[1] = book_review;

			array[2] = getByUuid_C_PrevAndNext(
				session, book_review, uuid, companyId, orderByComparator,
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

	protected book_review getByUuid_C_PrevAndNext(
		Session session, book_review book_review, String uuid, long companyId,
		OrderByComparator<book_review> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BOOK_REVIEW_WHERE);

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
			sb.append(book_reviewModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(book_review)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<book_review> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book_reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (book_review book_review :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(book_review);
		}
	}

	/**
	 * Returns the number of book_reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book_reviews
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BOOK_REVIEW_WHERE);

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
		"book_review.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(book_review.uuid IS NULL OR book_review.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"book_review.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByLibId;
	private FinderPath _finderPathWithoutPaginationFindByLibId;
	private FinderPath _finderPathCountByLibId;

	/**
	 * Returns all the book_reviews where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @return the matching book_reviews
	 */
	@Override
	public List<book_review> findByLibId(long libId) {
		return findByLibId(libId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<book_review> findByLibId(long libId, int start, int end) {
		return findByLibId(libId, start, end, null);
	}

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
	@Override
	public List<book_review> findByLibId(
		long libId, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return findByLibId(libId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<book_review> findByLibId(
		long libId, int start, int end,
		OrderByComparator<book_review> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByLibId;
				finderArgs = new Object[] {libId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByLibId;
			finderArgs = new Object[] {libId, start, end, orderByComparator};
		}

		List<book_review> list = null;

		if (useFinderCache) {
			list = (List<book_review>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (book_review book_review : list) {
					if (libId != book_review.getLibId()) {
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

			sb.append(_SQL_SELECT_BOOK_REVIEW_WHERE);

			sb.append(_FINDER_COLUMN_LIBID_LIBID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(book_reviewModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(libId);

				list = (List<book_review>)QueryUtil.list(
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
	 * Returns the first book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	@Override
	public book_review findByLibId_First(
			long libId, OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByLibId_First(libId, orderByComparator);

		if (book_review != null) {
			return book_review;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("libId=");
		sb.append(libId);

		sb.append("}");

		throw new NoSuchbook_reviewException(sb.toString());
	}

	/**
	 * Returns the first book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByLibId_First(
		long libId, OrderByComparator<book_review> orderByComparator) {

		List<book_review> list = findByLibId(libId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review
	 * @throws NoSuchbook_reviewException if a matching book_review could not be found
	 */
	@Override
	public book_review findByLibId_Last(
			long libId, OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByLibId_Last(libId, orderByComparator);

		if (book_review != null) {
			return book_review;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("libId=");
		sb.append(libId);

		sb.append("}");

		throw new NoSuchbook_reviewException(sb.toString());
	}

	/**
	 * Returns the last book_review in the ordered set where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public book_review fetchByLibId_Last(
		long libId, OrderByComparator<book_review> orderByComparator) {

		int count = countByLibId(libId);

		if (count == 0) {
			return null;
		}

		List<book_review> list = findByLibId(
			libId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the book_reviews before and after the current book_review in the ordered set where libId = &#63;.
	 *
	 * @param reviewId the primary key of the current book_review
	 * @param libId the lib ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	@Override
	public book_review[] findByLibId_PrevAndNext(
			long reviewId, long libId,
			OrderByComparator<book_review> orderByComparator)
		throws NoSuchbook_reviewException {

		book_review book_review = findByPrimaryKey(reviewId);

		Session session = null;

		try {
			session = openSession();

			book_review[] array = new book_reviewImpl[3];

			array[0] = getByLibId_PrevAndNext(
				session, book_review, libId, orderByComparator, true);

			array[1] = book_review;

			array[2] = getByLibId_PrevAndNext(
				session, book_review, libId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected book_review getByLibId_PrevAndNext(
		Session session, book_review book_review, long libId,
		OrderByComparator<book_review> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOK_REVIEW_WHERE);

		sb.append(_FINDER_COLUMN_LIBID_LIBID_2);

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
			sb.append(book_reviewModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(libId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(book_review)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<book_review> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book_reviews where libId = &#63; from the database.
	 *
	 * @param libId the lib ID
	 */
	@Override
	public void removeByLibId(long libId) {
		for (book_review book_review :
				findByLibId(
					libId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(book_review);
		}
	}

	/**
	 * Returns the number of book_reviews where libId = &#63;.
	 *
	 * @param libId the lib ID
	 * @return the number of matching book_reviews
	 */
	@Override
	public int countByLibId(long libId) {
		FinderPath finderPath = _finderPathCountByLibId;

		Object[] finderArgs = new Object[] {libId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOK_REVIEW_WHERE);

			sb.append(_FINDER_COLUMN_LIBID_LIBID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(libId);

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

	private static final String _FINDER_COLUMN_LIBID_LIBID_2 =
		"book_review.libId = ?";

	public book_reviewPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(book_review.class);

		setModelImplClass(book_reviewImpl.class);
		setModelPKClass(long.class);

		setTable(book_reviewTable.INSTANCE);
	}

	/**
	 * Caches the book_review in the entity cache if it is enabled.
	 *
	 * @param book_review the book_review
	 */
	@Override
	public void cacheResult(book_review book_review) {
		entityCache.putResult(
			book_reviewImpl.class, book_review.getPrimaryKey(), book_review);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {book_review.getUuid(), book_review.getGroupId()},
			book_review);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the book_reviews in the entity cache if it is enabled.
	 *
	 * @param book_reviews the book_reviews
	 */
	@Override
	public void cacheResult(List<book_review> book_reviews) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (book_reviews.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (book_review book_review : book_reviews) {
			if (entityCache.getResult(
					book_reviewImpl.class, book_review.getPrimaryKey()) ==
						null) {

				cacheResult(book_review);
			}
		}
	}

	/**
	 * Clears the cache for all book_reviews.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(book_reviewImpl.class);

		finderCache.clearCache(book_reviewImpl.class);
	}

	/**
	 * Clears the cache for the book_review.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(book_review book_review) {
		entityCache.removeResult(book_reviewImpl.class, book_review);
	}

	@Override
	public void clearCache(List<book_review> book_reviews) {
		for (book_review book_review : book_reviews) {
			entityCache.removeResult(book_reviewImpl.class, book_review);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(book_reviewImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(book_reviewImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		book_reviewModelImpl book_reviewModelImpl) {

		Object[] args = new Object[] {
			book_reviewModelImpl.getUuid(), book_reviewModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, book_reviewModelImpl);
	}

	/**
	 * Creates a new book_review with the primary key. Does not add the book_review to the database.
	 *
	 * @param reviewId the primary key for the new book_review
	 * @return the new book_review
	 */
	@Override
	public book_review create(long reviewId) {
		book_review book_review = new book_reviewImpl();

		book_review.setNew(true);
		book_review.setPrimaryKey(reviewId);

		String uuid = PortalUUIDUtil.generate();

		book_review.setUuid(uuid);

		book_review.setCompanyId(CompanyThreadLocal.getCompanyId());

		return book_review;
	}

	/**
	 * Removes the book_review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review that was removed
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	@Override
	public book_review remove(long reviewId) throws NoSuchbook_reviewException {
		return remove((Serializable)reviewId);
	}

	/**
	 * Removes the book_review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book_review
	 * @return the book_review that was removed
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	@Override
	public book_review remove(Serializable primaryKey)
		throws NoSuchbook_reviewException {

		Session session = null;

		try {
			session = openSession();

			book_review book_review = (book_review)session.get(
				book_reviewImpl.class, primaryKey);

			if (book_review == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchbook_reviewException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(book_review);
		}
		catch (NoSuchbook_reviewException noSuchEntityException) {
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
	protected book_review removeImpl(book_review book_review) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(book_review)) {
				book_review = (book_review)session.get(
					book_reviewImpl.class, book_review.getPrimaryKeyObj());
			}

			if (book_review != null) {
				session.delete(book_review);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (book_review != null) {
			clearCache(book_review);
		}

		return book_review;
	}

	@Override
	public book_review updateImpl(book_review book_review) {
		boolean isNew = book_review.isNew();

		if (!(book_review instanceof book_reviewModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(book_review.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(book_review);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in book_review proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom book_review implementation " +
					book_review.getClass());
		}

		book_reviewModelImpl book_reviewModelImpl =
			(book_reviewModelImpl)book_review;

		if (Validator.isNull(book_review.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			book_review.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (book_review.getCreateDate() == null)) {
			if (serviceContext == null) {
				book_review.setCreateDate(date);
			}
			else {
				book_review.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!book_reviewModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				book_review.setModifiedDate(date);
			}
			else {
				book_review.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(book_review);
			}
			else {
				book_review = (book_review)session.merge(book_review);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			book_reviewImpl.class, book_reviewModelImpl, false, true);

		cacheUniqueFindersCache(book_reviewModelImpl);

		if (isNew) {
			book_review.setNew(false);
		}

		book_review.resetOriginalValues();

		return book_review;
	}

	/**
	 * Returns the book_review with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book_review
	 * @return the book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	@Override
	public book_review findByPrimaryKey(Serializable primaryKey)
		throws NoSuchbook_reviewException {

		book_review book_review = fetchByPrimaryKey(primaryKey);

		if (book_review == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchbook_reviewException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return book_review;
	}

	/**
	 * Returns the book_review with the primary key or throws a <code>NoSuchbook_reviewException</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review
	 * @throws NoSuchbook_reviewException if a book_review with the primary key could not be found
	 */
	@Override
	public book_review findByPrimaryKey(long reviewId)
		throws NoSuchbook_reviewException {

		return findByPrimaryKey((Serializable)reviewId);
	}

	/**
	 * Returns the book_review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review, or <code>null</code> if a book_review with the primary key could not be found
	 */
	@Override
	public book_review fetchByPrimaryKey(long reviewId) {
		return fetchByPrimaryKey((Serializable)reviewId);
	}

	/**
	 * Returns all the book_reviews.
	 *
	 * @return the book_reviews
	 */
	@Override
	public List<book_review> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<book_review> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<book_review> findAll(
		int start, int end, OrderByComparator<book_review> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<book_review> findAll(
		int start, int end, OrderByComparator<book_review> orderByComparator,
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

		List<book_review> list = null;

		if (useFinderCache) {
			list = (List<book_review>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOK_REVIEW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOK_REVIEW;

				sql = sql.concat(book_reviewModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<book_review>)QueryUtil.list(
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
	 * Removes all the book_reviews from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (book_review book_review : findAll()) {
			remove(book_review);
		}
	}

	/**
	 * Returns the number of book_reviews.
	 *
	 * @return the number of book_reviews
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOK_REVIEW);

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
		return "reviewId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BOOK_REVIEW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return book_reviewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the book_review persistence.
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

		_finderPathWithPaginationFindByLibId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLibId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"libId"}, true);

		_finderPathWithoutPaginationFindByLibId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLibId",
			new String[] {Long.class.getName()}, new String[] {"libId"}, true);

		_finderPathCountByLibId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLibId",
			new String[] {Long.class.getName()}, new String[] {"libId"}, false);

		book_reviewUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		book_reviewUtil.setPersistence(null);

		entityCache.removeCache(book_reviewImpl.class.getName());
	}

	@Override
	@Reference(
		target = libPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = libPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = libPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_BOOK_REVIEW =
		"SELECT book_review FROM book_review book_review";

	private static final String _SQL_SELECT_BOOK_REVIEW_WHERE =
		"SELECT book_review FROM book_review book_review WHERE ";

	private static final String _SQL_COUNT_BOOK_REVIEW =
		"SELECT COUNT(book_review) FROM book_review book_review";

	private static final String _SQL_COUNT_BOOK_REVIEW_WHERE =
		"SELECT COUNT(book_review) FROM book_review book_review WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "book_review.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No book_review exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No book_review exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		book_reviewPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "comment"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}