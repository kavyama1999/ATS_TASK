/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.service.persistence.test;

import checkIndb3.exception.NoSuchcheckException;

import checkIndb3.model.check;

import checkIndb3.service.checkLocalServiceUtil;
import checkIndb3.service.persistence.checkPersistence;
import checkIndb3.service.persistence.checkUtil;

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
public class checkPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "checkIndb3.service"));

	@Before
	public void setUp() {
		_persistence = checkUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<check> iterator = _checks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		check check = _persistence.create(pk);

		Assert.assertNotNull(check);

		Assert.assertEquals(check.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		check newcheck = addcheck();

		_persistence.remove(newcheck);

		check existingcheck = _persistence.fetchByPrimaryKey(
			newcheck.getPrimaryKey());

		Assert.assertNull(existingcheck);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addcheck();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		check newcheck = _persistence.create(pk);

		newcheck.setUuid(RandomTestUtil.randomString());

		newcheck.setGroupId(RandomTestUtil.nextLong());

		newcheck.setCompanyId(RandomTestUtil.nextLong());

		newcheck.setUserId(RandomTestUtil.nextLong());

		newcheck.setUserName(RandomTestUtil.randomString());

		newcheck.setCreateDate(RandomTestUtil.nextDate());

		newcheck.setModifiedDate(RandomTestUtil.nextDate());

		newcheck.setDate(RandomTestUtil.nextDate());

		newcheck.setDay(RandomTestUtil.randomString());

		newcheck.setCheckInTime(RandomTestUtil.nextDate());

		newcheck.setCheckOutTime(RandomTestUtil.nextDate());

		newcheck.setTotalHours(RandomTestUtil.randomString());

		newcheck.setCreatedAt(RandomTestUtil.nextDate());

		_checks.add(_persistence.update(newcheck));

		check existingcheck = _persistence.findByPrimaryKey(
			newcheck.getPrimaryKey());

		Assert.assertEquals(existingcheck.getUuid(), newcheck.getUuid());
		Assert.assertEquals(
			existingcheck.getCheckInId(), newcheck.getCheckInId());
		Assert.assertEquals(existingcheck.getGroupId(), newcheck.getGroupId());
		Assert.assertEquals(
			existingcheck.getCompanyId(), newcheck.getCompanyId());
		Assert.assertEquals(existingcheck.getUserId(), newcheck.getUserId());
		Assert.assertEquals(
			existingcheck.getUserName(), newcheck.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingcheck.getCreateDate()),
			Time.getShortTimestamp(newcheck.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingcheck.getModifiedDate()),
			Time.getShortTimestamp(newcheck.getModifiedDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingcheck.getDate()),
			Time.getShortTimestamp(newcheck.getDate()));
		Assert.assertEquals(existingcheck.getDay(), newcheck.getDay());
		Assert.assertEquals(
			Time.getShortTimestamp(existingcheck.getCheckInTime()),
			Time.getShortTimestamp(newcheck.getCheckInTime()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingcheck.getCheckOutTime()),
			Time.getShortTimestamp(newcheck.getCheckOutTime()));
		Assert.assertEquals(
			existingcheck.getTotalHours(), newcheck.getTotalHours());
		Assert.assertEquals(
			Time.getShortTimestamp(existingcheck.getCreatedAt()),
			Time.getShortTimestamp(newcheck.getCreatedAt()));
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
		check newcheck = addcheck();

		check existingcheck = _persistence.findByPrimaryKey(
			newcheck.getPrimaryKey());

		Assert.assertEquals(existingcheck, newcheck);
	}

	@Test(expected = NoSuchcheckException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<check> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"practice_check", "uuid", true, "checkInId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "date", true, "day", true,
			"checkInTime", true, "checkOutTime", true, "totalHours", true,
			"createdAt", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		check newcheck = addcheck();

		check existingcheck = _persistence.fetchByPrimaryKey(
			newcheck.getPrimaryKey());

		Assert.assertEquals(existingcheck, newcheck);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		check missingcheck = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingcheck);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		check newcheck1 = addcheck();
		check newcheck2 = addcheck();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newcheck1.getPrimaryKey());
		primaryKeys.add(newcheck2.getPrimaryKey());

		Map<Serializable, check> checks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, checks.size());
		Assert.assertEquals(newcheck1, checks.get(newcheck1.getPrimaryKey()));
		Assert.assertEquals(newcheck2, checks.get(newcheck2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, check> checks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(checks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		check newcheck = addcheck();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newcheck.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, check> checks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, checks.size());
		Assert.assertEquals(newcheck, checks.get(newcheck.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, check> checks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(checks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		check newcheck = addcheck();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newcheck.getPrimaryKey());

		Map<Serializable, check> checks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, checks.size());
		Assert.assertEquals(newcheck, checks.get(newcheck.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			checkLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<check>() {

				@Override
				public void performAction(check check) {
					Assert.assertNotNull(check);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		check newcheck = addcheck();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			check.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("checkInId", newcheck.getCheckInId()));

		List<check> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		check existingcheck = result.get(0);

		Assert.assertEquals(existingcheck, newcheck);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			check.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("checkInId", RandomTestUtil.nextLong()));

		List<check> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		check newcheck = addcheck();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			check.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("checkInId"));

		Object newCheckInId = newcheck.getCheckInId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"checkInId", new Object[] {newCheckInId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCheckInId = result.get(0);

		Assert.assertEquals(existingCheckInId, newCheckInId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			check.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("checkInId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"checkInId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		check newcheck = addcheck();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newcheck.getPrimaryKey()));
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

		check newcheck = addcheck();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			check.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("checkInId", newcheck.getCheckInId()));

		List<check> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(check check) {
		Assert.assertEquals(
			check.getUuid(),
			ReflectionTestUtil.invoke(
				check, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(check.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				check, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
	}

	protected check addcheck() throws Exception {
		long pk = RandomTestUtil.nextLong();

		check check = _persistence.create(pk);

		check.setUuid(RandomTestUtil.randomString());

		check.setGroupId(RandomTestUtil.nextLong());

		check.setCompanyId(RandomTestUtil.nextLong());

		check.setUserId(RandomTestUtil.nextLong());

		check.setUserName(RandomTestUtil.randomString());

		check.setCreateDate(RandomTestUtil.nextDate());

		check.setModifiedDate(RandomTestUtil.nextDate());

		check.setDate(RandomTestUtil.nextDate());

		check.setDay(RandomTestUtil.randomString());

		check.setCheckInTime(RandomTestUtil.nextDate());

		check.setCheckOutTime(RandomTestUtil.nextDate());

		check.setTotalHours(RandomTestUtil.randomString());

		check.setCreatedAt(RandomTestUtil.nextDate());

		_checks.add(_persistence.update(check));

		return check;
	}

	private List<check> _checks = new ArrayList<check>();
	private checkPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}