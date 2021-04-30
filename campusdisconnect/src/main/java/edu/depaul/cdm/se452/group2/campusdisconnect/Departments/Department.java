package edu.depaul.cdm.se452.group2.campusdisconnect.Departments;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class Department implements Serializable {

    @Id
    @Column(name = "departmentid")
    private int departmentid;

    @Column( name = "departmentname")
    private String departmentname;

}
