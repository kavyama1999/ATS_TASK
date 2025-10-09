/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.persistence.test;

import AddAmbulanceDb.exception.NoSuchAmbulanceException;

import AddAmbulanceDb.model.Ambulance;

import AddAmbulanceDb.service.AmbulanceLocalServiceUtil;
import AddAmbulanceDb.service.persistence.AmbulancePersistence;
import AddAmbulanceDb.service.persistence.AmbulanceUtil;

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
public class AmbulancePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "AddAmbulanceDb.service"));

	@Before
	public void setUp() {
		_persistence = AmbulanceUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Ambulance> iterator = _ambulances.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Ambulance ambulance = _persistence.create(pk);

		Assert.assertNotNull(ambulance);

		Assert.assertEquals(ambulance.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Ambulance newAmbulance = addAmbulance();

		_persistence.remove(newAmbulance);

		Ambulance existingAmbulance = _persistence.fetchByPrimaryKey(
			newAmbulance.getPrimaryKey());

		Assert.assertNull(existingAmbulance);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAmbulance();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Ambulance newAmbulance = _persistence.create(pk);

		newAmbulance.setUuid(RandomTestUtil.randomString());

		newAmbulance.setHospitalId(RandomTestUtil.nextLong());

		newAmbulance.setDriverId(RandomTestUtil.nextLong());

		newAmbulance.setAmbulanceNumber(RandomTestUtil.randomString());

		newAmbulance.setVehicleType(RandomTestUtil.randomString());

		newAmbulance.setStatus(RandomTestUtil.randomString());

		newAmbulance.setLocation(RandomTestUtil.randomString());

		newAmbulance.setContactNumber(RandomTestUtil.randomString());

		newAmbulance.setCreateDate(RandomTestUtil.nextDate());

		newAmbulance.setModifiedDate(RandomTestUtil.nextDate());

		_ambulances.add(_persistence.update(newAmbulance));

		Ambulance existingAmbulance = _persistence.findByPrimaryKey(
			newAmbulance.getPrimaryKey());

		Assert.assertEquals(
			existingAmbulance.getUuid(), newAmbulance.getUuid());
		Assert.assertEquals(
			existingAmbulance.getAmbulanceId(), newAmbulance.getAmbulanceId());
		Assert.assertEquals(
			existingAmbulance.getHospitalId(), newAmbulance.getHospitalId());
		Assert.assertEquals(
			existingAmbulance.getDriverId(), newAmbulance.getDriverId());
		Assert.assertEquals(
			existingAmbulance.getAmbulanceNumber(),
			newAmbulance.getAmbulanceNumber());
		Assert.assertEquals(
			existingAmbulance.getVehicleType(), newAmbulance.getVehicleType());
		Assert.assertEquals(
			existingAmbulance.getStatus(), newAmbulance.getStatus());
		Assert.assertEquals(
			existingAmbulance.getLocation(), newAmbulance.getLocation());
		Assert.assertEquals(
			existingAmbulance.getContactNumber(),
			newAmbulance.getContactNumber());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAmbulance.getCreateDate()),
			Time.getShortTimestamp(newAmbulance.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAmbulance.getModifiedDate()),
			Time.getShortTimestamp(newAmbulance.getModifiedDate()));
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
	public void testFindByPrimaryKeyExisting() throws Exception {
		Ambulance newAmbulance = addAmbulance();

		Ambulance existingAmbulance = _persistence.findByPrimaryKey(
			newAmbulance.getPrimaryKey());

		Assert.assertEquals(existingAmbulance, newAmbulance);
	}

	@Test(expected = NoSuchAmbulanceException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Ambulance> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"HSP_Ambulance", "uuid", true, "ambulanceId", true, "hospitalId",
			true, "driverId", true, "ambulanceNumber", true, "vehicleType",
			true, "status", true, "location", true, "contactNumber", true,
			"createDate", true, "modifiedDate", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Ambulance newAmbulance = addAmbulance();

		Ambulance existingAmbulance = _persistence.fetchByPrimaryKey(
			newAmbulance.getPrimaryKey());

		Assert.assertEquals(existingAmbulance, newAmbulance);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Ambulance missingAmbulance = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAmbulance);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Ambulance newAmbulance1 = addAmbulance();
		Ambulance newAmbulance2 = addAmbulance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAmbulance1.getPrimaryKey());
		primaryKeys.add(newAmbulance2.getPrimaryKey());

		Map<Serializable, Ambulance> ambulances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ambulances.size());
		Assert.assertEquals(
			newAmbulance1, ambulances.get(newAmbulance1.getPrimaryKey()));
		Assert.assertEquals(
			newAmbulance2, ambulances.get(newAmbulance2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Ambulance> ambulances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ambulances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Ambulance newAmbulance = addAmbulance();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAmbulance.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Ambulance> ambulances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ambulances.size());
		Assert.assertEquals(
			newAmbulance, ambulances.get(newAmbulance.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Ambulance> ambulances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ambulances.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Ambulance newAmbulance = addAmbulance();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAmbulance.getPrimaryKey());

		Map<Serializable, Ambulance> ambulances =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ambulances.size());
		Assert.assertEquals(
			newAmbulance, ambulances.get(newAmbulance.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AmbulanceLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Ambulance>() {

				@Override
				public void performAction(Ambulance ambulance) {
					Assert.assertNotNull(ambulance);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Ambulance newAmbulance = addAmbulance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ambulance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ambulanceId", newAmbulance.getAmbulanceId()));

		List<Ambulance> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Ambulance existingAmbulance = result.get(0);

		Assert.assertEquals(existingAmbulance, newAmbulance);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ambulance.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"ambulanceId", RandomTestUtil.nextLong()));

		List<Ambulance> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Ambulance newAmbulance = addAmbulance();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ambulance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ambulanceId"));

		Object newAmbulanceId = newAmbulance.getAmbulanceId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ambulanceId", new Object[] {newAmbulanceId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingAmbulanceId = result.get(0);

		Assert.assertEquals(existingAmbulanceId, newAmbulanceId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Ambulance.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("ambulanceId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"ambulanceId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Ambulance addAmbulance() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Ambulance ambulance = _persistence.create(pk);

		ambulance.setUuid(RandomTestUtil.randomString());

		ambulance.setHospitalId(RandomTestUtil.nextLong());

		ambulance.setDriverId(RandomTestUtil.nextLong());

		ambulance.setAmbulanceNumber(RandomTestUtil.randomString());

		ambulance.setVehicleType(RandomTestUtil.randomString());

		ambulance.setStatus(RandomTestUtil.randomString());

		ambulance.setLocation(RandomTestUtil.randomString());

		ambulance.setContactNumber(RandomTestUtil.randomString());

		ambulance.setCreateDate(RandomTestUtil.nextDate());

		ambulance.setModifiedDate(RandomTestUtil.nextDate());

		_ambulances.add(_persistence.update(ambulance));

		return ambulance;
	}

	private List<Ambulance> _ambulances = new ArrayList<Ambulance>();
	private AmbulancePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}