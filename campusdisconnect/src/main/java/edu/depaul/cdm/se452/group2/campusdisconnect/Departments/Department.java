package edu.depaul.cdm.se452.group2.campusdisconnect.Departments;
import edu.depaul.cdm.se452.group2.campusdisconnect.Advisors.Advisor;
import edu.depaul.cdm.se452.group2.campusdisconnect.Majors.*;
import edu.depaul.cdm.se452.group2.campusdisconnect.Professors.*;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Data
@Entity
@Table
public class Department implements Serializable {

    @Id
    @Column( name = "departmentname")
    private String departmentname;

    @OneToMany(mappedBy = "department", targetEntity = Major.class, cascade = {CascadeType.ALL})
    private List<Major> majorList = new ArrayList<>();

    @OneToMany(mappedBy = "department",targetEntity = Advisor.class, cascade = {CascadeType.ALL})
    private List<Advisor> advisorList = new ArrayList<>();

    @OneToMany(mappedBy = "department", targetEntity = Professor.class, cascade = {CascadeType.ALL})
    private List<Professor> professorList = new ArrayList<>();

    

}
