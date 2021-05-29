package edu.depaul.cdm.se452.group2.campusdisconnect.course;


import edu.depaul.cdm.se452.group2.campusdisconnect.DisconnectUserUtil;
import edu.depaul.cdm.se452.group2.campusdisconnect.task.TaskNoSQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseNoSQLRepository courseNoSQLRepository;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String getCourseInfo(Model model) {
        Long disconnectUserId = DisconnectUserUtil.getDisconnectUserId();

        Course course = courseRepository.findBycourseid(disconnectUserId);

        model.addAttribute("id", disconnectUserId);
        model.addAttribute("course", course);
        return "coursePage";
    }

}