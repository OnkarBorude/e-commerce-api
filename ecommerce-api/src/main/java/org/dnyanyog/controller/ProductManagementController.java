package org.dnyanyog.controller;

import java.sql.SQLException;
import java.util.List;

import org.dnyanyog.dto.Product;
import org.dnyanyog.entity.Products;
import org.dnyanyog.service.ProductManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductManagementController {
	@Autowired
	ProductManagementService productManagementService;
	
	@GetMapping("/getAllProduct")
	public List<Products> getAllProduct() throws SQLException{
		return productManagementService.getAllProduct();
		}
	
	@GetMapping("/getProductById/{productId}")
	public Products getProductById(@PathVariable Integer productId) {
		return productManagementService.getProductById(productId);
	}
	
	@DeleteMapping("/deleteProductById/{productId}")
	public void deleteProductById(@PathVariable Integer productId) {
		productManagementService.deleteProduct(productId);
	}
}
