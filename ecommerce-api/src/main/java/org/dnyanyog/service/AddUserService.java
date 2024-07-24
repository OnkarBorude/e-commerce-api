package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UpdateUserResponse;
import org.dnyanyog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserService {
	
	@Autowired
	UserDao userDao;
	
	public AddUserResponse addUser(AddUserRequest addUserRequest) throws SQLException {
		
		AddUserResponse addUserResponse=new AddUserResponse();	
		
		User userTable=new User();
		userTable.setFirstname(addUserRequest.getFirst_name());
		userTable.setLastname(addUserRequest.getLast_name());
		userTable.setLoginName(addUserRequest.getLogin_name());
		userTable.setPassword(addUserRequest.getPassword());
		
		User dataValueGeneratedByDao=userDao.save(userTable);
		
		addUserResponse.setResponseCode("0000");
		addUserResponse.setMessege("User Added Successsully");
		addUserResponse.setAddUserRequest(addUserRequest);
		addUserResponse.setUser_id(dataValueGeneratedByDao.getUser_id());
		
		return addUserResponse;
	}
	
	public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest) {
		UpdateUserResponse updateUserResponse=new UpdateUserResponse();
		
		if(updateUserRequest.getUser_id()==null) {
			updateUserResponse.setResponseCode("0000");
			updateUserResponse.setMessege("User id not sent in request: it is mandatory to sent");
			return updateUserResponse;
		}
		
		User userTable=new User();
		userTable.setFirstname(updateUserRequest.getFirst_name());
		userTable.setLastname(updateUserRequest.getLast_name());
		userTable.setLoginName(updateUserRequest.getLogin_name());
		userTable.setPassword(updateUserRequest.getPassword());
		userTable.setUser_id(updateUserRequest.getUser_id());
		
		userDao.save(userTable);
		updateUserResponse.setResponseCode("0000");
		updateUserResponse.setMessege("Update User Sucessfully");
		updateUserResponse.setUpdateUserRequest(updateUserRequest);
		
		return updateUserResponse;
	}
	
	

}
