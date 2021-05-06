package edu.depaul.cdm.se452.group2.campusdisconnect.Scholarship;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scholarship")
public class ScholarshipController {

    @Autowired
    ScholarshipRepository scholarshipRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String getAllScholarships() {
        return scholarshipRepository.findAll().toString();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/price/{id}")
    public int getScholarshipAmount(@PathVariable Long id ) {
        return scholarshipRepository.findBystudentId(id).getScholarshipAmount();
    }





}