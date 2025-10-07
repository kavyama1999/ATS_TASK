/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AmbulanceDb2.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;AMB_AmbSignUp&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AmbSignUp
 * @generated
 */
public class AmbSignUpTable extends BaseTable<AmbSignUpTable> {

	public static final AmbSignUpTable INSTANCE = new AmbSignUpTable();

	public final Column<AmbSignUpTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbSignUpTable, Long> otpId = createColumn(
		"otpId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AmbSignUpTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AmbSignUpTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AmbSignUpTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AmbSignUpTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AmbSignUpTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AmbSignUpTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AmbSignUpTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<AmbSignUpTable, String> OTP = createColumn(
		"OTP", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	public final Column<AmbSignUpTable, Boolean> status = createColumn(
		"status", Boolean.class, Types.BOOLEAN, Column.FLAG_DEFAULT);

	private AmbSignUpTable() {
		super("AMB_AmbSignUp", AmbSignUpTable::new);
	}

}