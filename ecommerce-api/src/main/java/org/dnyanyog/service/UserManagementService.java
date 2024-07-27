package org.dnyanyog.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.dnyanyog.common.DBUtils;
import org.dnyanyog.dao.UserDao;
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
	
	public Users getUserById(Integer userId) {
		return userDao.findById(userId).get();
	}
	
	public void deleteUser(Integer userid) {
		userDao.deleteById(userid);
	}
}
