package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	public BlogVo findAll(String id) {
		return blogRepository.findAll(id);
	}
	
	public String findBlog(String id) {
		return blogRepository.findById(id);
	}
	
	public void updateBlog(BlogVo vo) {
		blogRepository.update(vo);
	}

	public int checkId(String blogId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
