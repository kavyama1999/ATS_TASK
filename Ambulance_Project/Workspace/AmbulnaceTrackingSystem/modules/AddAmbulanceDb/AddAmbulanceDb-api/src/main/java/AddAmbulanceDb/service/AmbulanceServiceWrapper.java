/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AmbulanceService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmbulanceService
 * @generated
 */
public class AmbulanceServiceWrapper
	implements AmbulanceService, ServiceWrapper<AmbulanceService> {

	public AmbulanceServiceWrapper() {
		this(null);
	}

	public AmbulanceServiceWrapper(AmbulanceService ambulanceService) {
		_ambulanceService = ambulanceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ambulanceService.getOSGiServiceIdentifier();
	}

	@Override
	public AmbulanceService getWrappedService() {
		return _ambulanceService;
	}

	@Override
	public void setWrappedService(AmbulanceService ambulanceService) {
		_ambulanceService = ambulanceService;
	}

	private AmbulanceService _ambulanceService;

}