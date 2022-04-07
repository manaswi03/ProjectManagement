package com.mvc.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mvc.model.Product;
import com.mvc.service.ProductService;
import com.mvc.service.ProductServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "spring-servlet.xml")
public class ProductRepositoryImplTest {
	
	/*
	 * @Mock ProductRepository productRepository;
	 */
	public ProductRepositoryImplTest() {
		
	}
	
	@Autowired
	ProductService productService;
	
	/*
	 * @BeforeEach void initUseCase() { productService = new
	 * ProductServiceImpl(productRepository); }
	 */
	
	@Test
	public void TestgetAllProduct() {
		List<Product> allPro = productService.getAllProduct();
		assertFalse("Product List Is Empty", allPro.isEmpty());
	}
	
	@Test
	public void getProductById() {
		Product product = productService.getProductById(5);
		Product proExpected = new Product(5,"almond", 600, 500, "kjdhgf", 1, 10, "jhgfdsdfghjk", 10, null, null);
		assertEquals(proExpected.toString(), product.toString());
		//proExpected.setProductTitle("almond");
		//assertEquals(proExpected.getProductTitle(),product.getProductTitle());
		
	}
//	
//	@Test
//	public void saveProduct() {
//		Product proAdded = new Product(0,"cheese", 10, 9, "Best cheese", 2, 1, "Best cheese", 5, null, null);
//		productService.saveAndupdate(proAdded);
//		//System.out.println("id:      "+proAdded.getProductId());
//		//assertTrue("Product Not Added",proAdded.getProductId() < 0);
//		assertFalse("Product Not Added",proAdded.getProductId() == 0);
//	}
	
	@Test
	public void updateProduct() {
		Product proUpdate = new Product(7,"egg", 10, 9, "Best cheese", 2, 2, "Best cheese", 5, null, null);
		productService.saveAndupdate(proUpdate);
		Product product = productService.getProductById(proUpdate.getProductId());
		assertEquals(proUpdate.toString(), product.toString());
	}
	
	@Test
	public void deleteProduct() {
		productService.deleteProduct(12);
		Product product = productService.getProductById(12);
		assertNull("product not deleted", product);
	}
	
}
