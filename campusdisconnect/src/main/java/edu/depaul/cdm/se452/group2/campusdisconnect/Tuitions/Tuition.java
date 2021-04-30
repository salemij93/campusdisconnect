package edu.depaul.cdm.se452.group2.campusdisconnect.Tuitions;
import org.springframework.*;
import java.io.Serializable;
import java.util.*;
import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import javax.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Entity
@Table(name = "tuition")
public class Tuition implements Serializable {

    @Id
    @Column(name = "majorid")
    private int majorid;

    @Column(name = "creditPrice")
    private int creditPrice;

}
