package edu.depaul.cdm.se452.group2.campusdisconnect.Scholarship;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scholarship")
public class ScholarshipController {

    @Autowired
    ScholarshipRepository scholarshipRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info/{id}")
    public int getAllScholarships(@PathVariable Long id) {
        return scholarshipRepository.findBystudentId(id).getScholarshipAmount();
    }




}