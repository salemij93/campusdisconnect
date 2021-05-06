-- DROP TABLE IF EXISTS professors;
-- DROP TABLE IF EXISTS student;
-- DROP TABLE IF EXISTS major;
-- DROP TABLE IF EXISTS course;
-- DROP TABLE IF EXISTS department;

-- CREATE TABLE department(
--     departmentid NUMERIC PRIMARY KEY,
--     departmentname VARCHAR
-- );

-- CREATE TABLE professor (
--     pid NUMERIC PRIMARY KEY,
--     firstName VARCHAR(50),
--     lastName VARCHAR(50),
--     deptId NUMERIC(2)
-- );

-- CREATE TABLE student (
--     studentid NUMERIC PRIMARY KEY,
--     majorid NUMERIC(3),
--     email VARCHAR(30),
--     address VARCHAR(50),
--     firstName VARCHAR(10),
--     lastName VARCHAR(50),
--     credit NUMERIC DEFAULT 0
-- );
-- CREATE TABLE major (
--     majorid NUMERIC(3) PRIMARY KEY,
--     majorName VARCHAR,
--     departmentid NUMERIC
-- );

-- CREATE TABLE course (
--     courseid VARCHAR PRIMARY Key,
--     majorid NUMERIC(3),
--     pid NUMERIC,
--     StartTime VARCHAR,
--     EndTime VARCHAR,
--     credits NUMERIC,
--     deptId NUMERIC,
--     year NUMERIC(4),
--     quarter VARCHAR
-- );

