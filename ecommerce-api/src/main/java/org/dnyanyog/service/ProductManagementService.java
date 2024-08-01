package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.ProductDao;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.Product;
import org.dnyanyog.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductManagementService {
	
	@Autowired
	ProductDao productDao;
	
	public List<Products> getAllProduct() throws SQLException{
		
		return productDao.findAll();
	}
	
	public Products getProductById(Integer product_id) {
		return productDao.findById(product_id).get();
	}
	
	public void deleteProduct(Integer productId) {
		productDao.deleteById(productId);
	}
}
