package org.dnyanyog.controller;

import java.sql.SQLException;

import org.dnyanyog.dto.AddProductResponse;
import org.dnyanyog.dto.UpdateProductRequest;
import org.dnyanyog.dto.UpdateProductResponse;
import org.dnyanyog.dto.AddProductRequest;
import org.dnyanyog.service.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddProductController {
	
	@Autowired
	AddProductService addProductService;
	
	@PostMapping("/addProduct")
	public AddProductResponse addproduct(@RequestBody AddProductRequest addProductRequest) throws SQLException {
		return addProductService.addProduct(addProductRequest);
	}
	
	@PostMapping("/updateProduct")
	public UpdateProductResponse updateProduct(@RequestBody UpdateProductRequest updateProductRequest) {
		return addProductService.updateProduct(updateProductRequest);
	}
}
