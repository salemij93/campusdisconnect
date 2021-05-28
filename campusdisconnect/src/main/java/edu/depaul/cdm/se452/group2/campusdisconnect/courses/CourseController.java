package edu.depaul.cdm.se452.group2.campusdisconnect.courses;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
import org.springframework.web.bind.annotation.ResponseBody;

import edu.depaul.cdm.se452.group2.campusdisconnect.courses.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.courses.CourseNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.courses.CourseNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.courses.CourseRepository;

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
    public String getCourseInfo(@PathVariable Long id, Model model) {
        Course course = courseRepository.findBycourseid(id);


        model.addAttribute("courseid", course.getCourseid());
    	model.addAttribute("courseName", course.getCourseName());
    	model.addAttribute("StartTime", course.getStartTime());
    	model.addAttribute("EndTime", course.getEndTime());
    	model.addAttribute("credits", course.getCredits());
    	model.addAttribute("year", course.getYear());
    	model.addAttribute("quarter", course.getQuarter());
    	
    
    return "Course Info";





    }

}