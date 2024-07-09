package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.Login;

public class LoginService {
	
	public String login(Login loginbody) throws SQLException {
		
		String loginQuery="select * from user where first_name='"+loginbody.user+"' and password='"+loginbody.password+"'";
		ResultSet resultSet=DBUtils.selectQuery(loginQuery);
		if(resultSet.next()) {
			return "login Successful";
		}
		return "login failed";
		
	}

}
