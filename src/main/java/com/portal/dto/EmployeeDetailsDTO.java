package com.portal.dto;



import java.util.Date;

import com.portal.entity.EmployeeDetails;



public class EmployeeDetailsDTO {

	String firstName;

	String lastName;

	char gender;

	Date dateOfBirth;
	
	String department;

	public EmployeeDetailsDTO() {
		super();
	}

	public EmployeeDetailsDTO(String firstName, String lastName, char gender, Date dateOfBirth, String department) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	// Converts Entity into DTO
	public static EmployeeDetailsDTO valueOf(EmployeeDetails empDetails) {
		EmployeeDetailsDTO empDetailsDTO = new EmployeeDetailsDTO();
		empDetailsDTO.setFirstName(empDetails.getFirstName());
		empDetailsDTO.setLastName(empDetails.getLastName());
		empDetailsDTO.setGender(empDetails.getGender());
		empDetailsDTO.setDateOfBirth(empDetails.getDateOfBirth());
		empDetailsDTO.setDepartment(empDetails.getDepartment());
		return empDetailsDTO;
	}

	// Converts DTO into Entity
	public EmployeeDetails createEntity() {
		EmployeeDetails empDetails = new EmployeeDetails();
		empDetails.setFirstName(this.firstName);
		empDetails.setLastName(this.lastName);
		empDetails.setGender(this.gender);
		empDetails.setDateOfBirth(this.dateOfBirth);
		empDetails.setDepartment(this.department);
		return empDetails;
	}

	@Override
	public String toString() {
		return "EmployeeDetailsDTO [FirstName=" + firstName + ", LastName=" + lastName + ", Gender=" + gender
				+ ", DateOfBirth=" + dateOfBirth + ", Department=" + department + "]";
	}

}
