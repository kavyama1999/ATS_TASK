/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package employe.db.layer.service.persistence.test;

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

import employe.db.layer.exception.NoSuchemployeeException;
import employe.db.layer.model.employee;
import employe.db.layer.service.employeeLocalServiceUtil;
import employe.db.layer.service.persistence.employeePersistence;
import employe.db.layer.service.persistence.employeeUtil;

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
public class employeePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "employe.db.layer.service"));

	@Before
	public void setUp() {
		_persistence = employeeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<employee> iterator = _employees.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		employee employee = _persistence.create(pk);

		Assert.assertNotNull(employee);

		Assert.assertEquals(employee.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		employee newemployee = addemployee();

		_persistence.remove(newemployee);

		employee existingemployee = _persistence.fetchByPrimaryKey(
			newemployee.getPrimaryKey());

		Assert.assertNull(existingemployee);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addemployee();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		employee newemployee = _persistence.create(pk);

		newemployee.setUuid(RandomTestUtil.randomString());

		newemployee.setGroupId(RandomTestUtil.nextLong());

		newemployee.setCompanyId(RandomTestUtil.nextLong());

		newemployee.setUserId(RandomTestUtil.nextLong());

		newemployee.setUserName(RandomTestUtil.randomString());

		newemployee.setCreateDate(RandomTestUtil.nextDate());

		newemployee.setModifiedDate(RandomTestUtil.nextDate());

		newemployee.setName(RandomTestUtil.randomString());

		newemployee.setSalary(RandomTestUtil.randomString());

		newemployee.setAge(RandomTestUtil.nextInt());

		newemployee.setCompany(RandomTestUtil.randomString());

		newemployee.setGender(RandomTestUtil.randomString());

		newemployee.setStatus(RandomTestUtil.nextInt());

		_employees.add(_persistence.update(newemployee));

		employee existingemployee = _persistence.findByPrimaryKey(
			newemployee.getPrimaryKey());

		Assert.assertEquals(existingemployee.getUuid(), newemployee.getUuid());
		Assert.assertEquals(
			existingemployee.getEmpId(), newemployee.getEmpId());
		Assert.assertEquals(
			existingemployee.getGroupId(), newemployee.getGroupId());
		Assert.assertEquals(
			existingemployee.getCompanyId(), newemployee.getCompanyId());
		Assert.assertEquals(
			existingemployee.getUserId(), newemployee.getUserId());
		Assert.assertEquals(
			existingemployee.getUserName(), newemployee.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingemployee.getCreateDate()),
			Time.getShortTimestamp(newemployee.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingemployee.getModifiedDate()),
			Time.getShortTimestamp(newemployee.getModifiedDate()));
		Assert.assertEquals(existingemployee.getName(), newemployee.getName());
		Assert.assertEquals(
			existingemployee.getSalary(), newemployee.getSalary());
		Assert.assertEquals(existingemployee.getAge(), newemployee.getAge());
		Assert.assertEquals(
			existingemployee.getCompany(), newemployee.getCompany());
		Assert.assertEquals(
			existingemployee.getGender(), newemployee.getGender());
		Assert.assertEquals(
			existingemployee.getStatus(), newemployee.getStatus());
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
		employee newemployee = addemployee();

		employee existingemployee = _persistence.findByPrimaryKey(
			newemployee.getPrimaryKey());

		Assert.assertEquals(existingemployee, newemployee);
	}

	@Test(expected = NoSuchemployeeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<employee> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Practice_employee", "uuid", true, "empId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "name", true, "salary", true, "age",
			true, "company", true, "gender", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		employee newemployee = addemployee();

		employee existingemployee = _persistence.fetchByPrimaryKey(
			newemployee.getPrimaryKey());

		Assert.assertEquals(existingemployee, newemployee);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		employee missingemployee = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingemployee);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		employee newemployee1 = addemployee();
		employee newemployee2 = addemployee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newemployee1.getPrimaryKey());
		primaryKeys.add(newemployee2.getPrimaryKey());

		Map<Serializable, employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, employees.size());
		Assert.assertEquals(
			newemployee1, employees.get(newemployee1.getPrimaryKey()));
		Assert.assertEquals(
			newemployee2, employees.get(newemployee2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		employee newemployee = addemployee();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newemployee.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, employees.size());
		Assert.assertEquals(
			newemployee, employees.get(newemployee.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		employee newemployee = addemployee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newemployee.getPrimaryKey());

		Map<Serializable, employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, employees.size());
		Assert.assertEquals(
			newemployee, employees.get(newemployee.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			employeeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<employee>() {

				@Override
				public void performAction(employee employee) {
					Assert.assertNotNull(employee);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		employee newemployee = addemployee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("empId", newemployee.getEmpId()));

		List<employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		employee existingemployee = result.get(0);

		Assert.assertEquals(existingemployee, newemployee);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("empId", RandomTestUtil.nextLong()));

		List<employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		employee newemployee = addemployee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("empId"));

		Object newEmpId = newemployee.getEmpId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("empId", new Object[] {newEmpId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEmpId = result.get(0);

		Assert.assertEquals(existingEmpId, newEmpId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("empId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"empId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		employee newemployee = addemployee();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newemployee.getPrimaryKey()));
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

		employee newemployee = addemployee();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("empId", newemployee.getEmpId()));

		List<employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(employee employee) {
		Assert.assertEquals(
			employee.getUuid(),
			ReflectionTestUtil.invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(employee.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				employee, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected employee addemployee() throws Exception {
		long pk = RandomTestUtil.nextLong();

		employee employee = _persistence.create(pk);

		employee.setUuid(RandomTestUtil.randomString());

		employee.setGroupId(RandomTestUtil.nextLong());

		employee.setCompanyId(RandomTestUtil.nextLong());

		employee.setUserId(RandomTestUtil.nextLong());

		employee.setUserName(RandomTestUtil.randomString());

		employee.setCreateDate(RandomTestUtil.nextDate());

		employee.setModifiedDate(RandomTestUtil.nextDate());

		employee.setName(RandomTestUtil.randomString());

		employee.setSalary(RandomTestUtil.randomString());

		employee.setAge(RandomTestUtil.nextInt());

		employee.setCompany(RandomTestUtil.randomString());

		employee.setGender(RandomTestUtil.randomString());

		employee.setStatus(RandomTestUtil.nextInt());

		_employees.add(_persistence.update(employee));

		return employee;
	}

	private List<employee> _employees = new ArrayList<employee>();
	private employeePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}