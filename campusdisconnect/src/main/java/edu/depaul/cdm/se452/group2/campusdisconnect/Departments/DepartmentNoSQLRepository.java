package edu.depaul.cdm.se452.group2.campusdisconnect.Departments;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentNoSQLRepository extends MongoRepository<DepartmentNoSQL, Long> {
    public DepartmentNoSQL findBydepartmentid(int departmentid);
 

}