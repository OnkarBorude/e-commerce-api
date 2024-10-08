package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.AddUserRequest;
import org.dnyanyog.dto.AddUserResponse;
import org.dnyanyog.dto.UpdateUserRequest;
import org.dnyanyog.dto.UpdateUserResponse;
import org.dnyanyog.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddUserService {
	
	@Autowired
	UserDao userDao;
	
	public AddUserResponse addUser(AddUserRequest addUserRequest) throws SQLException {
		
		AddUserResponse addUserResponse=new AddUserResponse();	
		
		Users userTable=new Users();
		userTable.setFirstname(addUserRequest.getFirst_name());
		userTable.setLastname(addUserRequest.getLast_name());
		userTable.setLoginName(addUserRequest.getLogin_name());
		userTable.setGender(addUserRequest.getGender());
		userTable.setAge(addUserRequest.getAge());
		userTable.setEmail(addUserRequest.getEmail());
		userTable.setPassword(addUserRequest.getPassword());

		
		Users dataValueGeneratedByDao=userDao.save(userTable);
		
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
		
		Optional<Users> users= userDao.findById(updateUserRequest.getUser_id());
		
		if(users.isPresent()) {
			Users userTable=new Users();
			
			userTable.setFirstname(updateUserRequest.getFirst_name());
			userTable.setLastname(updateUserRequest.getLast_name());
			userTable.setLoginName(updateUserRequest.getLogin_name());
			userTable.setPassword(updateUserRequest.getPassword());
			userTable.setUser_id(updateUserRequest.getUser_id());
			userTable.setAge(updateUserRequest.getAge());
			userTable.setEmail(updateUserRequest.getEmail());
			
			userDao.save(userTable);
			updateUserResponse.setResponseCode("0000");
			updateUserResponse.setMessege("Update User Sucessfully");
			updateUserResponse.setUpdateUserRequest(updateUserRequest);
			
			return updateUserResponse;
		}
		else {
			updateUserResponse.setResponseCode("911");
			updateUserResponse.setMessege("User Id not found");
			return updateUserResponse;
		}
		
	}
	
	

}
