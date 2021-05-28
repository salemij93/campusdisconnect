package edu.depaul.cdm.se452.group2.campusdisconnect.course.comment;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentNoSQLRepository extends MongoRepository<CommentNoSQL, Long> {
    public CommentNoSQL findBycommentid(long commentid);
 

}