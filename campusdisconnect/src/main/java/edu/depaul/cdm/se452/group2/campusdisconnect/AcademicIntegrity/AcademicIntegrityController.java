package edu.depaul.cdm.se452.group2.campusdisconnect.AcademicIntegrity;

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
@RequestMapping("/academicintergrity")

public class AcademicIntegrityController {
    @Autowired
    private AcademicIntegrityNoSQLrepository academicIntegrityNoSQLrepository;
  
    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/create")
    public AcademicIntegrityNoSQL newViolationRecord(@RequestBody AcademicIntegrityNoSQL newViolation) {
      return academicIntegrityNoSQLrepository.save(newViolation);
     
  
    }
  
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getAcademicintegrityinfo/{id}")
    public String getAcademicintegrityInfo(@PathVariable Long id) {
      return academicIntegrityNoSQLrepository.findBysid(id).toString();
    }
  
    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/updateAcademicintegrityInfo/{id}")
    public void updateAcademicintegrityInfo(@RequestBody AcademicIntegrityNoSQL newViolation, @PathVariable Long id) {
  
      academicIntegrityNoSQLrepository.save(newViolation);
    }
  
    @CrossOrigin(origins = "http://localhost:8080") 
    @DeleteMapping("/deleteAcademicintegrityInfo/{id}/{vid}")
    public void deleteAcademicintegrityInfo(@PathVariable Long id, @PathVariable String vid) {
        AcademicIntegrityNoSQL academicIntegrityNoSQL = academicIntegrityNoSQLrepository.findBysid(id);
        academicIntegrityNoSQL.getViloationList().remove(vid);
     
      
    }

    
}
