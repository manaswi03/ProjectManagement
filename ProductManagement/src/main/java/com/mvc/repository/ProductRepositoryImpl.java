package com.mvc.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import com.mvc.model.Category;
import com.mvc.model.Product;
import com.mvc.model.ProductType;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;


@Repository
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Autowired
	private SessionFactory factory;
	
	Logger log = Logger.getLogger("My Logger");
	
	
	@Override
	public List<Category> getAllCategory() {
		List<Category> categoryList = hibernateTemplate.loadAll(Category.class);
		System.out.println("categoryList"+categoryList);
		return categoryList;
	}

	@Override
	public Category getCategoryById(int categoryId) {
		Category category = hibernateTemplate.get(Category.class,categoryId);
		return category;
	}

	@Override
	public List<ProductType> getProductByCategoryId(int categoryId) {
		Query q = factory.openSession().createQuery("From ProductType where category.categoryId=:c");
		q.setParameter("c", categoryId);
		List<ProductType> ProductTypeList = q.list();
		return ProductTypeList;
	}

	
	@Transactional
	@Override
	public void saveAndupdate(Product product) {
		hibernateTemplate.saveOrUpdate(product);
		
	}

	
	@Override
	public List<Product> getAllProduct() {
		
		Query q = factory.openSession().createQuery("select p.productId as productId, p.productTitle as productTitle, p.productPrice as productPrice, p.productDiscountPrice as productDiscountPrice, p.productBrand as productBrand,"
				+ " p.productDescription as productDescription, p.quantity as quantity , c.categoryName as categoryName,pt.productName as productName "
				+ "from Product as p,Category as c,ProductType as pt Where p.categoryId = c.categoryId and p.productTypeId = pt.productTypeId");
		
		@SuppressWarnings({ "deprecation", "unchecked" })
		List<Product> productList = q.setResultTransformer(Transformers.aliasToBean(Product.class)).list();
		/*
		 * try { //throw new Exception("My Exception"); int x = 10/0; }catch
		 * (ArithmeticException e) { log.error("ArithmeticException : "+e.toString()); }
		 */
		return productList;
	}

	
	@Transactional
	@Override
	public void deleteProduct(int productId) {
		Product product = hibernateTemplate.get(Product.class,productId);
		hibernateTemplate.delete(product);
		log.warn("product Deleted");
	}

	@Override
	public Product getProductById(int productId) {
		Product product = hibernateTemplate.get(Product.class,productId);
		return product;
	}
}
