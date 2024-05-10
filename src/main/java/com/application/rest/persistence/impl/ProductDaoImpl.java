package com.application.rest.persistence.impl;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.rest.entities.Product;
import com.application.rest.persistence.IProductDao;
import com.application.rest.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductDaoImpl implements IProductDao {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public List<Product> findAll() {
		
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Optional<Product> findById(Long id) {
		
		return productRepository.findById(id);
	}


	@Override
	public void save(Product product) {
		
		productRepository.save(product);
		
	}

	@Override
	public void deleteById(Long id) {
		
		productRepository.deleteById(id);
		
	}

	@Override
	public void saveAll(List<Product> products) {
		
		productRepository.saveAll(products);
		
	}


	
	

}
