/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.service.impl;

import AddAmbulanceDb.service.base.AmbulanceLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=AddAmbulanceDb.model.Ambulance",
	service = AopService.class
)
public class AmbulanceLocalServiceImpl extends AmbulanceLocalServiceBaseImpl {
}