/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package employe.db.layer.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Practice_employee&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see employee
 * @generated
 */
public class employeeTable extends BaseTable<employeeTable> {

	public static final employeeTable INSTANCE = new employeeTable();

	public final Column<employeeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Long> empId = createColumn(
		"empId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<employeeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<employeeTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<employeeTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, String> salary = createColumn(
		"salary", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, Integer> age = createColumn(
		"age", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<employeeTable, String> company = createColumn(
		"company", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<employeeTable, String> gender = createColumn(
		"gender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private employeeTable() {
		super("Practice_employee", employeeTable::new);
	}

}