/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the library_books service. Represents a row in the &quot;lib_library_books&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see library_booksModel
 * @generated
 */
@ImplementationClassName("library.db.model.impl.library_booksImpl")
@ProviderType
public interface library_books extends library_booksModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>library.db.model.impl.library_booksImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<library_books, Long> LIB_ID_ACCESSOR =
		new Accessor<library_books, Long>() {

			@Override
			public Long get(library_books library_books) {
				return library_books.getLibId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<library_books> getTypeClass() {
				return library_books.class;
			}

		};

}