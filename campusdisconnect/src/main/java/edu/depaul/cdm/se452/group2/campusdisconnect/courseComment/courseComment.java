package edu.depaul.cdm.se452.group2.campusdisconnect.courseComment;

import java.util.*;
import lombok.*;
import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Id;

@Data
@Entity
@Table(name = "courseComment")
public class courseComment implements Serializable{
 
    @Id
    @Column(name = "commentid") 
    private long commentid;

    @Column(name = "review")
    private String review;

}