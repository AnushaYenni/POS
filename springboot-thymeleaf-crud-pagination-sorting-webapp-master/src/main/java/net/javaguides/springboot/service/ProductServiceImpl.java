package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Product;
import net.javaguides.springboot.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> listAll(String keyword){
		if (keyword != null) {
			return productRepository.search(keyword);
		}else
			return (List<Product>) productRepository.findAll();
		}
	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void saveProduct(Product product) {
		this.productRepository.save(product);
	}

	@Override
	public Product getProductById(long id) {
		Optional<Product> optional = productRepository.findById(id);
		Product product = null;
		if (optional.isPresent()) {
			product = optional.get();
		} else {
			throw new RuntimeException(" Product not found for id :: " + id);
		}
		return product;
	}

	@Override
	public void deleteProductById(long id) {
		this.productRepository.deleteById(id);
	}

	@Override
	public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDir) {
		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize,
				sortDir.equals("asc") ? Sort.by(sortField).ascending()
				  : Sort.by(sortField).descending());
		return this.productRepository.findAll(pageable);
	}

	@Override
	public void addProduct(Product product) {
		this.productRepository.save(product);
		
	}
	@Override
	public List<Product> getAllProduct(String keyword) {
		// TODO Auto-generated method stub
		return null ;
	}
	
	
	
	
	
}
