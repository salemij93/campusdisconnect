package edu.depaul.cdm.se452.group2.campusdisconnect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
class LoginController {
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
  
  

}