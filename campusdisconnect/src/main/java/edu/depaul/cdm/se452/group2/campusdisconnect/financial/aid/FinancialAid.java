package edu.depaul.cdm.se452.group2.campusdisconnect.financial.aid;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class FinancialAid implements Serializable {
    private static final long serialVersionUUID= 1L;

    @Id
    @Column(name = "financialaidId")
    private long financialaidid;

    @Column( name = "aid_name")
    private String financialAidDescription;

    @Column( name = "aid_amount")
    private int aidAmount;

    @Column (name = "student_id")
    private long studentid;
}
