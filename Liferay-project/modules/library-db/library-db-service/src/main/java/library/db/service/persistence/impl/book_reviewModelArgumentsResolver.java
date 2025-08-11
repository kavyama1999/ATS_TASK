/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.service.persistence.impl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import library.db.model.book_reviewTable;
import library.db.model.impl.book_reviewImpl;
import library.db.model.impl.book_reviewModelImpl;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from book_review.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=library.db.model.impl.book_reviewImpl",
		"table.name=lib_book_review"
	},
	service = ArgumentsResolver.class
)
public class book_reviewModelArgumentsResolver implements ArgumentsResolver {

	@Override
	public Object[] getArguments(
		FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
		boolean original) {

		String[] columnNames = finderPath.getColumnNames();

		if ((columnNames == null) || (columnNames.length == 0)) {
			if (baseModel.isNew()) {
				return new Object[0];
			}

			return null;
		}

		book_reviewModelImpl book_reviewModelImpl =
			(book_reviewModelImpl)baseModel;

		long columnBitmask = book_reviewModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(book_reviewModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |=
					book_reviewModelImpl.getColumnBitmask(columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(book_reviewModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return book_reviewImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return book_reviewTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		book_reviewModelImpl book_reviewModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = book_reviewModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = book_reviewModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}