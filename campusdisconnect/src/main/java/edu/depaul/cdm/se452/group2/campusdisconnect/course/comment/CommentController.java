package edu.depaul.cdm.se452.group2.campusdisconnect.course.comment;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping
    public void showAll() {
        commentRepository.findAll();
    }

}