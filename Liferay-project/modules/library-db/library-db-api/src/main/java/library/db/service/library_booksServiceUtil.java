/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for library_books. This utility wraps
 * <code>library.db.service.impl.library_booksServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see library_booksService
 * @generated
 */
public class library_booksServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>library.db.service.impl.library_booksServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static library_booksService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<library_booksService> _serviceSnapshot =
		new Snapshot<>(
			library_booksServiceUtil.class, library_booksService.class);

}