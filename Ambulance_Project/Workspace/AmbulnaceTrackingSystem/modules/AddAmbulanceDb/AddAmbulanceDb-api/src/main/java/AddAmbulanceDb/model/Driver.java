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
 * The extended model interface for the Driver service. Represents a row in the &quot;HSP_Driver&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DriverModel
 * @generated
 */
@ImplementationClassName("AddAmbulanceDb.model.impl.DriverImpl")
@ProviderType
public interface Driver extends DriverModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>AddAmbulanceDb.model.impl.DriverImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Driver, Long> DRIVER_ID_ACCESSOR =
		new Accessor<Driver, Long>() {

			@Override
			public Long get(Driver driver) {
				return driver.getDriverId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Driver> getTypeClass() {
				return Driver.class;
			}

		};

}