package edu.depaul.cdm.se452.group2.campusdisconnect.students;
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
public class Student implements Serializable {

    @Id
    private long studentid;

    private String major;

    private String email;


    private String firstName;

    private String lastName;

    private String address;

    private int credit;

   


}
