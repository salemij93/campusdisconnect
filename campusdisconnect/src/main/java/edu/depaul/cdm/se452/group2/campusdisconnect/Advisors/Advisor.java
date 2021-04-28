package edu.depaul.cdm.se452.group2.campusdisconnect.Advisors;

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

    @Column( name = "advisorname")
    private String advisorname;

    @Column(name = "departmentid")
    private int departmentid;

}
