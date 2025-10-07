/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package AmbulanceDb2.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAmbSignUpException extends NoSuchModelException {

	public NoSuchAmbSignUpException() {
	}

	public NoSuchAmbSignUpException(String msg) {
		super(msg);
	}

	public NoSuchAmbSignUpException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAmbSignUpException(Throwable throwable) {
		super(throwable);
	}

}