/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.liferay.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;practice_student&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see student
 * @generated
 */
public class studentTable extends BaseTable<studentTable> {

	public static final studentTable INSTANCE = new studentTable();

	public final Column<studentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, Long> studentId = createColumn(
		"studentId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<studentTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<studentTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<studentTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<studentTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> qualification = createColumn(
		"qualification", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, Long> fees = createColumn(
		"fees", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<studentTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private studentTable() {
		super("practice_student", studentTable::new);
	}

}