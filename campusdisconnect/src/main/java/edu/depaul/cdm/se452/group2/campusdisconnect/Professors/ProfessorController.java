package edu.depaul.cdm.se452.group2.campusdisconnect.Professors;

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
@RequestMapping("/professor")
class ProfessorController {

  @Autowired
  private ProfessorRepository professorRepository;
  @Autowired
  private ProfessorNoSQLRepository professorNoSQLRepository;

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public void newProfessor(@RequestBody Professor newProfessor) {
    ProfessorNoSQL newprofessorNoSQL = new ProfessorNoSQL();
    newprofessorNoSQL .setPid(newProfessor.getPid());
    professorNoSQLRepository.save(newprofessorNoSQL);
    professorRepository.save(newProfessor);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/getprofessorinfo/{id}")
  public String getProfessorInfo(@PathVariable Long id) {
    return professorRepository.findBypid(id).toString();
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PutMapping("/updateProfessorinfo/{id}")
  public void updateProfessorInfo(@RequestBody Professor newProfessor, @PathVariable Long id) {

    professorRepository.save(newProfessor);
  } 

  @CrossOrigin(origins = "http://localhost:8080") 
  @PostMapping("/addCourse/{id}/{cid}")
  public void addCourse(@PathVariable Long id, @PathVariable String cid) {
    ProfessorNoSQL professorNoSQL = professorNoSQLRepository.findBypid(id);
    professorNoSQL.getCourselist().add(cid);
    professorNoSQLRepository.save(professorNoSQL);
    
  }

  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/dropCourse/{id}/{cid}")
  public void dropCourse(@PathVariable Long id, @PathVariable String cid) {
    ProfessorNoSQL professorNoSQL = professorNoSQLRepository.findBypid(id);
    professorNoSQL.getCourselist().remove(cid);
    professorNoSQLRepository.save(professorNoSQL);
    
  }
}