package edu.depaul.cdm.se452.group2.campusdisconnect.advisor;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
@Table
public class Advisor implements Serializable {
    private static final long serialVersionUUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long advisorId;

    @Column( name = "advname")
    private String advisorName;

    @Column(name = "deptid")
    private long departmentId;

}
