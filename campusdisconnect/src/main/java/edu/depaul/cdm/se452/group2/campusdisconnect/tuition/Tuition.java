package edu.depaul.cdm.se452.group2.campusdisconnect.tuition;
import java.io.Serializable;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;


@Data
@Entity
public class Tuition implements Serializable {

    @Id
    private String majorname;

    private int creditPrice;

}
