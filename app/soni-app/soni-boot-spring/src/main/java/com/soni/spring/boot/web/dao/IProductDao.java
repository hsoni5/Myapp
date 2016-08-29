package com.soni.spring.boot.web.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.soni.spring.boot.web.bean.Product;

public interface IProductDao extends JpaRepository<Product, Long>{
	
	@Query("select p from Product p where p.productName like :x")
	public Page<Product> productName(@Param("x")String Category,Pageable p);
	
	public List<Product> findByCategory(String Category);
	
	public Page<Product> findByCategory(String Category,Pageable p);
	
}
