package edu.depaul.cdm.se452.group2.campusdisconnect.courses;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseNoSQLRepository extends MongoRepository<CourseNoSQL, Long> {
    public CourseNoSQL findBycourseid(Long courseid);
    public List<CourseNoSQL> findAll();
 

}