package edu.depaul.cdm.se452.group2.campusdisconnect.Students;

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
@RequestMapping("/student")
class StudentController {

  @Autowired
  private StudentRepository studentrepository;
  @Autowired
  private StudentNoSQLRepository studentNoSQLrepository;

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public void newStudent(@RequestBody Student newStudent) {
      StudentNoSQL newStudentNoSQL = new StudentNoSQL();
      newStudentNoSQL.setStudentid(newStudent.getStudentid());
      studentNoSQLrepository.save(newStudentNoSQL);
      studentrepository.save(newStudent);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/studentinfo/{id}")
  public String getStudentInfo(@PathVariable Long id) {
    return studentrepository.findBystudentid(id).toString();
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PutMapping("/update/{id}")
  public void updateStudentInfo(@RequestBody Student newStudent, @PathVariable Long id) {

    studentrepository.save(newStudent);
  }   

  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/dropCourse/{id}/{cid}")
  public void dropCourse(@PathVariable Long id, @PathVariable String cid) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    if(studentNoSQL.getCurrentRegistrated().contains(cid)){
        studentNoSQL.getCurrentRegistrated().remove(cid);
    }
    studentNoSQLrepository.save(studentNoSQL);
    
  }
  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/addCourse/{id}/{cid}")
  public void addCourse(@PathVariable Long id, @PathVariable String cid) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    studentNoSQL.getCurrentRegistrated().add(cid);
    studentNoSQLrepository.save(studentNoSQL);
  }


  

}