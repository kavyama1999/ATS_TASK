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
 * The table class for the &quot;lib_library_books&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see library_books
 * @generated
 */
public class library_booksTable extends BaseTable<library_booksTable> {

	public static final library_booksTable INSTANCE = new library_booksTable();

	public final Column<library_booksTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, Long> libId = createColumn(
		"libId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<library_booksTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, String> book_name = createColumn(
		"book_name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, String> author = createColumn(
		"author", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, Integer> title = createColumn(
		"title", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<library_booksTable, Integer> publisherd_year =
		createColumn(
			"publisherd_year", Integer.class, Types.INTEGER,
			Column.FLAG_DEFAULT);
	public final Column<library_booksTable, String> category = createColumn(
		"category", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private library_booksTable() {
		super("lib_library_books", library_booksTable::new);
	}

}