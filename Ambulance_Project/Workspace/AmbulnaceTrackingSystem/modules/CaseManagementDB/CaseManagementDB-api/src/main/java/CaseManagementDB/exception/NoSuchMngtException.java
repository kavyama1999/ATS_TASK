/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package CaseManagementDB.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMngtException extends NoSuchModelException {

	public NoSuchMngtException() {
	}

	public NoSuchMngtException(String msg) {
		super(msg);
	}

	public NoSuchMngtException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchMngtException(Throwable throwable) {
		super(throwable);
	}

}