/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CaseMngtService}.
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngtService
 * @generated
 */
public class CaseMngtServiceWrapper
	implements CaseMngtService, ServiceWrapper<CaseMngtService> {

	public CaseMngtServiceWrapper() {
		this(null);
	}

	public CaseMngtServiceWrapper(CaseMngtService caseMngtService) {
		_caseMngtService = caseMngtService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _caseMngtService.getOSGiServiceIdentifier();
	}

	@Override
	public CaseMngtService getWrappedService() {
		return _caseMngtService;
	}

	@Override
	public void setWrappedService(CaseMngtService caseMngtService) {
		_caseMngtService = caseMngtService;
	}

	private CaseMngtService _caseMngtService;

}