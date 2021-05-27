package edu.depaul.cdm.se452.group2.campusdisconnect.advisor;

import java.io.Serializable;

import javax.persistence.*;

import edu.depaul.cdm.se452.group2.campusdisconnect.department.Department;
import lombok.Data;

@Data
@Entity
@Table
public class Advisor implements Serializable {
    private static final long serialVersionUUID= 1L;

    @Id
    private long advisorId;

    private String advisorname;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    private Department department;

}
