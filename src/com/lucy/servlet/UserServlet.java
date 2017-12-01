package com.lucy.servlet;

import com.lucy.bean.User;
import com.lucy.common.BeanFactory;
import com.lucy.service.Typeservice;
import com.lucy.service.Userservice;
import com.lucy.servlet.common.BaseServlet;
import com.lucy.until.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-25
 * @修改人和其它信息
 */
@WebServlet(name="userServlet", urlPatterns={"/admin/user"},loadOnStartup=1)
public class UserServlet extends BaseServlet {
    Userservice userservice= (Userservice) BeanFactory.getBean("Userservice");

    /**
     *@描述   保存信息
     *@参数
     *@返回值
     *@创建人  lushiqin
     *@创建时间  2017-11-25
     *@修改人和其它信息
     */
     public String reg(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html;charset=UTF-8");
        String name=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        String sex=req.getParameter("sex");
        String email=req.getParameter("email");
        String add=req.getParameter("add");
        User user=new User(name,sex,pwd,email,add);
        boolean flag=userservice.adduser(user);
        if(flag){
            return  "/user/succRegister.jsp";
        }else{
            return  "/index.jsp";
        }
    }
    /**
     *@描述  修改员工状态
     *@参数
     *@返回值
     *@创建人  lushiqin
     *@创建时间  2017-11-25
     *@修改人和其它信息
     */
    public String update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id=Integer.parseInt(req.getParameter("userId"));
        int useState=Integer.parseInt(req.getParameter("useState"));
        User user=new User(id,useState);
        boolean flag=userservice.upuser(user);
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
        return  "";
     }


     public String del(HttpServletRequest req, HttpServletResponse resp) {
        String delIds=req.getParameter("delIds");
        boolean flag=userservice.deluser(delIds);
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
         return  "";
    }

    public String list(HttpServletRequest req, HttpServletResponse resp) {
        List<User> user = userservice.getall();
        JSONObject result = new JSONObject();
        JSONArray jsonArray = JSONArray.fromObject(user);
        int total = userservice.countuser();
        result.put("rows", jsonArray);
        result.put("total", total);

        try {
            ResponseUtil.write(resp, result);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return  "";
    }

    public String login(HttpServletRequest req, HttpServletResponse resp) {
        String name=req.getParameter("name");
        String pwd=req.getParameter("pwd");
        int flag=userservice.checkLogin(name,pwd);
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

        return "/user/succLogin.jsp";
    }

}