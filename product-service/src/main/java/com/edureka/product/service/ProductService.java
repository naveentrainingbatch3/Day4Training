package com.edureka.product.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edureka.product.model.Product;
import com.edureka.product.model.ProductDTO;
import com.edureka.product.model.ProductTransformer;
import com.edureka.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	ProductTransformer productTransformer;
	
	public boolean saveProduct(ProductDTO productDTO) {
		Product product = productTransformer.transform(productDTO);
		System.out.println("Before Saving "+product);
		Product savedProduct = productRepository.save(product);
		System.out.println("After Saving "+savedProduct );
		return savedProduct!=null;
	}
	
	public boolean isExists(String name) {
		Optional<Product> optionalProduct = productRepository.findByName(name);
		return optionalProduct.isPresent();
	}

}
