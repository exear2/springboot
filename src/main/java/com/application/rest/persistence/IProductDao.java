package com.application.rest.persistence;


import java.util.List;
import java.util.Optional;
import com.application.rest.entities.Product;



public interface IProductDao {

	List<Product> findAll();

	Optional<Product> findById(Long id);

	void save(Product product);

	void deleteById(Long id);

	void saveAll(List<Product> products);

}
