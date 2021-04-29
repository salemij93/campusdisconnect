package edu.depaul.cdm.se452.group2.campusdisconnect.Majors;
import org.springframework.*;
import java.io.Serializable;
import java.util.*;
import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.Departments.Department;


@Data
@Entity
@Table(name = "major")
public class Major implements Serializable {
    @Id
    @Column(name = "majorname")
    private String majorname;

    @Column(name = "requiredCredit")
    private int requiredCredit;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class,cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();


}
