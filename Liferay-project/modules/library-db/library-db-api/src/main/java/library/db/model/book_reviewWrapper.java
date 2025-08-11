/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package library.db.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link book_review}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see book_review
 * @generated
 */
public class book_reviewWrapper
	extends BaseModelWrapper<book_review>
	implements book_review, ModelWrapper<book_review> {

	public book_reviewWrapper(book_review book_review) {
		super(book_review);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("reviewId", getReviewId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("libId", getLibId());
		attributes.put("reviewerName", getReviewerName());
		attributes.put("reviewDate", getReviewDate());
		attributes.put("rating", getRating());
		attributes.put("comment", getComment());
		attributes.put("approved", isApproved());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long reviewId = (Long)attributes.get("reviewId");

		if (reviewId != null) {
			setReviewId(reviewId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long libId = (Long)attributes.get("libId");

		if (libId != null) {
			setLibId(libId);
		}

		String reviewerName = (String)attributes.get("reviewerName");

		if (reviewerName != null) {
			setReviewerName(reviewerName);
		}

		Date reviewDate = (Date)attributes.get("reviewDate");

		if (reviewDate != null) {
			setReviewDate(reviewDate);
		}

		Integer rating = (Integer)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		Boolean approved = (Boolean)attributes.get("approved");

		if (approved != null) {
			setApproved(approved);
		}
	}

	@Override
	public book_review cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the approved of this book_review.
	 *
	 * @return the approved of this book_review
	 */
	@Override
	public boolean getApproved() {
		return model.getApproved();
	}

	/**
	 * Returns the comment of this book_review.
	 *
	 * @return the comment of this book_review
	 */
	@Override
	public String getComment() {
		return model.getComment();
	}

	/**
	 * Returns the company ID of this book_review.
	 *
	 * @return the company ID of this book_review
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this book_review.
	 *
	 * @return the create date of this book_review
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this book_review.
	 *
	 * @return the group ID of this book_review
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lib ID of this book_review.
	 *
	 * @return the lib ID of this book_review
	 */
	@Override
	public long getLibId() {
		return model.getLibId();
	}

	/**
	 * Returns the modified date of this book_review.
	 *
	 * @return the modified date of this book_review
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this book_review.
	 *
	 * @return the primary key of this book_review
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rating of this book_review.
	 *
	 * @return the rating of this book_review
	 */
	@Override
	public int getRating() {
		return model.getRating();
	}

	/**
	 * Returns the review date of this book_review.
	 *
	 * @return the review date of this book_review
	 */
	@Override
	public Date getReviewDate() {
		return model.getReviewDate();
	}

	/**
	 * Returns the reviewer name of this book_review.
	 *
	 * @return the reviewer name of this book_review
	 */
	@Override
	public String getReviewerName() {
		return model.getReviewerName();
	}

	/**
	 * Returns the review ID of this book_review.
	 *
	 * @return the review ID of this book_review
	 */
	@Override
	public long getReviewId() {
		return model.getReviewId();
	}

	/**
	 * Returns the user ID of this book_review.
	 *
	 * @return the user ID of this book_review
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this book_review.
	 *
	 * @return the user name of this book_review
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this book_review.
	 *
	 * @return the user uuid of this book_review
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this book_review.
	 *
	 * @return the uuid of this book_review
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this book_review is approved.
	 *
	 * @return <code>true</code> if this book_review is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets whether this book_review is approved.
	 *
	 * @param approved the approved of this book_review
	 */
	@Override
	public void setApproved(boolean approved) {
		model.setApproved(approved);
	}

	/**
	 * Sets the comment of this book_review.
	 *
	 * @param comment the comment of this book_review
	 */
	@Override
	public void setComment(String comment) {
		model.setComment(comment);
	}

	/**
	 * Sets the company ID of this book_review.
	 *
	 * @param companyId the company ID of this book_review
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this book_review.
	 *
	 * @param createDate the create date of this book_review
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this book_review.
	 *
	 * @param groupId the group ID of this book_review
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lib ID of this book_review.
	 *
	 * @param libId the lib ID of this book_review
	 */
	@Override
	public void setLibId(long libId) {
		model.setLibId(libId);
	}

	/**
	 * Sets the modified date of this book_review.
	 *
	 * @param modifiedDate the modified date of this book_review
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this book_review.
	 *
	 * @param primaryKey the primary key of this book_review
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rating of this book_review.
	 *
	 * @param rating the rating of this book_review
	 */
	@Override
	public void setRating(int rating) {
		model.setRating(rating);
	}

	/**
	 * Sets the review date of this book_review.
	 *
	 * @param reviewDate the review date of this book_review
	 */
	@Override
	public void setReviewDate(Date reviewDate) {
		model.setReviewDate(reviewDate);
	}

	/**
	 * Sets the reviewer name of this book_review.
	 *
	 * @param reviewerName the reviewer name of this book_review
	 */
	@Override
	public void setReviewerName(String reviewerName) {
		model.setReviewerName(reviewerName);
	}

	/**
	 * Sets the review ID of this book_review.
	 *
	 * @param reviewId the review ID of this book_review
	 */
	@Override
	public void setReviewId(long reviewId) {
		model.setReviewId(reviewId);
	}

	/**
	 * Sets the user ID of this book_review.
	 *
	 * @param userId the user ID of this book_review
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this book_review.
	 *
	 * @param userName the user name of this book_review
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this book_review.
	 *
	 * @param userUuid the user uuid of this book_review
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this book_review.
	 *
	 * @param uuid the uuid of this book_review
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected book_reviewWrapper wrap(book_review book_review) {
		return new book_reviewWrapper(book_review);
	}

}