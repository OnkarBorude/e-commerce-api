package org.dnyanyog.controller;

import java.sql.SQLException;
import java.util.List;

import org.dnyanyog.dto.User;
import org.dnyanyog.entity.Users;
import org.dnyanyog.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController {
	
	@Autowired
	UserManagementService userManagementService;
	
	@GetMapping("/getAllUsers")
	public List<Users> getAllUsers() throws SQLException{
		return userManagementService.getAllUsers();
		}
	
	@GetMapping("/getUserById/{userId}")
	public Users getUserByid(@PathVariable Integer userId) {
		return userManagementService.getUserById(userId);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public void deleteUser(@PathVariable Integer userId) {
		userManagementService.deleteUser(userId);
	}
}
