/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the customer_table service. Represents a row in the &quot;FOO_customer_table&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see customer_tableModel
 * @generated
 */
@ImplementationClassName("com.liferay.model.impl.customer_tableImpl")
@ProviderType
public interface customer_table extends customer_tableModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.liferay.model.impl.customer_tableImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<customer_table, Long> CUST_ID_ACCESSOR =
		new Accessor<customer_table, Long>() {

			@Override
			public Long get(customer_table customer_table) {
				return customer_table.getCustId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<customer_table> getTypeClass() {
				return customer_table.class;
			}

		};

}