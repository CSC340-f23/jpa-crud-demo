package com.csc340.jpacruddemo.product;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author csc340-f23
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByName(String name);

    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, p.type) LIKE %?1%")
    public List<Product> search(String keyword);
}
