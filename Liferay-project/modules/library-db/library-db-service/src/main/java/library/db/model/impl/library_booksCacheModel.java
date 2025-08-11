/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import library.db.model.library_books;

/**
 * The cache model class for representing library_books in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class library_booksCacheModel
	implements CacheModel<library_books>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof library_booksCacheModel)) {
			return false;
		}

		library_booksCacheModel library_booksCacheModel =
			(library_booksCacheModel)object;

		if (libId == library_booksCacheModel.libId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, libId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", libId=");
		sb.append(libId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", book_name=");
		sb.append(book_name);
		sb.append(", author=");
		sb.append(author);
		sb.append(", title=");
		sb.append(title);
		sb.append(", publisherd_year=");
		sb.append(publisherd_year);
		sb.append(", category=");
		sb.append(category);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public library_books toEntityModel() {
		library_booksImpl library_booksImpl = new library_booksImpl();

		if (uuid == null) {
			library_booksImpl.setUuid("");
		}
		else {
			library_booksImpl.setUuid(uuid);
		}

		library_booksImpl.setLibId(libId);
		library_booksImpl.setGroupId(groupId);
		library_booksImpl.setCompanyId(companyId);
		library_booksImpl.setUserId(userId);

		if (userName == null) {
			library_booksImpl.setUserName("");
		}
		else {
			library_booksImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			library_booksImpl.setCreateDate(null);
		}
		else {
			library_booksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			library_booksImpl.setModifiedDate(null);
		}
		else {
			library_booksImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (book_name == null) {
			library_booksImpl.setBook_name("");
		}
		else {
			library_booksImpl.setBook_name(book_name);
		}

		if (author == null) {
			library_booksImpl.setAuthor("");
		}
		else {
			library_booksImpl.setAuthor(author);
		}

		library_booksImpl.setTitle(title);
		library_booksImpl.setPublisherd_year(publisherd_year);

		if (category == null) {
			library_booksImpl.setCategory("");
		}
		else {
			library_booksImpl.setCategory(category);
		}

		library_booksImpl.resetOriginalValues();

		return library_booksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		libId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		book_name = objectInput.readUTF();
		author = objectInput.readUTF();

		title = objectInput.readInt();

		publisherd_year = objectInput.readInt();
		category = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(libId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (book_name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(book_name);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		objectOutput.writeInt(title);

		objectOutput.writeInt(publisherd_year);

		if (category == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(category);
		}
	}

	public String uuid;
	public long libId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String book_name;
	public String author;
	public int title;
	public int publisherd_year;
	public String category;

}