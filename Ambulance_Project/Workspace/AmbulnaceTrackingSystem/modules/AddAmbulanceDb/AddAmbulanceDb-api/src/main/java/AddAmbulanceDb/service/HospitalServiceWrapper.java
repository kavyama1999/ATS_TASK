/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link HospitalService}.
 *
 * @author Brian Wing Shun Chan
 * @see HospitalService
 * @generated
 */
public class HospitalServiceWrapper
	implements HospitalService, ServiceWrapper<HospitalService> {

	public HospitalServiceWrapper() {
		this(null);
	}

	public HospitalServiceWrapper(HospitalService hospitalService) {
		_hospitalService = hospitalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _hospitalService.getOSGiServiceIdentifier();
	}

	@Override
	public HospitalService getWrappedService() {
		return _hospitalService;
	}

	@Override
	public void setWrappedService(HospitalService hospitalService) {
		_hospitalService = hospitalService;
	}

	private HospitalService _hospitalService;

}