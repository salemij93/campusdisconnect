package edu.depaul.cdm.se452.group2.campusdisconnect;

import edu.depaul.cdm.se452.group2.campusdisconnect.Students.Student;
import edu.depaul.cdm.se452.group2.campusdisconnect.Students.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
class LoginController {

  @Autowired
  private StudentRepository studentrepository;

  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/")
  public String Login() {
    return "index";
  }

  @GetMapping("/home")
  public String home(@RequestParam Long id) {
    return "homepage";
  }
  @GetMapping("/task")
  public String getTaskList(@RequestParam Long id) {
      return "mytask";
  }

  @GetMapping("/tuition")
  public String getAllTuition(@RequestParam Long id) {
      return "studentaccount";
  }
  
  @GetMapping(params = "edit")
  public String getStudentRegistrationPage(Model model) {
    model.addAttribute("student", new Student());
    return "registration";
  }

  @PostMapping("/")
  public String registrationSubmit(@ModelAttribute Student student) {
    studentrepository.save(student);
    return "homepage";
  }


}