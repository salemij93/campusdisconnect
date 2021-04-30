package edu.depaul.cdm.se452.group2.campusdisconnect.FinancialAid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialAidRepository extends JpaRepository<FinancialAid, Long>  {
    public FinancialAid findByStudentId(Long id);
}