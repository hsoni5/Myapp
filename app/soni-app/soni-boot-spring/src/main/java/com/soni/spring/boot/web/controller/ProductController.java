package com.soni.spring.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soni.spring.boot.web.bean.Product;
import com.soni.spring.boot.web.dao.IProductDao;

@RestController
public class ProductController {
    
	@Autowired
	private IProductDao iProductDao;
	
	@RequestMapping("/test")
	public String test(){
		
		return "test";
	}
	/*
	 *
	*/
	@RequestMapping("/save")
	public Product saveProduct(Product p)
	{
		iProductDao.save(p);
		return p;
	}
	/*
	http://localhost:8001/getAllProducts
	*/
	@RequestMapping("/getAllProducts")
	public List<Product> getProducts()
	{
		return iProductDao.findAll();
	}
	/*
	 * http://localhost:8001/product?page=1
	
	*/
	@RequestMapping("/product")
	public Page<Product> getProduct(int page){
		return iProductDao.findAll(new PageRequest(page, 5));
		
	}

	/*
	 * http://localhost:8001/getProductByName?name=S&page=0
	
	*/
    @RequestMapping("/getProductByName")
	public Page<Product> getProductByName(String name,int page){
		return iProductDao.productName("%"+name+"%", new PageRequest(page, 5));
	}

	@RequestMapping("/findByCategory")
	public Page<Product> findByCategory(String category,int page){
		return iProductDao.findByCategory(category, new PageRequest(page, 5));
		
	}
	
	/*
	 * http://localhost:8001/get?productId=4
		
	*/ 
	@RequestMapping("/get")
	public Product get(Long productId){
		return iProductDao.findOne(productId);
		
	}
	
	@RequestMapping("/update")
	public Product update(Product p){
		p=iProductDao.saveAndFlush(p);
		return p;
		
	}
/*
 * http://localhost:8001/delete?productId=4
	
*/    @RequestMapping("/delete")
	public boolean delete(Long productId){
		iProductDao.delete(productId);
		return true;
		
	}
}
