package edu.depaul.cdm.se452.group2.campusdisconnect.Courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseNoSQLRepository courseNoSQLRepository;

    @GetMapping
    public void showAll() {
        courseRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/create")
    public void newCourse(@RequestBody Course course) {

        CourseNoSQL newCourseNoSQL = new CourseNoSQL();
        newCourseNoSQL.setCourseid(course.getCourseid());
        courseNoSQLRepository.save(newCourseNoSQL);
        courseRepository.save(course);
        //return courseRepository.save(course);
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/courseinfo/{id}")
    public String getCourseInfo(@PathVariable Long id) {
        return courseRepository.findById(id).toString();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/updateCourseinfo/{id}")
    public void updateCourseInfo(@RequestBody Course newCourse, @PathVariable Long id) {
  
      courseRepository.save(newCourse);
    } 



}