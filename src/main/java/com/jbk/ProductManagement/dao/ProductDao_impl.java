package com.jbk.ProductManagement.dao;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;
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
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("productName", product.getProductName()));
			Product prd = (Product) criteria.uniqueResult();
			if (prd == null) {
				session.save(product);
				transaction.commit();
				b = true;
			}
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
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			products = criteria.list();// FROM Product
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return products;
	}

	@Override
	public Boolean deleteProductByProductId(int productId) {
		Session session = null;
		Boolean b = false;

		try {
			session = sessionFactory.openSession();
			Product product = session.load(Product.class, productId);

			if (product != null) {
				Transaction transaction = session.beginTransaction();
				session.delete(product);
				transaction.commit();
				b = true;
			}

		} catch (EntityNotFoundException e) {
			b = false;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return b;
	}

	@Override
	public Boolean updateProduct(Product product) {
		Session session = null;
		Boolean b = false;
		try {
			session = sessionFactory.openSession();
			Product prd = getProductById(product.getProductId());
			if (prd != null) {
				Transaction transaction = session.beginTransaction();
				session.update(product);
				transaction.commit();
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return b;
	}

}
