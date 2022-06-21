package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.vo.BlogVo;

public class BlogService {

	@Autowired
	private BlogRepository blogRepository;
	
	public void create(BlogVo vo) {
		blogRepository.insert(vo);
	}
	
	public BlogVo getBlog(Long no) {
		return blogRepository.findByNo(no);
	}
	
	public void updateBlog(BlogVo vo) {
		blogRepository.update(vo);
	}
}
