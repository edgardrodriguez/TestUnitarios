package org.example.repository;


import org.example.domain.Employee;

import java.util.List;

public interface EmployeeRepository {

    Integer count();

    List<Employee> findAll();

    Employee findOne(Long id);
    
    Employee save(Employee smartphone);

    boolean delete(Long id);

    void deleteAll();

}
