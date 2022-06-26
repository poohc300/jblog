package com.douzone.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.jblog.repository.PostRepository;
import com.douzone.jblog.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public List<PostVo> findAll(Long categoryNo, String blogId) {
		if(categoryNo == 0) {
			return postRepository.findAllByBlogId(blogId);
		}
		return postRepository.findByCategoryNo(categoryNo);
	}

	public PostVo findByCategoryNoPostNoBlogId(Long categoryNo, Long postNo, String blogId) {
		if(categoryNo == 0 && postNo == 0) {
			return postRepository.findByBlogId(blogId);
		}
		return postRepository.findByCategoryNoPostNoBlogId(categoryNo, postNo, blogId);
	}
}
