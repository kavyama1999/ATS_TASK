/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link checkService}.
 *
 * @author Brian Wing Shun Chan
 * @see checkService
 * @generated
 */
public class checkServiceWrapper
	implements checkService, ServiceWrapper<checkService> {

	public checkServiceWrapper() {
		this(null);
	}

	public checkServiceWrapper(checkService checkService) {
		_checkService = checkService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _checkService.getOSGiServiceIdentifier();
	}

	@Override
	public checkService getWrappedService() {
		return _checkService;
	}

	@Override
	public void setWrappedService(checkService checkService) {
		_checkService = checkService;
	}

	private checkService _checkService;

}