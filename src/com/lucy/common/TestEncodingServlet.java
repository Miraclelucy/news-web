package com.lucy.common;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-20
 * @修改人和其它信息
 */
@WebServlet(name="TestEncodingServlet", urlPatterns={"/EncodingServlet"},loadOnStartup=1)
public class TestEncodingServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminName = request.getParameter("adminName"); // AJAX验证，成功返回true
        String adminPwd = request.getParameter("adminPwd"); // AJAX验证，成功返回true
        System.out.println(adminName);
        System.out.println(adminPwd);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String adminName = request.getParameter("adminName"); // AJAX验证，成功返回true
        String adminPwd = request.getParameter("adminPwd"); // AJAX验证，成功返回true
        System.out.println(adminName);
        System.out.println(adminPwd);
    }

}
