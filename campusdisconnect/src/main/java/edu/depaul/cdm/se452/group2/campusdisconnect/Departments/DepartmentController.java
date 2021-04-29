package edu.depaul.cdm.se452.group2.campusdisconnect.Departments;

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

import edu.depaul.cdm.se452.group2.campusdisconnect.Majors.Major;
import edu.depaul.cdm.se452.group2.campusdisconnect.Majors.MajorRepository;

@RestController
@RequestMapping("/department")
class DepartmentController {

  @Autowired
  private DepartmentRepository departmentrepository;
  @Autowired
  private DepartmentNoSQLRepository departmentNoSQLrepository;
  @Autowired
  private MajorRepository MajorRepository;
 

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public Department newStudent(@RequestBody Department newDepartment) {
      DepartmentNoSQL newDepartmentNoSQL = new DepartmentNoSQL();
      newDepartmentNoSQL.setDepartmentid(newDepartment.getDepartmentid());
      departmentNoSQLrepository.save(newDepartmentNoSQL);
    return departmentrepository.save(newDepartment);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/info/{id}")
  public Department getDeparmentInfo(@PathVariable int id) {
    return departmentrepository.findBydepartmentid(id);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PutMapping("/update/{id}")
  public void updateDeparmentInfo(@RequestBody Department newDepartment, @PathVariable int id) {
    departmentrepository.save(newDepartment);
  }   

  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/deleteCourse/{id}/{mid}")
  public void DeleteMajor(@PathVariable int id, @PathVariable int mid) {
    departmentNoSQLrepository.findBydepartmentid(id).getMajorList().remove(mid);
    MajorRepository.deleteBymajorid(mid);
  }
  @CrossOrigin(origins = "http://localhost:8080") 
  @PostMapping("/addCourse/{id}/{mid}/{majorName}")
  public void addMajor(@PathVariable int id, @PathVariable int mid, @PathVariable String majorName) {
    departmentNoSQLrepository.findBydepartmentid(id).getMajorList().add(mid);
    Major newMajor = new Major();
    newMajor.setMajorid(mid);
    newMajor.setDepartmentid(id);
    newMajor.setMajorName(majorName);
    MajorRepository.save(newMajor);
  }
  
}