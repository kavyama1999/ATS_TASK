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

import library.db.model.BookReview;

/**
 * Provides the local service utility for BookReview. This utility wraps
 * <code>library.db.service.impl.BookReviewLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see BookReviewLocalService
 * @generated
 */
public class BookReviewLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>library.db.service.impl.BookReviewLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the book review to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookReview the book review
	 * @return the book review that was added
	 */
	public static BookReview addBookReview(BookReview bookReview) {
		return getService().addBookReview(bookReview);
	}

	/**
	 * Creates a new book review with the primary key. Does not add the book review to the database.
	 *
	 * @param reviewId the primary key for the new book review
	 * @return the new book review
	 */
	public static BookReview createBookReview(long reviewId) {
		return getService().createBookReview(reviewId);
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
	 * Deletes the book review from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookReview the book review
	 * @return the book review that was removed
	 */
	public static BookReview deleteBookReview(BookReview bookReview) {
		return getService().deleteBookReview(bookReview);
	}

	/**
	 * Deletes the book review with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review that was removed
	 * @throws PortalException if a book review with the primary key could not be found
	 */
	public static BookReview deleteBookReview(long reviewId)
		throws PortalException {

		return getService().deleteBookReview(reviewId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.BookReviewModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.BookReviewModelImpl</code>.
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

	public static BookReview fetchBookReview(long reviewId) {
		return getService().fetchBookReview(reviewId);
	}

	/**
	 * Returns the book review matching the UUID and group.
	 *
	 * @param uuid the book review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book review, or <code>null</code> if a matching book review could not be found
	 */
	public static BookReview fetchBookReviewByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchBookReviewByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the book review with the primary key.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review
	 * @throws PortalException if a book review with the primary key could not be found
	 */
	public static BookReview getBookReview(long reviewId)
		throws PortalException {

		return getService().getBookReview(reviewId);
	}

	/**
	 * Returns the book review matching the UUID and group.
	 *
	 * @param uuid the book review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book review
	 * @throws PortalException if a matching book review could not be found
	 */
	public static BookReview getBookReviewByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getBookReviewByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the book reviews.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.BookReviewModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @return the range of book reviews
	 */
	public static List<BookReview> getBookReviews(int start, int end) {
		return getService().getBookReviews(start, end);
	}

	/**
	 * Returns all the book reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the book reviews
	 * @param companyId the primary key of the company
	 * @return the matching book reviews, or an empty list if no matches were found
	 */
	public static List<BookReview> getBookReviewsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getBookReviewsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of book reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the book reviews
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of book reviews
	 * @param end the upper bound of the range of book reviews (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching book reviews, or an empty list if no matches were found
	 */
	public static List<BookReview> getBookReviewsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BookReview> orderByComparator) {

		return getService().getBookReviewsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of book reviews.
	 *
	 * @return the number of book reviews
	 */
	public static int getBookReviewsCount() {
		return getService().getBookReviewsCount();
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
	 * Updates the book review in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect BookReviewLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param bookReview the book review
	 * @return the book review that was updated
	 */
	public static BookReview updateBookReview(BookReview bookReview) {
		return getService().updateBookReview(bookReview);
	}

	public static BookReviewLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<BookReviewLocalService> _serviceSnapshot =
		new Snapshot<>(
			BookReviewLocalServiceUtil.class, BookReviewLocalService.class);

}