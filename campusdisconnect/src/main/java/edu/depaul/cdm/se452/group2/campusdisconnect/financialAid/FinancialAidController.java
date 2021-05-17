package edu.depaul.cdm.se452.group2.campusdisconnect.financialAid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financialaid")
public class FinancialAidController {

    @Autowired
    FinancialAidRepository financialAidRepository;

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/info")
    public String getAllFinancialAid() {
        return financialAidRepository.findAll().toString();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/price/{id}")
    public int getFinancialAidRepositoryAmount(@PathVariable Long id ) {
        return financialAidRepository.findBystudentid(id).getAidAmount();
    }





}