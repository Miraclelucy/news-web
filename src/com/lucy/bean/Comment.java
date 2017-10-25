package com.lucy.bean;

public class Comment {
	private int commentid;
	private int commentnewid;
	private String commenttype;
	private String commentname;
	private String commenttext; 

	public Comment() {
		super();
	}

	public Comment(String commenttype, String commentname, String commenttext) {
		super();
		this.commenttype = commenttype;
		this.commentname = commentname;
		this.commenttext = commenttext;
	}

	public Comment(int commentid, String commenttype, int commentnewid,
			String commentname, String commenttext) {
		super();
		this.commentid = commentid;
		this.commenttype = commenttype;
		this.commentnewid = commentnewid;
		this.commentname = commentname;
		this.commenttext = commenttext;
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

	public String getCommenttext() {
		return commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

}
