package com.lucy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.lucy.bean.Comment;
import com.lucy.bean.News;
import com.lucy.bean.Type;
import com.lucy.service.Commentservice;
import com.lucy.service.Newsservice;
import com.lucy.until.ResponseUtil;
import com.lucy.until.StringUtil;

/**  
 * @Title: CommentListServlet.java
 * @Package com.lucy.servlet
 * @Description: 
 * @author lushiqin  
 * @date 2017年10月24日 上午8:04:26
 * @version V1.0  
 */
public class CommentSaveServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");	
		/*
		 * commentid
			commenttype
			commentnewid
			commentname
			commenttext
		 * 
		 * 
		 * */
		String commentid = StringUtil.null2String(req.getParameter("commentid"));
		String commentnewid = StringUtil.null2String(req.getParameter("commentnewid"));
		String commentname = StringUtil.null2String(req.getParameter("commentname"));
		String commenttext = StringUtil.null2String(req.getParameter("commenttext"));
		
		System.out.println("从表格中接受到的值："+commentid);
		System.out.println("从表格中接受到的值："+commentnewid);
		System.out.println("从表格中接受到的值："+commentname);
		System.out.println("从表格中接受到的值："+commenttext);
		 if ("".equals(commentnewid)) {
			 commentnewid = "1";
		    }
		Comment comment = new Comment(commentnewid, "系统管理员",commenttext);
		
		boolean flag =false;
		System.out.println(commentid+"--------------------");
		JSONObject result=new JSONObject();
		if(StringUtil.isNotEmpty(commentid)){
			comment.setCommentid(Integer.valueOf(commentid));
			flag=new Commentservice().upComment(comment);
		}else{
			flag=new Commentservice().insertComment(comment);
		}
		if(flag==true){
			result.put("status", "1");
			result.put("errorMsg", "操作成功");
		}else{
			result.put("status", "0");
			result.put("errorMsg", "操作失败");
		}
		try {
			ResponseUtil.write(resp, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	
	}

}