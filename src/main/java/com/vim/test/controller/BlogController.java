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

import com.vim.test.entity.Blog;
import com.vim.test.service.BlogServiceImpl;
import com.vim.test.vo.BlogVO;

@RestController
@RequestMapping("/blog")
public class BlogController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private BlogServiceImpl blogServiceImpl;

	@GetMapping("/getBlogDetails")
	List<Blog> fetchAllBlogs() {
		LOG.debug("Fetch all Blogs");
		return blogServiceImpl.fetchAllBlogs();
	}
	
	@PostMapping("/editBlog")
	Blog editBlog(@RequestBody BlogVO blogVO) {
		LOG.debug("Edit Blog");
		return blogServiceImpl.editBlog(blogVO);
	}
	
	@PostMapping("/saveBlog")
	Blog saveBlog(@RequestBody BlogVO blogVO) {
		LOG.debug("Save Blog");
		return blogServiceImpl.saveBlog(blogVO);
	}
	
	@PostMapping("/deleteBlog")
	Boolean deleteBlog(@RequestBody BlogVO blog) {
		LOG.debug("Delete Blog");
		return blogServiceImpl.deleteBlog(blog);
	}
}