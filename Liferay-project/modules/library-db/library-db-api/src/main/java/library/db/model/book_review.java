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
 * The extended model interface for the book_review service. Represents a row in the &quot;lib_book_review&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see book_reviewModel
 * @generated
 */
@ImplementationClassName("library.db.model.impl.book_reviewImpl")
@ProviderType
public interface book_review extends book_reviewModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>library.db.model.impl.book_reviewImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<book_review, Long> REVIEW_ID_ACCESSOR =
		new Accessor<book_review, Long>() {

			@Override
			public Long get(book_review book_review) {
				return book_review.getReviewId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<book_review> getTypeClass() {
				return book_review.class;
			}

		};

}