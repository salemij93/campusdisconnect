package edu.depaul.cdm.se452.group2.campusdisconnect.Professors;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    public Professor findBypid(Long pid);
 
}