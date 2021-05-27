package edu.depaul.cdm.se452.group2.campusdisconnect.course.comment;

import lombok.*;
import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

@Data
@Entity
public class CourseComment implements Serializable{
 
    @Id
    private long commentid;


    private String review;

}