package edu.depaul.cdm.se452.group2.campusdisconnect.CourseComment;



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
public class commentController {

    @Autowired
    commentRepository commentRepository;

    @Autowired
    commentNoSQLRepository commentNoSQLRepository;

    @GetMapping
    public void showAll() {
        commentRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/create")
    public void newCourse(@RequestBody courseComment comment) {

        commentNoSQL newcommentNoSQL = new commentNoSQL();
        newcommentNoSQL.setCommentid(comment.getCommentid());
        commentNoSQLRepository.save(newcommentNoSQL);
        commentRepository.save(comment);
        
    }





}