/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link DriverService}.
 *
 * @author Brian Wing Shun Chan
 * @see DriverService
 * @generated
 */
public class DriverServiceWrapper
	implements DriverService, ServiceWrapper<DriverService> {

	public DriverServiceWrapper() {
		this(null);
	}

	public DriverServiceWrapper(DriverService driverService) {
		_driverService = driverService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _driverService.getOSGiServiceIdentifier();
	}

	@Override
	public DriverService getWrappedService() {
		return _driverService;
	}

	@Override
	public void setWrappedService(DriverService driverService) {
		_driverService = driverService;
	}

	private DriverService _driverService;

}