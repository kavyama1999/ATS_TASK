create index IX_BD937E76 on lib_book_review (libId);
create unique index IX_8CAD9AF0 on lib_book_review (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_BE670A38 on lib_library_books (groupId);
create unique index IX_9E6A428 on lib_library_books (uuid_[$COLUMN_LENGTH:75$], groupId);