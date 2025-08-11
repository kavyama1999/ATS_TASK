/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link customer_tableService}.
 *
 * @author Brian Wing Shun Chan
 * @see customer_tableService
 * @generated
 */
public class customer_tableServiceWrapper
	implements customer_tableService, ServiceWrapper<customer_tableService> {

	public customer_tableServiceWrapper() {
		this(null);
	}

	public customer_tableServiceWrapper(
		customer_tableService customer_tableService) {

		_customer_tableService = customer_tableService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customer_tableService.getOSGiServiceIdentifier();
	}

	@Override
	public customer_tableService getWrappedService() {
		return _customer_tableService;
	}

	@Override
	public void setWrappedService(customer_tableService customer_tableService) {
		_customer_tableService = customer_tableService;
	}

	private customer_tableService _customer_tableService;

}