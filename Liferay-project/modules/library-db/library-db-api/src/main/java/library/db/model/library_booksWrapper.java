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
 * This class is a wrapper for {@link library_books}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see library_books
 * @generated
 */
public class library_booksWrapper
	extends BaseModelWrapper<library_books>
	implements library_books, ModelWrapper<library_books> {

	public library_booksWrapper(library_books library_books) {
		super(library_books);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("libId", getLibId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("book_name", getBook_name());
		attributes.put("author", getAuthor());
		attributes.put("title", getTitle());
		attributes.put("publisherd_year", getPublisherd_year());
		attributes.put("category", getCategory());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long libId = (Long)attributes.get("libId");

		if (libId != null) {
			setLibId(libId);
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

		String book_name = (String)attributes.get("book_name");

		if (book_name != null) {
			setBook_name(book_name);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		Integer title = (Integer)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Integer publisherd_year = (Integer)attributes.get("publisherd_year");

		if (publisherd_year != null) {
			setPublisherd_year(publisherd_year);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}
	}

	@Override
	public library_books cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the author of this library_books.
	 *
	 * @return the author of this library_books
	 */
	@Override
	public String getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Returns the book_name of this library_books.
	 *
	 * @return the book_name of this library_books
	 */
	@Override
	public String getBook_name() {
		return model.getBook_name();
	}

	/**
	 * Returns the category of this library_books.
	 *
	 * @return the category of this library_books
	 */
	@Override
	public String getCategory() {
		return model.getCategory();
	}

	/**
	 * Returns the company ID of this library_books.
	 *
	 * @return the company ID of this library_books
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this library_books.
	 *
	 * @return the create date of this library_books
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this library_books.
	 *
	 * @return the group ID of this library_books
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the lib ID of this library_books.
	 *
	 * @return the lib ID of this library_books
	 */
	@Override
	public long getLibId() {
		return model.getLibId();
	}

	/**
	 * Returns the modified date of this library_books.
	 *
	 * @return the modified date of this library_books
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this library_books.
	 *
	 * @return the primary key of this library_books
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publisherd_year of this library_books.
	 *
	 * @return the publisherd_year of this library_books
	 */
	@Override
	public int getPublisherd_year() {
		return model.getPublisherd_year();
	}

	/**
	 * Returns the title of this library_books.
	 *
	 * @return the title of this library_books
	 */
	@Override
	public int getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this library_books.
	 *
	 * @return the user ID of this library_books
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this library_books.
	 *
	 * @return the user name of this library_books
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this library_books.
	 *
	 * @return the user uuid of this library_books
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this library_books.
	 *
	 * @return the uuid of this library_books
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the author of this library_books.
	 *
	 * @param author the author of this library_books
	 */
	@Override
	public void setAuthor(String author) {
		model.setAuthor(author);
	}

	/**
	 * Sets the book_name of this library_books.
	 *
	 * @param book_name the book_name of this library_books
	 */
	@Override
	public void setBook_name(String book_name) {
		model.setBook_name(book_name);
	}

	/**
	 * Sets the category of this library_books.
	 *
	 * @param category the category of this library_books
	 */
	@Override
	public void setCategory(String category) {
		model.setCategory(category);
	}

	/**
	 * Sets the company ID of this library_books.
	 *
	 * @param companyId the company ID of this library_books
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this library_books.
	 *
	 * @param createDate the create date of this library_books
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this library_books.
	 *
	 * @param groupId the group ID of this library_books
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the lib ID of this library_books.
	 *
	 * @param libId the lib ID of this library_books
	 */
	@Override
	public void setLibId(long libId) {
		model.setLibId(libId);
	}

	/**
	 * Sets the modified date of this library_books.
	 *
	 * @param modifiedDate the modified date of this library_books
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this library_books.
	 *
	 * @param primaryKey the primary key of this library_books
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publisherd_year of this library_books.
	 *
	 * @param publisherd_year the publisherd_year of this library_books
	 */
	@Override
	public void setPublisherd_year(int publisherd_year) {
		model.setPublisherd_year(publisherd_year);
	}

	/**
	 * Sets the title of this library_books.
	 *
	 * @param title the title of this library_books
	 */
	@Override
	public void setTitle(int title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this library_books.
	 *
	 * @param userId the user ID of this library_books
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this library_books.
	 *
	 * @param userName the user name of this library_books
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this library_books.
	 *
	 * @param userUuid the user uuid of this library_books
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this library_books.
	 *
	 * @param uuid the uuid of this library_books
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
	protected library_booksWrapper wrap(library_books library_books) {
		return new library_booksWrapper(library_books);
	}

}