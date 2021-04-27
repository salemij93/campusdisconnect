package edu.depaul.cdm.se452.group2.campusdisconnect.department;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
public class Department implements Serializable {
    private static final long serialVersionUUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deptId;

    @Column( name = "deptname")
    private String deptName;

    @Column( name = "address")
    private String deptAddress;

}
