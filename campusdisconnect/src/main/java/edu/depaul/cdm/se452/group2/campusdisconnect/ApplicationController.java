package edu.depaul.cdm.se452.group2.campusdisconnect;

import edu.depaul.cdm.se452.group2.campusdisconnect.student.Register;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.Student;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.StudentNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.StudentNoSQLRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.student.StudentRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.task.TaskNoSQL;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.DisconnectUser;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.UserRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.authority.Authority;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.authority.AuthorityRepository;
import edu.depaul.cdm.se452.group2.campusdisconnect.user.authority.AuthorityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@Controller
class ApplicationController {

    @Autowired
    private StudentRepository studentrepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private StudentNoSQLRepository studentNoSQLRepository;


    @GetMapping("/login")
    public String login() {return "login"; }

    @GetMapping("/home")
    public String home() {
        return "homepage";
    }

    @GetMapping("/")
    public String start() {
        return "homepage";
    }


    @GetMapping("/register")
    public String getStudentRegistrationPage(Model model) {
        model.addAttribute("register", new Register());
        return "registration";
    }

  @PostMapping("/register")
  public String registrationSubmit(@ModelAttribute Register registrationInformation) {
        //update user and user auth
      DisconnectUser user = new DisconnectUser();

      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
      String password = bCryptPasswordEncoder.encode(registrationInformation.getPassword());
      String userId = registrationInformation.getStudentuserId();
      user.setPassword(password);
      user.setStudentId(userId);
      Authority authorityRepositoryById = authorityRepository.findById(2L).get();
      user.setAuthorities(Set.of(authorityRepositoryById));
      userRepository.save(user);

      //update student
        Student student = new Student();
        student.setStudentid(user.getId());
        student.setStudentuserId(userId);
        student.setEmail(registrationInformation.getEmail());
        student.setMajor(registrationInformation.getMajor());
        student.setAddress(registrationInformation.getAddress());
        student.setFirstName(registrationInformation.getFirstName());
        student.setLastName(registrationInformation.getLastName());
        
        StudentNoSQL studentNoSQL = new StudentNoSQL();
        studentNoSQL.setStudentid(user.getId());
    studentrepository.save(student);
    studentNoSQLRepository.save(studentNoSQL);
    return "homepage";
  }


}