package com.tobilko.tobsport.repository;

import com.tobilko.tobsport.entity.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andrew Tobilko on 11/29/17.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {}
