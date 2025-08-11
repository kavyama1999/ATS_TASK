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

import library.db.model.book_review;

/**
 * The cache model class for representing book_review in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class book_reviewCacheModel
	implements CacheModel<book_review>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof book_reviewCacheModel)) {
			return false;
		}

		book_reviewCacheModel book_reviewCacheModel =
			(book_reviewCacheModel)object;

		if (reviewId == book_reviewCacheModel.reviewId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, reviewId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", reviewId=");
		sb.append(reviewId);
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
		sb.append(", libId=");
		sb.append(libId);
		sb.append(", reviewerName=");
		sb.append(reviewerName);
		sb.append(", reviewDate=");
		sb.append(reviewDate);
		sb.append(", rating=");
		sb.append(rating);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", approved=");
		sb.append(approved);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public book_review toEntityModel() {
		book_reviewImpl book_reviewImpl = new book_reviewImpl();

		if (uuid == null) {
			book_reviewImpl.setUuid("");
		}
		else {
			book_reviewImpl.setUuid(uuid);
		}

		book_reviewImpl.setReviewId(reviewId);
		book_reviewImpl.setGroupId(groupId);
		book_reviewImpl.setCompanyId(companyId);
		book_reviewImpl.setUserId(userId);

		if (userName == null) {
			book_reviewImpl.setUserName("");
		}
		else {
			book_reviewImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			book_reviewImpl.setCreateDate(null);
		}
		else {
			book_reviewImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			book_reviewImpl.setModifiedDate(null);
		}
		else {
			book_reviewImpl.setModifiedDate(new Date(modifiedDate));
		}

		book_reviewImpl.setLibId(libId);

		if (reviewerName == null) {
			book_reviewImpl.setReviewerName("");
		}
		else {
			book_reviewImpl.setReviewerName(reviewerName);
		}

		if (reviewDate == Long.MIN_VALUE) {
			book_reviewImpl.setReviewDate(null);
		}
		else {
			book_reviewImpl.setReviewDate(new Date(reviewDate));
		}

		book_reviewImpl.setRating(rating);

		if (comment == null) {
			book_reviewImpl.setComment("");
		}
		else {
			book_reviewImpl.setComment(comment);
		}

		book_reviewImpl.setApproved(approved);

		book_reviewImpl.resetOriginalValues();

		return book_reviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		reviewId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		libId = objectInput.readLong();
		reviewerName = objectInput.readUTF();
		reviewDate = objectInput.readLong();

		rating = objectInput.readInt();
		comment = objectInput.readUTF();

		approved = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(reviewId);

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

		objectOutput.writeLong(libId);

		if (reviewerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(reviewerName);
		}

		objectOutput.writeLong(reviewDate);

		objectOutput.writeInt(rating);

		if (comment == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(comment);
		}

		objectOutput.writeBoolean(approved);
	}

	public String uuid;
	public long reviewId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long libId;
	public String reviewerName;
	public long reviewDate;
	public int rating;
	public String comment;
	public boolean approved;

}