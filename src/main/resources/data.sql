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


-- DELIMITER $$
-- CREATE PROCEDURE generate_data()
-- BEGIN
--     DECLARE i INT DEFAULT 1;

--     DECLARE max_value INT DEFAULT 400; 
--     -- Loop to generate data
--     WHILE i <= max_value DO
--         insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
-- values(i,CONCAT('TAMU COURSE ', i), CONCAT('TAMU INSTRUCTOR ', i), 1);
--         SET i = i + 1;
--     END WHILE;

--      SET max_value = 800; 
--          -- Loop to generate data
--     WHILE i <= max_value DO
--         insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
-- values(i,CONCAT('STANFORD COURSE ', i), CONCAT('STANFORD INSTRUCTOR ', i), 2);
--         SET i = i + 1;
--     END WHILE;

--    SET max_value = 1200; 
--          -- Loop to generate data
--     WHILE i <= max_value DO
--         insert into course(ID, COURSENAME, INSTRUCTOR, SCHOOL_ID)
-- values(i,CONCAT('PURDUE COURSE ', i), CONCAT('PURDUE INSTRUCTOR ', i), 3);
--         SET i = i + 1;
--     END WHILE;
-- END$$
-- DELIMITER ;


-- DELIMITER $$
-- CREATE PROCEDURE generate_data_two()
-- BEGIN
--     DECLARE i INT DEFAULT 1;

--     DECLARE max_value INT DEFAULT 400; 
--     -- Loop to generate data
--     WHILE i <= max_value DO
--         insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
-- values(i+10000,CONCAT('user', i), CONCAT('pwd', i), 1);
--         SET i = i + 1;
--     END WHILE;

--      SET max_value = 800; 
--          -- Loop to generate data
--     WHILE i <= max_value DO
--                 insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
-- values(i+10000,CONCAT('user', i), CONCAT('pwd', i), 2);
--         SET i = i + 1;
--     END WHILE;

--    SET max_value = 1200; 
--          -- Loop to generate data
--     WHILE i <= max_value DO
--                 insert into user(ID, USERNAME, PASSWORD, SCHOOL_ID)
-- values(i+10000,CONCAT('user', i), CONCAT('pwd', i), 3);
--         SET i = i + 1;
--     END WHILE;
-- END$$
-- DELIMITER ;


