/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.service.persistence.test;

import com.ats.bank.exception.NoSuchbankException;
import com.ats.bank.model.bank;
import com.ats.bank.service.bankLocalServiceUtil;
import com.ats.bank.service.persistence.bankPersistence;
import com.ats.bank.service.persistence.bankUtil;

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
public class bankPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.ats.bank.service"));

	@Before
	public void setUp() {
		_persistence = bankUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<bank> iterator = _banks.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		bank bank = _persistence.create(pk);

		Assert.assertNotNull(bank);

		Assert.assertEquals(bank.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		bank newbank = addbank();

		_persistence.remove(newbank);

		bank existingbank = _persistence.fetchByPrimaryKey(
			newbank.getPrimaryKey());

		Assert.assertNull(existingbank);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addbank();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		bank newbank = _persistence.create(pk);

		newbank.setUuid(RandomTestUtil.randomString());

		newbank.setGroupId(RandomTestUtil.nextLong());

		newbank.setCompanyId(RandomTestUtil.nextLong());

		newbank.setUserId(RandomTestUtil.nextLong());

		newbank.setUserName(RandomTestUtil.randomString());

		newbank.setCreateDate(RandomTestUtil.nextDate());

		newbank.setModifiedDate(RandomTestUtil.nextDate());

		newbank.setName(RandomTestUtil.randomString());

		newbank.setAddress(RandomTestUtil.randomString());

		_banks.add(_persistence.update(newbank));

		bank existingbank = _persistence.findByPrimaryKey(
			newbank.getPrimaryKey());

		Assert.assertEquals(existingbank.getUuid(), newbank.getUuid());
		Assert.assertEquals(existingbank.getBankId(), newbank.getBankId());
		Assert.assertEquals(existingbank.getGroupId(), newbank.getGroupId());
		Assert.assertEquals(
			existingbank.getCompanyId(), newbank.getCompanyId());
		Assert.assertEquals(existingbank.getUserId(), newbank.getUserId());
		Assert.assertEquals(existingbank.getUserName(), newbank.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingbank.getCreateDate()),
			Time.getShortTimestamp(newbank.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingbank.getModifiedDate()),
			Time.getShortTimestamp(newbank.getModifiedDate()));
		Assert.assertEquals(existingbank.getName(), newbank.getName());
		Assert.assertEquals(existingbank.getAddress(), newbank.getAddress());
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
		bank newbank = addbank();

		bank existingbank = _persistence.findByPrimaryKey(
			newbank.getPrimaryKey());

		Assert.assertEquals(existingbank, newbank);
	}

	@Test(expected = NoSuchbankException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<bank> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"practice_bank", "uuid", true, "bankId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "name", true, "address", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		bank newbank = addbank();

		bank existingbank = _persistence.fetchByPrimaryKey(
			newbank.getPrimaryKey());

		Assert.assertEquals(existingbank, newbank);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		bank missingbank = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingbank);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		bank newbank1 = addbank();
		bank newbank2 = addbank();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newbank1.getPrimaryKey());
		primaryKeys.add(newbank2.getPrimaryKey());

		Map<Serializable, bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, banks.size());
		Assert.assertEquals(newbank1, banks.get(newbank1.getPrimaryKey()));
		Assert.assertEquals(newbank2, banks.get(newbank2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(banks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		bank newbank = addbank();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newbank.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, banks.size());
		Assert.assertEquals(newbank, banks.get(newbank.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(banks.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		bank newbank = addbank();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newbank.getPrimaryKey());

		Map<Serializable, bank> banks = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, banks.size());
		Assert.assertEquals(newbank, banks.get(newbank.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			bankLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<bank>() {

				@Override
				public void performAction(bank bank) {
					Assert.assertNotNull(bank);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		bank newbank = addbank();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			bank.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bankId", newbank.getBankId()));

		List<bank> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		bank existingbank = result.get(0);

		Assert.assertEquals(existingbank, newbank);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			bank.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bankId", RandomTestUtil.nextLong()));

		List<bank> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		bank newbank = addbank();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			bank.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bankId"));

		Object newBankId = newbank.getBankId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("bankId", new Object[] {newBankId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingBankId = result.get(0);

		Assert.assertEquals(existingBankId, newBankId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			bank.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("bankId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"bankId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		bank newbank = addbank();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newbank.getPrimaryKey()));
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

		bank newbank = addbank();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			bank.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("bankId", newbank.getBankId()));

		List<bank> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(bank bank) {
		Assert.assertEquals(
			bank.getUuid(),
			ReflectionTestUtil.invoke(
				bank, "getColumnOriginalValue", new Class<?>[] {String.class},
				"uuid_"));
		Assert.assertEquals(
			Long.valueOf(bank.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				bank, "getColumnOriginalValue", new Class<?>[] {String.class},
				"groupId"));
	}

	protected bank addbank() throws Exception {
		long pk = RandomTestUtil.nextLong();

		bank bank = _persistence.create(pk);

		bank.setUuid(RandomTestUtil.randomString());

		bank.setGroupId(RandomTestUtil.nextLong());

		bank.setCompanyId(RandomTestUtil.nextLong());

		bank.setUserId(RandomTestUtil.nextLong());

		bank.setUserName(RandomTestUtil.randomString());

		bank.setCreateDate(RandomTestUtil.nextDate());

		bank.setModifiedDate(RandomTestUtil.nextDate());

		bank.setName(RandomTestUtil.randomString());

		bank.setAddress(RandomTestUtil.randomString());

		_banks.add(_persistence.update(bank));

		return bank;
	}

	private List<bank> _banks = new ArrayList<bank>();
	private bankPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}