package edu.depaul.cdm.se452.group2.campusdisconnect.majors;

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
import org.springframework.web.servlet.ModelAndView;

import edu.depaul.cdm.se452.group2.campusdisconnect.courses.CourseNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.courses.CourseNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.courses.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.courses.CourseRepository;

@RestController
@RequestMapping("/major")
class MajorController {

  @Autowired
  private MajorRepository Majorrepository;
  @Autowired
  private CourseRepository CourseRepository;
  @Autowired
  private CourseNoSQLRepository courseNoSQLRepository;

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/majorinfo/{name}")
  public String getMajorInfo(@PathVariable String name) {
    return Majorrepository.findBymajorname(name).toString();
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PutMapping("/update/{name}")
  public void updateMajorInfo(@RequestBody Major newMajor, @PathVariable int name) {
    Majorrepository.save(newMajor);
  }   

  @CrossOrigin(origins = "http://localhost:8080") 
  @DeleteMapping("/deleteCourse/{name}/{cid}")
  public void DeleteCourse(@PathVariable String name, @PathVariable long cid) {
    Course courseToDelete = CourseRepository.findBycourseid(cid);
    courseToDelete.setMajor(null);
    CourseRepository.delete(courseToDelete);
    courseNoSQLRepository.deleteById(courseToDelete.getCourseid());
  }

  @CrossOrigin(origins = "http://localhost:8080") 
  @PutMapping("/addCourse/{name}")
  public void addCourse(@PathVariable String name, @RequestBody Course newCourse) {
    Major curMajor = Majorrepository.findBymajorname(name);
    CourseNoSQL courseNoSQL = new CourseNoSQL();
    courseNoSQL.setCourseid(newCourse.getCourseid());
    newCourse.setMajor(curMajor);
    courseNoSQLRepository.save(courseNoSQL);
    curMajor.getCourseList().add(newCourse);
    Majorrepository.save(curMajor);
    
  }


}