package org.dnyanyog;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerClass {
	
	@GetMapping("/")
	public String hello() {
		return "hello String";
	}
	
	@GetMapping("/hello")
	public String helloWorld() {
		return "hello Students";
	}
	
	@PostMapping("/hello")
	public String helloForPost(@RequestBody String data) {
		return "Receive data from user:"+data;
	}
	
	

}
