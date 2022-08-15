package com.example.catalogms.Repository;

import com.example.catalogms.common.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CATALOG")
@Data
@AllArgsConstructor
@NoArgsConstructor()
public class Catalog {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String name;
	private String type;
	@Column(name = "inhouse_brand")
	private boolean inhouse;
	@Transient
	private Product product;
}
