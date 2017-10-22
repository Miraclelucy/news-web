package com.lucy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.lucy.bean.News;
import com.lucy.until.ResponseUtil;

public class NewsListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
         ArrayList<News> news=new com.lucy.service.Newsservice().getnews();
         JSONObject result=new JSONObject();
         JSONArray jsonArray=JSONArray.fromObject(news);
		int total=new com.lucy.service.Newsservice().countnew();
		result.put("rows", jsonArray);
		result.put("total", total);
		
		try {
			ResponseUtil.write(resp, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	
	
}
