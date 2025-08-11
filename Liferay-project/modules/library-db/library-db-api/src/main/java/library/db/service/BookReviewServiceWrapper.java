/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BookReviewService}.
 *
 * @author Brian Wing Shun Chan
 * @see BookReviewService
 * @generated
 */
public class BookReviewServiceWrapper
	implements BookReviewService, ServiceWrapper<BookReviewService> {

	public BookReviewServiceWrapper() {
		this(null);
	}

	public BookReviewServiceWrapper(BookReviewService bookReviewService) {
		_bookReviewService = bookReviewService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bookReviewService.getOSGiServiceIdentifier();
	}

	@Override
	public BookReviewService getWrappedService() {
		return _bookReviewService;
	}

	@Override
	public void setWrappedService(BookReviewService bookReviewService) {
		_bookReviewService = bookReviewService;
	}

	private BookReviewService _bookReviewService;

}