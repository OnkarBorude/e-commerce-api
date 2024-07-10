package org.dnyanyog.controller;

import java.sql.SQLException;

import org.dnyanyog.dto.LoginRequest;
import org.dnyanyog.dto.LoginResponse;
import org.dnyanyog.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@PostMapping("/hello")
	public LoginResponse login(@RequestBody LoginRequest loginbody) throws SQLException {
		
		return new LoginService().login(loginbody);
	}
}
