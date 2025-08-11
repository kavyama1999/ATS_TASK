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

import library.db.exception.NoSuchbook_reviewException;
import library.db.model.book_review;
import library.db.service.book_reviewLocalServiceUtil;
import library.db.service.persistence.book_reviewPersistence;
import library.db.service.persistence.book_reviewUtil;

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
public class book_reviewPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "library.db.service"));

	@Before
	public void setUp() {
		_persistence = book_reviewUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<book_review> iterator = _book_reviews.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		book_review book_review = _persistence.create(pk);

		Assert.assertNotNull(book_review);

		Assert.assertEquals(book_review.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		book_review newbook_review = addbook_review();

		_persistence.remove(newbook_review);

		book_review existingbook_review = _persistence.fetchByPrimaryKey(
			newbook_review.getPrimaryKey());

		Assert.assertNull(existingbook_review);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addbook_review();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		book_review newbook_review = _persistence.create(pk);

		newbook_review.setUuid(RandomTestUtil.randomString());

		newbook_review.setGroupId(RandomTestUtil.nextLong());

		newbook_review.setCompanyId(RandomTestUtil.nextLong());

		newbook_review.setUserId(RandomTestUtil.nextLong());

		newbook_review.setUserName(RandomTestUtil.randomString());

		newbook_review.setCreateDate(RandomTestUtil.nextDate());

		newbook_review.setModifiedDate(RandomTestUtil.nextDate());

		newbook_review.setLibId(RandomTestUtil.nextLong());

		newbook_review.setReviewerName(RandomTestUtil.randomString());

		newbook_review.setReviewDate(RandomTestUtil.nextDate());

		newbook_review.setRating(RandomTestUtil.nextInt());

		newbook_review.setComment(RandomTestUtil.randomString());

		newbook_review.setApproved(RandomTestUtil.randomBoolean());

		_book_reviews.add(_persistence.update(newbook_review));

		book_review existingbook_review = _persistence.findByPrimaryKey(
			newbook_review.getPrimaryKey());

		Assert.assertEquals(
			existingbook_review.getUuid(), newbook_review.getUuid());
		Assert.assertEquals(
			existingbook_review.getReviewId(), newbook_review.getReviewId());
		Assert.assertEquals(
			existingbook_review.getGroupId(), newbook_review.getGroupId());
		Assert.assertEquals(
			existingbook_review.getCompanyId(), newbook_review.getCompanyId());
		Assert.assertEquals(
			existingbook_review.getUserId(), newbook_review.getUserId());
		Assert.assertEquals(
			existingbook_review.getUserName(), newbook_review.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingbook_review.getCreateDate()),
			Time.getShortTimestamp(newbook_review.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingbook_review.getModifiedDate()),
			Time.getShortTimestamp(newbook_review.getModifiedDate()));
		Assert.assertEquals(
			existingbook_review.getLibId(), newbook_review.getLibId());
		Assert.assertEquals(
			existingbook_review.getReviewerName(),
			newbook_review.getReviewerName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingbook_review.getReviewDate()),
			Time.getShortTimestamp(newbook_review.getReviewDate()));
		Assert.assertEquals(
			existingbook_review.getRating(), newbook_review.getRating());
		Assert.assertEquals(
			existingbook_review.getComment(), newbook_review.getComment());
		Assert.assertEquals(
			existingbook_review.isApproved(), newbook_review.isApproved());
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
	public void testCountByLibId() throws Exception {
		_persistence.countByLibId(RandomTestUtil.nextLong());

		_persistence.countByLibId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		book_review newbook_review = addbook_review();

		book_review existingbook_review = _persistence.findByPrimaryKey(
			newbook_review.getPrimaryKey());

		Assert.assertEquals(existingbook_review, newbook_review);
	}

	@Test(expected = NoSuchbook_reviewException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<book_review> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"lib_book_review", "uuid", true, "reviewId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "libId", true, "reviewerName", true,
			"reviewDate", true, "rating", true, "comment", true, "approved",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		book_review newbook_review = addbook_review();

		book_review existingbook_review = _persistence.fetchByPrimaryKey(
			newbook_review.getPrimaryKey());

		Assert.assertEquals(existingbook_review, newbook_review);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		book_review missingbook_review = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingbook_review);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		book_review newbook_review1 = addbook_review();
		book_review newbook_review2 = addbook_review();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newbook_review1.getPrimaryKey());
		primaryKeys.add(newbook_review2.getPrimaryKey());

		Map<Serializable, book_review> book_reviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, book_reviews.size());
		Assert.assertEquals(
			newbook_review1, book_reviews.get(newbook_review1.getPrimaryKey()));
		Assert.assertEquals(
			newbook_review2, book_reviews.get(newbook_review2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, book_review> book_reviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(book_reviews.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		book_review newbook_review = addbook_review();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newbook_review.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, book_review> book_reviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, book_reviews.size());
		Assert.assertEquals(
			newbook_review, book_reviews.get(newbook_review.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, book_review> book_reviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(book_reviews.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		book_review newbook_review = addbook_review();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newbook_review.getPrimaryKey());

		Map<Serializable, book_review> book_reviews =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, book_reviews.size());
		Assert.assertEquals(
			newbook_review, book_reviews.get(newbook_review.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			book_reviewLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<book_review>() {

				@Override
				public void performAction(book_review book_review) {
					Assert.assertNotNull(book_review);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		book_review newbook_review = addbook_review();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			book_review.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"reviewId", newbook_review.getReviewId()));

		List<book_review> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		book_review existingbook_review = result.get(0);

		Assert.assertEquals(existingbook_review, newbook_review);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			book_review.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("reviewId", RandomTestUtil.nextLong()));

		List<book_review> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		book_review newbook_review = addbook_review();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			book_review.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("reviewId"));

		Object newReviewId = newbook_review.getReviewId();

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
			book_review.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("reviewId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"reviewId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		book_review newbook_review = addbook_review();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newbook_review.getPrimaryKey()));
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

		book_review newbook_review = addbook_review();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			book_review.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"reviewId", newbook_review.getReviewId()));

		List<book_review> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(book_review book_review) {
		Assert.assertEquals(
			book_review.getUuid(),
			ReflectionTestUtil.invoke(
				book_review, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(book_review.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				book_review, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected book_review addbook_review() throws Exception {
		long pk = RandomTestUtil.nextLong();

		book_review book_review = _persistence.create(pk);

		book_review.setUuid(RandomTestUtil.randomString());

		book_review.setGroupId(RandomTestUtil.nextLong());

		book_review.setCompanyId(RandomTestUtil.nextLong());

		book_review.setUserId(RandomTestUtil.nextLong());

		book_review.setUserName(RandomTestUtil.randomString());

		book_review.setCreateDate(RandomTestUtil.nextDate());

		book_review.setModifiedDate(RandomTestUtil.nextDate());

		book_review.setLibId(RandomTestUtil.nextLong());

		book_review.setReviewerName(RandomTestUtil.randomString());

		book_review.setReviewDate(RandomTestUtil.nextDate());

		book_review.setRating(RandomTestUtil.nextInt());

		book_review.setComment(RandomTestUtil.randomString());

		book_review.setApproved(RandomTestUtil.randomBoolean());

		_book_reviews.add(_persistence.update(book_review));

		return book_review;
	}

	private List<book_review> _book_reviews = new ArrayList<book_review>();
	private book_reviewPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}