package edu.depaul.cdm.se452.group2.campusdisconnect.student;

import java.util.*;

import edu.depaul.cdm.se452.group2.campusdisconnect.DisconnectUserUtil;
import edu.depaul.cdm.se452.group2.campusdisconnect.task.TaskNoSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.depaul.cdm.se452.group2.campusdisconnect.academic.integrity.AcademicIntegrityNoSQLrepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.CourseNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.CourseNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.CourseRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.major.Major;
import edu.depaul.cdm.se452.group2.campusdisconnect.scholarship.ScholarshipRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.tuition.Tuition;
import edu.depaul.cdm.se452.group2.campusdisconnect.tuition.TuitionRepository;

@Controller
@RequestMapping("/student")
class StudentController {

  @Autowired
  private StudentRepository studentrepository;
  @Autowired
  private StudentNoSQLRepository studentNoSQLrepository;
  @Autowired
  private CourseRepository CourseRepository;
  @Autowired
  private CourseNoSQLRepository CourseNoSQLRepository;
  @Autowired
  private TuitionRepository TuitionRepository;
  @Autowired
  private ScholarshipRepository scholarshipRepository;
  @Autowired
   private AcademicIntegrityNoSQLrepository academicIntegrityNoSQLrepository;

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/create")
  public void newStudent(@RequestBody Student newStudent) {
      StudentNoSQL newStudentNoSQL = new StudentNoSQL();
      newStudentNoSQL.setStudentid(newStudent.getStudentid());
      studentNoSQLrepository.save(newStudentNoSQL);
      studentrepository.save(newStudent);
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/info")
  public String getStudentInfo(Model model) {
    Long disconnectUserId = DisconnectUserUtil.getDisconnectUserId();
    String username = DisconnectUserUtil.getDisconnectUsername();
    Student student = studentrepository.findBystudentid(disconnectUserId);
    // AcademicIntegrityNoSQL studentIntegrity = academicIntegrityNoSQLrepository.findBysid(id);
    // Set<String> violationListSet = studentIntegrity.getViloationList();
    int violation = 0;
    // if(violationListSet.size()>0){
    //   violation = violationListSet.size();
    // }
    model.addAttribute("studentid", student.getStudentid());
    model.addAttribute("studentuserId", username);
    model.addAttribute("firstname", student.getFirstName());
    model.addAttribute("lastname", student.getLastName());
    model.addAttribute("email", student.getEmail());
    model.addAttribute("major", student.getMajor());
    model.addAttribute("address", student.getAddress());
    model.addAttribute("credits", student.getCredit());
    model.addAttribute("violations", violation);
    
    return "student-profile";
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PostMapping("/update/{id}")
  public void updateStudentInfo(@RequestBody Student newStudent, @PathVariable Long id) {
    studentrepository.save(newStudent);
  }   


  //dropcourse and enroll first student on waitlist
  @CrossOrigin(origins = "http://localhost:8080") 
  @PostMapping("/dropCourse")
  public String dropCourse(@RequestParam Long id, @RequestParam String cid, RedirectAttributes redirectAttributes) {
    
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    if(studentNoSQL.getCurrentRegistrated().contains(cid)){
        studentNoSQL.getCurrentRegistrated().remove(cid);
    }else{
      redirectAttributes.addAttribute("id", id);
      return "redirect:/course/info";
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
    redirectAttributes.addAttribute("id", id);
      return "redirect:/course/info";
  }

  //addcourse
  @CrossOrigin(origins = "http://localhost:8080") 
  @PostMapping("/addCourse")
  public String addCourse(@RequestParam Long id, @RequestParam String cid, RedirectAttributes redirectAttributes) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    if(studentNoSQL.getCurrentRegistrated().contains(cid)){
      redirectAttributes.addAttribute("id", id);
      return "redirect:/course/info";
    }
    CourseNoSQL courseNoSQL = CourseNoSQLRepository.findBycourseid(Long.valueOf(cid));
    int EnrollmentCapacity = courseNoSQL.getEnrolledcapacity();
    if(EnrollmentCapacity > 0){
      studentNoSQL.getCurrentRegistrated().add(cid);
      studentNoSQLrepository.save(studentNoSQL);
      courseNoSQL.setEnrolledcapacity(EnrollmentCapacity-1);
      courseNoSQL.getEnrolledlist().add(id);
      CourseNoSQLRepository.save(courseNoSQL);
    }
    redirectAttributes.addAttribute("id", id);
      return "redirect:/course/info";
  }

  //add to waitlist
  @CrossOrigin(origins = "http://localhost:8080") 
  @PostMapping("/waitlistCourse")
  public String waitlistCourse(@RequestParam Long id, @RequestParam String cid) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    if(studentNoSQL.getCurrentWaitlist().contains(cid)){
      return "already waitlisted";
    }
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

  // drop from waitlist
  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/unwaitlistCourse")
  public void unwaitlistCourse(@RequestParam Long id, @RequestParam String cid) {
    StudentNoSQL studentNoSQL = studentNoSQLrepository.findBystudentid(id);
    if(!studentNoSQL.getCurrentWaitlist().contains(cid)){
      return;
    }
    CourseNoSQL courseNoSQL = CourseNoSQLRepository.findBycourseid(Long.valueOf(cid));
    int WaitlistCapacity = courseNoSQL.getWaitlistCapacity();
      studentNoSQL.getCurrentWaitlist().remove(cid);
      studentNoSQLrepository.save(studentNoSQL);
      courseNoSQL.setWaitlistCapacity(WaitlistCapacity+1);
      courseNoSQL.getWaitlist().remove(id);
      CourseNoSQLRepository.save(courseNoSQL);
  }


  @CrossOrigin(origins = "http://localhost:8080") 
  @GetMapping("/mytuition")
  public String currentTuition(Model model) {

    Long disconnectUserId = DisconnectUserUtil.getDisconnectUserId();


    StudentNoSQL studentNoSQL = Optional.ofNullable(studentNoSQLrepository.findBystudentid(disconnectUserId)).orElse(new StudentNoSQL());
    int tuition = 0;
    int scholarship = Optional.ofNullable(scholarshipRepository.findBystudentId(disconnectUserId)).map(id -> id.getScholarshipAmount()).orElse(0);
    Set<String> currentEnroll = studentNoSQL.getCurrentRegistrated();
    for(String cid : currentEnroll){
      Course course = CourseRepository.findBycourseid(Long.valueOf(cid));
      Major major = course.getMajor();
      Tuition curtuition = TuitionRepository.findBymajorname(major.getMajorname());
      tuition += curtuition.getCreditPrice()*course.getCredits();
    }
    model.addAttribute("scholarship", scholarship);
    model.addAttribute("tuition", tuition);
    return "studentaccount";
    
  }
  

  




  

}