/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service.persistence.test;

import CaseManagementDB.exception.NoSuchMngtException;

import CaseManagementDB.model.CaseMngt;

import CaseManagementDB.service.CaseMngtLocalServiceUtil;
import CaseManagementDB.service.persistence.CaseMngtPersistence;
import CaseManagementDB.service.persistence.CaseMngtUtil;

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
public class CaseMngtPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "CaseManagementDB.service"));

	@Before
	public void setUp() {
		_persistence = CaseMngtUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<CaseMngt> iterator = _caseMngts.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseMngt caseMngt = _persistence.create(pk);

		Assert.assertNotNull(caseMngt);

		Assert.assertEquals(caseMngt.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		CaseMngt newCaseMngt = addCaseMngt();

		_persistence.remove(newCaseMngt);

		CaseMngt existingCaseMngt = _persistence.fetchByPrimaryKey(
			newCaseMngt.getPrimaryKey());

		Assert.assertNull(existingCaseMngt);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addCaseMngt();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseMngt newCaseMngt = _persistence.create(pk);

		newCaseMngt.setUuid(RandomTestUtil.randomString());

		newCaseMngt.setGroupId(RandomTestUtil.nextLong());

		newCaseMngt.setCompanyId(RandomTestUtil.nextLong());

		newCaseMngt.setUserId(RandomTestUtil.nextLong());

		newCaseMngt.setUserName(RandomTestUtil.randomString());

		newCaseMngt.setCreateDate(RandomTestUtil.nextDate());

		newCaseMngt.setModifiedDate(RandomTestUtil.nextDate());

		newCaseMngt.setCaseNumber(RandomTestUtil.randomString());

		newCaseMngt.setCaseType(RandomTestUtil.randomString());

		newCaseMngt.setPatientName(RandomTestUtil.randomString());

		newCaseMngt.setPatientAge(RandomTestUtil.nextInt());

		newCaseMngt.setDescription(RandomTestUtil.randomString());

		newCaseMngt.setPatientGender(RandomTestUtil.randomString());

		newCaseMngt.setLocation(RandomTestUtil.randomString());

		newCaseMngt.setContactNumber(RandomTestUtil.randomString());

		_caseMngts.add(_persistence.update(newCaseMngt));

		CaseMngt existingCaseMngt = _persistence.findByPrimaryKey(
			newCaseMngt.getPrimaryKey());

		Assert.assertEquals(existingCaseMngt.getUuid(), newCaseMngt.getUuid());
		Assert.assertEquals(
			existingCaseMngt.getCaseId(), newCaseMngt.getCaseId());
		Assert.assertEquals(
			existingCaseMngt.getGroupId(), newCaseMngt.getGroupId());
		Assert.assertEquals(
			existingCaseMngt.getCompanyId(), newCaseMngt.getCompanyId());
		Assert.assertEquals(
			existingCaseMngt.getUserId(), newCaseMngt.getUserId());
		Assert.assertEquals(
			existingCaseMngt.getUserName(), newCaseMngt.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingCaseMngt.getCreateDate()),
			Time.getShortTimestamp(newCaseMngt.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingCaseMngt.getModifiedDate()),
			Time.getShortTimestamp(newCaseMngt.getModifiedDate()));
		Assert.assertEquals(
			existingCaseMngt.getCaseNumber(), newCaseMngt.getCaseNumber());
		Assert.assertEquals(
			existingCaseMngt.getCaseType(), newCaseMngt.getCaseType());
		Assert.assertEquals(
			existingCaseMngt.getPatientName(), newCaseMngt.getPatientName());
		Assert.assertEquals(
			existingCaseMngt.getPatientAge(), newCaseMngt.getPatientAge());
		Assert.assertEquals(
			existingCaseMngt.getDescription(), newCaseMngt.getDescription());
		Assert.assertEquals(
			existingCaseMngt.getPatientGender(),
			newCaseMngt.getPatientGender());
		Assert.assertEquals(
			existingCaseMngt.getLocation(), newCaseMngt.getLocation());
		Assert.assertEquals(
			existingCaseMngt.getContactNumber(),
			newCaseMngt.getContactNumber());
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
		CaseMngt newCaseMngt = addCaseMngt();

		CaseMngt existingCaseMngt = _persistence.findByPrimaryKey(
			newCaseMngt.getPrimaryKey());

		Assert.assertEquals(existingCaseMngt, newCaseMngt);
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

	protected OrderByComparator<CaseMngt> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"Case_CaseMngt", "uuid", true, "caseId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "caseNumber", true, "caseType", true,
			"patientName", true, "patientAge", true, "description", true,
			"patientGender", true, "location", true, "contactNumber", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		CaseMngt newCaseMngt = addCaseMngt();

		CaseMngt existingCaseMngt = _persistence.fetchByPrimaryKey(
			newCaseMngt.getPrimaryKey());

		Assert.assertEquals(existingCaseMngt, newCaseMngt);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseMngt missingCaseMngt = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingCaseMngt);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		CaseMngt newCaseMngt1 = addCaseMngt();
		CaseMngt newCaseMngt2 = addCaseMngt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCaseMngt1.getPrimaryKey());
		primaryKeys.add(newCaseMngt2.getPrimaryKey());

		Map<Serializable, CaseMngt> caseMngts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, caseMngts.size());
		Assert.assertEquals(
			newCaseMngt1, caseMngts.get(newCaseMngt1.getPrimaryKey()));
		Assert.assertEquals(
			newCaseMngt2, caseMngts.get(newCaseMngt2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, CaseMngt> caseMngts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(caseMngts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		CaseMngt newCaseMngt = addCaseMngt();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCaseMngt.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, CaseMngt> caseMngts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, caseMngts.size());
		Assert.assertEquals(
			newCaseMngt, caseMngts.get(newCaseMngt.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, CaseMngt> caseMngts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(caseMngts.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		CaseMngt newCaseMngt = addCaseMngt();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newCaseMngt.getPrimaryKey());

		Map<Serializable, CaseMngt> caseMngts = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, caseMngts.size());
		Assert.assertEquals(
			newCaseMngt, caseMngts.get(newCaseMngt.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			CaseMngtLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<CaseMngt>() {

				@Override
				public void performAction(CaseMngt caseMngt) {
					Assert.assertNotNull(caseMngt);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		CaseMngt newCaseMngt = addCaseMngt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("caseId", newCaseMngt.getCaseId()));

		List<CaseMngt> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		CaseMngt existingCaseMngt = result.get(0);

		Assert.assertEquals(existingCaseMngt, newCaseMngt);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("caseId", RandomTestUtil.nextLong()));

		List<CaseMngt> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		CaseMngt newCaseMngt = addCaseMngt();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("caseId"));

		Object newCaseId = newCaseMngt.getCaseId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("caseId", new Object[] {newCaseId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingCaseId = result.get(0);

		Assert.assertEquals(existingCaseId, newCaseId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("caseId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"caseId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		CaseMngt newCaseMngt = addCaseMngt();

		_persistence.clearCache();

		_assertOriginalValues(
			_persistence.findByPrimaryKey(newCaseMngt.getPrimaryKey()));
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

		CaseMngt newCaseMngt = addCaseMngt();

		if (clearSession) {
			Session session = _persistence.openSession();

			session.flush();

			session.clear();
		}

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			CaseMngt.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("caseId", newCaseMngt.getCaseId()));

		List<CaseMngt> result = _persistence.findWithDynamicQuery(dynamicQuery);

		_assertOriginalValues(result.get(0));
	}

	private void _assertOriginalValues(CaseMngt caseMngt) {
		Assert.assertEquals(
			caseMngt.getUuid(),
			ReflectionTestUtil.invoke(
				caseMngt, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "uuid_"));
		Assert.assertEquals(
			Long.valueOf(caseMngt.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				caseMngt, "getColumnOriginalValue",
				new Class<?>[] {String.class}, "groupId"));
	}

	protected CaseMngt addCaseMngt() throws Exception {
		long pk = RandomTestUtil.nextLong();

		CaseMngt caseMngt = _persistence.create(pk);

		caseMngt.setUuid(RandomTestUtil.randomString());

		caseMngt.setGroupId(RandomTestUtil.nextLong());

		caseMngt.setCompanyId(RandomTestUtil.nextLong());

		caseMngt.setUserId(RandomTestUtil.nextLong());

		caseMngt.setUserName(RandomTestUtil.randomString());

		caseMngt.setCreateDate(RandomTestUtil.nextDate());

		caseMngt.setModifiedDate(RandomTestUtil.nextDate());

		caseMngt.setCaseNumber(RandomTestUtil.randomString());

		caseMngt.setCaseType(RandomTestUtil.randomString());

		caseMngt.setPatientName(RandomTestUtil.randomString());

		caseMngt.setPatientAge(RandomTestUtil.nextInt());

		caseMngt.setDescription(RandomTestUtil.randomString());

		caseMngt.setPatientGender(RandomTestUtil.randomString());

		caseMngt.setLocation(RandomTestUtil.randomString());

		caseMngt.setContactNumber(RandomTestUtil.randomString());

		_caseMngts.add(_persistence.update(caseMngt));

		return caseMngt;
	}

	private List<CaseMngt> _caseMngts = new ArrayList<CaseMngt>();
	private CaseMngtPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}