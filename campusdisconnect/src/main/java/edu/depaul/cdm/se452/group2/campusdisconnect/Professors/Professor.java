package edu.depaul.cdm.se452.group2.campusdisconnect.Professors;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;

@Data
@Entity
@Table(name = "professors")
public class Professor implements Serializable {
    @Id
    @Column(name = "pid")
	private Long pid;
    
    @Column(name = "firstName")
    private String fistName;
    
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "deptId")
	private Integer deptId;

	

}