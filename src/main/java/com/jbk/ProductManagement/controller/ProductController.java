package com.jbk.ProductManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.ProductManagement.entity.Product;
import com.jbk.ProductManagement.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@PostMapping(value = "/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product product){
		
	
		Boolean b=	service.saveProduct(product);
	
		if(b) {
			return new ResponseEntity<String>("Saved !!",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String>("Something Worng !!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping(value = "/getProductById")
	public ResponseEntity<Product> getProductById(@RequestParam int productId){
		
		Product product=service.getProductById(productId);
		if(product!=null) {
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Product>(product,HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@GetMapping(value = "/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		
	List<Product> products=	service.getAllProduct();
	if(!products.isEmpty()) {
	return	new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	}
	
	//@GetMapping

}
