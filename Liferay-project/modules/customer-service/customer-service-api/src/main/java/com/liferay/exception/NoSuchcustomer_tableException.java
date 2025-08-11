/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.liferay.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchcustomer_tableException extends NoSuchModelException {

	public NoSuchcustomer_tableException() {
	}

	public NoSuchcustomer_tableException(String msg) {
		super(msg);
	}

	public NoSuchcustomer_tableException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchcustomer_tableException(Throwable throwable) {
		super(throwable);
	}

}