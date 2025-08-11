/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import library.db.model.library_books;
import library.db.model.impl.library_booksImpl;
import library.db.service.base.library_booksLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;



/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=library.db.model.library_books",
	service = AopService.class
)
public class library_booksLocalServiceImpl
	extends library_booksLocalServiceBaseImpl {
	
	public library_books getInstance() {
		return new library_booksImpl();
	}

	@Override
	public List<library_books> findByGroupId(long groupId) {
		// TODO Auto-generated method stub
		return library_booksPersistence.findByGroupId(groupId);
	}
}