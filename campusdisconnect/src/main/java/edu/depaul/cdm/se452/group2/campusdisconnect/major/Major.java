package edu.depaul.cdm.se452.group2.campusdisconnect.major;
import java.io.Serializable;
import java.util.*;
import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;

import edu.depaul.cdm.se452.group2.campusdisconnect.course.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.department.Department;


@Data
@Entity
public class Major implements Serializable {
    @Id
    private String majorname;

    private int requiredCredit;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class,cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();


}
