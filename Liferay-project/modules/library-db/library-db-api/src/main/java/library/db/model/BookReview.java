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
 * The extended model interface for the BookReview service. Represents a row in the &quot;lib_BookReview&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see BookReviewModel
 * @generated
 */
@ImplementationClassName("library.db.model.impl.BookReviewImpl")
@ProviderType
public interface BookReview extends BookReviewModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>library.db.model.impl.BookReviewImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BookReview, Long> REVIEW_ID_ACCESSOR =
		new Accessor<BookReview, Long>() {

			@Override
			public Long get(BookReview bookReview) {
				return bookReview.getReviewId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BookReview> getTypeClass() {
				return BookReview.class;
			}

		};

}