package com.lucy.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lucy.dao.ResolveNews;

/**
 * Servlet implementation class ResolveNewsServlet
 */
@WebServlet("/ResolveNewsServlet")
public class ResolveNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * 
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String URLString=req.getParameter("URLString");	
		//System.out.println("http://sports.sina.com.cn/c/2014-06-08/14407199057.shtml");
		ResolveNews t =new ResolveNews();		
		String HTMLcontent = t.getHtmlContent(URLString); 
		HTMLcontent = HTMLcontent.replaceAll("(<br>)+?", "\n");// 转化换行       
		HTMLcontent = HTMLcontent.replaceAll("<p><em>.*?</em></p>", "");// 去图片注释 
        String newTitle=t.getTitle(HTMLcontent); 
        List<String> a = t.getNews(HTMLcontent); 
        String newContent="";
        for (String s : a) { 
        	newContent+=s.replaceAll("<.*?>", "");
        } 
        req.setAttribute("newTitle", newTitle);
        req.setAttribute("newContent", newContent);
        req.getRequestDispatcher("/admin/newsAdd.jsp").forward(req, resp);
               
	}

}
