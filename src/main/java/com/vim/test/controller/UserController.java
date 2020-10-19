package com.vim.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vim.test.entity.User;
import com.vim.test.service.UserServiceImpl;
import com.vim.test.vo.UserVO;

@RestController
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserServiceImpl userServiceImpl;

	@GetMapping("/getUserDetails")
	List<User> fetchAllUsers() {
		LOG.debug("Fetch all users");
		return userServiceImpl.fetchAllUsers();
	}
	
	@PostMapping("/registerUser")
	User registerUser(@RequestBody UserVO user) {
		LOG.debug("Register user");
		return userServiceImpl.saveUser(user);
	}
	
	@PostMapping("/login")
	boolean login(@RequestBody UserVO user) {
		LOG.debug("Register user");
		return userServiceImpl.login(user);
	}
}

