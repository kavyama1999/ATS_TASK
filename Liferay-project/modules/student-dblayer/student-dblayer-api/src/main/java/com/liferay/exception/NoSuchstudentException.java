/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchstudentException extends NoSuchModelException {

	public NoSuchstudentException() {
	}

	public NoSuchstudentException(String msg) {
		super(msg);
	}

	public NoSuchstudentException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchstudentException(Throwable throwable) {
		super(throwable);
	}

}