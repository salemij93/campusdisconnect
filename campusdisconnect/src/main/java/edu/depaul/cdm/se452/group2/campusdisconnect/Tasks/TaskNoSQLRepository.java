package edu.depaul.cdm.se452.group2.campusdisconnect.Tasks;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskNoSQLRepository extends MongoRepository<TaskNoSQL, Long> {
    public TaskNoSQL findBysid(long sid);
    
}
