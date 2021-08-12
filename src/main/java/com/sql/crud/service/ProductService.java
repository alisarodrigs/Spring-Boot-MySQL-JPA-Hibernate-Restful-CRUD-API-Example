package com.sql.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sql.crud.entity.Product;
import com.sql.crud.repository.ProductRepository;


@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// POST

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> createProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	// GET

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	// DELETE

	public String deleteProductById(int id) {
		productRepository.deleteById(id);
		return "Product deleted: " + id;
	}

	// PUT

	public Product updateProduct(Product product) {
		
	Optional<Product> optionalUser=productRepository.findById(product.getId()) ;
	Product existingProduct=null;
	if(optionalUser.isPresent()) {
		existingProduct= optionalUser.get();
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		productRepository.save(existingProduct);
	}else {
		return new Product();
	}
	return existingProduct;
		
	}
	


}
