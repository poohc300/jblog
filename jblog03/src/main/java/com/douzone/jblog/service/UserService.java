package com.douzone.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.BlogRepository;
import com.douzone.jblog.repository.CategoryRepository;
import com.douzone.jblog.repository.UserRepository;
import com.douzone.jblog.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;	
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void join(UserVo vo) {
		userRepository.insert(vo);
		blogRepository.insert(vo);
		categoryRepository.insert(vo);
	}

	public UserVo getUser(String email, String password) {
		return userRepository.getUser(email, password);
	}
	
	public void updateUser(UserVo vo) {
		userRepository.update(vo);
	}
}