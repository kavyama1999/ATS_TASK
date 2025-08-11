/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import library.db.model.book_review;

/**
 * Provides the local service utility for book_review. This utility wraps
 * <code>library.db.service.impl.book_reviewLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see book_reviewLocalService
 * @generated
 */
public class book_reviewLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>library.db.service.impl.book_reviewLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the book_review to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect book_reviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param book_review the book_review
	 * @return the book_review that was added
	 */
	public static book_review addbook_review(book_review book_review) {
		return getService().addbook_review(book_review);
	}

	/**
	 * Creates a new book_review with the primary key. Does not add the book_review to the database.
	 *
	 * @param reviewId the primary key for the new book_review
	 * @return the new book_review
	 */
	public static book_review createbook_review(long reviewId) {
		return getService().createbook_review(reviewId);
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
	 * Deletes the book_review from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect book_reviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param book_review the book_review
	 * @return the book_review that was removed
	 */
	public static book_review deletebook_review(book_review book_review) {
		return getService().deletebook_review(book_review);
	}

	/**
	 * Deletes the book_review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect book_reviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review that was removed
	 * @throws PortalException if a book_review with the primary key could not be found
	 */
	public static book_review deletebook_review(long reviewId)
		throws PortalException {

		return getService().deletebook_review(reviewId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.book_reviewModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.book_reviewModelImpl</code>.
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

	public static book_review fetchbook_review(long reviewId) {
		return getService().fetchbook_review(reviewId);
	}

	/**
	 * Returns the book_review matching the UUID and group.
	 *
	 * @param uuid the book_review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	public static book_review fetchbook_reviewByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchbook_reviewByUuidAndGroupId(uuid, groupId);
	}

	public static List<book_review> findByLibId(long libId) {
		return getService().findByLibId(libId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the book_review with the primary key.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review
	 * @throws PortalException if a book_review with the primary key could not be found
	 */
	public static book_review getbook_review(long reviewId)
		throws PortalException {

		return getService().getbook_review(reviewId);
	}

	/**
	 * Returns the book_review matching the UUID and group.
	 *
	 * @param uuid the book_review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book_review
	 * @throws PortalException if a matching book_review could not be found
	 */
	public static book_review getbook_reviewByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getbook_reviewByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the book_reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.book_reviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @return the range of book_reviews
	 */
	public static List<book_review> getbook_reviews(int start, int end) {
		return getService().getbook_reviews(start, end);
	}

	/**
	 * Returns all the book_reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the book_reviews
	 * @param companyId the primary key of the company
	 * @return the matching book_reviews, or an empty list if no matches were found
	 */
	public static List<book_review> getbook_reviewsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getbook_reviewsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of book_reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the book_reviews
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of book_reviews
	 * @param end the upper bound of the range of book_reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching book_reviews, or an empty list if no matches were found
	 */
	public static List<book_review> getbook_reviewsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<book_review> orderByComparator) {

		return getService().getbook_reviewsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of book_reviews.
	 *
	 * @return the number of book_reviews
	 */
	public static int getbook_reviewsCount() {
		return getService().getbook_reviewsCount();
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

	public static book_review getInstance() {
		return getService().getInstance();
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
	 * Updates the book_review in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect book_reviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param book_review the book_review
	 * @return the book_review that was updated
	 */
	public static book_review updatebook_review(book_review book_review) {
		return getService().updatebook_review(book_review);
	}

	public static book_reviewLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<book_reviewLocalService> _serviceSnapshot =
		new Snapshot<>(
			book_reviewLocalServiceUtil.class, book_reviewLocalService.class);

}