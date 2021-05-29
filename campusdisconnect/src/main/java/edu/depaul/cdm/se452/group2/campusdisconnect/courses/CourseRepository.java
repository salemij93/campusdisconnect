package edu.depaul.cdm.se452.group2.campusdisconnect.courses;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findBycourseid(Long cid);
    public List<Course> findAll();
}