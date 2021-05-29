package edu.depaul.cdm.se452.group2.campusdisconnect.user.authority;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorityId;

    @Enumerated(EnumType.STRING)
    private AuthorityType authorityRole;

}
