package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.DeleteUserResponse;
import org.dnyanyog.dto.SearchUserResponse;
import org.dnyanyog.dto.User;
import org.dnyanyog.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagementService {
	
	@Autowired
	UserDao userDao;
	
	public List<Users> getAllUsers() throws SQLException{
		
		return userDao.findAll();		
	}
	
	public SearchUserResponse getUserById(Integer userId, String firstname) {
		SearchUserResponse searchUserResponse=new SearchUserResponse();
		
		Optional<Users> users= userDao.findById(userId);
		//Optional<Users> g=(Optional<Users>) userDao.findByUseridAndFirstname(userId, firstname);
		if(users.isPresent()) {
			searchUserResponse.setResponseCode("0000");
			searchUserResponse.setMessege("Successful");
			searchUserResponse.setFirst_name(users.get().getFirstname());
			searchUserResponse.setLast_name(users.get().getLastname());
			searchUserResponse.setLogin_name(users.get().getLoginName());
			searchUserResponse.setGender(users.get().getGender());
			searchUserResponse.setAge(users.get().getAge());
			searchUserResponse.setEmail(users.get().getEmail());
			searchUserResponse.setPassword(users.get().getPassword());
			return searchUserResponse;
		}
		else {
			searchUserResponse.setResponseCode("911");
			searchUserResponse.setMessege("Unssuccessful");
			return searchUserResponse;
		}
		
		
	}
	
	public DeleteUserResponse deleteUser(Integer userid) {
		
		DeleteUserResponse deleteUserResponse=new DeleteUserResponse();
		
		Optional<Users> users=userDao.findById(userid);
		if(users.isPresent()) {
			
			userDao.deleteById(userid);
			deleteUserResponse.setResponseCode("0000");
			deleteUserResponse.setMessege("Delete user Successfully");
			return deleteUserResponse;
		}
		else {
			deleteUserResponse.setResponseCode("911");
			deleteUserResponse.setMessege("User Deletion unSuccessful");
			return deleteUserResponse;
		}
		
	}
}
