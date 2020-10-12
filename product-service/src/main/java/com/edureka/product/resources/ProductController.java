package com.edureka.product.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edureka.product.model.ProductDTO;
import com.edureka.product.service.ProductService;

@RestController
@RequestMapping(value = "product")
//http:localhost:8081/product
public class ProductController {
	
	@Autowired
	ProductService productService;
	//ProductService p1=new ProductService();
	
	//1. Create a product
	@PostMapping
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	//https://localhost:8081/product
	//POST {
	//  name:"SamsunS8",
	//  description:"Some Description"
	//}
	public ResponseEntity<Boolean> createAProduct(@RequestBody ProductDTO productDTO) {
		boolean saved = productService.saveProduct(productDTO);
		if(!saved) {
			throw new ProductNotCreatedException("Product can not be created");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(true);
	}
	
	//2. get  product
	//GET https://localhost:8081/product?name=SamsungS10
	@GetMapping	
	public ResponseEntity<Boolean> isExists(@RequestParam String name){
		return ResponseEntity.ok(productService.isExists(name)); 
	}
	
	//UPdate
	
	//Delete

}
