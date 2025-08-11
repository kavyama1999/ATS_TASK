/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link library_booksService}.
 *
 * @author Brian Wing Shun Chan
 * @see library_booksService
 * @generated
 */
public class library_booksServiceWrapper
	implements library_booksService, ServiceWrapper<library_booksService> {

	public library_booksServiceWrapper() {
		this(null);
	}

	public library_booksServiceWrapper(
		library_booksService library_booksService) {

		_library_booksService = library_booksService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _library_booksService.getOSGiServiceIdentifier();
	}

	@Override
	public library_booksService getWrappedService() {
		return _library_booksService;
	}

	@Override
	public void setWrappedService(library_booksService library_booksService) {
		_library_booksService = library_booksService;
	}

	private library_booksService _library_booksService;

}