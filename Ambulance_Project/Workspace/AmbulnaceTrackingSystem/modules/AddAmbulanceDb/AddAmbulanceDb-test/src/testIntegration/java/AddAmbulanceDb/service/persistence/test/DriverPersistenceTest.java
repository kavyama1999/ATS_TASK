/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence.test;

import AddAmbulanceDb.exception.NoSuchDriverException;

import AddAmbulanceDb.model.Driver;

import AddAmbulanceDb.service.DriverLocalServiceUtil;
import AddAmbulanceDb.service.persistence.DriverPersistence;
import AddAmbulanceDb.service.persistence.DriverUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
public class DriverPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "AddAmbulanceDb.service"));

	@Before
	public void setUp() {
		_persistence = DriverUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Driver> iterator = _drivers.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Driver driver = _persistence.create(pk);

		Assert.assertNotNull(driver);

		Assert.assertEquals(driver.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Driver newDriver = addDriver();

		_persistence.remove(newDriver);

		Driver existingDriver = _persistence.fetchByPrimaryKey(
			newDriver.getPrimaryKey());

		Assert.assertNull(existingDriver);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addDriver();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Driver newDriver = _persistence.create(pk);

		newDriver.setUuid(RandomTestUtil.randomString());

		newDriver.setHospitalId(RandomTestUtil.nextLong());

		newDriver.setAmbulanceId(RandomTestUtil.nextLong());

		newDriver.setDriverName(RandomTestUtil.randomString());

		newDriver.setContactNumber(RandomTestUtil.randomString());

		newDriver.setEmail(RandomTestUtil.randomString());

		newDriver.setAddress(RandomTestUtil.randomString());

		newDriver.setExperienceYears(RandomTestUtil.nextInt());

		newDriver.setStatus(RandomTestUtil.randomString());

		newDriver.setCreateDate(RandomTestUtil.nextDate());

		newDriver.setModifiedDate(RandomTestUtil.nextDate());

		_drivers.add(_persistence.update(newDriver));

		Driver existingDriver = _persistence.findByPrimaryKey(
			newDriver.getPrimaryKey());

		Assert.assertEquals(existingDriver.getUuid(), newDriver.getUuid());
		Assert.assertEquals(
			existingDriver.getDriverId(), newDriver.getDriverId());
		Assert.assertEquals(
			existingDriver.getHospitalId(), newDriver.getHospitalId());
		Assert.assertEquals(
			existingDriver.getAmbulanceId(), newDriver.getAmbulanceId());
		Assert.assertEquals(
			existingDriver.getDriverName(), newDriver.getDriverName());
		Assert.assertEquals(
			existingDriver.getContactNumber(), newDriver.getContactNumber());
		Assert.assertEquals(existingDriver.getEmail(), newDriver.getEmail());
		Assert.assertEquals(
			existingDriver.getAddress(), newDriver.getAddress());
		Assert.assertEquals(
			existingDriver.getExperienceYears(),
			newDriver.getExperienceYears());
		Assert.assertEquals(existingDriver.getStatus(), newDriver.getStatus());
		Assert.assertEquals(
			Time.getShortTimestamp(existingDriver.getCreateDate()),
			Time.getShortTimestamp(newDriver.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingDriver.getModifiedDate()),
			Time.getShortTimestamp(newDriver.getModifiedDate()));
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByHospitalId() throws Exception {
		_persistence.countByHospitalId(RandomTestUtil.nextLong());

		_persistence.countByHospitalId(0L);
	}

	@Test
	public void testCountByAmbulanceId() throws Exception {
		_persistence.countByAmbulanceId(RandomTestUtil.nextLong());

		_persistence.countByAmbulanceId(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Driver newDriver = addDriver();

		Driver existingDriver = _persistence.findByPrimaryKey(
			newDriver.getPrimaryKey());

		Assert.assertEquals(existingDriver, newDriver);
	}

	@Test(expected = NoSuchDriverException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Driver> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"HSP_Driver", "uuid", true, "driverId", true, "hospitalId", true,
			"ambulanceId", true, "driverName", true, "contactNumber", true,
			"email", true, "address", true, "experienceYears", true, "status",
			true, "createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Driver newDriver = addDriver();

		Driver existingDriver = _persistence.fetchByPrimaryKey(
			newDriver.getPrimaryKey());

		Assert.assertEquals(existingDriver, newDriver);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Driver missingDriver = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingDriver);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Driver newDriver1 = addDriver();
		Driver newDriver2 = addDriver();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDriver1.getPrimaryKey());
		primaryKeys.add(newDriver2.getPrimaryKey());

		Map<Serializable, Driver> drivers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, drivers.size());
		Assert.assertEquals(
			newDriver1, drivers.get(newDriver1.getPrimaryKey()));
		Assert.assertEquals(
			newDriver2, drivers.get(newDriver2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Driver> drivers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(drivers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Driver newDriver = addDriver();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDriver.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Driver> drivers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, drivers.size());
		Assert.assertEquals(newDriver, drivers.get(newDriver.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Driver> drivers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(drivers.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Driver newDriver = addDriver();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newDriver.getPrimaryKey());

		Map<Serializable, Driver> drivers = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, drivers.size());
		Assert.assertEquals(newDriver, drivers.get(newDriver.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			DriverLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Driver>() {

				@Override
				public void performAction(Driver driver) {
					Assert.assertNotNull(driver);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Driver newDriver = addDriver();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Driver.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("driverId", newDriver.getDriverId()));

		List<Driver> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Driver existingDriver = result.get(0);

		Assert.assertEquals(existingDriver, newDriver);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Driver.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("driverId", RandomTestUtil.nextLong()));

		List<Driver> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Driver newDriver = addDriver();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Driver.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("driverId"));

		Object newDriverId = newDriver.getDriverId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("driverId", new Object[] {newDriverId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingDriverId = result.get(0);

		Assert.assertEquals(existingDriverId, newDriverId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Driver.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("driverId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"driverId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Driver addDriver() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Driver driver = _persistence.create(pk);

		driver.setUuid(RandomTestUtil.randomString());

		driver.setHospitalId(RandomTestUtil.nextLong());

		driver.setAmbulanceId(RandomTestUtil.nextLong());

		driver.setDriverName(RandomTestUtil.randomString());

		driver.setContactNumber(RandomTestUtil.randomString());

		driver.setEmail(RandomTestUtil.randomString());

		driver.setAddress(RandomTestUtil.randomString());

		driver.setExperienceYears(RandomTestUtil.nextInt());

		driver.setStatus(RandomTestUtil.randomString());

		driver.setCreateDate(RandomTestUtil.nextDate());

		driver.setModifiedDate(RandomTestUtil.nextDate());

		_drivers.add(_persistence.update(driver));

		return driver;
	}

	private List<Driver> _drivers = new ArrayList<Driver>();
	private DriverPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}