package edu.depaul.cdm.se452.group2.campusdisconnect.course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.depaul.cdm.se452.group2.campusdisconnect.DisconnectUserUtil;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.*;
import edu.depaul.cdm.se452.group2.campusdisconnect.course.comment.CourseComment;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    StudentNoSQLRepository studentNoSQLRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseNoSQLRepository courseNoSQLRepository;


    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String getCourseInfo(Model model) {
        Long disconnectUserId = DisconnectUserUtil.getDisconnectUserId();
        String username = DisconnectUserUtil.getDisconnectUsername();
        StudentNoSQL student =  studentNoSQLRepository.findBystudentid(disconnectUserId);
        Set<String> curCourses = student.getCurrentRegistrated();
        List<Course> curList = new ArrayList<>();
        List<CourseNoSQL> nosqlList = new ArrayList<>();
        List<Course> allCourse = courseRepository.findAll();
        for(String cid : curCourses){
            Course course = courseRepository.findBycourseid(Long.valueOf(cid));
            CourseNoSQL nosql = courseNoSQLRepository.findBycourseid(Long.valueOf(cid));
            curList.add(course);
            nosqlList.add(nosql);
            allCourse.remove(course);
        }
        

        model.addAttribute("curList", curList);
        model.addAttribute("nosqlList", nosqlList);
        model.addAttribute("allCourse", allCourse);
        model.addAttribute("sid", disconnectUserId);

    	
    return "coursePage";





    }
    @GetMapping("/comments/all")
    public String showComments(@RequestParam Long cid, Model model){
        List<CourseComment> comments = courseNoSQLRepository.findBycourseid(cid).getComments();
        model.addAttribute("comments", comments);
        model.addAttribute("cid", cid);
        return "commentPage";
    }
    @PostMapping("/comments/create")
    public String createComments(@RequestParam Long cid, Model model, String content){
        CourseNoSQL cur = courseNoSQLRepository.findBycourseid(cid);
        List<CourseComment> comments = cur.getComments();
        CourseComment new_comment = new CourseComment();
        new_comment.setReview(content);
        new_comment.setDate(new Date());
        comments.add(new_comment);
        courseNoSQLRepository.save(cur);
        model.addAttribute("comments", comments);
        model.addAttribute("cid", cid);
        return "commentPage";
    }

}