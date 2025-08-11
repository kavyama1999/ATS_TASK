/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link bankService}.
 *
 * @author Brian Wing Shun Chan
 * @see bankService
 * @generated
 */
public class bankServiceWrapper
	implements bankService, ServiceWrapper<bankService> {

	public bankServiceWrapper() {
		this(null);
	}

	public bankServiceWrapper(bankService bankService) {
		_bankService = bankService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _bankService.getOSGiServiceIdentifier();
	}

	@Override
	public bankService getWrappedService() {
		return _bankService;
	}

	@Override
	public void setWrappedService(bankService bankService) {
		_bankService = bankService;
	}

	private bankService _bankService;

}