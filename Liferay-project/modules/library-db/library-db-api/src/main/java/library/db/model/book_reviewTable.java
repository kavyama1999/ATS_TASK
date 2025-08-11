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
 * The table class for the &quot;lib_book_review&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see book_review
 * @generated
 */
public class book_reviewTable extends BaseTable<book_reviewTable> {

	public static final book_reviewTable INSTANCE = new book_reviewTable();

	public final Column<book_reviewTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Long> reviewId = createColumn(
		"reviewId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<book_reviewTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Long> libId = createColumn(
		"libId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, String> reviewerName = createColumn(
		"reviewerName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Date> reviewDate = createColumn(
		"reviewDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Integer> rating = createColumn(
		"rating", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, String> comment = createColumn(
		"comment_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<book_reviewTable, Boolean> approved = createColumn(
		"approved", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private book_reviewTable() {
		super("lib_book_review", book_reviewTable::new);
	}

}