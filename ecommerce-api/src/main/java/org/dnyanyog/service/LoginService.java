package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	@Autowired
	LoginResponse loginResponse;
	
	@Autowired
	UserDao userDao;
	
	public LoginResponse login(LoginRequest loginbody) throws SQLException {
		Users user=userDao.findById(1).get();
		//Users user=userDao.findByLoginName(loginbody.getUser());
		  
		if(user.getLoginName().equals(loginbody.getUser()) && user.getPassword().equals(loginbody.getPassword())) {
			loginResponse.setResponseCode("0000");
			loginResponse.setMessege("Login Successful");
			loginResponse.setId(user.getUser_id());
			loginResponse.setFirstName(user.getFirstname());
			loginResponse.setLastName(user.getLastname());
			loginResponse.setLoginName(user.getLoginName());
			loginResponse.setAge(user.getAge());
			loginResponse.setEmail(user.getEmail());
			loginResponse.setPassword(user.getPassword());
			return loginResponse;
		}
		else {
			loginResponse.setResponseCode("911");
			loginResponse.setMessege("Invalid User");
			return loginResponse;
		}
		  
		
		
	}

}
