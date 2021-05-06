<<<<<<< HEAD
<<<<<<< HEAD:campusdisconnect/src/main/java/edu/depaul/cdm/se452/group2/campusdisconnect/Majors/Major.java
package edu.depaul.cdm.se452.group2.campusdisconnect.Majors;
import org.springframework.*;
=======
package edu.depaul.cdm.se452.group2.campusdisconnect.Tuitions;
>>>>>>> main:campusdisconnect/src/main/java/edu/depaul/cdm/se452/group2/campusdisconnect/Tuitions/Tuition.java
=======
package edu.depaul.cdm.se452.group2.campusdisconnect.Majors;
>>>>>>> main
import java.io.Serializable;
import java.util.*;
import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

<<<<<<< HEAD

@Data
@Entity
@Table(name = "tuition")
public class Tuition implements Serializable {

=======
import edu.depaul.cdm.se452.group2.campusdisconnect.Courses.Course;
import edu.depaul.cdm.se452.group2.campusdisconnect.Departments.Department;


@Data
@Entity
@Table(name = "major")
public class Major implements Serializable {
>>>>>>> main
    @Id
    @Column(name = "majorname")
    private String majorname;

<<<<<<< HEAD
    @Column(name = "creditPrice")
    private int creditPrice;
=======
    @Column(name = "requiredCredit")
    private int requiredCredit;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    private Department department;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class,cascade = {CascadeType.ALL})
    private List<Course> courseList = new ArrayList<>();

>>>>>>> main

}
