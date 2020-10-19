package com.vim.test.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vim.test.entity.Blog;
import com.vim.test.repository.BlogRepository;
import com.vim.test.vo.BlogVO;

@Service
public class BlogServiceImpl {

	@Autowired
	private BlogRepository blogRepository;

	public List<Blog> fetchAllBlogs() {
		return blogRepository.findAll();
	}

	public Blog editBlog(BlogVO blogVO) {
		Blog updateBlog =null;
		Optional<Blog> blog = blogRepository.findById(blogVO.getBlogId());
		if(blog.isPresent()){
			updateBlog = blog.get();
			updateBlog.setContent(blogVO.getContent());
			updateBlog.setHeading(blogVO.getHeading());
			updateBlog.setLastUpdate(LocalDate.now().toString());
			blogRepository.save(updateBlog);
		}
		return updateBlog;
	}

	public Blog saveBlog(BlogVO blogVO) {
		ModelMapper modelMapper = new ModelMapper();
		Blog blog = modelMapper.map(blogVO, Blog.class);
		blog = blogRepository.save(blog);
		return blog;
	}

	public boolean deleteBlog(BlogVO blog) {
		try {
			blogRepository.deleteById(blog.getBlogId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
