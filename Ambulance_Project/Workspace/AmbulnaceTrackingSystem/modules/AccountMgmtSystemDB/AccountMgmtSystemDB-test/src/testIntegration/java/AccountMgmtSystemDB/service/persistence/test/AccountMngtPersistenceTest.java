/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.service.persistence.test;

import AccountMgmtSystemDB.exception.NoSuchMngtException;

import AccountMgmtSystemDB.model.AccountMngt;

import AccountMgmtSystemDB.service.AccountMngtLocalServiceUtil;
import AccountMgmtSystemDB.service.persistence.AccountMngtPersistence;
import AccountMgmtSystemDB.service.persistence.AccountMngtUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.test.AssertUtils;
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
public class AccountMngtPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "AccountMgmtSystemDB.service"));

	@Before
	public void setUp() {
		_persistence = AccountMngtUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AccountMngt> iterator = _accountMngts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AccountMngt accountMngt = _persistence.create(pk);

		Assert.assertNotNull(accountMngt);

		Assert.assertEquals(accountMngt.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AccountMngt newAccountMngt = addAccountMngt();

		_persistence.remove(newAccountMngt);

		AccountMngt existingAccountMngt = _persistence.fetchByPrimaryKey(
			newAccountMngt.getPrimaryKey());

		Assert.assertNull(existingAccountMngt);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAccountMngt();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AccountMngt newAccountMngt = _persistence.create(pk);

		newAccountMngt.setUuid(RandomTestUtil.randomString());

		newAccountMngt.setGroupId(RandomTestUtil.nextLong());

		newAccountMngt.setCompanyId(RandomTestUtil.nextLong());

		newAccountMngt.setUserId(RandomTestUtil.nextLong());

		newAccountMngt.setUserName(RandomTestUtil.randomString());

		newAccountMngt.setCreateDate(RandomTestUtil.nextDate());

		newAccountMngt.setModifiedDate(RandomTestUtil.nextDate());

		newAccountMngt.setAccountNumber(RandomTestUtil.randomString());

		newAccountMngt.setAccountHolderName(RandomTestUtil.randomString());

		newAccountMngt.setAccountType(RandomTestUtil.randomString());

		newAccountMngt.setEmail(RandomTestUtil.randomString());

		newAccountMngt.setPhoneNumber(RandomTestUtil.randomString());

		newAccountMngt.setBranchName(RandomTestUtil.randomString());

		newAccountMngt.setBalance(RandomTestUtil.nextDouble());

		newAccountMngt.setIfscCode(RandomTestUtil.randomString());

		_accountMngts.add(_persistence.update(newAccountMngt));

		AccountMngt existingAccountMngt = _persistence.findByPrimaryKey(
			newAccountMngt.getPrimaryKey());

		Assert.assertEquals(
			existingAccountMngt.getUuid(), newAccountMngt.getUuid());
		Assert.assertEquals(
			existingAccountMngt.getAccountId(), newAccountMngt.getAccountId());
		Assert.assertEquals(
			existingAccountMngt.getGroupId(), newAccountMngt.getGroupId());
		Assert.assertEquals(
			existingAccountMngt.getCompanyId(), newAccountMngt.getCompanyId());
		Assert.assertEquals(
			existingAccountMngt.getUserId(), newAccountMngt.getUserId());
		Assert.assertEquals(
			existingAccountMngt.getUserName(), newAccountMngt.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAccountMngt.getCreateDate()),
			Time.getShortTimestamp(newAccountMngt.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAccountMngt.getModifiedDate()),
			Time.getShortTimestamp(newAccountMngt.getModifiedDate()));
		Assert.assertEquals(
			existingAccountMngt.getAccountNumber(),
			newAccountMngt.getAccountNumber());
		Assert.assertEquals(
			existingAccountMngt.getAccountHolderName(),
			newAccountMngt.getAccountHolderName());
		Assert.assertEquals(
			existingAccountMngt.getAccountType(),
			newAccountMngt.getAccountType());
		Assert.assertEquals(
			existingAccountMngt.getEmail(), newAccountMngt.getEmail());
		Assert.assertEquals(
			existingAccountMngt.getPhoneNumber(),
			newAccountMngt.getPhoneNumber());
		Assert.assertEquals(
			existingAccountMngt.getBranchName(),
			newAccountMngt.getBranchName());
		AssertUtils.assertEquals(
			existingAccountMngt.getBalance(), newAccountMngt.getBalance());
		Assert.assertEquals(
			existingAccountMngt.getIfscCode(), newAccountMngt.getIfscCode());
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
		AccountMngt newAccountMngt = addAccountMngt();

		AccountMngt existingAccountMngt = _persistence.findByPrimaryKey(
			newAccountMngt.getPrimaryKey());

		Assert.assertEquals(existingAccountMngt, newAccountMngt);
	}

	@Test(expected = NoSuchMngtException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AccountMngt> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Account_AccountMngt", "uuid", true, "accountId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "accountNumber", true,
			"accountHolderName", true, "accountType", true, "email", true,
			"phoneNumber", true, "branchName", true, "balance", true,
			"ifscCode", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AccountMngt newAccountMngt = addAccountMngt();

		AccountMngt existingAccountMngt = _persistence.fetchByPrimaryKey(
			newAccountMngt.getPrimaryKey());

		Assert.assertEquals(existingAccountMngt, newAccountMngt);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AccountMngt missingAccountMngt = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAccountMngt);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AccountMngt newAccountMngt1 = addAccountMngt();
		AccountMngt newAccountMngt2 = addAccountMngt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccountMngt1.getPrimaryKey());
		primaryKeys.add(newAccountMngt2.getPrimaryKey());

		Map<Serializable, AccountMngt> accountMngts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, accountMngts.size());
		Assert.assertEquals(
			newAccountMngt1, accountMngts.get(newAccountMngt1.getPrimaryKey()));
		Assert.assertEquals(
			newAccountMngt2, accountMngts.get(newAccountMngt2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AccountMngt> accountMngts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(accountMngts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AccountMngt newAccountMngt = addAccountMngt();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccountMngt.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AccountMngt> accountMngts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, accountMngts.size());
		Assert.assertEquals(
			newAccountMngt, accountMngts.get(newAccountMngt.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AccountMngt> accountMngts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(accountMngts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AccountMngt newAccountMngt = addAccountMngt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAccountMngt.getPrimaryKey());

		Map<Serializable, AccountMngt> accountMngts =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, accountMngts.size());
		Assert.assertEquals(
			newAccountMngt, accountMngts.get(newAccountMngt.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AccountMngtLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AccountMngt>() {

				@Override
				public void performAction(AccountMngt accountMngt) {
					Assert.assertNotNull(accountMngt);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AccountMngt newAccountMngt = addAccountMngt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"accountId", newAccountMngt.getAccountId()));

		List<AccountMngt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AccountMngt existingAccountMngt = result.get(0);

		Assert.assertEquals(existingAccountMngt, newAccountMngt);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("accountId", RandomTestUtil.nextLong()));

		List<AccountMngt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AccountMngt newAccountMngt = addAccountMngt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("accountId"));

		Object newAccountId = newAccountMngt.getAccountId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"accountId", new Object[] {newAccountId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAccountId = result.get(0);

		Assert.assertEquals(existingAccountId, newAccountId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("accountId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"accountId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AccountMngt newAccountMngt = addAccountMngt();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAccountMngt.getPrimaryKey()));
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

		AccountMngt newAccountMngt = addAccountMngt();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AccountMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"accountId", newAccountMngt.getAccountId()));

		List<AccountMngt> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(AccountMngt accountMngt) {
		Assert.assertEquals(
			accountMngt.getUuid(),
			ReflectionTestUtil.invoke(
				accountMngt, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(accountMngt.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				accountMngt, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected AccountMngt addAccountMngt() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AccountMngt accountMngt = _persistence.create(pk);

		accountMngt.setUuid(RandomTestUtil.randomString());

		accountMngt.setGroupId(RandomTestUtil.nextLong());

		accountMngt.setCompanyId(RandomTestUtil.nextLong());

		accountMngt.setUserId(RandomTestUtil.nextLong());

		accountMngt.setUserName(RandomTestUtil.randomString());

		accountMngt.setCreateDate(RandomTestUtil.nextDate());

		accountMngt.setModifiedDate(RandomTestUtil.nextDate());

		accountMngt.setAccountNumber(RandomTestUtil.randomString());

		accountMngt.setAccountHolderName(RandomTestUtil.randomString());

		accountMngt.setAccountType(RandomTestUtil.randomString());

		accountMngt.setEmail(RandomTestUtil.randomString());

		accountMngt.setPhoneNumber(RandomTestUtil.randomString());

		accountMngt.setBranchName(RandomTestUtil.randomString());

		accountMngt.setBalance(RandomTestUtil.nextDouble());

		accountMngt.setIfscCode(RandomTestUtil.randomString());

		_accountMngts.add(_persistence.update(accountMngt));

		return accountMngt;
	}

	private List<AccountMngt> _accountMngts = new ArrayList<AccountMngt>();
	private AccountMngtPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}