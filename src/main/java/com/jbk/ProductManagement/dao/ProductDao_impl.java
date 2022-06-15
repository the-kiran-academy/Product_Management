package com.jbk.ProductManagement.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.ProductManagement.entity.Product;

@Repository
public class ProductDao_impl implements ProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Boolean saveProduct(Product product) {
		Boolean b = false;
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			b = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	@Override
	public Product getProductById(int productId) {
		Product product = null;
		try {
			Session session = sessionFactory.openSession();
			product = session.get(Product.class, productId);
		} catch (Exception e) {

		}
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		List<Product> products = null;
		Session session=null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			products = criteria.list();// FROM Product
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			session.close();
		}
		return products;
	}
	

	@Override
	public Boolean deleteProductByProductId(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
