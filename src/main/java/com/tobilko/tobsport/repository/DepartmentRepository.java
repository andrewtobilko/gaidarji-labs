package com.tobilko.tobsport.repository;

import com.tobilko.tobsport.entity.Department;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Andrew Tobilko on 11/29/17.
 */
public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
