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
import com.lucy.service.Commentservice;
import com.lucy.until.ResponseUtil;

/**  
 * @Title: CommentListServlet.java
 * @Package com.lucy.servlet
 * @Description: 
 * @author lushiqin  
 * @date 2017年10月24日 上午8:04:26
 * @version V1.0  
 */
public class CommentListServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		Commentservice ct=new Commentservice();
		ArrayList<Comment> commentlist=ct.getcomment();
		 JSONObject result=new JSONObject();
         JSONArray jsonArray=JSONArray.fromObject(commentlist);
         int count=ct.getCommentCount();
         try{
        	 result.put("rows", jsonArray);
        	 result.put("total", count);
        	ResponseUtil.write(resp, result);
         }
         catch(Exception e){
        	 
        	 
         }
		
		
	
	
	}

}