/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ats.bank.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchbankException extends NoSuchModelException {

	public NoSuchbankException() {
	}

	public NoSuchbankException(String msg) {
		super(msg);
	}

	public NoSuchbankException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchbankException(Throwable throwable) {
		super(throwable);
	}

}