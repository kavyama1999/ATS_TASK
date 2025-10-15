create table HSP_Ambulance (
	uuid_ VARCHAR(75) null,
	ambulanceId LONG not null primary key,
	hospitalId LONG,
	driverId LONG,
	ambulanceNumber VARCHAR(75) null,
	vehicleType VARCHAR(75) null,
	status VARCHAR(75) null,
	location VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table HSP_Driver (
	uuid_ VARCHAR(75) null,
	driverId LONG not null primary key,
	hospitalId LONG,
	ambulanceId LONG,
	userId LONG,
	driverName VARCHAR(75) null,
	contactNumber VARCHAR(75) null,
	email VARCHAR(75) null,
	address VARCHAR(75) null,
	status VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table HSP_Hospital (
	uuid_ VARCHAR(75) null,
	hospitalId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	hospitalName VARCHAR(75) null,
	location VARCHAR(75) null,
	address VARCHAR(75) null,
	contactNumber VARCHAR(75) null
);