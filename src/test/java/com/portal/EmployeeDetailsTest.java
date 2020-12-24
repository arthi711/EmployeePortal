package com.portal;


import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.portal.controller.EmployeeDetailsController;
import com.portal.dto.EmployeeDetailsDTO;
import com.portal.service.EmployeeDetailsService;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(value = EmployeeDetailsController.class)
public class EmployeeDetailsTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	EmployeeDetailsService mockService;

	@Test
	public void testCreateEmployee() throws Exception {

		EmployeeDetailsDTO employeeDetailsDTO = new EmployeeDetailsDTO ("Gyn", "Paula", 'F', DateUtils.parseDate("1992-01-07", new String[] { "yyyy-MM-dd" }),"Manufacturing");
		Mockito.when(mockService.createEmployee(employeeDetailsDTO)).thenReturn(employeeDetailsDTO.createEntity());

		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/employeePortal/employee")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();

		System.out.println(result.getResponse());

		String expected = "{firstName:Gyn,lastName:Paula,gender:F,dateOfBirth:1992-01-07,department:Manufacturing}";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

	}

	@Test
	public void testGetAllEmployees() throws Exception {


		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/employeePortal/all-employees")
				.contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		MockHttpServletResponse response = result.getResponse();

		System.out.println(result.getResponse());

		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}
}
