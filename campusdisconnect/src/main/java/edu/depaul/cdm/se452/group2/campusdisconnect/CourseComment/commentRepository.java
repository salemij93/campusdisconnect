package edu.depaul.cdm.se452.group2.campusdisconnect.CourseComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<courseComment, Long> {
    public courseComment findBypid(long commentid);
 
}