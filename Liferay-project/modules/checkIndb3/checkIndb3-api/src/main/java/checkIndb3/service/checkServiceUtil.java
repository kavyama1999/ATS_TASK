/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.service;

import com.liferay.portal.kernel.module.service.Snapshot;

/**
 * Provides the remote service utility for check. This utility wraps
 * <code>checkIndb3.service.impl.checkServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see checkService
 * @generated
 */
public class checkServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>checkIndb3.service.impl.checkServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static checkService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<checkService> _serviceSnapshot =
		new Snapshot<>(checkServiceUtil.class, checkService.class);

}