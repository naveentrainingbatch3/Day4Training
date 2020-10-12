package com.edureka.product.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edureka.product.model.Product;
import com.edureka.product.model.ProductDTO;
import com.edureka.product.model.ProductTransformer;
import com.edureka.product.repository.ProductRepository;

@SpringBootTest
public class ProductServiceTest {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductService produtService;
	
	@Autowired
	ProductTransformer productTranasformer;
	
	@Test
	public void shouldSaveProductDTO() {
		ProductDTO productDTO = ProductDTO.builder().name("SamsungS20").description("SamsungS20 Description").build();
		Product expectedProduct = productTranasformer.transform(productDTO);
		
		produtService.saveProduct(productDTO);
		
		Optional<Product> optionalProduct = productRepository.findByName(productDTO.getName());
		
		Assertions.assertThat(expectedProduct).isEqualTo(optionalProduct.get());
		
		
	}

}
