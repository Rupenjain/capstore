package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Product;

@Repository
public interface ProductDAO extends JpaRepository<Product, Integer> {
	
	@Query("select p.price from Product p where p.productID=?1")
	public Integer getProductPrice(Integer productId);
}
