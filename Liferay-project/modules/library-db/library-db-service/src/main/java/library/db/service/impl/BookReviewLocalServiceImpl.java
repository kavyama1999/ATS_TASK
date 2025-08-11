/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.impl;

import com.liferay.portal.aop.AopService;

import library.db.service.base.BookReviewLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=library.db.model.BookReview",
	service = AopService.class
)
public class BookReviewLocalServiceImpl extends BookReviewLocalServiceBaseImpl {
}