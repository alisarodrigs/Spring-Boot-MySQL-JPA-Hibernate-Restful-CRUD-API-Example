package com.sql.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sql.crud.entity.Product;
import com.sql.crud.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	

	//POST

	@PostMapping("/addProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> createProduct(@RequestBody List<Product> products) {
		return productService.createProducts(products);
	}
	
	//GET
		@GetMapping("/")
	public String helloworld() {
		return "Hello World";
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}
	
	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProductById(id);
	}
	
	//DELETE
	
	@DeleteMapping("/product/{id}")
	public String deleteProductById(@PathVariable int id) {
		return productService.deleteProductById(id);
	}
	
	//PUT
	
	@PutMapping("/product")
	public Product updateProductById(@RequestBody Product product) {
		return productService.updateProduct(product);
	}

}
