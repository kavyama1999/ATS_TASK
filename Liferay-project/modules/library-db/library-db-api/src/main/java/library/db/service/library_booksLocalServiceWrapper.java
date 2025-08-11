/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link library_booksLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see library_booksLocalService
 * @generated
 */
public class library_booksLocalServiceWrapper
	implements library_booksLocalService,
			   ServiceWrapper<library_booksLocalService> {

	public library_booksLocalServiceWrapper() {
		this(null);
	}

	public library_booksLocalServiceWrapper(
		library_booksLocalService library_booksLocalService) {

		_library_booksLocalService = library_booksLocalService;
	}

	/**
	 * Adds the library_books to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect library_booksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library_books the library_books
	 * @return the library_books that was added
	 */
	@Override
	public library.db.model.library_books addlibrary_books(
		library.db.model.library_books library_books) {

		return _library_booksLocalService.addlibrary_books(library_books);
	}

	/**
	 * Creates a new library_books with the primary key. Does not add the library_books to the database.
	 *
	 * @param libId the primary key for the new library_books
	 * @return the new library_books
	 */
	@Override
	public library.db.model.library_books createlibrary_books(long libId) {
		return _library_booksLocalService.createlibrary_books(libId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _library_booksLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the library_books from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect library_booksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library_books the library_books
	 * @return the library_books that was removed
	 */
	@Override
	public library.db.model.library_books deletelibrary_books(
		library.db.model.library_books library_books) {

		return _library_booksLocalService.deletelibrary_books(library_books);
	}

	/**
	 * Deletes the library_books with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect library_booksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books that was removed
	 * @throws PortalException if a library_books with the primary key could not be found
	 */
	@Override
	public library.db.model.library_books deletelibrary_books(long libId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _library_booksLocalService.deletelibrary_books(libId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _library_booksLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _library_booksLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _library_booksLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _library_booksLocalService.dynamicQuery();
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

		return _library_booksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.library_booksModelImpl</code>.
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

		return _library_booksLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.library_booksModelImpl</code>.
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

		return _library_booksLocalService.dynamicQuery(
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

		return _library_booksLocalService.dynamicQueryCount(dynamicQuery);
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

		return _library_booksLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public library.db.model.library_books fetchlibrary_books(long libId) {
		return _library_booksLocalService.fetchlibrary_books(libId);
	}

	/**
	 * Returns the library_books matching the UUID and group.
	 *
	 * @param uuid the library_books's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	@Override
	public library.db.model.library_books fetchlibrary_booksByUuidAndGroupId(
		String uuid, long groupId) {

		return _library_booksLocalService.fetchlibrary_booksByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public java.util.List<library.db.model.library_books> findByGroupId(
		long groupId) {

		return _library_booksLocalService.findByGroupId(groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _library_booksLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _library_booksLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _library_booksLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public library.db.model.library_books getInstance() {
		return _library_booksLocalService.getInstance();
	}

	/**
	 * Returns the library_books with the primary key.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books
	 * @throws PortalException if a library_books with the primary key could not be found
	 */
	@Override
	public library.db.model.library_books getlibrary_books(long libId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _library_booksLocalService.getlibrary_books(libId);
	}

	/**
	 * Returns the library_books matching the UUID and group.
	 *
	 * @param uuid the library_books's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library_books
	 * @throws PortalException if a matching library_books could not be found
	 */
	@Override
	public library.db.model.library_books getlibrary_booksByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _library_booksLocalService.getlibrary_booksByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Returns a range of all the library_bookses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.library_booksModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @return the range of library_bookses
	 */
	@Override
	public java.util.List<library.db.model.library_books> getlibrary_bookses(
		int start, int end) {

		return _library_booksLocalService.getlibrary_bookses(start, end);
	}

	/**
	 * Returns all the library_bookses matching the UUID and company.
	 *
	 * @param uuid the UUID of the library_bookses
	 * @param companyId the primary key of the company
	 * @return the matching library_bookses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<library.db.model.library_books>
		getlibrary_booksesByUuidAndCompanyId(String uuid, long companyId) {

		return _library_booksLocalService.getlibrary_booksesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of library_bookses matching the UUID and company.
	 *
	 * @param uuid the UUID of the library_bookses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of library_bookses
	 * @param end the upper bound of the range of library_bookses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching library_bookses, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<library.db.model.library_books>
		getlibrary_booksesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<library.db.model.library_books> orderByComparator) {

		return _library_booksLocalService.getlibrary_booksesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of library_bookses.
	 *
	 * @return the number of library_bookses
	 */
	@Override
	public int getlibrary_booksesCount() {
		return _library_booksLocalService.getlibrary_booksesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _library_booksLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _library_booksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the library_books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect library_booksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library_books the library_books
	 * @return the library_books that was updated
	 */
	@Override
	public library.db.model.library_books updatelibrary_books(
		library.db.model.library_books library_books) {

		return _library_booksLocalService.updatelibrary_books(library_books);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _library_booksLocalService.getBasePersistence();
	}

	@Override
	public library_booksLocalService getWrappedService() {
		return _library_booksLocalService;
	}

	@Override
	public void setWrappedService(
		library_booksLocalService library_booksLocalService) {

		_library_booksLocalService = library_booksLocalService;
	}

	private library_booksLocalService _library_booksLocalService;

}