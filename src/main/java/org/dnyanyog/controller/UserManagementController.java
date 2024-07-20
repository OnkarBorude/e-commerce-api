package org.dnyanyog.controller;

import java.sql.SQLException;
import java.util.List;

import org.dnyanyog.dto.User;
import org.dnyanyog.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {
	
	@Autowired
	UserManagementService userManagementService;
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() throws SQLException{
		return userManagementService.getAllUsers();
		}
}
