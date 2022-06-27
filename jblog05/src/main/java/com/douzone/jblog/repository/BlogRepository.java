package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.BlogVo;
import com.douzone.jblog.vo.UserVo;

@Repository
public class BlogRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean insert(@Valid UserVo userVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", userVo.getId());
		map.put("title", userVo.getName() + "의 블로그");
		map.put("url", "assets/images/logo.jpg");
		
		return sqlSession.insert("blog.insert", map) == 1;
	}
	
	public boolean update(BlogVo vo) {
		return sqlSession.update("blog.update", vo) == 1;
	}

	public BlogVo findAll(String id) {
		return sqlSession.selectOne("blog.findAll", id);
	}

	public String findById(String id) {
		return sqlSession.selectOne("blog.findById", id);

	}
}
