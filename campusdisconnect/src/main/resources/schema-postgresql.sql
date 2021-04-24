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
);

