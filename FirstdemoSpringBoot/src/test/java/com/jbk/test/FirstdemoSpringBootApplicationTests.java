package com.jbk.test;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbk.FirstdemoSpringBoot.FirstdemoSpringBootApplication;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes=FirstdemoSpringBootApplication.class)
class FirstdemoSpringBootApplicationTests 
{


	 protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }
	   protected <T> T mapFromJson(String json, Class<T> clazz)
	      throws JsonParseException, JsonMappingException, IOException {
	      
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.readValue(json, clazz);
	   }
	
}