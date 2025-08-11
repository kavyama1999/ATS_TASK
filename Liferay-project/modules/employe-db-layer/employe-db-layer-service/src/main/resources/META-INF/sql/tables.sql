create table Practice_employee (
	uuid_ VARCHAR(75) null,
	empId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	salary VARCHAR(75) null,
	age INTEGER,
	company VARCHAR(75) null,
	gender VARCHAR(75) null
);