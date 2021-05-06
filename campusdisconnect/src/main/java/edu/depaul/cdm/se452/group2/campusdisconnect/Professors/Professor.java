package edu.depaul.cdm.se452.group2.campusdisconnect.Professors;

import javax.persistence.Table;

import lombok.*;

@Data
@Entity
    @Id
	private Long pid;
    @Column(name = "firstName")
    private String firstName;
    
    @Column(name = "lastName")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
    private Department department;
    
    @OneToMany(fetch = FetchType.LAZY, targetEntity = Course.class,cascade = {CascadeType.ALL})
    private Set<Course> courselist = new HashSet<>(); 
	

}