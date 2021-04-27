package edu.depaul.cdm.se452.group2.campusdisconnect.professor;
//import java.util.Set;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfessorNoSQLRepository extends MongoRepository<ProfessorNoSQL, Long> {
    public ProfessorNoSQL findBypid(long pid);
    // public Set<String> findRegisteredBystudentid(long studentid);
    // public Set<String> findWaitlistedBystudentid(long studentid);
    // public Set<String> findCompletedBystudentid(long studentid);

}