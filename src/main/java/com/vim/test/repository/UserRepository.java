package com.vim.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vim.test.entity.User;


public interface UserRepository extends MongoRepository<User, String> {

	User findByEmailId(String emailId);

}
