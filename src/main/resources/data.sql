-- universities
insert into school(ID, NAME, LOCATION)
values(1, 'Texas A&M', 'College Station, Texas');

insert into school(ID, NAME, LOCATION)
values(2, 'Stanford', 'Palo Alto, California');

insert into school(ID, NAME, LOCATION)
values(3, 'Purdue', 'West Lafayette, Indiana');

insert into school(ID, NAME, LOCATION)
values(4, 'UC Berkeley', 'Berkeley, California');

insert into school(ID, NAME, LOCATION)
values(5, 'UT Austin', 'Austin, Texas');

insert into school(ID, NAME, LOCATION)
values(6, 'NYU', 'New York, New York');

insert into school(ID, NAME, LOCATION)
values(7, 'UCLA', 'Los Angels, California');

insert into school(ID, NAME, LOCATION)
values(8, 'CU Boulder', 'Boulder, Colarado');

insert into school(ID, NAME, LOCATION)
values(9, 'USC', 'Los Angels, California');

insert into school(ID, NAME, LOCATION)
values(10, 'Columbia', 'New York, New York');

insert into school(ID, NAME, LOCATION)
values(11, 'UC San Diego', 'San Diego, California');

insert into school(ID, NAME, LOCATION)
values(12, 'UC Davis', 'Davis, California');


--courses

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10001, 'UCB SOCCER', 'UCB MESSI', 4);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10002, 'UCB C++', 'UCB C++ MASTER', 4);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10003, 'UCB Java', 'UCB JAVA MASTER', 4);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10004, 'UT SOCCER', 'UT MESSI', 5);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10005, 'UT C++', 'UT C++ MASTER', 5);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10006, 'UT Java', 'UT JAVA MASTER', 5);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10007, 'NYU SOCCER', 'NYU MESSI', 6);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10008, 'NYU C++', 'NYU C++ MASTER', 6);

insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
values(10009, 'NYU Java', 'NYU JAVA MASTER', 6);

--users

insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
values(9998, 'Bryan', '123', 2);

insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
values(9999, 'Harden', '123', 3);

insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
values(10000, 'Messi', '123', 1);
