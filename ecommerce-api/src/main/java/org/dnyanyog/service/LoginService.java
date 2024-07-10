package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;

public class LoginService {
	
	public LoginResponse login(LoginRequest loginbody) throws SQLException {
		LoginResponse loginResponse=new LoginResponse();
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
