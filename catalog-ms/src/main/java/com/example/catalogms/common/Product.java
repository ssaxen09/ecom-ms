package com.example.catalogms.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private String name;
	private BigDecimal price;
	private Integer catalogId;

	public Product(Product product, int catalogId) {
		this.name = product.getName();
		this.price = product.getPrice();
		this.catalogId = catalogId;
	}
}