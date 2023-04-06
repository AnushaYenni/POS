package net.javaguides.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.condition.ProducesRequestCondition;

import net.javaguides.springboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
@Query("SELECT products FROM Product products WHERE CONCAT(products.id, ' ', products.name, ' ', products.pack) LIKE %?1%")
	public List<Product> search(String keyword);
    public Product findByname(String name);
}
