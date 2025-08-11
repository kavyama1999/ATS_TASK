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

import library.db.exception.NoSuchBookReviewException;
import library.db.model.BookReview;
import library.db.model.BookReviewTable;
import library.db.model.impl.BookReviewImpl;
import library.db.model.impl.BookReviewModelImpl;
import library.db.service.persistence.BookReviewPersistence;
import library.db.service.persistence.BookReviewUtil;
import library.db.service.persistence.impl.constants.libPersistenceConstants;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the book review service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BookReviewPersistence.class)
public class BookReviewPersistenceImpl
	extends BasePersistenceImpl<BookReview> implements BookReviewPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BookReviewUtil</code> to access the book review persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BookReviewImpl.class.getName();

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
	 * Returns all the book reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching book reviews
	 */
	@Override
	public List<BookReview> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BookReview> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

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
	@Override
	public List<BookReview> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookReview> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

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
	@Override
	public List<BookReview> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BookReview> orderByComparator,
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

		List<BookReview> list = null;

		if (useFinderCache) {
			list = (List<BookReview>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookReview bookReview : list) {
					if (!uuid.equals(bookReview.getUuid())) {
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

			sb.append(_SQL_SELECT_BOOKREVIEW_WHERE);

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
				sb.append(BookReviewModelImpl.ORDER_BY_JPQL);
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

				list = (List<BookReview>)QueryUtil.list(
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
	 * Returns the first book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	@Override
	public BookReview findByUuid_First(
			String uuid, OrderByComparator<BookReview> orderByComparator)
		throws NoSuchBookReviewException {

		BookReview bookReview = fetchByUuid_First(uuid, orderByComparator);

		if (bookReview != null) {
			return bookReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBookReviewException(sb.toString());
	}

	/**
	 * Returns the first book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review, or <code>null</code> if a matching book review could not be found
	 */
	@Override
	public BookReview fetchByUuid_First(
		String uuid, OrderByComparator<BookReview> orderByComparator) {

		List<BookReview> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	@Override
	public BookReview findByUuid_Last(
			String uuid, OrderByComparator<BookReview> orderByComparator)
		throws NoSuchBookReviewException {

		BookReview bookReview = fetchByUuid_Last(uuid, orderByComparator);

		if (bookReview != null) {
			return bookReview;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBookReviewException(sb.toString());
	}

	/**
	 * Returns the last book review in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review, or <code>null</code> if a matching book review could not be found
	 */
	@Override
	public BookReview fetchByUuid_Last(
		String uuid, OrderByComparator<BookReview> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BookReview> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the book reviews before and after the current book review in the ordered set where uuid = &#63;.
	 *
	 * @param reviewId the primary key of the current book review
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next book review
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	@Override
	public BookReview[] findByUuid_PrevAndNext(
			long reviewId, String uuid,
			OrderByComparator<BookReview> orderByComparator)
		throws NoSuchBookReviewException {

		uuid = Objects.toString(uuid, "");

		BookReview bookReview = findByPrimaryKey(reviewId);

		Session session = null;

		try {
			session = openSession();

			BookReview[] array = new BookReviewImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, bookReview, uuid, orderByComparator, true);

			array[1] = bookReview;

			array[2] = getByUuid_PrevAndNext(
				session, bookReview, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookReview getByUuid_PrevAndNext(
		Session session, BookReview bookReview, String uuid,
		OrderByComparator<BookReview> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_BOOKREVIEW_WHERE);

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
			sb.append(BookReviewModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bookReview)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookReview> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book reviews where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BookReview bookReview :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(bookReview);
		}
	}

	/**
	 * Returns the number of book reviews where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching book reviews
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BOOKREVIEW_WHERE);

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
		"bookReview.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(bookReview.uuid IS NULL OR bookReview.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the book review where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBookReviewException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	@Override
	public BookReview findByUUID_G(String uuid, long groupId)
		throws NoSuchBookReviewException {

		BookReview bookReview = fetchByUUID_G(uuid, groupId);

		if (bookReview == null) {
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

			throw new NoSuchBookReviewException(sb.toString());
		}

		return bookReview;
	}

	/**
	 * Returns the book review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching book review, or <code>null</code> if a matching book review could not be found
	 */
	@Override
	public BookReview fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the book review where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching book review, or <code>null</code> if a matching book review could not be found
	 */
	@Override
	public BookReview fetchByUUID_G(
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

		if (result instanceof BookReview) {
			BookReview bookReview = (BookReview)result;

			if (!Objects.equals(uuid, bookReview.getUuid()) ||
				(groupId != bookReview.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BOOKREVIEW_WHERE);

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

				List<BookReview> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BookReview bookReview = list.get(0);

					result = bookReview;

					cacheResult(bookReview);
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
			return (BookReview)result;
		}
	}

	/**
	 * Removes the book review where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the book review that was removed
	 */
	@Override
	public BookReview removeByUUID_G(String uuid, long groupId)
		throws NoSuchBookReviewException {

		BookReview bookReview = findByUUID_G(uuid, groupId);

		return remove(bookReview);
	}

	/**
	 * Returns the number of book reviews where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching book reviews
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		BookReview bookReview = fetchByUUID_G(uuid, groupId);

		if (bookReview == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"bookReview.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(bookReview.uuid IS NULL OR bookReview.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"bookReview.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the book reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching book reviews
	 */
	@Override
	public List<BookReview> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BookReview> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

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
	@Override
	public List<BookReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookReview> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

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
	@Override
	public List<BookReview> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookReview> orderByComparator,
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

		List<BookReview> list = null;

		if (useFinderCache) {
			list = (List<BookReview>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BookReview bookReview : list) {
					if (!uuid.equals(bookReview.getUuid()) ||
						(companyId != bookReview.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BOOKREVIEW_WHERE);

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
				sb.append(BookReviewModelImpl.ORDER_BY_JPQL);
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

				list = (List<BookReview>)QueryUtil.list(
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
	 * Returns the first book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	@Override
	public BookReview findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BookReview> orderByComparator)
		throws NoSuchBookReviewException {

		BookReview bookReview = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (bookReview != null) {
			return bookReview;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBookReviewException(sb.toString());
	}

	/**
	 * Returns the first book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching book review, or <code>null</code> if a matching book review could not be found
	 */
	@Override
	public BookReview fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BookReview> orderByComparator) {

		List<BookReview> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review
	 * @throws NoSuchBookReviewException if a matching book review could not be found
	 */
	@Override
	public BookReview findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BookReview> orderByComparator)
		throws NoSuchBookReviewException {

		BookReview bookReview = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (bookReview != null) {
			return bookReview;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBookReviewException(sb.toString());
	}

	/**
	 * Returns the last book review in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching book review, or <code>null</code> if a matching book review could not be found
	 */
	@Override
	public BookReview fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BookReview> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BookReview> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public BookReview[] findByUuid_C_PrevAndNext(
			long reviewId, String uuid, long companyId,
			OrderByComparator<BookReview> orderByComparator)
		throws NoSuchBookReviewException {

		uuid = Objects.toString(uuid, "");

		BookReview bookReview = findByPrimaryKey(reviewId);

		Session session = null;

		try {
			session = openSession();

			BookReview[] array = new BookReviewImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, bookReview, uuid, companyId, orderByComparator, true);

			array[1] = bookReview;

			array[2] = getByUuid_C_PrevAndNext(
				session, bookReview, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected BookReview getByUuid_C_PrevAndNext(
		Session session, BookReview bookReview, String uuid, long companyId,
		OrderByComparator<BookReview> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_BOOKREVIEW_WHERE);

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
			sb.append(BookReviewModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(bookReview)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BookReview> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the book reviews where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BookReview bookReview :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(bookReview);
		}
	}

	/**
	 * Returns the number of book reviews where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching book reviews
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BOOKREVIEW_WHERE);

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
		"bookReview.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(bookReview.uuid IS NULL OR bookReview.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"bookReview.companyId = ?";

	public BookReviewPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("comment", "comment_");

		setDBColumnNames(dbColumnNames);

		setModelClass(BookReview.class);

		setModelImplClass(BookReviewImpl.class);
		setModelPKClass(long.class);

		setTable(BookReviewTable.INSTANCE);
	}

	/**
	 * Caches the book review in the entity cache if it is enabled.
	 *
	 * @param bookReview the book review
	 */
	@Override
	public void cacheResult(BookReview bookReview) {
		entityCache.putResult(
			BookReviewImpl.class, bookReview.getPrimaryKey(), bookReview);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {bookReview.getUuid(), bookReview.getGroupId()},
			bookReview);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the book reviews in the entity cache if it is enabled.
	 *
	 * @param bookReviews the book reviews
	 */
	@Override
	public void cacheResult(List<BookReview> bookReviews) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (bookReviews.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BookReview bookReview : bookReviews) {
			if (entityCache.getResult(
					BookReviewImpl.class, bookReview.getPrimaryKey()) == null) {

				cacheResult(bookReview);
			}
		}
	}

	/**
	 * Clears the cache for all book reviews.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BookReviewImpl.class);

		finderCache.clearCache(BookReviewImpl.class);
	}

	/**
	 * Clears the cache for the book review.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BookReview bookReview) {
		entityCache.removeResult(BookReviewImpl.class, bookReview);
	}

	@Override
	public void clearCache(List<BookReview> bookReviews) {
		for (BookReview bookReview : bookReviews) {
			entityCache.removeResult(BookReviewImpl.class, bookReview);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BookReviewImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(BookReviewImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BookReviewModelImpl bookReviewModelImpl) {

		Object[] args = new Object[] {
			bookReviewModelImpl.getUuid(), bookReviewModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathFetchByUUID_G, args, bookReviewModelImpl);
	}

	/**
	 * Creates a new book review with the primary key. Does not add the book review to the database.
	 *
	 * @param reviewId the primary key for the new book review
	 * @return the new book review
	 */
	@Override
	public BookReview create(long reviewId) {
		BookReview bookReview = new BookReviewImpl();

		bookReview.setNew(true);
		bookReview.setPrimaryKey(reviewId);

		String uuid = PortalUUIDUtil.generate();

		bookReview.setUuid(uuid);

		bookReview.setCompanyId(CompanyThreadLocal.getCompanyId());

		return bookReview;
	}

	/**
	 * Removes the book review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review that was removed
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	@Override
	public BookReview remove(long reviewId) throws NoSuchBookReviewException {
		return remove((Serializable)reviewId);
	}

	/**
	 * Removes the book review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the book review
	 * @return the book review that was removed
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	@Override
	public BookReview remove(Serializable primaryKey)
		throws NoSuchBookReviewException {

		Session session = null;

		try {
			session = openSession();

			BookReview bookReview = (BookReview)session.get(
				BookReviewImpl.class, primaryKey);

			if (bookReview == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBookReviewException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(bookReview);
		}
		catch (NoSuchBookReviewException noSuchEntityException) {
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
	protected BookReview removeImpl(BookReview bookReview) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(bookReview)) {
				bookReview = (BookReview)session.get(
					BookReviewImpl.class, bookReview.getPrimaryKeyObj());
			}

			if (bookReview != null) {
				session.delete(bookReview);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (bookReview != null) {
			clearCache(bookReview);
		}

		return bookReview;
	}

	@Override
	public BookReview updateImpl(BookReview bookReview) {
		boolean isNew = bookReview.isNew();

		if (!(bookReview instanceof BookReviewModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(bookReview.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(bookReview);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in bookReview proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BookReview implementation " +
					bookReview.getClass());
		}

		BookReviewModelImpl bookReviewModelImpl =
			(BookReviewModelImpl)bookReview;

		if (Validator.isNull(bookReview.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			bookReview.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (bookReview.getCreateDate() == null)) {
			if (serviceContext == null) {
				bookReview.setCreateDate(date);
			}
			else {
				bookReview.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!bookReviewModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				bookReview.setModifiedDate(date);
			}
			else {
				bookReview.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(bookReview);
			}
			else {
				bookReview = (BookReview)session.merge(bookReview);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BookReviewImpl.class, bookReviewModelImpl, false, true);

		cacheUniqueFindersCache(bookReviewModelImpl);

		if (isNew) {
			bookReview.setNew(false);
		}

		bookReview.resetOriginalValues();

		return bookReview;
	}

	/**
	 * Returns the book review with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the book review
	 * @return the book review
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	@Override
	public BookReview findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBookReviewException {

		BookReview bookReview = fetchByPrimaryKey(primaryKey);

		if (bookReview == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBookReviewException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return bookReview;
	}

	/**
	 * Returns the book review with the primary key or throws a <code>NoSuchBookReviewException</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review
	 * @throws NoSuchBookReviewException if a book review with the primary key could not be found
	 */
	@Override
	public BookReview findByPrimaryKey(long reviewId)
		throws NoSuchBookReviewException {

		return findByPrimaryKey((Serializable)reviewId);
	}

	/**
	 * Returns the book review with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review, or <code>null</code> if a book review with the primary key could not be found
	 */
	@Override
	public BookReview fetchByPrimaryKey(long reviewId) {
		return fetchByPrimaryKey((Serializable)reviewId);
	}

	/**
	 * Returns all the book reviews.
	 *
	 * @return the book reviews
	 */
	@Override
	public List<BookReview> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<BookReview> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<BookReview> findAll(
		int start, int end, OrderByComparator<BookReview> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<BookReview> findAll(
		int start, int end, OrderByComparator<BookReview> orderByComparator,
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

		List<BookReview> list = null;

		if (useFinderCache) {
			list = (List<BookReview>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BOOKREVIEW);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BOOKREVIEW;

				sql = sql.concat(BookReviewModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BookReview>)QueryUtil.list(
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
	 * Removes all the book reviews from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BookReview bookReview : findAll()) {
			remove(bookReview);
		}
	}

	/**
	 * Returns the number of book reviews.
	 *
	 * @return the number of book reviews
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_BOOKREVIEW);

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
		return _SQL_SELECT_BOOKREVIEW;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BookReviewModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the book review persistence.
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

		BookReviewUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		BookReviewUtil.setPersistence(null);

		entityCache.removeCache(BookReviewImpl.class.getName());
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

	private static final String _SQL_SELECT_BOOKREVIEW =
		"SELECT bookReview FROM BookReview bookReview";

	private static final String _SQL_SELECT_BOOKREVIEW_WHERE =
		"SELECT bookReview FROM BookReview bookReview WHERE ";

	private static final String _SQL_COUNT_BOOKREVIEW =
		"SELECT COUNT(bookReview) FROM BookReview bookReview";

	private static final String _SQL_COUNT_BOOKREVIEW_WHERE =
		"SELECT COUNT(bookReview) FROM BookReview bookReview WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "bookReview.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BookReview exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BookReview exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BookReviewPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "comment"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}