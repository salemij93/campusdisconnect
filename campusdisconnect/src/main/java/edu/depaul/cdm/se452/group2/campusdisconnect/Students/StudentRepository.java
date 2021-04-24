package edu.depaul.cdm.se452.group2.campusdisconnect.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
    public Student findBystudentid(String studentid);
}