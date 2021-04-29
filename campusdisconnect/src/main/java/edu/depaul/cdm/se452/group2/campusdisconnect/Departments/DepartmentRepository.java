package edu.depaul.cdm.se452.group2.campusdisconnect.Departments;

import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
    public Department findBydepartmentid(int departmentid);
}
