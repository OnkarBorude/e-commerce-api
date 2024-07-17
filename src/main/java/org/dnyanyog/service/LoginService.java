package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	
	@Autowired
	LoginResponse loginResponse;
	
	public LoginResponse login(LoginRequest loginbody) throws SQLException {
		
		String loginQuery="select * from user where first_name='"+loginbody.user+"' and password='"+loginbody.password+"'";
		ResultSet resultSet=DBUtils.selectQuery(loginQuery);
		if(resultSet.next()) {
			loginResponse.errorCode="0000";
			loginResponse.messege="Login Successful";
			return loginResponse;
			
		}else {
			loginResponse.errorCode="911";
			loginResponse.messege="login failed";
			return loginResponse;
		}
		
	}

}
