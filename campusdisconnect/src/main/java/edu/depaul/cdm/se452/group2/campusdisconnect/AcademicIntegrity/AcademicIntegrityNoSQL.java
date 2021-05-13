package edu.depaul.cdm.se452.group2.campusdisconnect.academicIntegrity;


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
@Document(collection = "academicIntegrityRecord")

public class AcademicIntegrityNoSQL implements Serializable {

    @Id
    private long sid;

    private long vid;

    private Set<String> viloationList = new HashSet<>(); 
    

    
}
