create table FOO_customer_table (
	uuid_ VARCHAR(75) null,
	custId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	custName VARCHAR(75) null,
	age VARCHAR(75) null,
	salary LONG,
	gender VARCHAR(75) null,
	address VARCHAR(75) null
);