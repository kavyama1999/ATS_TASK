/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.exception.NoSuchstudentException;
import com.liferay.model.student;
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
import com.liferay.service.persistence.studentPersistence;
import com.liferay.service.persistence.studentUtil;
import com.liferay.service.studentLocalServiceUtil;

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
public class studentPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.liferay.service"));

	@Before
	public void setUp() {
		_persistence = studentUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<student> iterator = _students.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student student = _persistence.create(pk);

		Assert.assertNotNull(student);

		Assert.assertEquals(student.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		student newstudent = addstudent();

		_persistence.remove(newstudent);

		student existingstudent = _persistence.fetchByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertNull(existingstudent);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addstudent();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student newstudent = _persistence.create(pk);

		newstudent.setUuid(RandomTestUtil.randomString());

		newstudent.setGroupId(RandomTestUtil.nextLong());

		newstudent.setCompanyId(RandomTestUtil.nextLong());

		newstudent.setUserId(RandomTestUtil.nextLong());

		newstudent.setUserName(RandomTestUtil.randomString());

		newstudent.setCreateDate(RandomTestUtil.nextDate());

		newstudent.setModifiedDate(RandomTestUtil.nextDate());

		newstudent.setName(RandomTestUtil.randomString());

		newstudent.setQualification(RandomTestUtil.randomString());

		newstudent.setFees(RandomTestUtil.nextLong());

		newstudent.setAddress(RandomTestUtil.randomString());

		newstudent.setGender(RandomTestUtil.randomString());

		_students.add(_persistence.update(newstudent));

		student existingstudent = _persistence.findByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertEquals(existingstudent.getUuid(), newstudent.getUuid());
		Assert.assertEquals(
			existingstudent.getStudentId(), newstudent.getStudentId());
		Assert.assertEquals(
			existingstudent.getGroupId(), newstudent.getGroupId());
		Assert.assertEquals(
			existingstudent.getCompanyId(), newstudent.getCompanyId());
		Assert.assertEquals(
			existingstudent.getUserId(), newstudent.getUserId());
		Assert.assertEquals(
			existingstudent.getUserName(), newstudent.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingstudent.getCreateDate()),
			Time.getShortTimestamp(newstudent.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingstudent.getModifiedDate()),
			Time.getShortTimestamp(newstudent.getModifiedDate()));
		Assert.assertEquals(existingstudent.getName(), newstudent.getName());
		Assert.assertEquals(
			existingstudent.getQualification(), newstudent.getQualification());
		Assert.assertEquals(existingstudent.getFees(), newstudent.getFees());
		Assert.assertEquals(
			existingstudent.getAddress(), newstudent.getAddress());
		Assert.assertEquals(
			existingstudent.getGender(), newstudent.getGender());
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
		student newstudent = addstudent();

		student existingstudent = _persistence.findByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertEquals(existingstudent, newstudent);
	}

	@Test(expected = NoSuchstudentException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<student> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"practice_student", "uuid", true, "studentId", true, "groupId",
			true, "companyId", true, "userId", true, "userName", true,
			"createDate", true, "modifiedDate", true, "name", true,
			"qualification", true, "fees", true, "address", true, "gender",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		student newstudent = addstudent();

		student existingstudent = _persistence.fetchByPrimaryKey(
			newstudent.getPrimaryKey());

		Assert.assertEquals(existingstudent, newstudent);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student missingstudent = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingstudent);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		student newstudent1 = addstudent();
		student newstudent2 = addstudent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newstudent1.getPrimaryKey());
		primaryKeys.add(newstudent2.getPrimaryKey());

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, students.size());
		Assert.assertEquals(
			newstudent1, students.get(newstudent1.getPrimaryKey()));
		Assert.assertEquals(
			newstudent2, students.get(newstudent2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(students.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		student newstudent = addstudent();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newstudent.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, students.size());
		Assert.assertEquals(
			newstudent, students.get(newstudent.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(students.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		student newstudent = addstudent();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newstudent.getPrimaryKey());

		Map<Serializable, student> students = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, students.size());
		Assert.assertEquals(
			newstudent, students.get(newstudent.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			studentLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<student>() {

				@Override
				public void performAction(student student) {
					Assert.assertNotNull(student);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		student newstudent = addstudent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("studentId", newstudent.getStudentId()));

		List<student> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		student existingstudent = result.get(0);

		Assert.assertEquals(existingstudent, newstudent);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("studentId", RandomTestUtil.nextLong()));

		List<student> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		student newstudent = addstudent();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("studentId"));

		Object newStudentId = newstudent.getStudentId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"studentId", new Object[] {newStudentId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingStudentId = result.get(0);

		Assert.assertEquals(existingStudentId, newStudentId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("studentId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"studentId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		student newstudent = addstudent();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newstudent.getPrimaryKey()));
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

		student newstudent = addstudent();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			student.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("studentId", newstudent.getStudentId()));

		List<student> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(student student) {
		Assert.assertEquals(
			student.getUuid(),
			ReflectionTestUtil.invoke(
				student, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(student.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				student, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected student addstudent() throws Exception {
		long pk = RandomTestUtil.nextLong();

		student student = _persistence.create(pk);

		student.setUuid(RandomTestUtil.randomString());

		student.setGroupId(RandomTestUtil.nextLong());

		student.setCompanyId(RandomTestUtil.nextLong());

		student.setUserId(RandomTestUtil.nextLong());

		student.setUserName(RandomTestUtil.randomString());

		student.setCreateDate(RandomTestUtil.nextDate());

		student.setModifiedDate(RandomTestUtil.nextDate());

		student.setName(RandomTestUtil.randomString());

		student.setQualification(RandomTestUtil.randomString());

		student.setFees(RandomTestUtil.nextLong());

		student.setAddress(RandomTestUtil.randomString());

		student.setGender(RandomTestUtil.randomString());

		_students.add(_persistence.update(student));

		return student;
	}

	private List<student> _students = new ArrayList<student>();
	private studentPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}