package com.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.service.dto.UserDto;
import com.user.service.impl.UserService;

@RestController
@RequestMapping(value= "/app/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value="/register")
	public ResponseEntity<String> userRegister(@RequestBody UserDto userDto) {
		
		String register= userService.register(userDto);
		return new ResponseEntity<String>(register, HttpStatus.OK);
		
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<String> userLogin(@RequestParam String emailId, @RequestParam String password) {
		String loginMsg= userService.login(emailId,password);
		return new ResponseEntity<String>(loginMsg, HttpStatus.OK);
	}

	@PostMapping(value="/logout")
	public ResponseEntity<String> logout() {
		String logout= userService.logout();
		return new ResponseEntity<String>(logout, HttpStatus.OK);
	}
	
	@PostMapping(value="/resetPswd")
	public ResponseEntity<String> forgotPassword(@RequestParam String emailId, @RequestParam String oldPswd, @RequestParam String newPswd) {
		String resetPswd= userService.resetPswd(emailId,oldPswd,newPswd);
		return new ResponseEntity<String>(resetPswd, HttpStatus.OK);
	}
}
