package com.lucy.servlet;

import java.io.IOException;





import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.lucy.bean.User;
import com.lucy.until.ResponseUtil;

public class UserLoginServlet extends HttpServlet {
	
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
         int flag=new com.lucy.service.Userservice().checkLogin(name,pwd);
 		 String Msg="";
         if(flag==0){
        	 Msg= "您的账号不存在!";			
 		}
         else if(flag==1){
        	 Msg="您的账号與密碼不匹配!";			
  		}
         else  if(flag==2){
        	 Msg="您的账号被判断为非法用户，已被禁用!!";			
   		}
         else  if(flag==3){
        	 Msg="成功登陆，欢迎来到网站！！";	
        	 req.getSession().setAttribute("userName",name);
    		}
         else{
        	 Msg="操作失败";
 		}
         req.getSession().setAttribute("Msg",Msg);
        
         resp.sendRedirect(req.getContextPath()+"/user/succLogin.jsp");  
	}
}
