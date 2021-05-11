package edu.depaul.cdm.se452.group2.campusdisconnect.Students;
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
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name = "studentid")
    private long studentid;

    @Column(name = "major")
    private String major;

    @Column(name = "email")
    private String email;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "credit")
    private int credit;

   


}
