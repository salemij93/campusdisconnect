package edu.depaul.cdm.se452.group2.campusdisconnect.Departments;
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
@Document(collection = "departmentInfo")
public class DepartmentNoSQL implements Serializable {

    @Id
    private int departmentid; // the cousre id (key)

    private Set<Long> advisorList = new HashSet<>(); // list of advisors of the department

    private Set<Integer> majorList = new HashSet<>();
    
    
}