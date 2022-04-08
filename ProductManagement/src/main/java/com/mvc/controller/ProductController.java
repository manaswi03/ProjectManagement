package com.mvc.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.model.Category;
import com.mvc.model.Product;
import com.mvc.model.ProductType;
import com.mvc.service.ProductService;

@Controller
public class ProductController {
	//controller

	//second new comment
	// new comment
	// third new comment

	@Autowired
	private ProductService productService;
	
	static Logger log = Logger.getLogger(ProductController.class);
	
	
	/* home page */
	@RequestMapping("/")
	public String home() {
		log.info("home page");
		return "index";
	}

	
	@RequestMapping("/addProduct")
	public ModelAndView addProduct() {
		
		ModelAndView modelAndView = new ModelAndView();
		List<Category> allCategory = productService.getAllCategory();
		modelAndView.addObject("allCategory", allCategory);
		modelAndView.addObject("Action","Add");
		modelAndView.setViewName("addProduct");
		log.info("Product Page");
		return modelAndView;
	}
	

	@RequestMapping(path = "/productHandler", method = RequestMethod.POST)
	public String productHandler(@ModelAttribute("product") Product product,BindingResult bindingResult) {
		productService.saveAndupdate(product);
		return "redirect:/viewAllProduct";
	}
	
	
	@RequestMapping("/viewAllProduct")
	public ModelAndView ViewAllProduct() {
		ModelAndView modelAndView = new ModelAndView();
		List<Product> productList = productService.getAllProduct();
		modelAndView.addObject("productList", productList);
		modelAndView.setViewName("viewAllProduct");
		//log.trace("View Product Page");
		log.fatal("Fetal msg");
		return modelAndView;
	}
	
	@RequestMapping(path = "deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		log.debug("after delete redirect to view page");
		return "redirect:/viewAllProduct";
	}
	
	
	@RequestMapping(path = "editProduct/{productId}")
	public ModelAndView editProduct(@PathVariable("productId") int productId) {
		
		ModelAndView modelAndView = new ModelAndView();
		List<Category> allCategory = productService.getAllCategory();
		modelAndView.addObject("allCategory", allCategory);
		Product productById = productService.getProductById(productId);
		modelAndView.addObject("product",productById);
		modelAndView.addObject("Action","Edit");
		modelAndView.setViewName("addProduct");
		log.info("Edit Product Page");

		return modelAndView;
	}
	
	
	
	/* Ajax */
	
	@RequestMapping(path="/productType/{categoryId}",method = RequestMethod.GET)
	public @ResponseBody List<ProductType> getProductTypeList1(@PathVariable("categoryId") int categoryId){
		
		
		List<ProductType> productByCategoryId = productService.getProductByCategoryId(categoryId);
		//System.out.println("productByCategoryId "+productByCategoryId);
		return productByCategoryId;
	
	}
	
	@RequestMapping(path="/editProduct/productType/{categoryId}",method = RequestMethod.GET)
	public @ResponseBody List<ProductType> getProductTypeList(@PathVariable("categoryId") int categoryId){
		
		List<ProductType> productByCategoryId = productService.getProductByCategoryId(categoryId);
		System.out.println("productByCategoryId "+productByCategoryId);
		return productByCategoryId;
	
	}
	
	@RequestMapping(path="/editProduct/productType/{categoryId}/{productTypeId}")
	public @ResponseBody String getProductTypeOnLoad(@PathVariable("categoryId") int categoryId, @PathVariable("productTypeId") int productTypeId) {
		
		List<ProductType> product = productService.getProductByCategoryId(categoryId);
		String option = "";
		for (ProductType productType : product) {
			if(productTypeId != 0) {
				if(productTypeId == productType.getProductTypeId()) { 
					option += "<option value='"+productType.getProductTypeId()+"'  selected='selected'>"+productType.getProductName()+"</option>";
				}
				else {
					option += "<option value='"+productType.getProductTypeId()+"'>"+productType.getProductName()+"</option>";
				}
			}
			else {
				option += "<option value='"+productType.getProductTypeId()+"'>"+productType.getProductName()+"</option>";
			}
			
		}
		
		return option;
	}
}
