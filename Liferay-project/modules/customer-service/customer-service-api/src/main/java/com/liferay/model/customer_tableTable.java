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
 * The table class for the &quot;FOO_customer_table&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see customer_table
 * @generated
 */
public class customer_tableTable extends BaseTable<customer_tableTable> {

	public static final customer_tableTable INSTANCE =
		new customer_tableTable();

	public final Column<customer_tableTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, Long> custId = createColumn(
		"custId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<customer_tableTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, String> custName = createColumn(
		"custName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, String> age = createColumn(
		"age", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, Long> salary = createColumn(
		"salary", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<customer_tableTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private customer_tableTable() {
		super("FOO_customer_table", customer_tableTable::new);
	}

}