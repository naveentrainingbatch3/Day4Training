package com.edureka.product.repository;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.edureka.product.model.Product;

@SpringBootTest
public class ProductRepsitoryTest {
	@Autowired
	ProductRepository productRepository;
	
	@Test
	public void shouldGetAProductIfSaved() {
		Product product = Product.builder()
				.name("SamsungS20")
				.description("SamsungS2 Amoled Phone")
				.build();
		
		productRepository.save(product);
		
		Optional<Product> productActual = productRepository.findByName(product.getName());
		Assertions.assertThat(productActual.get()).isEqualTo(product);
		
	}

}
