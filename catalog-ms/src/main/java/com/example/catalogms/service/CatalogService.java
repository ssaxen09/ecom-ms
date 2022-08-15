package com.example.catalogms.service;

import com.example.catalogms.Repository.Catalog;
import com.example.catalogms.Repository.CatalogRepository;
import com.example.catalogms.common.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CatalogService {
	@Autowired
	private CatalogRepository catalogRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<Catalog> fetchByType(String type) {

		List<Catalog> persistedCat = catalogRepository.findCatalogByType(type);
		return persistedCat.stream().map(catalog -> {

			ResponseEntity<List<Product>> rateResponse = restTemplate.exchange(
					"http://PRODUCT-SERVICE/product?catalogId=" + catalog.getId(), HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Product>>() {
					});
			List<Product> persistedProduct = rateResponse.getBody();
			catalog.setProduct(persistedProduct.get(0));
			return catalog;

		}).collect(Collectors.toList());
	}

	public List<Catalog> fetchInHouseBrand(boolean isInHouse) {
		return catalogRepository.findCatalogByInhouse(isInHouse);
	}

	public Catalog addCatalog(Catalog catalog) {
		Catalog persistedCat = catalogRepository.save(catalog);
		Product product = new Product(catalog.getProduct(), persistedCat.getId());
		Product persistedProduct = restTemplate.postForObject("http://PRODUCT_SERVICE/product", product, Product.class);
		persistedCat.setProduct(persistedProduct);
		return persistedCat;

	}
}
