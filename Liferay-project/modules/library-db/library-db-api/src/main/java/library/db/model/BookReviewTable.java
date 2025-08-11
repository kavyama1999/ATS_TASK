/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;lib_BookReview&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see BookReview
 * @generated
 */
public class BookReviewTable extends BaseTable<BookReviewTable> {

	public static final BookReviewTable INSTANCE = new BookReviewTable();

	public final Column<BookReviewTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Long> reviewId = createColumn(
		"reviewId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<BookReviewTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Long> libId = createColumn(
		"libId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, String> reviewerName = createColumn(
		"reviewerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Date> reviewDate = createColumn(
		"reviewDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Integer> rating = createColumn(
		"rating", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, String> comment = createColumn(
		"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<BookReviewTable, Boolean> approved = createColumn(
		"approved", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private BookReviewTable() {
		super("lib_BookReview", BookReviewTable::new);
	}

}