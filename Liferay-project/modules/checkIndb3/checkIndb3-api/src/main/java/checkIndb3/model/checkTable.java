/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package checkIndb3.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;practice_check&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see check
 * @generated
 */
public class checkTable extends BaseTable<checkTable> {

	public static final checkTable INSTANCE = new checkTable();

	public final Column<checkTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<checkTable, Long> checkInId = createColumn(
		"checkInId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<checkTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<checkTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<checkTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<checkTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<checkTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<checkTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<checkTable, Date> date = createColumn(
		"date_", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<checkTable, String> day = createColumn(
		"day", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<checkTable, Date> checkInTime = createColumn(
		"checkInTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<checkTable, Date> checkOutTime = createColumn(
		"checkOutTime", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<checkTable, String> totalHours = createColumn(
		"totalHours", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<checkTable, Date> createdAt = createColumn(
		"createdAt", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private checkTable() {
		super("practice_check", checkTable::new);
	}

}