/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package library.db.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchbook_reviewException extends NoSuchModelException {

	public NoSuchbook_reviewException() {
	}

	public NoSuchbook_reviewException(String msg) {
		super(msg);
	}

	public NoSuchbook_reviewException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchbook_reviewException(Throwable throwable) {
		super(throwable);
	}

}