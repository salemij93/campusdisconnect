package edu.depaul.cdm.se452.group2.campusdisconnect.task;


import java.io.Serializable;
import java.util.*;
import lombok.*;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "tasks")

public class TaskNoSQL implements Serializable{
    @Id
    private long sid;

    private long taskid;
     private Set<String> taskList = new HashSet<>(); 
    
}
