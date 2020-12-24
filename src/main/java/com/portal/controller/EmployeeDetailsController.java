package com.portal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.dto.EmployeeDetailsDTO;
import com.portal.entity.EmployeeDetails;
import com.portal.service.EmployeeDetailsService;


@RestController
@CrossOrigin
@RequestMapping("/employeePortal")
public class EmployeeDetailsController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	// Create a new employee
	@PostMapping(value = "/employee",  consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeDetails> createEmployee(@RequestBody EmployeeDetailsDTO empDTO) {
		logger.info("Creation request for employee {}", empDTO);
		EmployeeDetails empDetails = employeeDetailsService.createEmployee(empDTO);
		return new ResponseEntity<EmployeeDetails>(empDetails, HttpStatus.CREATED);
	}

	// Fetches all employee details
	@GetMapping(value = "/all-employees", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EmployeeDetailsDTO>> getAllEmployees() {
		logger.info("Fetching all employees");
		List<EmployeeDetailsDTO> empDetailsDTOList =  employeeDetailsService.getAllEmployees();
		return new ResponseEntity<List<EmployeeDetailsDTO>>(empDetailsDTOList, HttpStatus.OK);
	}

}
