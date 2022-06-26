package com.douzone.jblog.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.jblog.vo.PostVo;

@Repository
public class PostRepository {

	@Autowired
	private SqlSession sqlSession;

	public List<PostVo> findAllByBlogId(String id) {
		return sqlSession.selectList("post.findAllByBlogId", id);
	}

	public List<PostVo> findByCategoryNo(Long categoryNo) {
		return sqlSession.selectList("post.findByCategoryNo", categoryNo);
	}
	
	public PostVo findByBlogId(String id) {
		return sqlSession.selectOne("post.findByBlogId", id);
	}
	
	public PostVo findByCategoryNoPostNoBlogId(Long categoryNo, Long postNo, String id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cno", categoryNo);
		map.put("pno", postNo);
		map.put("id", id);
		
		return sqlSession.selectOne("post.findByCaterogyNoPostNoBlogId", map);
	}

	public void insert(PostVo vo) {
		sqlSession.insert("post.insertOne", vo);
	}


}
