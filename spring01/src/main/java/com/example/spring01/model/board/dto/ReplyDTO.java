package com.example.spring01.model.board.dto;

import java.util.Date;

public class ReplyDTO {
	private Integer rno; //댓글번호
	private Integer bno; //글번호
	private String replytext; //댓글내용
	private String replyer; //댓작성자 아이디
	private String name; //댓작성자 이름
	private Date regdate; //날짜
	private Date updatedate; //수정일자
	private String secret_reply; //비밀댓글 여부
	private String writer; //게시판 테이블 아이디
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getReplytext() {
		return replytext;
	}
	public void setReplytext(String replytext) {
		this.replytext = replytext;
	}
	public String getReplyer() {
		return replyer;
	}
	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getSecret_reply() {
		return secret_reply;
	}
	public void setSecret_reply(String secret_reply) {
		this.secret_reply = secret_reply;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "ReplyDTO [rno=" + rno + ", bno=" + bno + ", replytext=" + replytext + ", replyer=" + replyer + ", name="
				+ name + ", regdate=" + regdate + ", updatedate=" + updatedate + ", secret_reply=" + secret_reply
				+ ", writer=" + writer + "]";
	}
	
	
}
