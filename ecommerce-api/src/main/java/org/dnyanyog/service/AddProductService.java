package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.ProductDao;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.AddProductResponse;
import org.dnyanyog.dto.UpdateProductRequest;
import org.dnyanyog.dto.UpdateProductResponse;
import org.dnyanyog.dto.AddProductRequest;
import org.dnyanyog.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProductService {
	
	@Autowired
	ProductDao productDao;
	
	public AddProductResponse addProduct(AddProductRequest addProductRequest) throws SQLException {
		AddProductResponse addProductResponse=new AddProductResponse();
		Products productTable=new Products();
		productTable.setProductName(addProductRequest.getProduct_name());
		productTable.setProductQuantity(addProductRequest.getProduct_quantity());
		productTable.setProductPrice(addProductRequest.getProduct_price());
		
		productDao.save(productTable);
		
		addProductResponse.setResponseCode("0000");
		addProductResponse.setMessege("Product Added Successfully");
		addProductResponse.setAddProductRequest(addProductRequest);
	
		return addProductResponse;
	}
	
	public UpdateProductResponse updateProduct(UpdateProductRequest updateProductRequest) {
		UpdateProductResponse updateProductResponse=new UpdateProductResponse();
		if(updateProductRequest.getProduct_id()==null) {
			updateProductResponse.setResponseCode("911");
			updateProductResponse.setMessege("It mandatory to give product id ");
			return updateProductResponse;
		}
		Optional<Products> product=productDao.findById(updateProductRequest.getProduct_id());
		
		if(product.isPresent()) {
			Products products=new Products();
			products.setProductName(updateProductRequest.getProductName());
			products.setProductQuantity(updateProductRequest.getProductQuantity());
			products.setProductPrice(updateProductRequest.getProductPrice());
			products.setProduct_id(updateProductRequest.getProduct_id());
			productDao.save(products);
			updateProductResponse.setResponseCode("0000");
			updateProductResponse.setMessege("Product Update Successfully");
			updateProductResponse.setUpdateProductRequest(updateProductRequest);
			return updateProductResponse;
		}
		else {
			updateProductResponse.setResponseCode("911");
			updateProductResponse.setMessege("Product Id Not Found");
			return updateProductResponse;
		}
		
		
		
		
	}
	
	
}
