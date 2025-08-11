/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.service.impl;

import com.ats.bank.model.bank;
import com.ats.bank.model.impl.bankImpl;
import com.ats.bank.service.base.bankLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ats.bank.model.bank",
	service = AopService.class
)
public class bankLocalServiceImpl extends bankLocalServiceBaseImpl {
	
	
	public bank getInstance() {
		return new bankImpl();
	}

}