package com.vim.test.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vim.test.entity.User;
import com.vim.test.repository.UserRepository;
import com.vom.test.vo.UserVO;

@Service
public class UserServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> fetchAllUsers() {
		return userRepository.findAll();
	}
	public User saveUser(UserVO userVO){
		ModelMapper modelMapper = new ModelMapper();
		User savedUser = modelMapper.map(userVO, User.class);
		savedUser = userRepository.save(savedUser);
		return savedUser;
	}
	public boolean login(UserVO userVO) {
		User user = userRepository.findByEmailId(userVO.getEmailId());
		return (user!=null && userVO.getPassword().equals(user.getPassword()));
	}

}
