package edu.depaul.cdm.se452.group2.campusdisconnect.course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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