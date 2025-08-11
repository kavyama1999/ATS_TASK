/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link book_reviewService}.
 *
 * @author Brian Wing Shun Chan
 * @see book_reviewService
 * @generated
 */
public class book_reviewServiceWrapper
	implements book_reviewService, ServiceWrapper<book_reviewService> {

	public book_reviewServiceWrapper() {
		this(null);
	}

	public book_reviewServiceWrapper(book_reviewService book_reviewService) {
		_book_reviewService = book_reviewService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _book_reviewService.getOSGiServiceIdentifier();
	}

	@Override
	public book_reviewService getWrappedService() {
		return _book_reviewService;
	}

	@Override
	public void setWrappedService(book_reviewService book_reviewService) {
		_book_reviewService = book_reviewService;
	}

	private book_reviewService _book_reviewService;

}