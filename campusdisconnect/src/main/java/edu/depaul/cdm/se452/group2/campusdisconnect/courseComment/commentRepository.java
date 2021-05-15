package edu.depaul.cdm.se452.group2.campusdisconnect.courseComment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<courseComment, Long> {
    public courseComment findBycommentid(long commentid);
 
}