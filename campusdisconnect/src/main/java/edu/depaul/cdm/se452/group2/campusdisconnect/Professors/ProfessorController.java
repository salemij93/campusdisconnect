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

import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.CourseRepository;

@RestController
@RequestMapping("/professor")
class ProfessorController {

  @Autowired
  private ProfessorRepository professorRepository;
  @Autowired
  private CourseRepository CourseRepository;
  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public void newProfessor(@RequestBody Professor newProfessor) {
    professorRepository.save(newProfessor);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/info/{id}")
  public String getProfessorInfo(@PathVariable Long id) {
    return professorRepository.findBypid(id).toString();
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PutMapping("/update/info/{id}")
  public void updateProfessorInfo(@RequestBody Professor newProfessor, @PathVariable Long id) {

    professorRepository.save(newProfessor);
  } 

  @CrossOrigin(origins = "http://localhost:8080") 
  @PostMapping("/addCourse/{id}/{cid}")
  public void addCourse(@PathVariable Long id, @PathVariable long cid) {
    Professor curProfessor = professorRepository.findBypid(id);
    Course course = CourseRepository.findBycourseid(cid);
    if(course.getProfessor() != null){
      Professor previousProfessor = course.getProfessor();
      previousProfessor.getCourselist().remove(course);
    }
    curProfessor.getCourselist().add(course);
    course.setProfessor(curProfessor);
    professorRepository.save(curProfessor);
  }

  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/dropCourse/{id}/{cid}")
  public void dropCourse(@PathVariable Long id, @PathVariable Long cid) {
    Professor curProfessor = professorRepository.findBypid(id);
    Course course = CourseRepository.findBycourseid(cid);
    if(curProfessor.getCourselist().contains(course)){
      curProfessor.getCourselist().remove(course);
      course.setProfessor(null);
    }
    professorRepository.save(curProfessor);
  }
}