package com.douzone.jblog.vo;

public class PostVo {

	private Long no;
	private String title;
	private String contents;
	private Long categoryNo;
	private String regDate;
	
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getNo() {
		return no;
	}
	public String getTitle() {
		return title;
	}
	public String getContents() {
		return contents;
	}
	public Long getCategoryNo() {
		return categoryNo;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}
	
	
}
