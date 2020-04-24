package com.banking.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.exceptions.ResourceNotFoundException;
import com.banking.models.Product;
import com.banking.repository.ProductRepository;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/products")
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	@PostMapping("/products")
	public Product createProduct( @RequestBody Product product) {
		return productRepository.save(product);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
		Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found for id: "+id));
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/products/")
	public List<Product> deleteProduct(@RequestBody Product product){
		productRepository.delete(product);
		ResponseEntity.ok().build(); 	
		return productRepository.findAll();
	}
	
	/*
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") long productId) throws ResourceNotFoundException {
		productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found for id: "+productId));
		productRepository.deleteById(productId);
		return ResponseEntity.ok().build(); 
	}
	*/
}
