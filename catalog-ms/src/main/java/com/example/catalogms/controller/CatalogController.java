package com.example.catalogms.controller;

import com.example.catalogms.Repository.Catalog;
import com.example.catalogms.common.Product;
import com.example.catalogms.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

@RestController
@RequestMapping("catalog")
public class CatalogController {

	@Autowired
	private CatalogService catalogService;


	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	private List<Catalog> fetchCatalogs(@RequestParam("criteria") String criteria,
			@RequestParam("value") String value) {
		if (criteria.equals("type")) {
			return catalogService.fetchByType(value);
		} else if (criteria.equals("inhouse")) {
			return catalogService.fetchInHouseBrand(Boolean.parseBoolean(value));
		} else {
			return emptyList();
		}
	}

	@PostMapping
	public Catalog addCatalog(@RequestBody Catalog catalog) {
	return catalogService.addCatalog(catalog);


	}
}


