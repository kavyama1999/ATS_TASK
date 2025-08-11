/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link BookReviewLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookReviewLocalService
 * @generated
 */
public class BookReviewLocalServiceWrapper
	implements BookReviewLocalService, ServiceWrapper<BookReviewLocalService> {

	public BookReviewLocalServiceWrapper() {
		this(null);
	}

	public BookReviewLocalServiceWrapper(
		BookReviewLocalService bookReviewLocalService) {

		_bookReviewLocalService = bookReviewLocalService;
	}

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
	@Override
	public library.db.model.BookReview addBookReview(
		library.db.model.BookReview bookReview) {

		return _bookReviewLocalService.addBookReview(bookReview);
	}

	/**
	 * Creates a new book review with the primary key. Does not add the book review to the database.
	 *
	 * @param reviewId the primary key for the new book review
	 * @return the new book review
	 */
	@Override
	public library.db.model.BookReview createBookReview(long reviewId) {
		return _bookReviewLocalService.createBookReview(reviewId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookReviewLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public library.db.model.BookReview deleteBookReview(
		library.db.model.BookReview bookReview) {

		return _bookReviewLocalService.deleteBookReview(bookReview);
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
	@Override
	public library.db.model.BookReview deleteBookReview(long reviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookReviewLocalService.deleteBookReview(reviewId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookReviewLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _bookReviewLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _bookReviewLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _bookReviewLocalService.dynamicQuery();
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

		return _bookReviewLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _bookReviewLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _bookReviewLocalService.dynamicQuery(
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

		return _bookReviewLocalService.dynamicQueryCount(dynamicQuery);
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

		return _bookReviewLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public library.db.model.BookReview fetchBookReview(long reviewId) {
		return _bookReviewLocalService.fetchBookReview(reviewId);
	}

	/**
	 * Returns the book review matching the UUID and group.
	 *
	 * @param uuid the book review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book review, or <code>null</code> if a matching book review could not be found
	 */
	@Override
	public library.db.model.BookReview fetchBookReviewByUuidAndGroupId(
		String uuid, long groupId) {

		return _bookReviewLocalService.fetchBookReviewByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _bookReviewLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the book review with the primary key.
	 *
	 * @param reviewId the primary key of the book review
	 * @return the book review
	 * @throws PortalException if a book review with the primary key could not be found
	 */
	@Override
	public library.db.model.BookReview getBookReview(long reviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookReviewLocalService.getBookReview(reviewId);
	}

	/**
	 * Returns the book review matching the UUID and group.
	 *
	 * @param uuid the book review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book review
	 * @throws PortalException if a matching book review could not be found
	 */
	@Override
	public library.db.model.BookReview getBookReviewByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookReviewLocalService.getBookReviewByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<library.db.model.BookReview> getBookReviews(
		int start, int end) {

		return _bookReviewLocalService.getBookReviews(start, end);
	}

	/**
	 * Returns all the book reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the book reviews
	 * @param companyId the primary key of the company
	 * @return the matching book reviews, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<library.db.model.BookReview>
		getBookReviewsByUuidAndCompanyId(String uuid, long companyId) {

		return _bookReviewLocalService.getBookReviewsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<library.db.model.BookReview>
		getBookReviewsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<library.db.model.BookReview> orderByComparator) {

		return _bookReviewLocalService.getBookReviewsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of book reviews.
	 *
	 * @return the number of book reviews
	 */
	@Override
	public int getBookReviewsCount() {
		return _bookReviewLocalService.getBookReviewsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _bookReviewLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _bookReviewLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookReviewLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _bookReviewLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public library.db.model.BookReview updateBookReview(
		library.db.model.BookReview bookReview) {

		return _bookReviewLocalService.updateBookReview(bookReview);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _bookReviewLocalService.getBasePersistence();
	}

	@Override
	public BookReviewLocalService getWrappedService() {
		return _bookReviewLocalService;
	}

	@Override
	public void setWrappedService(
		BookReviewLocalService bookReviewLocalService) {

		_bookReviewLocalService = bookReviewLocalService;
	}

	private BookReviewLocalService _bookReviewLocalService;

}