package edu.depaul.cdm.se452.group2.campusdisconnect.courseComment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentRepository extends JpaRepository<CourseComment, Long> {
    public List<CourseComment> findAll();
 
}