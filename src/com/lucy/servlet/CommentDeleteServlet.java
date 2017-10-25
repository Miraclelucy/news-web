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
public class CommentDeleteServlet  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		String delIds=req.getParameter("delIds");
        boolean flag=new com.lucy.service.Commentservice().delCommentbyid(delIds);
		JSONObject result=new JSONObject();
		if(flag==true){
			result.put("status", "1");
		}else{
			result.put("status", "0");
			result.put("errorMsg", "操作失败");
		}
		try {
			ResponseUtil.write(resp, result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	
	}

}