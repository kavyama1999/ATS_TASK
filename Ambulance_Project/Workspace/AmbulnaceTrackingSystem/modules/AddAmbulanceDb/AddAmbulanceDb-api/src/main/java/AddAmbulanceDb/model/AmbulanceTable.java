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
 * The table class for the &quot;HSP_Ambulance&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Ambulance
 * @generated
 */
public class AmbulanceTable extends BaseTable<AmbulanceTable> {

	public static final AmbulanceTable INSTANCE = new AmbulanceTable();

	public final Column<AmbulanceTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, Long> ambulanceId = createColumn(
		"ambulanceId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AmbulanceTable, Long> hospitalId = createColumn(
		"hospitalId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, Long> driverId = createColumn(
		"driverId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, String> driverName = createColumn(
		"driverName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, String> ambulanceNumber = createColumn(
		"ambulanceNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, String> vehicleType = createColumn(
		"vehicleType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, String> status = createColumn(
		"status", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, String> contactNumber = createColumn(
		"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AmbulanceTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);

	private AmbulanceTable() {
		super("HSP_Ambulance", AmbulanceTable::new);
	}

}