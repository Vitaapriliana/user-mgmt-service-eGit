package com.ttj.usermgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttj.usermgmt.dao.DAOProduct;
import com.ttj.usermgmt.dao.ProductDao;
import com.ttj.usermgmt.model.ProductDTO;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public Iterable<DAOProduct> getListProduct(){
		return productDao.findAll();
	}
	
	public DAOProduct save(ProductDTO peroduct) {
		DAOProduct product = new DAOProduct();
		product.setProduct(peroduct.getProduct());
		product.setPrice(peroduct.getPrice());
		return productDao.save(product);
	}

	public DAOProduct update(ProductDTO peroduct) {
		DAOProduct product = productDao.getProductById((int) peroduct.getId());
		product.setId(product.getId());
		product.setProduct(peroduct.getProduct());
		product.setPrice(peroduct.getPrice());
		return productDao.save(product);
	}
	
	public void delete(Integer id) {
		productDao.deleteById(id);
	}
	
	public Iterable<DAOProduct> getList() {
	return productDao.findAll();
	}
	
	public DAOProduct getProductById(Integer id) {
	return productDao.findById(id).get();
	}
}