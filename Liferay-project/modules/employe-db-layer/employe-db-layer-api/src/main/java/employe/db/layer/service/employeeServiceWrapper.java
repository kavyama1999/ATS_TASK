/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package employe.db.layer.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link employeeService}.
 *
 * @author Brian Wing Shun Chan
 * @see employeeService
 * @generated
 */
public class employeeServiceWrapper
	implements employeeService, ServiceWrapper<employeeService> {

	public employeeServiceWrapper() {
		this(null);
	}

	public employeeServiceWrapper(employeeService employeeService) {
		_employeeService = employeeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _employeeService.getOSGiServiceIdentifier();
	}

	@Override
	public employeeService getWrappedService() {
		return _employeeService;
	}

	@Override
	public void setWrappedService(employeeService employeeService) {
		_employeeService = employeeService;
	}

	private employeeService _employeeService;

}