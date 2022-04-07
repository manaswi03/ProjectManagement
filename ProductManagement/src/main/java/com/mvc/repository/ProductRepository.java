package com.mvc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mvc.model.Category;
import com.mvc.model.Product;
import com.mvc.model.ProductType;


@Repository
public interface ProductRepository {
	
	public void saveAndupdate(Product product);
	
	public List<Product> getAllProduct();
	
	public void deleteProduct(int productId);

	public Product getProductById(int productId);

	public List<Category> getAllCategory();
	
	public Category getCategoryById(int categoryId);
	
	public List<ProductType> getProductByCategoryId(int categoryId);
}
