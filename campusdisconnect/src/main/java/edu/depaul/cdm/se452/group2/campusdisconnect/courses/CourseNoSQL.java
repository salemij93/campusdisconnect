package edu.depaul.cdm.se452.group2.campusdisconnect.courses;
import java.io.Serializable;
import java.util.*;
import lombok.*;


import org.springframework.data.annotation.Id;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.depaul.cdm.se452.group2.campusdisconnect.courseComment.CourseComment;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "courseInfo")
public class CourseNoSQL implements Serializable {

    @Id
    private long courseid; // the cousre id (key)

    private int enrolledcapacity; // how many people can enroll

    private int waitlistCapacity; // how many people can be on the waitlist

    private List<Long> waitlist = new ArrayList<>(); // list of student ids in order who are waiting to be enrolled
    private List<Long> enrolledlist = new ArrayList<>(); //list of student ids in order who are enrolled
    private List<CourseComment> comments = new ArrayList<>();
    


}