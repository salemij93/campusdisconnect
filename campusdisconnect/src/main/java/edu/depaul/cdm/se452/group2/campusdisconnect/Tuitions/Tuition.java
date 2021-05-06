<<<<<<< HEAD
package edu.depaul.cdm.se452.group2.campusdisconnect.Tuitions;
import org.springframework.*;
=======
<<<<<<< HEAD:campusdisconnect/src/main/java/edu/depaul/cdm/se452/group2/campusdisconnect/Majors/Major.java
package edu.depaul.cdm.se452.group2.campusdisconnect.Majors;
import org.springframework.*;
=======
package edu.depaul.cdm.se452.group2.campusdisconnect.Tuitions;
>>>>>>> main:campusdisconnect/src/main/java/edu/depaul/cdm/se452/group2/campusdisconnect/Tuitions/Tuition.java
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


@Data
@Entity
@Table(name = "tuition")
public class Tuition implements Serializable {

    @Id
<<<<<<< HEAD
    @Column(name = "majorid")
    private int majorid;
=======
    @Column(name = "majorname")
    private String majorname;
>>>>>>> main

    @Column(name = "creditPrice")
    private int creditPrice;

}
