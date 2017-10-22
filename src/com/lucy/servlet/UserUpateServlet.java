package com.lucy.servlet;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.lucy.bean.User;
import com.lucy.until.ResponseUtil;

public class UserUpateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * The doGet method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to get.	
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
       this.doPost(req, response);	
	}

	/**
	 * The doPost method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param req the req send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");	
		 int id=Integer.parseInt(req.getParameter("userId"));
         int useState=Integer.parseInt(req.getParameter("useState"));
         User user=new User(id,useState);
         boolean flag=new com.lucy.service.Userservice().upuser(user);
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
