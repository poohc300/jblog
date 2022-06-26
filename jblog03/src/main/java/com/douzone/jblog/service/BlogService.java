package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;

public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	public BlogVo getAll(String id) {
		return blogRepository.findAll(id);
	}
	
	public String getBlog(String id) {
		return blogRepository.findById(id);
	}
	
	public void updateBlog(BlogVo vo) {
		blogRepository.update(vo);
	}
}
