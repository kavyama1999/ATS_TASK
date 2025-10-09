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
 * The extended model interface for the Ambulance service. Represents a row in the &quot;HSP_Ambulance&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AmbulanceModel
 * @generated
 */
@ImplementationClassName("AddAmbulanceDb.model.impl.AmbulanceImpl")
@ProviderType
public interface Ambulance extends AmbulanceModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>AddAmbulanceDb.model.impl.AmbulanceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Ambulance, Long> AMBULANCE_ID_ACCESSOR =
		new Accessor<Ambulance, Long>() {

			@Override
			public Long get(Ambulance ambulance) {
				return ambulance.getAmbulanceId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Ambulance> getTypeClass() {
				return Ambulance.class;
			}

		};

}