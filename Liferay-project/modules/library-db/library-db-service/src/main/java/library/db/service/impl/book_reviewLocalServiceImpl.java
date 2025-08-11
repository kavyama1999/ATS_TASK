/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import library.db.model.book_review;
import library.db.model.impl.book_reviewImpl;
import library.db.service.base.book_reviewLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=library.db.model.book_review",
	service = AopService.class
)
public class book_reviewLocalServiceImpl
	extends book_reviewLocalServiceBaseImpl {
	
	public book_review getInstance() {
		book_review bookReview = new book_reviewImpl();
		return bookReview;
	}

	@Override
	public List<book_review> findByLibId(long libId) {
		// TODO Auto-generated method stub
		return book_reviewPersistence.findByLibId(libId);
	}
}