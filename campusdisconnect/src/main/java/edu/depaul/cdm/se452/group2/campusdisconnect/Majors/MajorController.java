package edu.depaul.cdm.se452.group2.campusdisconnect.Majors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/major")
class MajorController {

  @Autowired
  private MajorRepository Majorrepository;


  @CrossOrigin(origins = "http://localhost:8080")
  @GetMapping("/majorinfo/{id}")
  public String getMajorInfo(@PathVariable int id) {
    return Majorrepository.findBymajorid(id).toString();
  }

  @CrossOrigin(origins = "http://localhost:8080")
  @PutMapping("/update/{id}")
  public void updateMajorInfo(@RequestBody Major newMajor, @PathVariable int id) {
    Majorrepository.save(newMajor);
  }   

  
}