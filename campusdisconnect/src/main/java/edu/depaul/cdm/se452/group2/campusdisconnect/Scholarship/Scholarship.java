package edu.depaul.cdm.se452.group2.campusdisconnect.Scholarship;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Scholarship implements Serializable {
    

    @Id
    @Column (name = "student_id")
    private long studentId;

    @Column( name = "scholarship_amount")
    private int scholarshipAmount;

    
}
