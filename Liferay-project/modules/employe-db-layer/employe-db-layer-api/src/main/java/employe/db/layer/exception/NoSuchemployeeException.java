/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package employe.db.layer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchemployeeException extends NoSuchModelException {

	public NoSuchemployeeException() {
	}

	public NoSuchemployeeException(String msg) {
		super(msg);
	}

	public NoSuchemployeeException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchemployeeException(Throwable throwable) {
		super(throwable);
	}

}