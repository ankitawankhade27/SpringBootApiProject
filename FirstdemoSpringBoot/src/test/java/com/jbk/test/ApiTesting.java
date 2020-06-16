package com.jbk.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jbk.UiPOJO.EmployeeUI;

public class ApiTesting extends FirstdemoSpringBootApplicationTests{
	@Autowired
	private MockMvc mvc;

	@Test
	public void ShowAllEmployeeTest() throws Exception 
	{
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.get("http://localhost:9090/apii/showallemployeehb").contentType(MediaType.APPLICATION_JSON))
				.andReturn();
        int status = result.getResponse().getStatus();
		assertEquals(200, status);
	}
	
	/*
	@Test
	public void AddEmployeeTest() throws Exception
	{
		EmployeeUI e=new EmployeeUI();
		e.setName("Ankita");
		e.setPhoneno("9284233697");
		e.setDepartment("CSE");
		e.setStatus("active");
		e.setCreateddtm("2020-06-06");
		e.setCreatedby("Ankita");
		e.setUpdateddtm("2020-06-06");
		e.setUpdatedby("Akita");
		e.setCid(1);
		e.setCname("india");
		String employee=mapToJson(e);
		MvcResult result = mvc
				.perform(MockMvcRequestBuilders.post("http://localhost:9090/apii/addemployeehb").content(employee).contentType(MediaType.APPLICATION_JSON))
				.andReturn();

		int status = result.getResponse().getStatus();
		assertEquals(200, status);
} */
}
