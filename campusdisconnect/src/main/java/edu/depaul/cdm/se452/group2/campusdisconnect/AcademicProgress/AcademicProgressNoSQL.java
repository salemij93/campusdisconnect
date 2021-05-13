package edu.depaul.cdm.se452.group2.campusdisconnect.AcademicProgress;
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
@Document(collection = "academicProgress")

public class AcademicProgressNoSQL implements Serializable {

    @Id
    private long sid;

    private Set<String> completedCourseList = new HashSet<>(); 
    private Set<String> inprogressCourseList = new HashSet<>();
    
    
    
}
