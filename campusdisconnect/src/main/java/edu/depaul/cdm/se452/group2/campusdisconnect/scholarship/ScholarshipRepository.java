package edu.depaul.cdm.se452.group2.campusdisconnect.scholarship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long>  {
     Scholarship findBystudentId(long id);
}