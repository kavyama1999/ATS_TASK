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

import library.db.model.library_books;

/**
 * Provides the local service utility for library_books. This utility wraps
 * <code>library.db.service.impl.library_booksLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see library_booksLocalService
 * @generated
 */
public class library_booksLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>library.db.service.impl.library_booksLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static library_books addlibrary_books(library_books library_books) {
		return getService().addlibrary_books(library_books);
	}

	/**
	 * Creates a new library_books with the primary key. Does not add the library_books to the database.
	 *
	 * @param libId the primary key for the new library_books
	 * @return the new library_books
	 */
	public static library_books createlibrary_books(long libId) {
		return getService().createlibrary_books(libId);
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
	 * Deletes the library_books from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect library_booksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library_books the library_books
	 * @return the library_books that was removed
	 */
	public static library_books deletelibrary_books(
		library_books library_books) {

		return getService().deletelibrary_books(library_books);
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
	public static library_books deletelibrary_books(long libId)
		throws PortalException {

		return getService().deletelibrary_books(libId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.library_booksModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>library.db.model.impl.library_booksModelImpl</code>.
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

	public static library_books fetchlibrary_books(long libId) {
		return getService().fetchlibrary_books(libId);
	}

	/**
	 * Returns the library_books matching the UUID and group.
	 *
	 * @param uuid the library_books's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library_books, or <code>null</code> if a matching library_books could not be found
	 */
	public static library_books fetchlibrary_booksByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchlibrary_booksByUuidAndGroupId(uuid, groupId);
	}

	public static List<library_books> findByGroupId(long groupId) {
		return getService().findByGroupId(groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
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

	public static library_books getInstance() {
		return getService().getInstance();
	}

	/**
	 * Returns the library_books with the primary key.
	 *
	 * @param libId the primary key of the library_books
	 * @return the library_books
	 * @throws PortalException if a library_books with the primary key could not be found
	 */
	public static library_books getlibrary_books(long libId)
		throws PortalException {

		return getService().getlibrary_books(libId);
	}

	/**
	 * Returns the library_books matching the UUID and group.
	 *
	 * @param uuid the library_books's UUID
	 * @param groupId the primary key of the group
	 * @return the matching library_books
	 * @throws PortalException if a matching library_books could not be found
	 */
	public static library_books getlibrary_booksByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getlibrary_booksByUuidAndGroupId(uuid, groupId);
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
	public static List<library_books> getlibrary_bookses(int start, int end) {
		return getService().getlibrary_bookses(start, end);
	}

	/**
	 * Returns all the library_bookses matching the UUID and company.
	 *
	 * @param uuid the UUID of the library_bookses
	 * @param companyId the primary key of the company
	 * @return the matching library_bookses, or an empty list if no matches were found
	 */
	public static List<library_books> getlibrary_booksesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getlibrary_booksesByUuidAndCompanyId(
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
	public static List<library_books> getlibrary_booksesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<library_books> orderByComparator) {

		return getService().getlibrary_booksesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of library_bookses.
	 *
	 * @return the number of library_bookses
	 */
	public static int getlibrary_booksesCount() {
		return getService().getlibrary_booksesCount();
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
	 * Updates the library_books in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect library_booksLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library_books the library_books
	 * @return the library_books that was updated
	 */
	public static library_books updatelibrary_books(
		library_books library_books) {

		return getService().updatelibrary_books(library_books);
	}

	public static library_booksLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<library_booksLocalService> _serviceSnapshot =
		new Snapshot<>(
			library_booksLocalServiceUtil.class,
			library_booksLocalService.class);

}