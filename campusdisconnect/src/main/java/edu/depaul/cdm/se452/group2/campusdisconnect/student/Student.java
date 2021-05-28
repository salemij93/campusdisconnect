package edu.depaul.cdm.se452.group2.campusdisconnect.student;
import java.io.Serializable;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;


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
