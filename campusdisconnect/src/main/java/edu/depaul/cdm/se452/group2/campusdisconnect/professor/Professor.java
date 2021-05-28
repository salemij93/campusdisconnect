package edu.depaul.cdm.se452.group2.campusdisconnect.professor;

import edu.depaul.cdm.se452.group2.campusdisconnect.course.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.department.Department;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
public class Professor implements Serializable {
    @Id
	private Long pid;
    
    private String firstName;
    
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    private Department department;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class,cascade = {CascadeType.ALL})
    private Set<Course> courselist = new HashSet<>(); 
	

}