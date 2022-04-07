package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.model.Category;
import com.mvc.model.Product;
import com.mvc.model.ProductType;
import com.mvc.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }
		
	@Override
	public List<Category> getAllCategory() {
		List<Category> allCategory = productRepo.getAllCategory();
		return allCategory;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category categoryById = productRepo.getCategoryById(categoryId);
		return categoryById;
	}

	@Override
	public List<ProductType> getProductByCategoryId(int categoryId) {
		List<ProductType> productByCategoryId = productRepo.getProductByCategoryId(categoryId);
		return productByCategoryId;
	}

	
	
	@Override
	public void saveAndupdate(Product product) {
		
		productRepo.saveAndupdate(product);
	}

	@Override
	public List<Product> getAllProduct() {
		
		List<Product> productList = productRepo.getAllProduct();
		return productList;
	}

	@Override
	public void deleteProduct(int productId) {
		productRepo.deleteProduct(productId);
	}

	@Override
	public Product getProductById(int productId) {
		
		Product product = productRepo.getProductById(productId);
		
		return product;
	}
}
