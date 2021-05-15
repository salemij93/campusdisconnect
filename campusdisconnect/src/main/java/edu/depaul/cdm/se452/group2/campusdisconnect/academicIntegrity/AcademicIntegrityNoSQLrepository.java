package edu.depaul.cdm.se452.group2.campusdisconnect.academicIntegrity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AcademicIntegrityNoSQLrepository extends MongoRepository<AcademicIntegrityNoSQL, Long>{
    public  AcademicIntegrityNoSQL findBysid(long sid);
    
}
