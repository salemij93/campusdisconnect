package edu.depaul.cdm.se452.group2.campusdisconnect.Tuitions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tuition")
public class TuitionController {

    @Autowired
    TuitionRepository tuitionRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String getAllTuition() {
        return tuitionRepository.findAll().toString();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/price/{majorname}")
    public int getMajorTuition(@PathVariable String name ) {
        return tuitionRepository.findBymajorname(name).getCreditPrice();
    }





}