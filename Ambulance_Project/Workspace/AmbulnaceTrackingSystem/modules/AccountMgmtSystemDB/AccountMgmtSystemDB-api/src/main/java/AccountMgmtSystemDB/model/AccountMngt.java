/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AccountMngt service. Represents a row in the &quot;Account_AccountMngt&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngtModel
 * @generated
 */
@ImplementationClassName("AccountMgmtSystemDB.model.impl.AccountMngtImpl")
@ProviderType
public interface AccountMngt extends AccountMngtModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>AccountMgmtSystemDB.model.impl.AccountMngtImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AccountMngt, Long> ACCOUNT_ID_ACCESSOR =
		new Accessor<AccountMngt, Long>() {

			@Override
			public Long get(AccountMngt accountMngt) {
				return accountMngt.getAccountId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AccountMngt> getTypeClass() {
				return AccountMngt.class;
			}

		};

}