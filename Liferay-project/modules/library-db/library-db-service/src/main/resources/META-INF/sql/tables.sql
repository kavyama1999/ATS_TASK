create table lib_book_review (
	uuid_ VARCHAR(75) null,
	reviewId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	libId LONG,
	reviewerName VARCHAR(75) null,
	reviewDate DATE null,
	rating INTEGER,
	comment_ VARCHAR(75) null,
	approved BOOLEAN
);

create table lib_library_books (
	uuid_ VARCHAR(75) null,
	libId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	book_name VARCHAR(75) null,
	author VARCHAR(75) null,
	title INTEGER,
	publisherd_year INTEGER,
	category VARCHAR(75) null
);