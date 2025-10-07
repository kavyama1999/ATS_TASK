/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AmbSignUp service. Represents a row in the &quot;AMB_AmbSignUp&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AmbSignUpModel
 * @generated
 */
@ImplementationClassName("AmbulanceDb2.model.impl.AmbSignUpImpl")
@ProviderType
public interface AmbSignUp extends AmbSignUpModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>AmbulanceDb2.model.impl.AmbSignUpImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AmbSignUp, Long> OTP_ID_ACCESSOR =
		new Accessor<AmbSignUp, Long>() {

			@Override
			public Long get(AmbSignUp ambSignUp) {
				return ambSignUp.getOtpId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<AmbSignUp> getTypeClass() {
				return AmbSignUp.class;
			}

		};

}