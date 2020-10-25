package com.vim.test.service;

import java.time.LocalDate;
import java.util.ArrayList;
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

	public List<BlogVO> fetchAllBlogs() {
		List<BlogVO> blogVos = new ArrayList<>();
		List<Blog> blogs=  blogRepository.findAll();
		for(Blog blog: blogs){
			BlogVO blogVO = setBlogVO(blog);
			blogVos.add(blogVO);
		}
		return blogVos;
	}

	private BlogVO setBlogVO(Blog blog) {
		BlogVO blogVO = new BlogVO();
		blogVO.setAuthor(blog.getAuthor());
		blogVO.setId(blog.getBlogId());
		blogVO.setHeader(blog.getHeading());
		blogVO.setBody(blog.getContent());
		blogVO.setTimestamp(blog.getLastUpdate());
		return blogVO;
	}

	public BlogVO editBlog(BlogVO blogVO) {
		Blog updateBlog =null;
		Optional<Blog> blog = blogRepository.findById(blogVO.getId());
		if(blog.isPresent()){
			updateBlog = blog.get();
			updateBlog.setContent(blogVO.getBody());
			updateBlog.setHeading(blogVO.getHeader());
			updateBlog.setLastUpdate(LocalDate.now().toString());
			updateBlog = blogRepository.save(updateBlog);
		}
		return setBlogVO(updateBlog);
	}

	public BlogVO saveBlog(BlogVO blogVO) {
		//ModelMapper modelMapper = new ModelMapper();
		Blog blog = setBlog(blogVO);
		blog = blogRepository.save(blog);
		return setBlogVO(blog);
	}

	private Blog setBlog(BlogVO blogVO) {
		Blog blog = new Blog();
		blog.setAuthor(blogVO.getAuthor());
		blog.setContent(blogVO.getBody());
		blog.setHeading(blogVO.getHeader());
		blog.setLastUpdate(blogVO.getTimestamp());
		return blog;
	}

	public boolean deleteBlog(BlogVO blog) {
		try {
			blogRepository.deleteById(blog.getId());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
