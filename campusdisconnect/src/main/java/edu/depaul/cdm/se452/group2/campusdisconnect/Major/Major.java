package edu.depaul.cdm.se452.group2.campusdisconnect.Major;
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


@Data
@Entity
@Table(name = "major")
public class Major implements Serializable {

    @Id
    @Column(name = "majorid")
    private int majorid;

    @Column(name = "majorName")
    private String majorName;

    @Column(name = "departmentid")
    private int departmentid;

}
