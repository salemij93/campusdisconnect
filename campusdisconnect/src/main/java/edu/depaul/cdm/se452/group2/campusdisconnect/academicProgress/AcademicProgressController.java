package edu.depaul.cdm.se452.group2.campusdisconnect.academicProgress;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/academicprogress")

public class AcademicProgressController {
  @Autowired
  private AcademicprogressNoSQLrepository academicprogressNoSQLrepository;

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public AcademicProgressNoSQL newStudentAcademicProgress(@RequestBody AcademicProgressNoSQL newAcademicprogress) {
    return academicprogressNoSQLrepository.save(newAcademicprogress);
   

  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/getAcademicprogressinfo/{id}")
  public String getProfessorInfo(@PathVariable Long id) {
    return academicprogressNoSQLrepository.findBysid(id).toString();
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PutMapping("/updateAcademicprogressinfo/{id}")
  public void updateAcademicprogressInfo(@RequestBody AcademicProgressNoSQL newAcademicprogress, @PathVariable Long id) {

    academicprogressNoSQLrepository.save(newAcademicprogress);
  }

  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/deleteAcademicprogressinfo/{id}/{cid}")
  public void deleteAcademicprogressinfo(@PathVariable Long id, @PathVariable String cid) {
    AcademicProgressNoSQL academicProgressNoSQL = academicprogressNoSQLrepository.findBysid(id);
    academicProgressNoSQL.getInprogressCourseList().remove(cid);
   
    
  }


    
}
