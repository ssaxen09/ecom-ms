package com.example.productms.service;

import com.example.productms.repository.Product;
import com.example.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public List<Product> fetchProducts(int catalogId) {
		return productRepository.findProductsByCatalogId(catalogId);

	}

	public Product add(Product product) {
		return productRepository.save(product);
	}
}
