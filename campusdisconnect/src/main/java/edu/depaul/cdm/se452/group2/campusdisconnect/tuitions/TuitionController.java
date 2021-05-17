package edu.depaul.cdm.se452.group2.campusdisconnect.tuitions;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tuition")
public class TuitionController {

    @Autowired
    TuitionRepository tuitionRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String getAllTuition(@RequestParam Long id, Model model) {

        return "studentaccount";
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/price/{majorname}")
    public int getMajorTuition(@PathVariable String name ) {
        return tuitionRepository.findBymajorname(name).getCreditPrice();
    }





}