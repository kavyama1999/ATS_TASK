/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ats.bank.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the bank service. Represents a row in the &quot;practice_bank&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see bankModel
 * @generated
 */
@ImplementationClassName("com.ats.bank.model.impl.bankImpl")
@ProviderType
public interface bank extends bankModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ats.bank.model.impl.bankImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<bank, Long> BANK_ID_ACCESSOR =
		new Accessor<bank, Long>() {

			@Override
			public Long get(bank bank) {
				return bank.getBankId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<bank> getTypeClass() {
				return bank.class;
			}

		};

}