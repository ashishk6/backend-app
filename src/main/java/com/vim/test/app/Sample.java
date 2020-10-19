package com.vim.test.app;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vim.test.entity.User;
import com.vim.test.service.UserServiceImpl;
import com.vim.test.vo.BlogVO;

@RestController
@RequestMapping("/")
public class Sample {
	
	@Value("${spring.application.name}")
	String applicationName;

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired(required=true)
	private UserServiceImpl userServiceImpl;
	
	@GetMapping("/test")
	String home() {
		return applicationName;
	}
	
	@GetMapping("/new")
	BlogVO newhome() {
		return  new BlogVO();
	}
	
	@GetMapping(value= "/getUserDetails")
	@ResponseBody
	List<User> fetchAllUsers() {
		LOG.debug("Fetch all users");
		return userServiceImpl.fetchAllUsers();
	}
}
