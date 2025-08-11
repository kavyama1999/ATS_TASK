/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import library.db.exception.NoSuchBookReviewException;
import library.db.model.BookReview;
import library.db.service.BookReviewLocalServiceUtil;
import library.db.service.persistence.BookReviewPersistence;
import library.db.service.persistence.BookReviewUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class BookReviewPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "library.db.service"));

	@Before
	public void setUp() {
		_persistence = BookReviewUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<BookReview> iterator = _bookReviews.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookReview bookReview = _persistence.create(pk);

		Assert.assertNotNull(bookReview);

		Assert.assertEquals(bookReview.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		BookReview newBookReview = addBookReview();

		_persistence.remove(newBookReview);

		BookReview existingBookReview = _persistence.fetchByPrimaryKey(
			newBookReview.getPrimaryKey());

		Assert.assertNull(existingBookReview);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addBookReview();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookReview newBookReview = _persistence.create(pk);

		newBookReview.setUuid(RandomTestUtil.randomString());

		newBookReview.setGroupId(RandomTestUtil.nextLong());

		newBookReview.setCompanyId(RandomTestUtil.nextLong());

		newBookReview.setUserId(RandomTestUtil.nextLong());

		newBookReview.setUserName(RandomTestUtil.randomString());

		newBookReview.setCreateDate(RandomTestUtil.nextDate());

		newBookReview.setModifiedDate(RandomTestUtil.nextDate());

		newBookReview.setLibId(RandomTestUtil.nextLong());

		newBookReview.setReviewerName(RandomTestUtil.randomString());

		newBookReview.setReviewDate(RandomTestUtil.nextDate());

		newBookReview.setRating(RandomTestUtil.nextInt());

		newBookReview.setComment(RandomTestUtil.randomString());

		newBookReview.setApproved(RandomTestUtil.randomBoolean());

		_bookReviews.add(_persistence.update(newBookReview));

		BookReview existingBookReview = _persistence.findByPrimaryKey(
			newBookReview.getPrimaryKey());

		Assert.assertEquals(
			existingBookReview.getUuid(), newBookReview.getUuid());
		Assert.assertEquals(
			existingBookReview.getReviewId(), newBookReview.getReviewId());
		Assert.assertEquals(
			existingBookReview.getGroupId(), newBookReview.getGroupId());
		Assert.assertEquals(
			existingBookReview.getCompanyId(), newBookReview.getCompanyId());
		Assert.assertEquals(
			existingBookReview.getUserId(), newBookReview.getUserId());
		Assert.assertEquals(
			existingBookReview.getUserName(), newBookReview.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBookReview.getCreateDate()),
			Time.getShortTimestamp(newBookReview.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingBookReview.getModifiedDate()),
			Time.getShortTimestamp(newBookReview.getModifiedDate()));
		Assert.assertEquals(
			existingBookReview.getLibId(), newBookReview.getLibId());
		Assert.assertEquals(
			existingBookReview.getReviewerName(),
			newBookReview.getReviewerName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingBookReview.getReviewDate()),
			Time.getShortTimestamp(newBookReview.getReviewDate()));
		Assert.assertEquals(
			existingBookReview.getRating(), newBookReview.getRating());
		Assert.assertEquals(
			existingBookReview.getComment(), newBookReview.getComment());
		Assert.assertEquals(
			existingBookReview.isApproved(), newBookReview.isApproved());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		BookReview newBookReview = addBookReview();

		BookReview existingBookReview = _persistence.findByPrimaryKey(
			newBookReview.getPrimaryKey());

		Assert.assertEquals(existingBookReview, newBookReview);
	}

	@Test(expected = NoSuchBookReviewException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<BookReview> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"lib_BookReview", "uuid", true, "reviewId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "libId", true, "reviewerName", true,
			"reviewDate", true, "rating", true, "comment", true, "approved",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		BookReview newBookReview = addBookReview();

		BookReview existingBookReview = _persistence.fetchByPrimaryKey(
			newBookReview.getPrimaryKey());

		Assert.assertEquals(existingBookReview, newBookReview);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookReview missingBookReview = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingBookReview);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		BookReview newBookReview1 = addBookReview();
		BookReview newBookReview2 = addBookReview();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookReview1.getPrimaryKey());
		primaryKeys.add(newBookReview2.getPrimaryKey());

		Map<Serializable, BookReview> bookReviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, bookReviews.size());
		Assert.assertEquals(
			newBookReview1, bookReviews.get(newBookReview1.getPrimaryKey()));
		Assert.assertEquals(
			newBookReview2, bookReviews.get(newBookReview2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, BookReview> bookReviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bookReviews.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		BookReview newBookReview = addBookReview();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookReview.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, BookReview> bookReviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bookReviews.size());
		Assert.assertEquals(
			newBookReview, bookReviews.get(newBookReview.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, BookReview> bookReviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(bookReviews.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		BookReview newBookReview = addBookReview();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newBookReview.getPrimaryKey());

		Map<Serializable, BookReview> bookReviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, bookReviews.size());
		Assert.assertEquals(
			newBookReview, bookReviews.get(newBookReview.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			BookReviewLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<BookReview>() {

				@Override
				public void performAction(BookReview bookReview) {
					Assert.assertNotNull(bookReview);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		BookReview newBookReview = addBookReview();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookReview.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"reviewId", newBookReview.getReviewId()));

		List<BookReview> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		BookReview existingBookReview = result.get(0);

		Assert.assertEquals(existingBookReview, newBookReview);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookReview.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("reviewId", RandomTestUtil.nextLong()));

		List<BookReview> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		BookReview newBookReview = addBookReview();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookReview.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("reviewId"));

		Object newReviewId = newBookReview.getReviewId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("reviewId", new Object[] {newReviewId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingReviewId = result.get(0);

		Assert.assertEquals(existingReviewId, newReviewId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookReview.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("reviewId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"reviewId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		BookReview newBookReview = addBookReview();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newBookReview.getPrimaryKey()));
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromDatabase()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(true);
	}

	@Test
	public void testResetOriginalValuesWithDynamicQueryLoadFromSession()
		throws Exception {

		_testResetOriginalValuesWithDynamicQuery(false);
	}

	private void _testResetOriginalValuesWithDynamicQuery(boolean clearSession)
		throws Exception {

		BookReview newBookReview = addBookReview();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			BookReview.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"reviewId", newBookReview.getReviewId()));

		List<BookReview> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(BookReview bookReview) {
		Assert.assertEquals(
			bookReview.getUuid(),
			ReflectionTestUtil.invoke(
				bookReview, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(bookReview.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				bookReview, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected BookReview addBookReview() throws Exception {
		long pk = RandomTestUtil.nextLong();

		BookReview bookReview = _persistence.create(pk);

		bookReview.setUuid(RandomTestUtil.randomString());

		bookReview.setGroupId(RandomTestUtil.nextLong());

		bookReview.setCompanyId(RandomTestUtil.nextLong());

		bookReview.setUserId(RandomTestUtil.nextLong());

		bookReview.setUserName(RandomTestUtil.randomString());

		bookReview.setCreateDate(RandomTestUtil.nextDate());

		bookReview.setModifiedDate(RandomTestUtil.nextDate());

		bookReview.setLibId(RandomTestUtil.nextLong());

		bookReview.setReviewerName(RandomTestUtil.randomString());

		bookReview.setReviewDate(RandomTestUtil.nextDate());

		bookReview.setRating(RandomTestUtil.nextInt());

		bookReview.setComment(RandomTestUtil.randomString());

		bookReview.setApproved(RandomTestUtil.randomBoolean());

		_bookReviews.add(_persistence.update(bookReview));

		return bookReview;
	}

	private List<BookReview> _bookReviews = new ArrayList<BookReview>();
	private BookReviewPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}