package com.lucy.bean;

public class Bbs {
	private int bbsId;
	private String bbsUsername;	
	private String bbsContent;
	private String bbsTitle;
	private String bbsTime;
	private String bbsIP;
	private String bbsRemark;
	private String bbsPic;

	public Bbs(String bbsusername, String bbscontent) {
		super();
		this.bbsUsername = bbsusername;
		this.bbsContent = bbscontent;
		
	}
    
	public Bbs(String bbsusername, String bbstime, String bbscontent,
			int   bbsid) {
		super();
		this.bbsUsername = bbsusername;
		this.bbsTime = bbstime;
		this.bbsContent = bbscontent;
		this.bbsId=bbsid;
	}

	public int getBbsId() {
		return bbsId;
	}

	public void setBbsId(int bbsId) {
		this.bbsId = bbsId;
	}

	public String getBbsUsername() {
		return bbsUsername;
	}

	public void setBbsUsername(String bbsUsername) {
		this.bbsUsername = bbsUsername;
	}

	public String getBbsContent() {
		return bbsContent;
	}

	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}

	public String getBbsTitle() {
		return bbsTitle;
	}

	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}

	public String getBbsTime() {
		return bbsTime;
	}

	public void setBbsTime(String bbsTime) {
		this.bbsTime = bbsTime;
	}

	public String getBbsIP() {
		return bbsIP;
	}

	public void setBbsIP(String bbsIP) {
		this.bbsIP = bbsIP;
	}

	public String getBbsRemark() {
		return bbsRemark;
	}

	public void setBbsRemark(String bbsRemark) {
		this.bbsRemark = bbsRemark;
	}

	public String getBbsPic() {
		return bbsPic;
	}

	public void setBbsPic(String bbsPic) {
		this.bbsPic = bbsPic;
	}

	
}
