package com.edureka.product.model;

import org.springframework.stereotype.Component;

@Component
public class ProductTransformer {

	public Product transform(ProductDTO productDTO) {
		return Product.builder()
				.name(productDTO.getName())
				.description(productDTO.getDescription())
				.build();
	}

}
