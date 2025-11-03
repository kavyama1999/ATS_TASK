package AccountMgmtSystem.Headless_API.client.serdes.v1_0;

import AccountMgmtSystem.Headless_API.client.dto.v1_0.AccountMngt;
import AccountMgmtSystem.Headless_API.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public class AccountMngtSerDes {

	public static AccountMngt toDTO(String json) {
		AccountMngtJSONParser accountMngtJSONParser =
			new AccountMngtJSONParser();

		return accountMngtJSONParser.parseToDTO(json);
	}

	public static AccountMngt[] toDTOs(String json) {
		AccountMngtJSONParser accountMngtJSONParser =
			new AccountMngtJSONParser();

		return accountMngtJSONParser.parseToDTOs(json);
	}

	public static String toJSON(AccountMngt accountMngt) {
		if (accountMngt == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (accountMngt.getAccountHolderName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountHolderName\": ");

			sb.append("\"");

			sb.append(_escape(accountMngt.getAccountHolderName()));

			sb.append("\"");
		}

		if (accountMngt.getAccountId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountId\": ");

			sb.append(accountMngt.getAccountId());
		}

		if (accountMngt.getAccountNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountNumber\": ");

			sb.append("\"");

			sb.append(_escape(accountMngt.getAccountNumber()));

			sb.append("\"");
		}

		if (accountMngt.getAccountType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"accountType\": ");

			sb.append("\"");

			sb.append(_escape(accountMngt.getAccountType()));

			sb.append("\"");
		}

		if (accountMngt.getBalance() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"balance\": ");

			sb.append(accountMngt.getBalance());
		}

		if (accountMngt.getBranchName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"branchName\": ");

			sb.append("\"");

			sb.append(_escape(accountMngt.getBranchName()));

			sb.append("\"");
		}

		if (accountMngt.getEmail() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"email\": ");

			sb.append("\"");

			sb.append(_escape(accountMngt.getEmail()));

			sb.append("\"");
		}

		if (accountMngt.getIfscCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"ifscCode\": ");

			sb.append("\"");

			sb.append(_escape(accountMngt.getIfscCode()));

			sb.append("\"");
		}

		if (accountMngt.getPhoneNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"phoneNumber\": ");

			sb.append("\"");

			sb.append(_escape(accountMngt.getPhoneNumber()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		AccountMngtJSONParser accountMngtJSONParser =
			new AccountMngtJSONParser();

		return accountMngtJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(AccountMngt accountMngt) {
		if (accountMngt == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (accountMngt.getAccountHolderName() == null) {
			map.put("accountHolderName", null);
		}
		else {
			map.put(
				"accountHolderName",
				String.valueOf(accountMngt.getAccountHolderName()));
		}

		if (accountMngt.getAccountId() == null) {
			map.put("accountId", null);
		}
		else {
			map.put("accountId", String.valueOf(accountMngt.getAccountId()));
		}

		if (accountMngt.getAccountNumber() == null) {
			map.put("accountNumber", null);
		}
		else {
			map.put(
				"accountNumber",
				String.valueOf(accountMngt.getAccountNumber()));
		}

		if (accountMngt.getAccountType() == null) {
			map.put("accountType", null);
		}
		else {
			map.put(
				"accountType", String.valueOf(accountMngt.getAccountType()));
		}

		if (accountMngt.getBalance() == null) {
			map.put("balance", null);
		}
		else {
			map.put("balance", String.valueOf(accountMngt.getBalance()));
		}

		if (accountMngt.getBranchName() == null) {
			map.put("branchName", null);
		}
		else {
			map.put("branchName", String.valueOf(accountMngt.getBranchName()));
		}

		if (accountMngt.getEmail() == null) {
			map.put("email", null);
		}
		else {
			map.put("email", String.valueOf(accountMngt.getEmail()));
		}

		if (accountMngt.getIfscCode() == null) {
			map.put("ifscCode", null);
		}
		else {
			map.put("ifscCode", String.valueOf(accountMngt.getIfscCode()));
		}

		if (accountMngt.getPhoneNumber() == null) {
			map.put("phoneNumber", null);
		}
		else {
			map.put(
				"phoneNumber", String.valueOf(accountMngt.getPhoneNumber()));
		}

		return map;
	}

	public static class AccountMngtJSONParser
		extends BaseJSONParser<AccountMngt> {

		@Override
		protected AccountMngt createDTO() {
			return new AccountMngt();
		}

		@Override
		protected AccountMngt[] createDTOArray(int size) {
			return new AccountMngt[size];
		}

		@Override
		protected void setField(
			AccountMngt accountMngt, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "accountHolderName")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setAccountHolderName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "accountId")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setAccountId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "accountNumber")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setAccountNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "accountType")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setAccountType((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "balance")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setBalance(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "branchName")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setBranchName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "email")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setEmail((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "ifscCode")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setIfscCode((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "phoneNumber")) {
				if (jsonParserFieldValue != null) {
					accountMngt.setPhoneNumber((String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}