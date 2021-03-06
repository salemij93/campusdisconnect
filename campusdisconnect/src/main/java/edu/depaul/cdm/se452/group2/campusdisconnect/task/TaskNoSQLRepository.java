package edu.depaul.cdm.se452.group2.campusdisconnect.task;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskNoSQLRepository extends MongoRepository<TaskNoSQL, Long> {
    TaskNoSQL findBysid(long sid);
    
}
