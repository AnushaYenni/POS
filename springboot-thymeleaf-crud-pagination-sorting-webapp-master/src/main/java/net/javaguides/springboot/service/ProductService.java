package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import net.javaguides.springboot.model.Product;

public interface ProductService {
	List<Product> getAllProducts();
	void saveProduct(Product product);
	void addProduct(Product product);
	Product getProductById(long id);
	void deleteProductById(long id);
	Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
	List<Product> getAllProduct(String keyword);
	
	
	}
	
	
	

