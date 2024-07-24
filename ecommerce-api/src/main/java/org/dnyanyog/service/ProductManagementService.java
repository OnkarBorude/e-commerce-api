package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductManagementService {
	
	
	
	public List<Product> getAllProduct() throws SQLException{
		ArrayList<Product> list=new ArrayList<>();
		String selectQuery="select * from product";
		ResultSet resultSet=DBUtils.selectQuery(selectQuery);
		while(resultSet.next()) {
			
			Product product=new Product();
			product.product_name=resultSet.getString(1);
			product.product_quantity=resultSet.getInt(2);
			product.product_price=resultSet.getInt(3);
			list.add(product);
		}
		
		
		return list;
	}

}
