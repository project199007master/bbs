create table mms_member(

	id number,
	name varchar2(12) unique not null,
	addr varchar2(50) not null,
	nation varchar2(12) not null,
	email varchar2(30) not null,
	age number,
	constraint mms_member_id_pk primary key(id)

);

drop sequence member_id_seq;
create sequence member_id_seq
minvalue 1
increment by 1
