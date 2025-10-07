create table AMB_AmbSignUp (
	uuid_ VARCHAR(75) null,
	otpId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	email VARCHAR(75) null,
	OTP VARCHAR(75) null,
	status BOOLEAN
);