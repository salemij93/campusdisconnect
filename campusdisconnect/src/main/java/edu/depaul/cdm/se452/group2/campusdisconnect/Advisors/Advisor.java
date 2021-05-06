package edu.depaul.cdm.se452.group2.campusdisconnect.Advisors;

import java.io.Serializable;

import javax.persistence.*;

import edu.depaul.cdm.se452.group2.campusdisconnect.Departments.Department;
import lombok.Data;

@Data
@Entity
@Table
public class Advisor implements Serializable {
    private static final long serialVersionUUID= 1L;

    @Id
    @Column(name = "advisorId")
    private long advisorId;

    @Column( name = "advisorname")
    private String advisorname;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    private Department department;

}
