package org.dnyanyog.controller;

import java.sql.SQLException;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@PostMapping(path="/login")
	public LoginResponse login(@RequestBody LoginRequest loginbody) throws SQLException {
		
		return loginService.login(loginbody);
	}
}
