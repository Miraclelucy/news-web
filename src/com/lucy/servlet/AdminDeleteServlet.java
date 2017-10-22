package com.lucy.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.lucy.bean.News;
import com.lucy.until.StringUtil;
import com.lucy.until.ResponseUtil;
import com.lucy.service.Newsservice;

public class AdminDeleteServlet extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String delIds=req.getParameter("delIds");
         boolean flag=new com.lucy.service.Adminservice().del(delIds);
		JSONObject result=new JSONObject();
		if(flag==true){
			result.put("success", "true");
		}else{
			result.put("success", "error");
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
