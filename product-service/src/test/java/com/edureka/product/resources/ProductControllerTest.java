package com.edureka.product.resources;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.edureka.product.model.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void shouldSaveAProduct() throws Exception {
		//Given
		ProductDTO productDTO = ProductDTO.builder()
				.name("SamsungS10")
				.description("SomeDescription")
				.build();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String stringValue = objectMapper.writeValueAsString(productDTO);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/product")
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(stringValue)
				).andExpect(MockMvcResultMatchers.status().isCreated());
	}

}
