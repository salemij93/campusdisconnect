package edu.depaul.cdm.se452.group2.campusdisconnect.Courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Course newCourse(@RequestBody Course course) {
        return courseRepository.save(course);
    }


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/courseinfo/{id}")
    public String getCourseInfo(@PathVariable Long id) {
        return courseRepository.findById(id).toString();
    }





}