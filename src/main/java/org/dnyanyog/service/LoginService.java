package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.UserDao;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	@Autowired
	LoginResponse loginResponse;
	
	@Autowired
	UserDao userDao;
	
	public LoginResponse login(LoginRequest loginbody) throws SQLException {
		//User user=userDao.findById(1).get();
		  User user=userDao.findByLoginName(loginbody.user);
		  
		if(user.getLoginName().equals(loginbody.user) && user.getPassword().equals(loginbody.password)) {
			loginResponse.errorCode="0000";
			loginResponse.messege="Login Successful";
			loginResponse.id=user.getUser_id();
			loginResponse.firstName=user.getFirstname();
			loginResponse.lastName=user.getLastname();
			loginResponse.loginName=user.getLoginName();
			loginResponse.password=user.getPassword();
			return loginResponse;
		}else {
			loginResponse.errorCode="911";
			loginResponse.messege="login failed";
			return loginResponse;
		}
		
	}

}
