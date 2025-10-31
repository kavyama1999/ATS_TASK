/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.service;

import AccountMgmtSystemDB.model.AccountMngt;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for AccountMngt. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngtLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AccountMngtLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>AccountMgmtSystemDB.service.impl.AccountMngtLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the account mngt local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link AccountMngtLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the account mngt to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountMngt the account mngt
	 * @return the account mngt that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AccountMngt addAccountMngt(AccountMngt accountMngt);

	/**
	 * Creates a new account mngt with the primary key. Does not add the account mngt to the database.
	 *
	 * @param accountId the primary key for the new account mngt
	 * @return the new account mngt
	 */
	@Transactional(enabled = false)
	public AccountMngt createAccountMngt(long accountId);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the account mngt from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountMngt the account mngt
	 * @return the account mngt that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public AccountMngt deleteAccountMngt(AccountMngt accountMngt);

	/**
	 * Deletes the account mngt with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt that was removed
	 * @throws PortalException if a account mngt with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public AccountMngt deleteAccountMngt(long accountId) throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMgmtSystemDB.model.impl.AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMgmtSystemDB.model.impl.AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountMngt fetchAccountMngt(long accountId);

	/**
	 * Returns the account mngt matching the UUID and group.
	 *
	 * @param uuid the account mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account mngt, or <code>null</code> if a matching account mngt could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountMngt fetchAccountMngtByUuidAndGroupId(
		String uuid, long groupId);

	/**
	 * Returns the account mngt with the primary key.
	 *
	 * @param accountId the primary key of the account mngt
	 * @return the account mngt
	 * @throws PortalException if a account mngt with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountMngt getAccountMngt(long accountId) throws PortalException;

	/**
	 * Returns the account mngt matching the UUID and group.
	 *
	 * @param uuid the account mngt's UUID
	 * @param groupId the primary key of the group
	 * @return the matching account mngt
	 * @throws PortalException if a matching account mngt could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AccountMngt getAccountMngtByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the account mngts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountMgmtSystemDB.model.impl.AccountMngtModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @return the range of account mngts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountMngt> getAccountMngts(int start, int end);

	/**
	 * Returns all the account mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the account mngts
	 * @param companyId the primary key of the company
	 * @return the matching account mngts, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountMngt> getAccountMngtsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of account mngts matching the UUID and company.
	 *
	 * @param uuid the UUID of the account mngts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of account mngts
	 * @param end the upper bound of the range of account mngts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching account mngts, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AccountMngt> getAccountMngtsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AccountMngt> orderByComparator);

	/**
	 * Returns the number of account mngts.
	 *
	 * @return the number of account mngts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAccountMngtsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the account mngt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AccountMngtLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param accountMngt the account mngt
	 * @return the account mngt that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public AccountMngt updateAccountMngt(AccountMngt accountMngt);

}