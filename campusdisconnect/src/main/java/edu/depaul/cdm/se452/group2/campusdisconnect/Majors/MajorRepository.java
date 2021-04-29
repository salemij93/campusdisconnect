package edu.depaul.cdm.se452.group2.campusdisconnect.Majors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long>  {
    public Major findBymajorname(String majorname);
    
}