create table practice_check (
	uuid_ VARCHAR(75) null,
	checkInId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	date_ DATE null,
	day VARCHAR(75) null,
	checkInTime DATE null,
	checkOutTime DATE null,
	totalHours VARCHAR(75) null,
	createdAt DATE null
);