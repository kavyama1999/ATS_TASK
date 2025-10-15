/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AddAmbulanceDb.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;HSP_Driver&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Driver
 * @generated
 */
public class DriverTable extends BaseTable<DriverTable> {

	public static final DriverTable INSTANCE = new DriverTable();

	public final Column<DriverTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, Long> driverId = createColumn(
		"driverId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DriverTable, Long> hospitalId = createColumn(
		"hospitalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DriverTable, Long> ambulanceId = createColumn(
		"ambulanceId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DriverTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<DriverTable, String> driverName = createColumn(
		"driverName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, String> contactNumber = createColumn(
		"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, String> address = createColumn(
		"address", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DriverTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<DriverTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private DriverTable() {
		super("HSP_Driver", DriverTable::new);
	}

}