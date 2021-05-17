package edu.depaul.cdm.se452.group2.campusdisconnect.courses;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseNoSQLRepository courseNoSQLRepository;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String getCourseInfo(@RequestParam Long id) {
        Course course = courseRepository.findBycourseid(id);
        return "coursePage";
    }

}