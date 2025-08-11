/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package library.db.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchrary_booksException extends NoSuchModelException {

	public NoSuchrary_booksException() {
	}

	public NoSuchrary_booksException(String msg) {
		super(msg);
	}

	public NoSuchrary_booksException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchrary_booksException(Throwable throwable) {
		super(throwable);
	}

}