package edu.depaul.cdm.se452.group2.campusdisconnect.Courses;
import org.springframework.*;
import java.io.Serializable;
import java.util.*;
import lombok.*;


import org.springframework.data.annotation.Id;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "courseInfo")
public class CourseNoSQL implements Serializable {

    @Id
    private String courseid; // the cousre id (key)

    private int enrolledcapacity; // how many people can enroll

    private int waitlistCapacity; // how many people can be on the waitlist


    private Set<String> waitlist = new HashSet<>(); // list of student ids in order who are waiting to be enrolled
    private Set<String> enroledlist = new HashSet<>(); //list of student ids in order who are enrolled
    
    
    


}