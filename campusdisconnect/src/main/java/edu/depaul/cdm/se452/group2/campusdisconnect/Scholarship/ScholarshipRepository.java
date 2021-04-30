package edu.depaul.cdm.se452.group2.campusdisconnect.Scholarship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long>  {
    public Scholarship findByStudentId(long id);
}