package edu.depaul.cdm.se452.group2.campusdisconnect.course.comment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CommentNoSQLRepository commentNoSQLRepository;

    @GetMapping
    public void showAll() {
        commentRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/create")
    public void newCourse(@RequestBody CourseComment comment) {

        CommentNoSQL newcommentNoSQL = new CommentNoSQL();
        newcommentNoSQL.setCommentid(comment.getCommentid());
        commentNoSQLRepository.save(newcommentNoSQL);
        commentRepository.save(comment);
        
    }





}