package edu.depaul.cdm.se452.group2.campusdisconnect.departments;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    public Department findBydepartmentname(String departmentname);
}
