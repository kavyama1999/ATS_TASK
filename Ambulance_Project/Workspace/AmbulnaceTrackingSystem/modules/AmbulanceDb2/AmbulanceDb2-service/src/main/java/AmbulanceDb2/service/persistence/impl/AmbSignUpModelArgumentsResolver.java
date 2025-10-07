/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.service.persistence.impl;

import AmbulanceDb2.model.AmbSignUpTable;
import AmbulanceDb2.model.impl.AmbSignUpImpl;
import AmbulanceDb2.model.impl.AmbSignUpModelImpl;

import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.osgi.service.component.annotations.Component;

/**
 * The arguments resolver class for retrieving value from AmbSignUp.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(
	property = {
		"class.name=AmbulanceDb2.model.impl.AmbSignUpImpl",
		"table.name=AMB_AmbSignUp"
	},
	service = ArgumentsResolver.class
)
public class AmbSignUpModelArgumentsResolver implements ArgumentsResolver {

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

		AmbSignUpModelImpl ambSignUpModelImpl = (AmbSignUpModelImpl)baseModel;

		long columnBitmask = ambSignUpModelImpl.getColumnBitmask();

		if (!checkColumn || (columnBitmask == 0)) {
			return _getValue(ambSignUpModelImpl, columnNames, original);
		}

		Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
			finderPath);

		if (finderPathColumnBitmask == null) {
			finderPathColumnBitmask = 0L;

			for (String columnName : columnNames) {
				finderPathColumnBitmask |= ambSignUpModelImpl.getColumnBitmask(
					columnName);
			}

			_finderPathColumnBitmasksCache.put(
				finderPath, finderPathColumnBitmask);
		}

		if ((columnBitmask & finderPathColumnBitmask) != 0) {
			return _getValue(ambSignUpModelImpl, columnNames, original);
		}

		return null;
	}

	@Override
	public String getClassName() {
		return AmbSignUpImpl.class.getName();
	}

	@Override
	public String getTableName() {
		return AmbSignUpTable.INSTANCE.getTableName();
	}

	private static Object[] _getValue(
		AmbSignUpModelImpl ambSignUpModelImpl, String[] columnNames,
		boolean original) {

		Object[] arguments = new Object[columnNames.length];

		for (int i = 0; i < arguments.length; i++) {
			String columnName = columnNames[i];

			if (original) {
				arguments[i] = ambSignUpModelImpl.getColumnOriginalValue(
					columnName);
			}
			else {
				arguments[i] = ambSignUpModelImpl.getColumnValue(columnName);
			}
		}

		return arguments;
	}

	private static final Map<FinderPath, Long> _finderPathColumnBitmasksCache =
		new ConcurrentHashMap<>();

}