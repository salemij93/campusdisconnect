package edu.depaul.cdm.se452.group2.campusdisconnect.department;
import edu.depaul.cdm.se452.group2.campusdisconnect.advisor.Advisor;
import edu.depaul.cdm.se452.group2.campusdisconnect.major.*;
import edu.depaul.cdm.se452.group2.campusdisconnect.professor.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
public class Department implements Serializable {

    @Id
    private String departmentname;

    @OneToMany(mappedBy = "department", targetEntity = Major.class, cascade = {CascadeType.ALL})
    private List<Major> majorList = new ArrayList<>();

    @OneToMany(mappedBy = "department",targetEntity = Advisor.class, cascade = {CascadeType.ALL})
    private List<Advisor> advisorList = new ArrayList<>();

    @OneToMany(mappedBy = "department", targetEntity = Professor.class, cascade = {CascadeType.ALL})
    private List<Professor> professorList = new ArrayList<>();

    

}
