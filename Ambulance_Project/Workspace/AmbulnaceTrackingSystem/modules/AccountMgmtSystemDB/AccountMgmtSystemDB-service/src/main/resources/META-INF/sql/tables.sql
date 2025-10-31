create table Account_AccountMngt (
	uuid_ VARCHAR(75) null,
	accountId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	accountNumber VARCHAR(75) null,
	accountHolderName VARCHAR(75) null,
	accountType VARCHAR(75) null,
	email VARCHAR(75) null,
	phoneNumber VARCHAR(75) null,
	branchName VARCHAR(75) null,
	balance DOUBLE,
	ifscCode VARCHAR(75) null
);