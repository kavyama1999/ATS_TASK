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

import library.db.exception.NoSuchrary_booksException;
import library.db.model.library_books;
import library.db.service.library_booksLocalServiceUtil;
import library.db.service.persistence.library_booksPersistence;
import library.db.service.persistence.library_booksUtil;

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
public class library_booksPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "library.db.service"));

	@Before
	public void setUp() {
		_persistence = library_booksUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<library_books> iterator = _library_bookses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		library_books library_books = _persistence.create(pk);

		Assert.assertNotNull(library_books);

		Assert.assertEquals(library_books.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		library_books newlibrary_books = addlibrary_books();

		_persistence.remove(newlibrary_books);

		library_books existinglibrary_books = _persistence.fetchByPrimaryKey(
			newlibrary_books.getPrimaryKey());

		Assert.assertNull(existinglibrary_books);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addlibrary_books();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		library_books newlibrary_books = _persistence.create(pk);

		newlibrary_books.setUuid(RandomTestUtil.randomString());

		newlibrary_books.setGroupId(RandomTestUtil.nextLong());

		newlibrary_books.setCompanyId(RandomTestUtil.nextLong());

		newlibrary_books.setUserId(RandomTestUtil.nextLong());

		newlibrary_books.setUserName(RandomTestUtil.randomString());

		newlibrary_books.setCreateDate(RandomTestUtil.nextDate());

		newlibrary_books.setModifiedDate(RandomTestUtil.nextDate());

		newlibrary_books.setBook_name(RandomTestUtil.randomString());

		newlibrary_books.setAuthor(RandomTestUtil.randomString());

		newlibrary_books.setTitle(RandomTestUtil.nextInt());

		newlibrary_books.setPublisherd_year(RandomTestUtil.nextInt());

		newlibrary_books.setCategory(RandomTestUtil.randomString());

		_library_bookses.add(_persistence.update(newlibrary_books));

		library_books existinglibrary_books = _persistence.findByPrimaryKey(
			newlibrary_books.getPrimaryKey());

		Assert.assertEquals(
			existinglibrary_books.getUuid(), newlibrary_books.getUuid());
		Assert.assertEquals(
			existinglibrary_books.getLibId(), newlibrary_books.getLibId());
		Assert.assertEquals(
			existinglibrary_books.getGroupId(), newlibrary_books.getGroupId());
		Assert.assertEquals(
			existinglibrary_books.getCompanyId(),
			newlibrary_books.getCompanyId());
		Assert.assertEquals(
			existinglibrary_books.getUserId(), newlibrary_books.getUserId());
		Assert.assertEquals(
			existinglibrary_books.getUserName(),
			newlibrary_books.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existinglibrary_books.getCreateDate()),
			Time.getShortTimestamp(newlibrary_books.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existinglibrary_books.getModifiedDate()),
			Time.getShortTimestamp(newlibrary_books.getModifiedDate()));
		Assert.assertEquals(
			existinglibrary_books.getBook_name(),
			newlibrary_books.getBook_name());
		Assert.assertEquals(
			existinglibrary_books.getAuthor(), newlibrary_books.getAuthor());
		Assert.assertEquals(
			existinglibrary_books.getTitle(), newlibrary_books.getTitle());
		Assert.assertEquals(
			existinglibrary_books.getPublisherd_year(),
			newlibrary_books.getPublisherd_year());
		Assert.assertEquals(
			existinglibrary_books.getCategory(),
			newlibrary_books.getCategory());
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
	public void testCountByGroupId() throws Exception {
		_persistence.countByGroupId(RandomTestUtil.nextLong());

		_persistence.countByGroupId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		library_books newlibrary_books = addlibrary_books();

		library_books existinglibrary_books = _persistence.findByPrimaryKey(
			newlibrary_books.getPrimaryKey());

		Assert.assertEquals(existinglibrary_books, newlibrary_books);
	}

	@Test(expected = NoSuchrary_booksException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<library_books> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"lib_library_books", "uuid", true, "libId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "book_name", true, "author", true,
			"title", true, "publisherd_year", true, "category", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		library_books newlibrary_books = addlibrary_books();

		library_books existinglibrary_books = _persistence.fetchByPrimaryKey(
			newlibrary_books.getPrimaryKey());

		Assert.assertEquals(existinglibrary_books, newlibrary_books);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		library_books missinglibrary_books = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missinglibrary_books);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		library_books newlibrary_books1 = addlibrary_books();
		library_books newlibrary_books2 = addlibrary_books();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newlibrary_books1.getPrimaryKey());
		primaryKeys.add(newlibrary_books2.getPrimaryKey());

		Map<Serializable, library_books> library_bookses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, library_bookses.size());
		Assert.assertEquals(
			newlibrary_books1,
			library_bookses.get(newlibrary_books1.getPrimaryKey()));
		Assert.assertEquals(
			newlibrary_books2,
			library_bookses.get(newlibrary_books2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, library_books> library_bookses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(library_bookses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		library_books newlibrary_books = addlibrary_books();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newlibrary_books.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, library_books> library_bookses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, library_bookses.size());
		Assert.assertEquals(
			newlibrary_books,
			library_bookses.get(newlibrary_books.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, library_books> library_bookses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(library_bookses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		library_books newlibrary_books = addlibrary_books();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newlibrary_books.getPrimaryKey());

		Map<Serializable, library_books> library_bookses =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, library_bookses.size());
		Assert.assertEquals(
			newlibrary_books,
			library_bookses.get(newlibrary_books.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			library_booksLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<library_books>() {

				@Override
				public void performAction(library_books library_books) {
					Assert.assertNotNull(library_books);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		library_books newlibrary_books = addlibrary_books();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			library_books.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("libId", newlibrary_books.getLibId()));

		List<library_books> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		library_books existinglibrary_books = result.get(0);

		Assert.assertEquals(existinglibrary_books, newlibrary_books);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			library_books.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("libId", RandomTestUtil.nextLong()));

		List<library_books> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		library_books newlibrary_books = addlibrary_books();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			library_books.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("libId"));

		Object newLibId = newlibrary_books.getLibId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("libId", new Object[] {newLibId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLibId = result.get(0);

		Assert.assertEquals(existingLibId, newLibId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			library_books.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("libId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"libId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		library_books newlibrary_books = addlibrary_books();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newlibrary_books.getPrimaryKey()));
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

		library_books newlibrary_books = addlibrary_books();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			library_books.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("libId", newlibrary_books.getLibId()));

		List<library_books> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(library_books library_books) {
		Assert.assertEquals(
			library_books.getUuid(),
			ReflectionTestUtil.invoke(
				library_books, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(library_books.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				library_books, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected library_books addlibrary_books() throws Exception {
		long pk = RandomTestUtil.nextLong();

		library_books library_books = _persistence.create(pk);

		library_books.setUuid(RandomTestUtil.randomString());

		library_books.setGroupId(RandomTestUtil.nextLong());

		library_books.setCompanyId(RandomTestUtil.nextLong());

		library_books.setUserId(RandomTestUtil.nextLong());

		library_books.setUserName(RandomTestUtil.randomString());

		library_books.setCreateDate(RandomTestUtil.nextDate());

		library_books.setModifiedDate(RandomTestUtil.nextDate());

		library_books.setBook_name(RandomTestUtil.randomString());

		library_books.setAuthor(RandomTestUtil.randomString());

		library_books.setTitle(RandomTestUtil.nextInt());

		library_books.setPublisherd_year(RandomTestUtil.nextInt());

		library_books.setCategory(RandomTestUtil.randomString());

		_library_bookses.add(_persistence.update(library_books));

		return library_books;
	}

	private List<library_books> _library_bookses =
		new ArrayList<library_books>();
	private library_booksPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}