/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CaseMngt service. Represents a row in the &quot;Case_CaseMngt&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngtModel
 * @generated
 */
@ImplementationClassName("CaseManagementDB.model.impl.CaseMngtImpl")
@ProviderType
public interface CaseMngt extends CaseMngtModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>CaseManagementDB.model.impl.CaseMngtImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CaseMngt, Long> CASE_ID_ACCESSOR =
		new Accessor<CaseMngt, Long>() {

			@Override
			public Long get(CaseMngt caseMngt) {
				return caseMngt.getCaseId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<CaseMngt> getTypeClass() {
				return CaseMngt.class;
			}

		};

}