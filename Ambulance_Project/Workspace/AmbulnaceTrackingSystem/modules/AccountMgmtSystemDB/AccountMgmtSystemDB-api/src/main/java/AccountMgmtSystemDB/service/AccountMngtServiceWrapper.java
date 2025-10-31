/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AccountMngtService}.
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngtService
 * @generated
 */
public class AccountMngtServiceWrapper
	implements AccountMngtService, ServiceWrapper<AccountMngtService> {

	public AccountMngtServiceWrapper() {
		this(null);
	}

	public AccountMngtServiceWrapper(AccountMngtService accountMngtService) {
		_accountMngtService = accountMngtService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _accountMngtService.getOSGiServiceIdentifier();
	}

	@Override
	public AccountMngtService getWrappedService() {
		return _accountMngtService;
	}

	@Override
	public void setWrappedService(AccountMngtService accountMngtService) {
		_accountMngtService = accountMngtService;
	}

	private AccountMngtService _accountMngtService;

}