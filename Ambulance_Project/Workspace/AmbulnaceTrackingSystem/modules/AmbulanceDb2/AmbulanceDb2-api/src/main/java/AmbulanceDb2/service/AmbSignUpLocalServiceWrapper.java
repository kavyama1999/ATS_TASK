/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AmbSignUpLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmbSignUpLocalService
 * @generated
 */
public class AmbSignUpLocalServiceWrapper
	implements AmbSignUpLocalService, ServiceWrapper<AmbSignUpLocalService> {

	public AmbSignUpLocalServiceWrapper() {
		this(null);
	}

	public AmbSignUpLocalServiceWrapper(
		AmbSignUpLocalService ambSignUpLocalService) {

		_ambSignUpLocalService = ambSignUpLocalService;
	}

	/**
	 * Adds the amb sign up to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbSignUpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ambSignUp the amb sign up
	 * @return the amb sign up that was added
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp addAmbSignUp(
		AmbulanceDb2.model.AmbSignUp ambSignUp) {

		return _ambSignUpLocalService.addAmbSignUp(ambSignUp);
	}

	/**
	 * Creates a new amb sign up with the primary key. Does not add the amb sign up to the database.
	 *
	 * @param otpId the primary key for the new amb sign up
	 * @return the new amb sign up
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp createAmbSignUp(long otpId) {
		return _ambSignUpLocalService.createAmbSignUp(otpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambSignUpLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the amb sign up from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbSignUpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ambSignUp the amb sign up
	 * @return the amb sign up that was removed
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp deleteAmbSignUp(
		AmbulanceDb2.model.AmbSignUp ambSignUp) {

		return _ambSignUpLocalService.deleteAmbSignUp(ambSignUp);
	}

	/**
	 * Deletes the amb sign up with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbSignUpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up that was removed
	 * @throws PortalException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp deleteAmbSignUp(long otpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambSignUpLocalService.deleteAmbSignUp(otpId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambSignUpLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ambSignUpLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ambSignUpLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ambSignUpLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ambSignUpLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceDb2.model.impl.AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _ambSignUpLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceDb2.model.impl.AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _ambSignUpLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _ambSignUpLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _ambSignUpLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public AmbulanceDb2.model.AmbSignUp fetchAmbSignUp(long otpId) {
		return _ambSignUpLocalService.fetchAmbSignUp(otpId);
	}

	/**
	 * Returns the amb sign up matching the UUID and group.
	 *
	 * @param uuid the amb sign up's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp fetchAmbSignUpByUuidAndGroupId(
		String uuid, long groupId) {

		return _ambSignUpLocalService.fetchAmbSignUpByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ambSignUpLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the amb sign up with the primary key.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up
	 * @throws PortalException if a amb sign up with the primary key could not be found
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp getAmbSignUp(long otpId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambSignUpLocalService.getAmbSignUp(otpId);
	}

	/**
	 * Returns the amb sign up matching the UUID and group.
	 *
	 * @param uuid the amb sign up's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amb sign up
	 * @throws PortalException if a matching amb sign up could not be found
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp getAmbSignUpByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambSignUpLocalService.getAmbSignUpByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the amb sign ups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AmbulanceDb2.model.impl.AmbSignUpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @return the range of amb sign ups
	 */
	@Override
	public java.util.List<AmbulanceDb2.model.AmbSignUp> getAmbSignUps(
		int start, int end) {

		return _ambSignUpLocalService.getAmbSignUps(start, end);
	}

	/**
	 * Returns all the amb sign ups matching the UUID and company.
	 *
	 * @param uuid the UUID of the amb sign ups
	 * @param companyId the primary key of the company
	 * @return the matching amb sign ups, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<AmbulanceDb2.model.AmbSignUp>
		getAmbSignUpsByUuidAndCompanyId(String uuid, long companyId) {

		return _ambSignUpLocalService.getAmbSignUpsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of amb sign ups matching the UUID and company.
	 *
	 * @param uuid the UUID of the amb sign ups
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of amb sign ups
	 * @param end the upper bound of the range of amb sign ups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching amb sign ups, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<AmbulanceDb2.model.AmbSignUp>
		getAmbSignUpsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<AmbulanceDb2.model.AmbSignUp> orderByComparator) {

		return _ambSignUpLocalService.getAmbSignUpsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amb sign ups.
	 *
	 * @return the number of amb sign ups
	 */
	@Override
	public int getAmbSignUpsCount() {
		return _ambSignUpLocalService.getAmbSignUpsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _ambSignUpLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ambSignUpLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ambSignUpLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambSignUpLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the amb sign up in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbSignUpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ambSignUp the amb sign up
	 * @return the amb sign up that was updated
	 */
	@Override
	public AmbulanceDb2.model.AmbSignUp updateAmbSignUp(
		AmbulanceDb2.model.AmbSignUp ambSignUp) {

		return _ambSignUpLocalService.updateAmbSignUp(ambSignUp);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _ambSignUpLocalService.getBasePersistence();
	}

	@Override
	public AmbSignUpLocalService getWrappedService() {
		return _ambSignUpLocalService;
	}

	@Override
	public void setWrappedService(AmbSignUpLocalService ambSignUpLocalService) {
		_ambSignUpLocalService = ambSignUpLocalService;
	}

	private AmbSignUpLocalService _ambSignUpLocalService;

}