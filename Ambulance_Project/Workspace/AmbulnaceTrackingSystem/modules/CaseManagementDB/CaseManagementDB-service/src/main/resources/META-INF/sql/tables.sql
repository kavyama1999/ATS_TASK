create table Case_CaseMngt (
	uuid_ VARCHAR(75) null,
	caseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	caseNumber VARCHAR(75) null,
	caseType VARCHAR(75) null,
	patientName VARCHAR(75) null,
	patientAge INTEGER,
	description VARCHAR(75) null,
	patientGender VARCHAR(75) null,
	location VARCHAR(75) null,
	contactNumber VARCHAR(75) null
);