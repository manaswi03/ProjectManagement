package com.mvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	
	private String productTitle;
	
	private int productPrice;
	
	private int productDiscountPrice;
	
	private String productBrand;
	
	private int categoryId;
	
	private int productTypeId;
	
	private String productDescription;
	
	private int quantity;
	
	@Transient
	private String categoryName;
	
	@Transient
	private String productName;

	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	
	public Product(int productId, String productTitle, int productPrice, int productDiscountPrice, String productBrand,
			int categoryId, int productTypeId, String productDescription, int quantity, String categoryName,
			String productName) {
		super();
		this.productId = productId;
		this.productTitle = productTitle;
		this.productPrice = productPrice;
		this.productDiscountPrice = productDiscountPrice;
		this.productBrand = productBrand;
		this.categoryId = categoryId;
		this.productTypeId = productTypeId;
		this.productDescription = productDescription;
		this.quantity = quantity;
		this.categoryName = categoryName;
		this.productName = productName;
	}




	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductTitle() {
		return productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDiscountPrice() {
		return productDiscountPrice;
	}

	public void setProductDiscountPrice(int productDiscountPrice) {
		this.productDiscountPrice = productDiscountPrice;
	}

	public String getProductBrand() {
		return productBrand;
	}

	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productTitle=" + productTitle + ", productPrice=" + productPrice
				+ ", productDiscountPrice=" + productDiscountPrice + ", productBrand=" + productBrand + ", categoryId="
				+ categoryId + ", productTypeId=" + productTypeId + ", productDescription=" + productDescription
				+ ", quantity=" + quantity + ", categoryName=" + categoryName + ", productName=" + productName + "]";
	}

	
	
	
}
