package edu.depaul.cdm.se452.group2.campusdisconnect.tuition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuitionRepository extends JpaRepository<Tuition, Long>  {
    public Tuition findBymajorname(String majorname);
}