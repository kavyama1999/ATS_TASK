package com.ats.client.serdes.v1_0;

import com.ats.client.dto.v1_0.Student;
import com.ats.client.json.BaseJSONParser;

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
public class StudentSerDes {

	public static Student toDTO(String json) {
		StudentJSONParser studentJSONParser = new StudentJSONParser();

		return studentJSONParser.parseToDTO(json);
	}

	public static Student[] toDTOs(String json) {
		StudentJSONParser studentJSONParser = new StudentJSONParser();

		return studentJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Student student) {
		if (student == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (student.getData() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"data\": ");

			if (student.getData() instanceof String) {
				sb.append("\"");
				sb.append((String)student.getData());
				sb.append("\"");
			}
			else {
				sb.append(student.getData());
			}
		}

		if (student.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(student.getId());
		}

		if (student.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			if (student.getMessage() instanceof String) {
				sb.append("\"");
				sb.append((String)student.getMessage());
				sb.append("\"");
			}
			else {
				sb.append(student.getMessage());
			}
		}

		if (student.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(student.getName()));

			sb.append("\"");
		}

		if (student.getStandard() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"standard\": ");

			sb.append("\"");

			sb.append(_escape(student.getStandard()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		StudentJSONParser studentJSONParser = new StudentJSONParser();

		return studentJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Student student) {
		if (student == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (student.getData() == null) {
			map.put("data", null);
		}
		else {
			map.put("data", String.valueOf(student.getData()));
		}

		if (student.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(student.getId()));
		}

		if (student.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(student.getMessage()));
		}

		if (student.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(student.getName()));
		}

		if (student.getStandard() == null) {
			map.put("standard", null);
		}
		else {
			map.put("standard", String.valueOf(student.getStandard()));
		}

		return map;
	}

	public static class StudentJSONParser extends BaseJSONParser<Student> {

		@Override
		protected Student createDTO() {
			return new Student();
		}

		@Override
		protected Student[] createDTOArray(int size) {
			return new Student[size];
		}

		@Override
		protected void setField(
			Student student, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "data")) {
				if (jsonParserFieldValue != null) {
					student.setData((Object)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					student.setId(Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					student.setMessage((Object)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					student.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "standard")) {
				if (jsonParserFieldValue != null) {
					student.setStandard((String)jsonParserFieldValue);
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