/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence.test;

import AddAmbulanceDb.exception.NoSuchHospitalException;

import AddAmbulanceDb.model.Hospital;

import AddAmbulanceDb.service.HospitalLocalServiceUtil;
import AddAmbulanceDb.service.persistence.HospitalPersistence;
import AddAmbulanceDb.service.persistence.HospitalUtil;

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
public class HospitalPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "AddAmbulanceDb.service"));

	@Before
	public void setUp() {
		_persistence = HospitalUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Hospital> iterator = _hospitals.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Hospital hospital = _persistence.create(pk);

		Assert.assertNotNull(hospital);

		Assert.assertEquals(hospital.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Hospital newHospital = addHospital();

		_persistence.remove(newHospital);

		Hospital existingHospital = _persistence.fetchByPrimaryKey(
			newHospital.getPrimaryKey());

		Assert.assertNull(existingHospital);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addHospital();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Hospital newHospital = _persistence.create(pk);

		newHospital.setUuid(RandomTestUtil.randomString());

		newHospital.setGroupId(RandomTestUtil.nextLong());

		newHospital.setCompanyId(RandomTestUtil.nextLong());

		newHospital.setUserId(RandomTestUtil.nextLong());

		newHospital.setUserName(RandomTestUtil.randomString());

		newHospital.setCreateDate(RandomTestUtil.nextDate());

		newHospital.setModifiedDate(RandomTestUtil.nextDate());

		newHospital.setHospitalName(RandomTestUtil.randomString());

		newHospital.setLocation(RandomTestUtil.randomString());

		newHospital.setAddress(RandomTestUtil.randomString());

		newHospital.setContactNumber(RandomTestUtil.randomString());

		_hospitals.add(_persistence.update(newHospital));

		Hospital existingHospital = _persistence.findByPrimaryKey(
			newHospital.getPrimaryKey());

		Assert.assertEquals(existingHospital.getUuid(), newHospital.getUuid());
		Assert.assertEquals(
			existingHospital.getHospitalId(), newHospital.getHospitalId());
		Assert.assertEquals(
			existingHospital.getGroupId(), newHospital.getGroupId());
		Assert.assertEquals(
			existingHospital.getCompanyId(), newHospital.getCompanyId());
		Assert.assertEquals(
			existingHospital.getUserId(), newHospital.getUserId());
		Assert.assertEquals(
			existingHospital.getUserName(), newHospital.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingHospital.getCreateDate()),
			Time.getShortTimestamp(newHospital.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingHospital.getModifiedDate()),
			Time.getShortTimestamp(newHospital.getModifiedDate()));
		Assert.assertEquals(
			existingHospital.getHospitalName(), newHospital.getHospitalName());
		Assert.assertEquals(
			existingHospital.getLocation(), newHospital.getLocation());
		Assert.assertEquals(
			existingHospital.getAddress(), newHospital.getAddress());
		Assert.assertEquals(
			existingHospital.getContactNumber(),
			newHospital.getContactNumber());
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
		Hospital newHospital = addHospital();

		Hospital existingHospital = _persistence.findByPrimaryKey(
			newHospital.getPrimaryKey());

		Assert.assertEquals(existingHospital, newHospital);
	}

	@Test(expected = NoSuchHospitalException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Hospital> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"HSP_Hospital", "uuid", true, "hospitalId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "hospitalName", true, "location", true,
			"address", true, "contactNumber", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Hospital newHospital = addHospital();

		Hospital existingHospital = _persistence.fetchByPrimaryKey(
			newHospital.getPrimaryKey());

		Assert.assertEquals(existingHospital, newHospital);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Hospital missingHospital = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingHospital);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Hospital newHospital1 = addHospital();
		Hospital newHospital2 = addHospital();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHospital1.getPrimaryKey());
		primaryKeys.add(newHospital2.getPrimaryKey());

		Map<Serializable, Hospital> hospitals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, hospitals.size());
		Assert.assertEquals(
			newHospital1, hospitals.get(newHospital1.getPrimaryKey()));
		Assert.assertEquals(
			newHospital2, hospitals.get(newHospital2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Hospital> hospitals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(hospitals.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Hospital newHospital = addHospital();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHospital.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Hospital> hospitals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, hospitals.size());
		Assert.assertEquals(
			newHospital, hospitals.get(newHospital.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Hospital> hospitals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(hospitals.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Hospital newHospital = addHospital();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newHospital.getPrimaryKey());

		Map<Serializable, Hospital> hospitals = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, hospitals.size());
		Assert.assertEquals(
			newHospital, hospitals.get(newHospital.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			HospitalLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Hospital>() {

				@Override
				public void performAction(Hospital hospital) {
					Assert.assertNotNull(hospital);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Hospital newHospital = addHospital();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Hospital.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"hospitalId", newHospital.getHospitalId()));

		List<Hospital> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Hospital existingHospital = result.get(0);

		Assert.assertEquals(existingHospital, newHospital);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Hospital.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"hospitalId", RandomTestUtil.nextLong()));

		List<Hospital> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Hospital newHospital = addHospital();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Hospital.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("hospitalId"));

		Object newHospitalId = newHospital.getHospitalId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"hospitalId", new Object[] {newHospitalId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingHospitalId = result.get(0);

		Assert.assertEquals(existingHospitalId, newHospitalId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Hospital.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("hospitalId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"hospitalId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Hospital newHospital = addHospital();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newHospital.getPrimaryKey()));
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

		Hospital newHospital = addHospital();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Hospital.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"hospitalId", newHospital.getHospitalId()));

		List<Hospital> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(Hospital hospital) {
		Assert.assertEquals(
			hospital.getUuid(),
			ReflectionTestUtil.invoke(
				hospital, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(hospital.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				hospital, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected Hospital addHospital() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Hospital hospital = _persistence.create(pk);

		hospital.setUuid(RandomTestUtil.randomString());

		hospital.setGroupId(RandomTestUtil.nextLong());

		hospital.setCompanyId(RandomTestUtil.nextLong());

		hospital.setUserId(RandomTestUtil.nextLong());

		hospital.setUserName(RandomTestUtil.randomString());

		hospital.setCreateDate(RandomTestUtil.nextDate());

		hospital.setModifiedDate(RandomTestUtil.nextDate());

		hospital.setHospitalName(RandomTestUtil.randomString());

		hospital.setLocation(RandomTestUtil.randomString());

		hospital.setAddress(RandomTestUtil.randomString());

		hospital.setContactNumber(RandomTestUtil.randomString());

		_hospitals.add(_persistence.update(hospital));

		return hospital;
	}

	private List<Hospital> _hospitals = new ArrayList<Hospital>();
	private HospitalPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}