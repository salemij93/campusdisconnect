package edu.depaul.cdm.se452.group2.campusdisconnect.student;
import java.io.Serializable;
import java.util.*;
import lombok.*;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "studentsinfo")
public class StudentNoSQL implements Serializable {

    @Id
    private long studentid;

    private Set<String> currentRegistrated = new HashSet<>(); 
    private Set<String> currentWaitlist= new HashSet<>(); 
    private Set<String> compeletedCourses= new HashSet<>(); 
    
    // use a set to store registered courseid allows quick O(1) drop and add course


}
