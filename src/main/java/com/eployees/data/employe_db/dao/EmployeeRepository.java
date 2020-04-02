package com.eployees.data.employe_db.dao;

import com.eployees.data.employe_db.model.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails,Long> {
    Optional<Object> findAllById(Long employeeId);
}
