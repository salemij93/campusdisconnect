package edu.depaul.cdm.se452.group2.campusdisconnect.academicProgress;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AcademicprogressNoSQLrepository extends MongoRepository<AcademicProgressNoSQL, Long>{
    public  AcademicProgressNoSQL findBysid(long sid);
    
}
