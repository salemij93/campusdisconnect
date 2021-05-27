package edu.depaul.cdm.se452.group2.campusdisconnect.advisor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/advisor")
public class AdvisorController {

    @Autowired
    private AdvisorRepository advisorRepository;

    @GetMapping
    public String showAll(Model model) {
        Iterable<Advisor> advisors = advisorRepository.findAll();
        model.addAttribute("advisors", advisors);
        return "advisors/list";
    }

}
