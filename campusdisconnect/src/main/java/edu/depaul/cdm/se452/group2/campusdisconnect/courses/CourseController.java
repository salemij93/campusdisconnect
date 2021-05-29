package edu.depaul.cdm.se452.group2.campusdisconnect.courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.depaul.cdm.se452.group2.campusdisconnect.courseComment.CourseComment;
import edu.depaul.cdm.se452.group2.campusdisconnect.students.StudentNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.students.StudentNoSQLRepository;

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
    public String getCourseInfo(@RequestParam Long id, Model model) {
        StudentNoSQL student =  studentNoSQLRepository.findBystudentid(id);
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

    	
    return "coursePage";





    }
    @GetMapping("/comments/all")
    public String showComments(@RequestParam Long cid, Model model){
        List<CourseComment> comments = courseNoSQLRepository.findBycourseid(cid).getComments();
        model.addAttribute("comments", comments);
        return "commentPage";
    }
    @PostMapping("/comments/create")
    public String createComments(@RequestParam Long cid, Model model, String content){
        List<CourseComment> comments = courseNoSQLRepository.findBycourseid(cid).getComments();
        CourseComment new_comment = new CourseComment();
        new_comment.setReview(content);
        comments.add(new_comment);
        model.addAttribute("comments", comments);
        return "commentPage";
    }

}