/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package AccountMgmtSystemDB.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Account_AccountMngt&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see AccountMngt
 * @generated
 */
public class AccountMngtTable extends BaseTable<AccountMngtTable> {

	public static final AccountMngtTable INSTANCE = new AccountMngtTable();

	public final Column<AccountMngtTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, Long> accountId = createColumn(
		"accountId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<AccountMngtTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> accountNumber = createColumn(
		"accountNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> accountHolderName =
		createColumn(
			"accountHolderName", String.class, Types.VARCHAR,
			Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> accountType = createColumn(
		"accountType", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> email = createColumn(
		"email", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> phoneNumber = createColumn(
		"phoneNumber", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> branchName = createColumn(
		"branchName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, Double> balance = createColumn(
		"balance", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<AccountMngtTable, String> ifscCode = createColumn(
		"ifscCode", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private AccountMngtTable() {
		super("Account_AccountMngt", AccountMngtTable::new);
	}

}