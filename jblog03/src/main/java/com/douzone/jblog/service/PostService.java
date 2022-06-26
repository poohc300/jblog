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
	
	public List<PostVo> findAll(Long categoryNo, String id) {
		if(categoryNo == 0) {
			return postRepository.findAllByBlogId(id);
		}
		return postRepository.findByCategoryNo(categoryNo);
	}

	public PostVo findByCategoryNoPostNoBlogId(Long categoryNo, Long postNo, String id) {
		if(categoryNo == 0 && postNo == 0) {
			return postRepository.findByBlogId(id);
		}
		return postRepository.findByCategoryNoPostNoBlogId(categoryNo, postNo, id);
	}
	public void insert(PostVo vo) {
		postRepository.insert(vo);
	}

}
