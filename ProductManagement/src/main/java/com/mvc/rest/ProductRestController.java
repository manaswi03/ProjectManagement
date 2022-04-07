package com.mvc.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.Category;
import com.mvc.model.Product;
import com.mvc.model.Status;
import com.mvc.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/viewProducts",method = RequestMethod.GET)
	public @ResponseBody Status viewProducts() {
				
		List<Product> productList = productService.getAllProduct();
		if(productList != null) {
			return new Status(1, "List Fetched", productList);
		}else {
			return new Status(0, "Empty List");
		}
	}
	
	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public @ResponseBody Status saveProduct(@RequestBody Product product) {
		
		productService.saveAndupdate(product);
		
		return new Status(1, "Save success");
	}
	
	@RequestMapping(value = "/getProduct/{productId}",method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable("productId") int productId) {
		
		Product productById = productService.getProductById(productId);
		
		return new ResponseEntity<Product>(productById, HttpStatus.ACCEPTED);
		//return new Status(productId, 1, "Product Fetched", productById);
	}
	
}
