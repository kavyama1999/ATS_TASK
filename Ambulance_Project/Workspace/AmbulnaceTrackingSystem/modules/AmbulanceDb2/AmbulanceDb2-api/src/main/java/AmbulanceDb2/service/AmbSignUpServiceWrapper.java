/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AmbSignUpService}.
 *
 * @author Brian Wing Shun Chan
 * @see AmbSignUpService
 * @generated
 */
public class AmbSignUpServiceWrapper
	implements AmbSignUpService, ServiceWrapper<AmbSignUpService> {

	public AmbSignUpServiceWrapper() {
		this(null);
	}

	public AmbSignUpServiceWrapper(AmbSignUpService ambSignUpService) {
		_ambSignUpService = ambSignUpService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ambSignUpService.getOSGiServiceIdentifier();
	}

	@Override
	public AmbSignUpService getWrappedService() {
		return _ambSignUpService;
	}

	@Override
	public void setWrappedService(AmbSignUpService ambSignUpService) {
		_ambSignUpService = ambSignUpService;
	}

	private AmbSignUpService _ambSignUpService;

}