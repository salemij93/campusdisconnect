package edu.depaul.cdm.se452.group2.campusdisconnect.majors;
import java.io.Serializable;
import java.util.*;
import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se452.group2.campusdisconnect.courses.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.departments.Department;


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
