/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link book_reviewLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see book_reviewLocalService
 * @generated
 */
public class book_reviewLocalServiceWrapper
	implements book_reviewLocalService,
			   ServiceWrapper<book_reviewLocalService> {

	public book_reviewLocalServiceWrapper() {
		this(null);
	}

	public book_reviewLocalServiceWrapper(
		book_reviewLocalService book_reviewLocalService) {

		_book_reviewLocalService = book_reviewLocalService;
	}

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
	@Override
	public library.db.model.book_review addbook_review(
		library.db.model.book_review book_review) {

		return _book_reviewLocalService.addbook_review(book_review);
	}

	/**
	 * Creates a new book_review with the primary key. Does not add the book_review to the database.
	 *
	 * @param reviewId the primary key for the new book_review
	 * @return the new book_review
	 */
	@Override
	public library.db.model.book_review createbook_review(long reviewId) {
		return _book_reviewLocalService.createbook_review(reviewId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _book_reviewLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public library.db.model.book_review deletebook_review(
		library.db.model.book_review book_review) {

		return _book_reviewLocalService.deletebook_review(book_review);
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
	@Override
	public library.db.model.book_review deletebook_review(long reviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _book_reviewLocalService.deletebook_review(reviewId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _book_reviewLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _book_reviewLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _book_reviewLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _book_reviewLocalService.dynamicQuery();
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

		return _book_reviewLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _book_reviewLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _book_reviewLocalService.dynamicQuery(
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

		return _book_reviewLocalService.dynamicQueryCount(dynamicQuery);
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

		return _book_reviewLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public library.db.model.book_review fetchbook_review(long reviewId) {
		return _book_reviewLocalService.fetchbook_review(reviewId);
	}

	/**
	 * Returns the book_review matching the UUID and group.
	 *
	 * @param uuid the book_review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book_review, or <code>null</code> if a matching book_review could not be found
	 */
	@Override
	public library.db.model.book_review fetchbook_reviewByUuidAndGroupId(
		String uuid, long groupId) {

		return _book_reviewLocalService.fetchbook_reviewByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<library.db.model.book_review> findByLibId(
		long libId) {

		return _book_reviewLocalService.findByLibId(libId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _book_reviewLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the book_review with the primary key.
	 *
	 * @param reviewId the primary key of the book_review
	 * @return the book_review
	 * @throws PortalException if a book_review with the primary key could not be found
	 */
	@Override
	public library.db.model.book_review getbook_review(long reviewId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _book_reviewLocalService.getbook_review(reviewId);
	}

	/**
	 * Returns the book_review matching the UUID and group.
	 *
	 * @param uuid the book_review's UUID
	 * @param groupId the primary key of the group
	 * @return the matching book_review
	 * @throws PortalException if a matching book_review could not be found
	 */
	@Override
	public library.db.model.book_review getbook_reviewByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _book_reviewLocalService.getbook_reviewByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<library.db.model.book_review> getbook_reviews(
		int start, int end) {

		return _book_reviewLocalService.getbook_reviews(start, end);
	}

	/**
	 * Returns all the book_reviews matching the UUID and company.
	 *
	 * @param uuid the UUID of the book_reviews
	 * @param companyId the primary key of the company
	 * @return the matching book_reviews, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<library.db.model.book_review>
		getbook_reviewsByUuidAndCompanyId(String uuid, long companyId) {

		return _book_reviewLocalService.getbook_reviewsByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<library.db.model.book_review>
		getbook_reviewsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<library.db.model.book_review> orderByComparator) {

		return _book_reviewLocalService.getbook_reviewsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of book_reviews.
	 *
	 * @return the number of book_reviews
	 */
	@Override
	public int getbook_reviewsCount() {
		return _book_reviewLocalService.getbook_reviewsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _book_reviewLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _book_reviewLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public library.db.model.book_review getInstance() {
		return _book_reviewLocalService.getInstance();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _book_reviewLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _book_reviewLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public library.db.model.book_review updatebook_review(
		library.db.model.book_review book_review) {

		return _book_reviewLocalService.updatebook_review(book_review);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _book_reviewLocalService.getBasePersistence();
	}

	@Override
	public book_reviewLocalService getWrappedService() {
		return _book_reviewLocalService;
	}

	@Override
	public void setWrappedService(
		book_reviewLocalService book_reviewLocalService) {

		_book_reviewLocalService = book_reviewLocalService;
	}

	private book_reviewLocalService _book_reviewLocalService;

}