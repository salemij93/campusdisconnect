<<<<<<< HEAD
DROP TABLE IF EXISTS professors;
-- DROP TABLE IF EXISTS students;
-- DROP TABLE IF EXISTS course;
-- DROP SEQUENCE IF EXISTS hibernate_sequence;

-- CREATE SEQUENCE hibernate_sequence START WITH 100 INCREMENT BY 1;

CREATE TABLE professors (
    pid NUMERIC PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    deptId NUMERIC(2)
=======

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS major;

CREATE TABLE student (
    studentid NUMERIC PRIMARY KEY,
    majorid NUMERIC(3),
    email VARCHAR(30),
    address VARCHAR(50),
    firstName VARCHAR(10),
    lastName VARCHAR(50),
    credit NUMERIC DEFAULT 0
);
CREATE TABLE major (
    majorid NUMERIC(3) PRIMARY KEY,
    majorName VARCHAR,
    departmentid NUMERIC
>>>>>>> bc41b306f3cbc421424c6fb10e070b45c3f96912
);

