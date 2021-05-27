package edu.depaul.cdm.se452.group2.campusdisconnect.tuition;
import java.io.Serializable;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;


@Data
@Entity
@Table(name = "tuition")
public class Tuition implements Serializable {

    @Id
    @Column(name = "majorname")
    private String majorname;

    @Column(name = "creditPrice")
    private int creditPrice;

}
