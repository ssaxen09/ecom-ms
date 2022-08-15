package com.example.catalogms.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CatalogRepository extends CrudRepository<Catalog, Integer> {

	public List<Catalog> findCatalogByType(String type);

	public List<Catalog> findCatalogByInhouse(boolean isInHouse);
}
