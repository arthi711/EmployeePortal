package com.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.dto.EmployeeDetailsDTO;
import com.portal.entity.EmployeeDetails;
import com.portal.repository.EmployeeDetailsRepository;

@Service
public class EmployeeDetailsService {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeDetailsRepository employeeDetailsRepo;

	//Create a employee 
	public EmployeeDetails createEmployee(EmployeeDetailsDTO employeeDetailsDTO) {
		logger.info("Creation request for employee {}", employeeDetailsDTO);
		EmployeeDetails employeeDetails = employeeDetailsDTO.createEntity();
		return employeeDetailsRepo.save(employeeDetails);
	}
	
	// Fetches all employee details
	public List<EmployeeDetailsDTO> getAllEmployees() {

		List<EmployeeDetails> employeeDetails = employeeDetailsRepo.findAll();
		List<EmployeeDetailsDTO> resultEmpDetailsList = new ArrayList<EmployeeDetailsDTO>();

		for (EmployeeDetails empDetail : employeeDetails) {
			EmployeeDetailsDTO empDTO = EmployeeDetailsDTO.valueOf(empDetail);
			resultEmpDetailsList.add(empDTO);
		}

		logger.info("Employee details : {}", resultEmpDetailsList);
		return resultEmpDetailsList;
	}
}
