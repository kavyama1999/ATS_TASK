create table liferay_student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	qualification VARCHAR(75) null,
	fees LONG,
	address VARCHAR(75) null,
	gender VARCHAR(75) null
);

create table practice_student (
	uuid_ VARCHAR(75) null,
	studentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	qualification VARCHAR(75) null,
	fees LONG,
	address VARCHAR(75) null,
	gender VARCHAR(75) null
);