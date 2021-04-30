package edu.depaul.cdm.se452.group2.campusdisconnect.Professors;
//import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorNoSQLRepository extends MongoRepository<ProfessorNoSQL, Long> {
    public ProfessorNoSQL findBypid(long pid);
    

}