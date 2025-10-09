/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package AddAmbulanceDb.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchAmbulanceException extends NoSuchModelException {

	public NoSuchAmbulanceException() {
	}

	public NoSuchAmbulanceException(String msg) {
		super(msg);
	}

	public NoSuchAmbulanceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchAmbulanceException(Throwable throwable) {
		super(throwable);
	}

}