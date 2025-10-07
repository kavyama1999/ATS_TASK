/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service.persistence.test;

import AmbulanceDb2.exception.NoSuchAmbSignUpException;

import AmbulanceDb2.model.AmbSignUp;

import AmbulanceDb2.service.AmbSignUpLocalServiceUtil;
import AmbulanceDb2.service.persistence.AmbSignUpPersistence;
import AmbulanceDb2.service.persistence.AmbSignUpUtil;

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
public class AmbSignUpPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "AmbulanceDb2.service"));

	@Before
	public void setUp() {
		_persistence = AmbSignUpUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<AmbSignUp> iterator = _ambSignUps.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AmbSignUp ambSignUp = _persistence.create(pk);

		Assert.assertNotNull(ambSignUp);

		Assert.assertEquals(ambSignUp.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		AmbSignUp newAmbSignUp = addAmbSignUp();

		_persistence.remove(newAmbSignUp);

		AmbSignUp existingAmbSignUp = _persistence.fetchByPrimaryKey(
			newAmbSignUp.getPrimaryKey());

		Assert.assertNull(existingAmbSignUp);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addAmbSignUp();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AmbSignUp newAmbSignUp = _persistence.create(pk);

		newAmbSignUp.setUuid(RandomTestUtil.randomString());

		newAmbSignUp.setGroupId(RandomTestUtil.nextLong());

		newAmbSignUp.setCompanyId(RandomTestUtil.nextLong());

		newAmbSignUp.setUserId(RandomTestUtil.nextLong());

		newAmbSignUp.setUserName(RandomTestUtil.randomString());

		newAmbSignUp.setCreateDate(RandomTestUtil.nextDate());

		newAmbSignUp.setModifiedDate(RandomTestUtil.nextDate());

		newAmbSignUp.setEmail(RandomTestUtil.randomString());

		newAmbSignUp.setOTP(RandomTestUtil.randomString());

		newAmbSignUp.setStatus(RandomTestUtil.randomBoolean());

		_ambSignUps.add(_persistence.update(newAmbSignUp));

		AmbSignUp existingAmbSignUp = _persistence.findByPrimaryKey(
			newAmbSignUp.getPrimaryKey());

		Assert.assertEquals(
			existingAmbSignUp.getUuid(), newAmbSignUp.getUuid());
		Assert.assertEquals(
			existingAmbSignUp.getOtpId(), newAmbSignUp.getOtpId());
		Assert.assertEquals(
			existingAmbSignUp.getGroupId(), newAmbSignUp.getGroupId());
		Assert.assertEquals(
			existingAmbSignUp.getCompanyId(), newAmbSignUp.getCompanyId());
		Assert.assertEquals(
			existingAmbSignUp.getUserId(), newAmbSignUp.getUserId());
		Assert.assertEquals(
			existingAmbSignUp.getUserName(), newAmbSignUp.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingAmbSignUp.getCreateDate()),
			Time.getShortTimestamp(newAmbSignUp.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingAmbSignUp.getModifiedDate()),
			Time.getShortTimestamp(newAmbSignUp.getModifiedDate()));
		Assert.assertEquals(
			existingAmbSignUp.getEmail(), newAmbSignUp.getEmail());
		Assert.assertEquals(existingAmbSignUp.getOTP(), newAmbSignUp.getOTP());
		Assert.assertEquals(
			existingAmbSignUp.isStatus(), newAmbSignUp.isStatus());
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
		AmbSignUp newAmbSignUp = addAmbSignUp();

		AmbSignUp existingAmbSignUp = _persistence.findByPrimaryKey(
			newAmbSignUp.getPrimaryKey());

		Assert.assertEquals(existingAmbSignUp, newAmbSignUp);
	}

	@Test(expected = NoSuchAmbSignUpException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<AmbSignUp> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"AMB_AmbSignUp", "uuid", true, "otpId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "email", true, "OTP", true, "status",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		AmbSignUp newAmbSignUp = addAmbSignUp();

		AmbSignUp existingAmbSignUp = _persistence.fetchByPrimaryKey(
			newAmbSignUp.getPrimaryKey());

		Assert.assertEquals(existingAmbSignUp, newAmbSignUp);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AmbSignUp missingAmbSignUp = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingAmbSignUp);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		AmbSignUp newAmbSignUp1 = addAmbSignUp();
		AmbSignUp newAmbSignUp2 = addAmbSignUp();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAmbSignUp1.getPrimaryKey());
		primaryKeys.add(newAmbSignUp2.getPrimaryKey());

		Map<Serializable, AmbSignUp> ambSignUps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, ambSignUps.size());
		Assert.assertEquals(
			newAmbSignUp1, ambSignUps.get(newAmbSignUp1.getPrimaryKey()));
		Assert.assertEquals(
			newAmbSignUp2, ambSignUps.get(newAmbSignUp2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, AmbSignUp> ambSignUps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ambSignUps.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		AmbSignUp newAmbSignUp = addAmbSignUp();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAmbSignUp.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, AmbSignUp> ambSignUps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ambSignUps.size());
		Assert.assertEquals(
			newAmbSignUp, ambSignUps.get(newAmbSignUp.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, AmbSignUp> ambSignUps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(ambSignUps.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		AmbSignUp newAmbSignUp = addAmbSignUp();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newAmbSignUp.getPrimaryKey());

		Map<Serializable, AmbSignUp> ambSignUps =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, ambSignUps.size());
		Assert.assertEquals(
			newAmbSignUp, ambSignUps.get(newAmbSignUp.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			AmbSignUpLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<AmbSignUp>() {

				@Override
				public void performAction(AmbSignUp ambSignUp) {
					Assert.assertNotNull(ambSignUp);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		AmbSignUp newAmbSignUp = addAmbSignUp();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AmbSignUp.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("otpId", newAmbSignUp.getOtpId()));

		List<AmbSignUp> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		AmbSignUp existingAmbSignUp = result.get(0);

		Assert.assertEquals(existingAmbSignUp, newAmbSignUp);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AmbSignUp.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("otpId", RandomTestUtil.nextLong()));

		List<AmbSignUp> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		AmbSignUp newAmbSignUp = addAmbSignUp();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AmbSignUp.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("otpId"));

		Object newOtpId = newAmbSignUp.getOtpId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("otpId", new Object[] {newOtpId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingOtpId = result.get(0);

		Assert.assertEquals(existingOtpId, newOtpId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AmbSignUp.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("otpId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"otpId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		AmbSignUp newAmbSignUp = addAmbSignUp();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newAmbSignUp.getPrimaryKey()));
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

		AmbSignUp newAmbSignUp = addAmbSignUp();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			AmbSignUp.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("otpId", newAmbSignUp.getOtpId()));

		List<AmbSignUp> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(AmbSignUp ambSignUp) {
		Assert.assertEquals(
			ambSignUp.getUuid(),
			ReflectionTestUtil.invoke(
				ambSignUp, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(ambSignUp.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				ambSignUp, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected AmbSignUp addAmbSignUp() throws Exception {
		long pk = RandomTestUtil.nextLong();

		AmbSignUp ambSignUp = _persistence.create(pk);

		ambSignUp.setUuid(RandomTestUtil.randomString());

		ambSignUp.setGroupId(RandomTestUtil.nextLong());

		ambSignUp.setCompanyId(RandomTestUtil.nextLong());

		ambSignUp.setUserId(RandomTestUtil.nextLong());

		ambSignUp.setUserName(RandomTestUtil.randomString());

		ambSignUp.setCreateDate(RandomTestUtil.nextDate());

		ambSignUp.setModifiedDate(RandomTestUtil.nextDate());

		ambSignUp.setEmail(RandomTestUtil.randomString());

		ambSignUp.setOTP(RandomTestUtil.randomString());

		ambSignUp.setStatus(RandomTestUtil.randomBoolean());

		_ambSignUps.add(_persistence.update(ambSignUp));

		return ambSignUp;
	}

	private List<AmbSignUp> _ambSignUps = new ArrayList<AmbSignUp>();
	private AmbSignUpPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}