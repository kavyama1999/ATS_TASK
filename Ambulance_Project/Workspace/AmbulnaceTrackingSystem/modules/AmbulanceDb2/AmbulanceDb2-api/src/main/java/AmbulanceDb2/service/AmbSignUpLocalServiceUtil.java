/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service;

import AmbulanceDb2.model.AmbSignUp;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AmbSignUp. This utility wraps
 * <code>AmbulanceDb2.service.impl.AmbSignUpLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AmbSignUpLocalService
 * @generated
 */
public class AmbSignUpLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>AmbulanceDb2.service.impl.AmbSignUpLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static AmbSignUp addAmbSignUp(AmbSignUp ambSignUp) {
		return getService().addAmbSignUp(ambSignUp);
	}

	/**
	 * Creates a new amb sign up with the primary key. Does not add the amb sign up to the database.
	 *
	 * @param otpId the primary key for the new amb sign up
	 * @return the new amb sign up
	 */
	public static AmbSignUp createAmbSignUp(long otpId) {
		return getService().createAmbSignUp(otpId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
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
	public static AmbSignUp deleteAmbSignUp(AmbSignUp ambSignUp) {
		return getService().deleteAmbSignUp(ambSignUp);
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
	public static AmbSignUp deleteAmbSignUp(long otpId) throws PortalException {
		return getService().deleteAmbSignUp(otpId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AmbSignUp fetchAmbSignUp(long otpId) {
		return getService().fetchAmbSignUp(otpId);
	}

	/**
	 * Returns the amb sign up matching the UUID and group.
	 *
	 * @param uuid the amb sign up's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amb sign up, or <code>null</code> if a matching amb sign up could not be found
	 */
	public static AmbSignUp fetchAmbSignUpByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchAmbSignUpByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the amb sign up with the primary key.
	 *
	 * @param otpId the primary key of the amb sign up
	 * @return the amb sign up
	 * @throws PortalException if a amb sign up with the primary key could not be found
	 */
	public static AmbSignUp getAmbSignUp(long otpId) throws PortalException {
		return getService().getAmbSignUp(otpId);
	}

	/**
	 * Returns the amb sign up matching the UUID and group.
	 *
	 * @param uuid the amb sign up's UUID
	 * @param groupId the primary key of the group
	 * @return the matching amb sign up
	 * @throws PortalException if a matching amb sign up could not be found
	 */
	public static AmbSignUp getAmbSignUpByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getAmbSignUpByUuidAndGroupId(uuid, groupId);
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
	public static List<AmbSignUp> getAmbSignUps(int start, int end) {
		return getService().getAmbSignUps(start, end);
	}

	/**
	 * Returns all the amb sign ups matching the UUID and company.
	 *
	 * @param uuid the UUID of the amb sign ups
	 * @param companyId the primary key of the company
	 * @return the matching amb sign ups, or an empty list if no matches were found
	 */
	public static List<AmbSignUp> getAmbSignUpsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getAmbSignUpsByUuidAndCompanyId(uuid, companyId);
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
	public static List<AmbSignUp> getAmbSignUpsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<AmbSignUp> orderByComparator) {

		return getService().getAmbSignUpsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of amb sign ups.
	 *
	 * @return the number of amb sign ups
	 */
	public static int getAmbSignUpsCount() {
		return getService().getAmbSignUpsCount();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static AmbSignUp updateAmbSignUp(AmbSignUp ambSignUp) {
		return getService().updateAmbSignUp(ambSignUp);
	}

	public static AmbSignUpLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<AmbSignUpLocalService> _serviceSnapshot =
		new Snapshot<>(
			AmbSignUpLocalServiceUtil.class, AmbSignUpLocalService.class);

}