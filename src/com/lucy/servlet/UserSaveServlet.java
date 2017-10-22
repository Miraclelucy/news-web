package com.lucy.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.bean.User;

public class UserSaveServlet extends HttpServlet {
	
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
         String sex=req.getParameter("sex");
         String email=req.getParameter("email");
         String add=req.getParameter("add");
         User user=new User(name,sex,pwd,email,add);
         boolean flag=new com.lucy.service.Userservice().adduser(user);
         if(flag){
        	 resp.sendRedirect(req.getContextPath()+"/user/succRegister.jsp");      	 
         }else{
        	 resp.sendRedirect(req.getContextPath()+"/index.jsp");
         }	
	}
}
