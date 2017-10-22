package com.lucy.servlet;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.lucy.bean.Type;
import com.lucy.until.StringUtil;
import com.lucy.until.ResponseUtil;
import com.lucy.service.Typeservice;

public class TypeSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");	
		String name = req.getParameter("typeName");
		String id=req.getParameter("typeId");		
		Type type = new Type(name);
		if(StringUtil.isNotEmpty(id)){
			type.setTypeId(Integer.parseInt(id));
		}
		boolean flag =false;
		
		JSONObject result=new JSONObject();
		if(StringUtil.isNotEmpty(id)){
			flag=new Typeservice().uptype(type);
		}else{
			flag=new Typeservice().inserttype(name);
		}
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
