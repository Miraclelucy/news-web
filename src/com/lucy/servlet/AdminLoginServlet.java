package com.lucy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import com.lucy.bean.Admin;
import com.lucy.until.ResponseUtil;

public class AdminLoginServlet extends HttpServlet {
	
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
		 String name=req.getParameter("name");
		 String pwd=req.getParameter("pwd");
		 boolean flag=new com.lucy.service.Adminservice().checkAdmin(name,pwd);
 		 String Msg="";
 		   if(flag==true){
        	 Msg="成功登陆，欢迎来到新闻管理后台！！";
        	 req.getSession().setAttribute("adminName",name);  
        	 resp.sendRedirect(req.getContextPath()+"/admin/index.jsp"); 
	 		}
	        else if(flag==false){
	        	 Msg="您的名称或密码错误!";  
	        	 req.getSession().setAttribute("Msg2",Msg); 
	             resp.sendRedirect(req.getContextPath()+"/checkLogin.jsp"); 
	  		} 
	         else{
	        	 Msg="操作失败";
	 		}
         
	}
}
