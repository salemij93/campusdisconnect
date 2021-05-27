package edu.depaul.cdm.se452.group2.campusdisconnect.scholarship;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Scholarship implements Serializable {
    

    @Id
    private long studentId;

    @Column( name = "scholarship_amount")
    private int scholarshipAmount;

    
}
