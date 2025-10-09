create index IX_F9D94FD1 on HSP_Ambulance (hospitalId);
create index IX_F8079B0C on HSP_Ambulance (uuid_[$COLUMN_LENGTH:75$]);

create index IX_DC3E4EDF on HSP_Driver (ambulanceId);
create index IX_9C10E691 on HSP_Driver (hospitalId);
create index IX_959CCC4C on HSP_Driver (uuid_[$COLUMN_LENGTH:75$]);

create unique index IX_CE90CCF0 on HSP_Hospital (uuid_[$COLUMN_LENGTH:75$], groupId);