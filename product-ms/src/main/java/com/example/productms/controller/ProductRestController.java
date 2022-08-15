package com.example.productms.controller;

import com.example.productms.repository.Product;
import com.example.productms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping(produces = APPLICATION_JSON_VALUE)
	public List<Product> getProducts(@RequestParam("catalogId") @Validated Integer catalogId) {

		return productService.fetchProducts(catalogId);
	}

	@PostMapping(produces = APPLICATION_JSON_VALUE)
	public Product getProducts(@RequestBody Product product) {
		return productService.add(product);
	}

}
