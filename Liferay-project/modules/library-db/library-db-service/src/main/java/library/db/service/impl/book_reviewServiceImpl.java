/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.impl;

import com.liferay.portal.aop.AopService;

import library.db.service.base.book_reviewServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=lib",
		"json.web.service.context.path=book_review"
	},
	service = AopService.class
)
public class book_reviewServiceImpl extends book_reviewServiceBaseImpl {
}