package edu.depaul.cdm.se452.group2.campusdisconnect.departments;

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

import edu.depaul.cdm.se452.group2.campusdisconnect.advisors.AdvisorRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.majors.Major;
import edu.depaul.cdm.se452.group2.campusdisconnect.majors.MajorRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.professors.Professor;
import edu.depaul.cdm.se452.group2.campusdisconnect.professors.ProfessorRepository;

@RestController
@RequestMapping("/department")
class DepartmentController {

  @Autowired
  private DepartmentRepository departmentrepository;
  @Autowired
  private MajorRepository MajorRepository;
  @Autowired
  private ProfessorRepository ProfessorRepository;
 

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public Department newDepartment(@RequestBody Department newDepartment) {
    return departmentrepository.save(newDepartment);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/info/{name}")
  public Department getDeparmentInfo(@PathVariable String name) {
    return departmentrepository.findBydepartmentname(name);
  }
 
  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/deleteMajor/{name}/{majorname}")
  public void DeleteMajor(@PathVariable String name, @PathVariable String majorname) {
    Major majorToDelete = MajorRepository.findBymajorname(majorname);
    majorToDelete.setDepartment(null);
    MajorRepository.delete(majorToDelete);
  }

  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/addMajor/{name}")
  public void addMajor(@PathVariable String name, @RequestBody Major newMajor) {
    Department curDepartment = departmentrepository.findBydepartmentname(name);
    curDepartment.getMajorList().add(newMajor);
    newMajor.setDepartment(curDepartment);
    departmentrepository.save(curDepartment);
  }
  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/addProfessor/{name}")
  public void addProfessor(@PathVariable String name, @RequestBody Professor newProfessor) {
    Department curDepartment = departmentrepository.findBydepartmentname(name);
    curDepartment.getProfessorList().add(newProfessor);
    departmentrepository.save(curDepartment);
  }
  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/deleteProfessor/{name}/{id}}")
  public void DeleteProfessor(@PathVariable String name, @PathVariable long id) {
    Professor professorToDelete = ProfessorRepository.findBypid(id);
    professorToDelete.setDepartment(null);
    professorToDelete.setCourselist(null);
    ProfessorRepository.delete(professorToDelete);
  }


}