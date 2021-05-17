package edu.depaul.cdm.se452.group2.campusdisconnect.courseComment;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface commentNoSQLRepository extends MongoRepository<commentNoSQL, Long> {
    public commentNoSQL findBycommentid(long commentid);
 

}