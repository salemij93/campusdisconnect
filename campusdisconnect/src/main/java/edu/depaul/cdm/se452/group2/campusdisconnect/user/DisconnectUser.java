package edu.depaul.cdm.se452.group2.campusdisconnect.user;

import edu.depaul.cdm.se452.group2.campusdisconnect.user.authority.Authority;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class DisconnectUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(nullable = false, unique = true)
    private String studentId;

    @NotEmpty
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_authority",
            joinColumns = { @JoinColumn(name = "id") },
            inverseJoinColumns = { @JoinColumn(name = "authority_id")  })
    private Set<Authority> authorities = new HashSet<>();

}
