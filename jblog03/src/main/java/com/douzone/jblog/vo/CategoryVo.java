package com.douzone.jblog.vo;

public class CategoryVo {

	private Long no;
	private String name;
	private String description;
	private Long blogUserNo;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getBlogId() {
		return blogUserNo;
	}
	public void setBlogId(Long blogUserNo) {
		this.blogUserNo = blogUserNo;
	}
	
	
}
