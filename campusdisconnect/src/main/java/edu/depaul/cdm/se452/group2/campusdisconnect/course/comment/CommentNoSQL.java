package edu.depaul.cdm.se452.group2.campusdisconnect.course.comment;

import java.io.Serializable;

import lombok.*;


import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "commentInfo")
public class CommentNoSQL implements Serializable {

    @Id
    private long commentid; 

    private String review;
    
    


}