package com.company.hellospring.board;

public class BoardDTO {
	private String seq;
	private String title;
	private String writer;      //user_name --> userName 으로 자동으로 바꿔주
	private String content;
	private String regdate;
	private String cnt;
	private String out_msg;		//카멜케이스 적용이 안됨 그래서 똑같이 맞춰준다.
		
	public String getOut_msg() {
		return out_msg;
	}
	public void setOut_msg(String out_msg) {
		this.out_msg = out_msg;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "BoardDTO [title=" + title + ", writer=" + writer + ", content=" + content + ", regdate=" + regdate
				+ ", cnt=" + cnt + "]";
	}
}
