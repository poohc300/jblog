package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.CategoryVo;
import com.douzone.jblog.vo.UserVo;

@Repository
public class CategoryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public boolean create(@Valid UserVo userVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "게시판");
		map.put("description", "게시판");
		map.put("id", userVo.getId());	
		
		return sqlSession.insert("category.create", map) == 1;	
	}
	
	public List<CategoryVo> findAll(String id){
		return sqlSession.selectList("category.findAll", id);
	}
	
	public void insert(CategoryVo vo) {
		sqlSession.insert("category.insertOne", vo);
	}
	
	public void delete(String id, Long no) {		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("no", no);
		sqlSession.delete("category.delete", map);
	}
	
	
}
