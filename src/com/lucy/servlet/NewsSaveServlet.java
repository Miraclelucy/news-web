package com.lucy.servlet;
 
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import com.lucy.bean.News;
import com.lucy.bean.Type;
import com.lucy.until.StringUtil;
import com.lucy.until.ResponseUtil;
import com.lucy.service.Newsservice;

public class NewsSaveServlet extends HttpServlet {

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
		String title = req.getParameter("newTitle");
		int typeId = Integer.parseInt(req.getParameter("newTypeId"));
		//String type = req.getParameter("newType");
		String content = req.getParameter("newContent");
		String newtTime=req.getParameter("newtTime");
		String id=req.getParameter("newId");
		System.out.println("从表格中接受到的值："+id);
		System.out.println("从表格中接受到的值："+title);
		System.out.println("从表格中接受到的值："+content);
		System.out.println("从表格中接受到的值："+typeId);
		Type type=new com.lucy.service.Typeservice().gettypeName(typeId);
		News news = new News(title,content, type.getTypeName(), newtTime);
		if(StringUtil.isNotEmpty(id)){
			news.setNewId(Integer.parseInt(id));
		}
		boolean flag =false;
		
		JSONObject result=new JSONObject();
		if(StringUtil.isNotEmpty(id)){
			flag=new Newsservice().upnews(news);
		}else{
			flag=new Newsservice().insertnew(news);
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
