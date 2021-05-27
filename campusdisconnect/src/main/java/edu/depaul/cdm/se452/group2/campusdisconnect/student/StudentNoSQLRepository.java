package edu.depaul.cdm.se452.group2.campusdisconnect.student;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentNoSQLRepository extends MongoRepository<StudentNoSQL, Long> {
    public StudentNoSQL findBystudentid(long studentid);
   

}