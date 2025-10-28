/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package CaseManagementDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Case_CaseMngt&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see CaseMngt
 * @generated
 */
public class CaseMngtTable extends BaseTable<CaseMngtTable> {

	public static final CaseMngtTable INSTANCE = new CaseMngtTable();

	public final Column<CaseMngtTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, Long> caseId = createColumn(
		"caseId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<CaseMngtTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> caseNumber = createColumn(
		"caseNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> caseType = createColumn(
		"caseType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> patientName = createColumn(
		"patientName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, Integer> patientAge = createColumn(
		"patientAge", Integer.class, Types.INTEGER, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> patientGender = createColumn(
		"patientGender", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> location = createColumn(
		"location", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<CaseMngtTable, String> contactNumber = createColumn(
		"contactNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private CaseMngtTable() {
		super("Case_CaseMngt", CaseMngtTable::new);
	}

}