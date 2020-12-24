package com.portal.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entity.EmployeeDetails;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Integer> {

	
}
