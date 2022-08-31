package com.ttj.usermgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ttj.usermgmt.dao.ProductDao;
import com.ttj.usermgmt.model.ProductDTO;
import com.ttj.usermgmt.service.ProductService;


@RestController
public class ProductController {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	private ProductService productService;
	
    @RequestMapping(value = "/product/create", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> create(@RequestBody ProductDTO productDTO){
    	productService.save(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/getListProduct", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> getListProduct(){
    	productService.getListProduct();
        return new ResponseEntity<>(productService, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/product/update", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<?> update(@RequestBody ProductDTO productDTO){
    	productService.update(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "product/getProductById/{Id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getProductById(@PathVariable (value ="id") Integer id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/delete/{id}" , method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> deleteProduct(@PathVariable (value ="id") Integer id){
    	productService.delete(id);
        return new ResponseEntity<>("Delete Product", HttpStatus.CREATED);
	}
}
