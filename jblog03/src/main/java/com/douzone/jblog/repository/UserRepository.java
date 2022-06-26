package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo getUser(String email, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", email);
		map.put("password", password);
	
		return sqlSession.selectOne("findByEmailPassword", map);
	}	
	
	public boolean insert(@Valid UserVo userVo) {
		return sqlSession.insert("user.insert", userVo) == 1;		
	}

	public void update(UserVo vo) {
		// TODO Auto-generated method stub
		
	}
}