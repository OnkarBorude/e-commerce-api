package org.dnyanyog.service;

import java.sql.SQLException;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;

public class AddUserService {
	
	
	public AddUserResponse addUser(AddUserRequest addUserRequest) throws SQLException {
		AddUserResponse addUserResponse=new AddUserResponse();
		String insertQuery="insert into user(first_name,last_name,gender,age,email,password) values('"+addUserRequest.first_name+"','"+addUserRequest.last_name+"','"+addUserRequest.gender+"','"+addUserRequest.age+"','"+addUserRequest.email+"','"+addUserRequest.password+"')";
		int rowaffected =DBUtils.executeQuery(insertQuery);
		if(rowaffected>0) {
			addUserResponse.errorCode="0000";
			addUserResponse.messege="Add User Succesfully";
			return addUserResponse;
		}else {
			addUserResponse.errorCode="911";
			addUserResponse.messege="User Additon Failed";
			return addUserResponse;
		}
	}

}
