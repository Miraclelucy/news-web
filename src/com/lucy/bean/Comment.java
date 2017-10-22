package com.lucy.bean;

public class Comment {
	private int commentid;
	private String commenttype;
	private int commentnewid;
	private String commentname;
	private int commentcount;

	public Comment() {
		super();
	}

	public Comment(String commenttype, String commentname, int commentcount) {
		super();
		this.commenttype = commenttype;
		this.commentname = commentname;
		this.commentcount = commentcount;
	}

	public Comment(int commentid, String commenttype, int commentnewid,
			String commentname, int commentcount) {
		super();
		this.commentid = commentid;
		this.commenttype = commenttype;
		this.commentnewid = commentnewid;
		this.commentname = commentname;
		this.commentcount = commentcount;
	}

	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public String getCommenttype() {
		return commenttype;
	}

	public void setCommenttype(String commenttype) {
		this.commenttype = commenttype;
	}

	public int getCommentnewid() {
		return commentnewid;
	}

	public void setCommentnewid(int commentnewid) {
		this.commentnewid = commentnewid;
	}

	public String getCommentname() {
		return commentname;
	}

	public void setCommentname(String commentname) {
		this.commentname = commentname;
	}

	public int getCommentcount() {
		return commentcount;
	}

	public void setCommentcount(int commentcount) {
		this.commentcount = commentcount;
	}

}
