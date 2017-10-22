package com.lucy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.lucy.bean.Type;
import com.lucy.until.ResponseUtil;

public class TypeComboListServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
         ArrayList<Type> type=new com.lucy.service.Typeservice().gettype();  
         JSONArray jsonArray=JSONArray.fromObject(type);
         JSONObject jsonObject=new JSONObject();
			jsonObject.put("typeId", "");
			jsonObject.put("typeName", "请选择...");
			jsonArray.add(jsonObject);
         				
		try {
			ResponseUtil.write(resp, jsonArray);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	
	
}
