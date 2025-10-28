/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.service.impl;

import CaseManagementDB.service.base.CaseMngtServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=case",
		"json.web.service.context.path=CaseMngt"
	},
	service = AopService.class
)
public class CaseMngtServiceImpl extends CaseMngtServiceBaseImpl {
}