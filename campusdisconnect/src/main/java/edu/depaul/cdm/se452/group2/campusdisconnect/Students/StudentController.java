package edu.depaul.cdm.se452.group2.campusdisconnect.Students;

import java.util.*;

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

import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.CourseNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.CourseNoSQLRepository;

@RestController
@RequestMapping("/student")
class StudentController {

  @Autowired
  private StudentRepository studentrepository;
  @Autowired
  private StudentNoSQLRepository studentNoSQLrepository;
  @Autowired
  private CourseNoSQLRepository CourseNoSQLRepository;

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public void newStudent(@RequestBody Student newStudent) {
      StudentNoSQL newStudentNoSQL = new StudentNoSQL();
      newStudentNoSQL.setStudentid(newStudent.getStudentid());
      studentNoSQLrepository.save(newStudentNoSQL);
      studentrepository.save(newStudent);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/info/{id}")
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
    }else{
      return;
    }
    CourseNoSQL curCourse = CourseNoSQLRepository.findBycourseid(Long.valueOf(cid));
    int EnrollmentCapacity = curCourse.getEnrolledcapacity();
    int waitlistCapacity = curCourse.getWaitlistCapacity();
    curCourse.getEnrolledlist().remove(id);
    List<Long> waitlist = curCourse.getWaitlist();
    if(waitlist.size()>0){
      long newsid = waitlist.remove(0);
      StudentNoSQL nextstudentNoSQL = studentNoSQLrepository.findBystudentid(newsid);
      nextstudentNoSQL.getCurrentWaitlist().remove(String.valueOf(cid));
      nextstudentNoSQL.getCurrentRegistrated().add(String.valueOf(cid));
      studentNoSQLrepository.save(nextstudentNoSQL);
      curCourse.getEnrolledlist().add(newsid);
      curCourse.setWaitlistCapacity(waitlistCapacity+1);
    }
    CourseNoSQLRepository.save(curCourse);
    studentNoSQLrepository.save(studentNoSQL);
    
  }
  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/addCourse/{id}/{cid}")
  public void addCourse(@PathVariable Long id, @PathVariable String cid) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    CourseNoSQL courseNoSQL = CourseNoSQLRepository.findBycourseid(Long.valueOf(cid));
    int EnrollmentCapacity = courseNoSQL.getEnrolledcapacity();
    if(EnrollmentCapacity > 0){
      studentNoSQL.getCurrentRegistrated().add(cid);
      studentNoSQLrepository.save(studentNoSQL);
      courseNoSQL.setEnrolledcapacity(EnrollmentCapacity-1);
      courseNoSQL.getEnrolledlist().add(id);
      CourseNoSQLRepository.save(courseNoSQL);
    }
  }

  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/waitlistCourse/{id}/{cid}")
  public String waitlistCourse(@PathVariable Long id, @PathVariable String cid) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    CourseNoSQL courseNoSQL = CourseNoSQLRepository.findBycourseid(Long.valueOf(cid));
    int EnrollmentCapacity = courseNoSQL.getEnrolledcapacity();
    if(EnrollmentCapacity>0) return "You can directly enroll";
    int WaitlistCapacity = courseNoSQL.getWaitlistCapacity();
    if(WaitlistCapacity>0){
      studentNoSQL.getCurrentWaitlist().add(cid);
      studentNoSQLrepository.save(studentNoSQL);
      courseNoSQL.setWaitlistCapacity(WaitlistCapacity-1);
      courseNoSQL.getWaitlist().add(id);
      CourseNoSQLRepository.save(courseNoSQL);
      return "successfully waitlisted";
    }
    return "waitlist is full, please check later";
  }

  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/unwaitlistCourse/{id}/{cid}")
  public void unwaitlistCourse(@PathVariable Long id, @PathVariable String cid) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    CourseNoSQL courseNoSQL = CourseNoSQLRepository.findBycourseid(Long.valueOf(cid));
    int WaitlistCapacity = courseNoSQL.getWaitlistCapacity();
      studentNoSQL.getCurrentWaitlist().remove(cid);
      studentNoSQLrepository.save(studentNoSQL);
      courseNoSQL.setWaitlistCapacity(WaitlistCapacity+1);
      courseNoSQL.getWaitlist().remove(id);
      CourseNoSQLRepository.save(courseNoSQL);
  }




  

}