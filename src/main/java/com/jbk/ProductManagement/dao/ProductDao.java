package com.jbk.ProductManagement.dao;

import java.util.List;

import com.jbk.ProductManagement.entity.Product;

public interface ProductDao {

	public Boolean saveProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProduct();
	public Boolean deleteProductByProductId(String productId);
	public Boolean updateProduct(Product product);
}
