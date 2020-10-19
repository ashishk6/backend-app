package com.vim.test.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.vim.test.entity.Blog;


public interface BlogRepository extends MongoRepository<Blog, String> {
}
