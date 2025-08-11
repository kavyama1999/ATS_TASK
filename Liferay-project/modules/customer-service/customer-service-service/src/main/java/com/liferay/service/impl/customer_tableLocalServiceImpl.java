/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.service.base.customer_tableLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.liferay.model.customer_table",
	service = AopService.class
)
public class customer_tableLocalServiceImpl
	extends customer_tableLocalServiceBaseImpl {
}