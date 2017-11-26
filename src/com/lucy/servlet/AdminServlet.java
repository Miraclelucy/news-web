package com.lucy.servlet;

import com.lucy.bean.Admin;
import com.lucy.common.BaseServlet;
import com.lucy.service.Adminservice;
import com.lucy.until.CookieUtils;
import com.lucy.until.ResponseUtil;
import com.lucy.until.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-25
 * @修改人和其它信息
 */

@WebServlet(name="adminServlet", urlPatterns={"/admin"},loadOnStartup=1)
public class AdminServlet extends BaseServlet {
    /**
     *@描述   保存信息
     *@参数
     *@返回值
     *@创建人  lushiqin
     *@创建时间  2017-11-25
     *@修改人和其它信息
     */
    public String save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String adminId=req.getParameter("adminId");
        String adminName=req.getParameter("adminName");
        String adminPwd=req.getParameter("adminPwd");
        Admin admin=new Admin(adminName,adminPwd);
        boolean flag=false;
        if(StringUtil.isNotEmpty(adminId)){
            admin.setAdminId(Integer.parseInt(adminId));
        }
        JSONObject result=new JSONObject();
        if(StringUtil.isNotEmpty(adminId)){
            flag=new Adminservice().upadmin(admin);
        }else{
            flag=new com.lucy.service.Adminservice().add(admin);
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
        return "";
    }


    public String del(HttpServletRequest req, HttpServletResponse resp) {
        String delIds=req.getParameter("delIds");
        boolean flag=new com.lucy.service.Adminservice().del(delIds);
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
        return "";
    }

    public String list(HttpServletRequest req, HttpServletResponse resp) {
        ArrayList<Admin> admin=new com.lucy.service.Adminservice().getall();
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(admin);
        int total=new com.lucy.service.Adminservice().countadmin();
        result.put("rows", jsonArray);
        result.put("total", total);

        try {
            ResponseUtil.write(resp, result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public String login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String Msg = "";
        String name = req.getParameter("adminName");
        String pwd = req.getParameter("adminPwd");
        //验证码获取
        String validateCode = req.getParameter("validateCode");
        //是否记住我
        String rememberMe = req.getParameter("rememberMe");
        //自动登录
        String autologin = req.getParameter("autologin");
        String validateCode_session=req.getSession().getAttribute("validateCode").toString();
        System.out.println("------表单获取的validateCode------"+validateCode);
        System.out.println("------session中的验证码------"+validateCode_session);
        if (!StringUtils.upperCase(validateCode).equals(StringUtils.upperCase(validateCode_session))) {
            Msg = "验证码错误!";
            req.getSession().setAttribute("Msg2", Msg);
            resp.sendRedirect(req.getContextPath() + "/checkLogin.jsp");
        } else {

            boolean flag = new com.lucy.service.Adminservice().checkAdmin(name, pwd);

            //统计登陆人数
            ServletContext servletContext = getServletContext();
            String strcount =StringUtil.null2String(servletContext.getAttribute("count"));
            int count=0;
            if(!"".equals(strcount)){
                count=Integer.valueOf(strcount);
            }
            //获取cookie中的lastJsp值，取得最后访问的页面
            Cookie cookie = CookieUtils.getCookieByName("lastJsp", req.getCookies());
            String lastJsp = "index.jsp";
            if (cookie != null) {
                lastJsp = cookie.getValue();
            }
            System.out.println("最后访问的页面：-----------" + lastJsp);


            if (flag == true) {
                //统计登陆人数start
                count++;
                servletContext.setAttribute("count", count);
                //统计登陆人数 end

                //记住我功能实现
                if(rememberMe!=null){
                    if (rememberMe.equals("on")) {
                        //提示：cookie中不能存中文
                        Cookie cookie1 = new Cookie("rememberMeName", name);
                        Cookie cookie2 = new Cookie("rememberMePwd", pwd);
                        cookie1.setMaxAge(60*60); //1小时
                        cookie1.setPath(req.getContextPath() + "/");
                        cookie2.setMaxAge(60*60);
                        cookie2.setPath(req.getContextPath() + "/");
                        //cookie1.setPath("/admin/");
                        //System.out.println("--req.getContextPath()---"+req.getContextPath()); 项目部署在ROOT下，打印结果为空
                        resp.addCookie(cookie1);
                        resp.addCookie(cookie2);
                    }
                }

                Msg = "成功登陆，欢迎来到新闻管理后台！！";
                req.getSession().setAttribute("adminName", name);

                //自动登录功能实现
                if(autologin!=null){
                    if (autologin.equals("on")) {
                        Cookie cookie3 = new Cookie("autologin", name+"-"+pwd);
                        cookie3.setMaxAge(60*60); //1小时
                        cookie3.setPath(req.getContextPath() + "/");
                        resp.addCookie(cookie3);
                    }
                }

                //
                resp.sendRedirect(req.getContextPath() + "/admin/" + lastJsp);
            } else if (flag == false) {
                Msg = "您的名称或密码错误!";
                req.getSession().setAttribute("Msg2", Msg);
                resp.sendRedirect(req.getContextPath() + "/checkLogin.jsp");
            } else {
                Msg = "操作失败";
            }

        }
        return "";
    }



}