package edu.depaul.cdm.se452.group2.campusdisconnect.Scholarship;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Scholarship implements Serializable {
    private static final long serialVersionUUID= 1L;

    @Id
    @Column(name = "scholarshipId")
    private long scholarshipId;

    @Column( name = "scholarship_name")
    private String scholarshipDescription;

    @Column( name = "scholarship_amount")
    private int scholarshipAmount;

    @Column (name = "student_id")
    private long studentId;
}
