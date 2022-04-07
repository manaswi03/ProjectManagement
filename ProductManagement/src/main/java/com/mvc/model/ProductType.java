package com.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductType {

	@Id 
	@Column(name = "ProductType_id")
	private int productTypeId;
	
	@Column(name = "ProductType_name" ,length = 45)
	private String productName;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProductType [productTypeId=" + productTypeId + ", productName=" + productName + ", category=" + category
				+ "]";
	}

}
