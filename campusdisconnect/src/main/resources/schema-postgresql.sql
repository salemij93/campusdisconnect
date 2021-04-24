
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
);

