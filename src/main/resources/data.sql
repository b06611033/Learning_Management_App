-- universities
insert into school(ID, NAME, LOCATION)
values(1, 'Texas A&M', 'College Station, Texas');

insert into school(ID, NAME, LOCATION)
values(2, 'Stanford', 'Palo Alto, California');

insert into school(ID, NAME, LOCATION)
values(3, 'Purdue', 'West Lafayette, Indiana');

--courses

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10001, 'TAMU SOCCER', 'TAMU MESSI', 1);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10002, 'TAMU C++', 'TAMU C++ MASTER', 1);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10003, 'TAMU Java', 'TAMU JAVA MASTER', 1);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10004, 'Stanford SOCCER', 'Stanford MESSI', 2);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10005, 'Stanford C++', 'Stanford C++ MASTER', 2);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10006, 'Stanford Java', 'Stanford JAVA MASTER', 2);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10007, 'Purdue SOCCER', 'Purdue MESSI', 3);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10008, 'Purdue C++', 'Purdue C++ MASTER', 3);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10009, 'Purdue Java', 'Purdue JAVA MASTER', 3);

--users

insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
values(10001, 'Bryan', '123', 2);

insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
values(10002, 'CR7', '123', 3);

insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
values(10003, 'Messi', '123', 1);
