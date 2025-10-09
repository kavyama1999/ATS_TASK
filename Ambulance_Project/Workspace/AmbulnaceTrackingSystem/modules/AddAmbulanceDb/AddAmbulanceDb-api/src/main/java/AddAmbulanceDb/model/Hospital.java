/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Hospital service. Represents a row in the &quot;HSP_Hospital&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see HospitalModel
 * @generated
 */
@ImplementationClassName("AddAmbulanceDb.model.impl.HospitalImpl")
@ProviderType
public interface Hospital extends HospitalModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>AddAmbulanceDb.model.impl.HospitalImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Hospital, Long> HOSPITAL_ID_ACCESSOR =
		new Accessor<Hospital, Long>() {

			@Override
			public Long get(Hospital hospital) {
				return hospital.getHospitalId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Hospital> getTypeClass() {
				return Hospital.class;
			}

		};

}