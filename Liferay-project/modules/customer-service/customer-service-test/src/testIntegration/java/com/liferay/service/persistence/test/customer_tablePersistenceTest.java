/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.exception.NoSuchcustomer_tableException;
import com.liferay.model.customer_table;
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
import com.liferay.service.customer_tableLocalServiceUtil;
import com.liferay.service.persistence.customer_tablePersistence;
import com.liferay.service.persistence.customer_tableUtil;

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
public class customer_tablePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.service"));

	@Before
	public void setUp() {
		_persistence = customer_tableUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<customer_table> iterator = _customer_tables.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		customer_table customer_table = _persistence.create(pk);

		Assert.assertNotNull(customer_table);

		Assert.assertEquals(customer_table.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		customer_table newcustomer_table = addcustomer_table();

		_persistence.remove(newcustomer_table);

		customer_table existingcustomer_table = _persistence.fetchByPrimaryKey(
			newcustomer_table.getPrimaryKey());

		Assert.assertNull(existingcustomer_table);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addcustomer_table();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		customer_table newcustomer_table = _persistence.create(pk);

		newcustomer_table.setUuid(RandomTestUtil.randomString());

		newcustomer_table.setGroupId(RandomTestUtil.nextLong());

		newcustomer_table.setCompanyId(RandomTestUtil.nextLong());

		newcustomer_table.setUserId(RandomTestUtil.nextLong());

		newcustomer_table.setUserName(RandomTestUtil.randomString());

		newcustomer_table.setCreateDate(RandomTestUtil.nextDate());

		newcustomer_table.setModifiedDate(RandomTestUtil.nextDate());

		newcustomer_table.setCustName(RandomTestUtil.randomString());

		newcustomer_table.setAge(RandomTestUtil.randomString());

		newcustomer_table.setSalary(RandomTestUtil.nextLong());

		newcustomer_table.setGender(RandomTestUtil.randomString());

		newcustomer_table.setAddress(RandomTestUtil.randomString());

		_customer_tables.add(_persistence.update(newcustomer_table));

		customer_table existingcustomer_table = _persistence.findByPrimaryKey(
			newcustomer_table.getPrimaryKey());

		Assert.assertEquals(
			existingcustomer_table.getUuid(), newcustomer_table.getUuid());
		Assert.assertEquals(
			existingcustomer_table.getCustId(), newcustomer_table.getCustId());
		Assert.assertEquals(
			existingcustomer_table.getGroupId(),
			newcustomer_table.getGroupId());
		Assert.assertEquals(
			existingcustomer_table.getCompanyId(),
			newcustomer_table.getCompanyId());
		Assert.assertEquals(
			existingcustomer_table.getUserId(), newcustomer_table.getUserId());
		Assert.assertEquals(
			existingcustomer_table.getUserName(),
			newcustomer_table.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingcustomer_table.getCreateDate()),
			Time.getShortTimestamp(newcustomer_table.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingcustomer_table.getModifiedDate()),
			Time.getShortTimestamp(newcustomer_table.getModifiedDate()));
		Assert.assertEquals(
			existingcustomer_table.getCustName(),
			newcustomer_table.getCustName());
		Assert.assertEquals(
			existingcustomer_table.getAge(), newcustomer_table.getAge());
		Assert.assertEquals(
			existingcustomer_table.getSalary(), newcustomer_table.getSalary());
		Assert.assertEquals(
			existingcustomer_table.getGender(), newcustomer_table.getGender());
		Assert.assertEquals(
			existingcustomer_table.getAddress(),
			newcustomer_table.getAddress());
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
		customer_table newcustomer_table = addcustomer_table();

		customer_table existingcustomer_table = _persistence.findByPrimaryKey(
			newcustomer_table.getPrimaryKey());

		Assert.assertEquals(existingcustomer_table, newcustomer_table);
	}

	@Test(expected = NoSuchcustomer_tableException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<customer_table> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"FOO_customer_table", "uuid", true, "custId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "custName", true, "age", true, "salary",
			true, "gender", true, "address", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		customer_table newcustomer_table = addcustomer_table();

		customer_table existingcustomer_table = _persistence.fetchByPrimaryKey(
			newcustomer_table.getPrimaryKey());

		Assert.assertEquals(existingcustomer_table, newcustomer_table);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		customer_table missingcustomer_table = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingcustomer_table);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		customer_table newcustomer_table1 = addcustomer_table();
		customer_table newcustomer_table2 = addcustomer_table();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newcustomer_table1.getPrimaryKey());
		primaryKeys.add(newcustomer_table2.getPrimaryKey());

		Map<Serializable, customer_table> customer_tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, customer_tables.size());
		Assert.assertEquals(
			newcustomer_table1,
			customer_tables.get(newcustomer_table1.getPrimaryKey()));
		Assert.assertEquals(
			newcustomer_table2,
			customer_tables.get(newcustomer_table2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, customer_table> customer_tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(customer_tables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		customer_table newcustomer_table = addcustomer_table();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newcustomer_table.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, customer_table> customer_tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, customer_tables.size());
		Assert.assertEquals(
			newcustomer_table,
			customer_tables.get(newcustomer_table.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, customer_table> customer_tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(customer_tables.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		customer_table newcustomer_table = addcustomer_table();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newcustomer_table.getPrimaryKey());

		Map<Serializable, customer_table> customer_tables =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, customer_tables.size());
		Assert.assertEquals(
			newcustomer_table,
			customer_tables.get(newcustomer_table.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			customer_tableLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<customer_table>() {

				@Override
				public void performAction(customer_table customer_table) {
					Assert.assertNotNull(customer_table);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		customer_table newcustomer_table = addcustomer_table();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			customer_table.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"custId", newcustomer_table.getCustId()));

		List<customer_table> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		customer_table existingcustomer_table = result.get(0);

		Assert.assertEquals(existingcustomer_table, newcustomer_table);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			customer_table.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("custId", RandomTestUtil.nextLong()));

		List<customer_table> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		customer_table newcustomer_table = addcustomer_table();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			customer_table.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("custId"));

		Object newCustId = newcustomer_table.getCustId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("custId", new Object[] {newCustId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCustId = result.get(0);

		Assert.assertEquals(existingCustId, newCustId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			customer_table.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("custId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"custId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		customer_table newcustomer_table = addcustomer_table();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newcustomer_table.getPrimaryKey()));
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

		customer_table newcustomer_table = addcustomer_table();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			customer_table.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"custId", newcustomer_table.getCustId()));

		List<customer_table> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(customer_table customer_table) {
		Assert.assertEquals(
			customer_table.getUuid(),
			ReflectionTestUtil.invoke(
				customer_table, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(customer_table.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				customer_table, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected customer_table addcustomer_table() throws Exception {
		long pk = RandomTestUtil.nextLong();

		customer_table customer_table = _persistence.create(pk);

		customer_table.setUuid(RandomTestUtil.randomString());

		customer_table.setGroupId(RandomTestUtil.nextLong());

		customer_table.setCompanyId(RandomTestUtil.nextLong());

		customer_table.setUserId(RandomTestUtil.nextLong());

		customer_table.setUserName(RandomTestUtil.randomString());

		customer_table.setCreateDate(RandomTestUtil.nextDate());

		customer_table.setModifiedDate(RandomTestUtil.nextDate());

		customer_table.setCustName(RandomTestUtil.randomString());

		customer_table.setAge(RandomTestUtil.randomString());

		customer_table.setSalary(RandomTestUtil.nextLong());

		customer_table.setGender(RandomTestUtil.randomString());

		customer_table.setAddress(RandomTestUtil.randomString());

		_customer_tables.add(_persistence.update(customer_table));

		return customer_table;
	}

	private List<customer_table> _customer_tables =
		new ArrayList<customer_table>();
	private customer_tablePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}