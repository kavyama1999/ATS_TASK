/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link AmbulanceLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmbulanceLocalService
 * @generated
 */
public class AmbulanceLocalServiceWrapper
	implements AmbulanceLocalService, ServiceWrapper<AmbulanceLocalService> {

	public AmbulanceLocalServiceWrapper() {
		this(null);
	}

	public AmbulanceLocalServiceWrapper(
		AmbulanceLocalService ambulanceLocalService) {

		_ambulanceLocalService = ambulanceLocalService;
	}

	/**
	 * Adds the ambulance to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbulanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ambulance the ambulance
	 * @return the ambulance that was added
	 */
	@Override
	public AddAmbulanceDb.model.Ambulance addAmbulance(
		AddAmbulanceDb.model.Ambulance ambulance) {

		return _ambulanceLocalService.addAmbulance(ambulance);
	}

	/**
	 * Creates a new ambulance with the primary key. Does not add the ambulance to the database.
	 *
	 * @param ambulanceId the primary key for the new ambulance
	 * @return the new ambulance
	 */
	@Override
	public AddAmbulanceDb.model.Ambulance createAmbulance(long ambulanceId) {
		return _ambulanceLocalService.createAmbulance(ambulanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambulanceLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the ambulance from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbulanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ambulance the ambulance
	 * @return the ambulance that was removed
	 */
	@Override
	public AddAmbulanceDb.model.Ambulance deleteAmbulance(
		AddAmbulanceDb.model.Ambulance ambulance) {

		return _ambulanceLocalService.deleteAmbulance(ambulance);
	}

	/**
	 * Deletes the ambulance with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbulanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance that was removed
	 * @throws PortalException if a ambulance with the primary key could not be found
	 */
	@Override
	public AddAmbulanceDb.model.Ambulance deleteAmbulance(long ambulanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambulanceLocalService.deleteAmbulance(ambulanceId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambulanceLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _ambulanceLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _ambulanceLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _ambulanceLocalService.dynamicQuery();
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

		return _ambulanceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddAmbulanceDb.model.impl.AmbulanceModelImpl</code>.
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

		return _ambulanceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddAmbulanceDb.model.impl.AmbulanceModelImpl</code>.
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

		return _ambulanceLocalService.dynamicQuery(
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

		return _ambulanceLocalService.dynamicQueryCount(dynamicQuery);
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

		return _ambulanceLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public AddAmbulanceDb.model.Ambulance fetchAmbulance(long ambulanceId) {
		return _ambulanceLocalService.fetchAmbulance(ambulanceId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _ambulanceLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the ambulance with the primary key.
	 *
	 * @param ambulanceId the primary key of the ambulance
	 * @return the ambulance
	 * @throws PortalException if a ambulance with the primary key could not be found
	 */
	@Override
	public AddAmbulanceDb.model.Ambulance getAmbulance(long ambulanceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambulanceLocalService.getAmbulance(ambulanceId);
	}

	/**
	 * Returns a range of all the ambulances.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AddAmbulanceDb.model.impl.AmbulanceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of ambulances
	 * @param end the upper bound of the range of ambulances (not inclusive)
	 * @return the range of ambulances
	 */
	@Override
	public java.util.List<AddAmbulanceDb.model.Ambulance> getAmbulances(
		int start, int end) {

		return _ambulanceLocalService.getAmbulances(start, end);
	}

	/**
	 * Returns the number of ambulances.
	 *
	 * @return the number of ambulances
	 */
	@Override
	public int getAmbulancesCount() {
		return _ambulanceLocalService.getAmbulancesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _ambulanceLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ambulanceLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _ambulanceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the ambulance in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AmbulanceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ambulance the ambulance
	 * @return the ambulance that was updated
	 */
	@Override
	public AddAmbulanceDb.model.Ambulance updateAmbulance(
		AddAmbulanceDb.model.Ambulance ambulance) {

		return _ambulanceLocalService.updateAmbulance(ambulance);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _ambulanceLocalService.getBasePersistence();
	}

	@Override
	public AmbulanceLocalService getWrappedService() {
		return _ambulanceLocalService;
	}

	@Override
	public void setWrappedService(AmbulanceLocalService ambulanceLocalService) {
		_ambulanceLocalService = ambulanceLocalService;
	}

	private AmbulanceLocalService _ambulanceLocalService;

}