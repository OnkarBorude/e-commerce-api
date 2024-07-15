package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.AddProducResponse;
import org.dnyanyog.dto.AddProductRequest;

public class AddProductService {
	
	public AddProducResponse addProduct(AddProductRequest addProductRequest) throws SQLException {
		AddProducResponse addProducResponse=new AddProducResponse();
		String query="insert into product values('"+addProductRequest.product_name+"','"+addProductRequest.product_quantity+"','"+addProductRequest.product_price+"')";
		DBUtils.executeQuery(query);
		String selectQuery="select * from product where product_name='"+addProductRequest.product_name+"'";
		ResultSet resultSet=DBUtils.selectQuery(selectQuery);
		if(resultSet.next()) {
			addProducResponse.errorCode="0000";
			addProducResponse.messege="Product added successfully";
			return addProducResponse;
		}else {
			addProducResponse.errorCode="911";
			addProducResponse.messege="Product addition failed";
			
			return addProducResponse;
		}
	}

}
