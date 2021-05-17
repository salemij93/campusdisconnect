package edu.depaul.cdm.se452.group2.campusdisconnect.courses;


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


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info/{id}")
    public String getCourseInfo(@PathVariable Long id) {
        return courseRepository.findById(id).toString();
    }

}