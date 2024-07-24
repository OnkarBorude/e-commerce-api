package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManagementService {
	
	
	public List<User> getAllUsers() throws SQLException{
		
		ArrayList<User> list=new ArrayList<>();
		
		String selectQuery="select * from user";
		ResultSet resultSet=DBUtils.selectQuery(selectQuery);
		while(resultSet.next()) {
			User user=new User();
			user.first_name=resultSet.getString(1);
			user.last_name=resultSet.getString(2);
			user.gender=resultSet.getString(3);
			user.age=resultSet.getInt(4);
			user.email=resultSet.getString(5);
			user.password=resultSet.getString(6);
			
			list.add(user);
		}
		
		return list;
		
	}
}
