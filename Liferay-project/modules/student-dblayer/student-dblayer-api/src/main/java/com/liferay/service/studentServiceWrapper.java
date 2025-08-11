/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link studentService}.
 *
 * @author Brian Wing Shun Chan
 * @see studentService
 * @generated
 */
public class studentServiceWrapper
	implements ServiceWrapper<studentService>, studentService {

	public studentServiceWrapper() {
		this(null);
	}

	public studentServiceWrapper(studentService studentService) {
		_studentService = studentService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studentService.getOSGiServiceIdentifier();
	}

	@Override
	public studentService getWrappedService() {
		return _studentService;
	}

	@Override
	public void setWrappedService(studentService studentService) {
		_studentService = studentService;
	}

	private studentService _studentService;

}