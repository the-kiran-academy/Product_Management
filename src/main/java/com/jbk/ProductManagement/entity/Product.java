package com.jbk.ProductManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productId;
	
	@Column(unique = true)
	@NotBlank(message = "Name is mandatory")
	private String productName;
	private int supplierId;
	private String quantityPerUnit;
	private long productPrice;
	
	private int productInStock;
	
	public Product() {
		
	}

	public Product(int productId, String productName, int supplierId, String quantityPerUnit, long productPrice,
			int productInStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.quantityPerUnit = quantityPerUnit;
		this.productPrice = productPrice;
		this.productInStock = productInStock;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductInStock() {
		return productInStock;
	}

	public void setProductInStock(int productInStock) {
		this.productInStock = productInStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", quantityPerUnit=" + quantityPerUnit + ", productPrice=" + productPrice + ", productInStock="
				+ productInStock + "]";
	}
	
	

}
