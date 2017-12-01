package com.lucy.servlet;

import com.lucy.bean.Comment;
import com.lucy.common.BeanFactory;
import com.lucy.service.Bbsservice;
import com.lucy.servlet.common.BaseServlet;
import com.lucy.service.Commentservice;
import com.lucy.until.ResponseUtil;
import com.lucy.until.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-25
 * @修改人和其它信息
 */
@WebServlet(name="commentServlet", urlPatterns={"/admin/comment"},loadOnStartup=1)
public class CommentServlet extends BaseServlet {
    Commentservice commentservice= (Commentservice) BeanFactory.getBean("Commentservice");

    public String save(HttpServletRequest req, HttpServletResponse resp){
        String  pathInfo = req.getPathInfo();
        String  servletPath = req.getServletPath();
        System.out.println("------req.getPathInfo()----"+pathInfo);
        System.out.println("------req.getServletPath()-------"+servletPath);
        //System.out.println("------getRelativePath-------"+getRelativePath(req,true));
        String commentid = StringUtil.null2String(req.getParameter("commentid"));
        String commentnewid = StringUtil.null2String(req.getParameter("commentnewid"));
        String commentname = StringUtil.null2String(req.getParameter("commentname"));
        String commenttext = StringUtil.null2String(req.getParameter("commenttext"));

        System.out.println("commentServlet---------------");
        if ("".equals(commentnewid)) {
            commentnewid = "1";
        }
        Comment comment = new Comment(commentnewid, "系统管理员",commenttext);

        boolean flag =false;
        System.out.println(commentid+"--------------------");
        JSONObject result=new JSONObject();
        if(StringUtil.isNotEmpty(commentid)){
            comment.setCommentid(Integer.valueOf(commentid));
            flag=commentservice.upComment(comment);
        }else{
            flag=commentservice.insertComment(comment);
        }
        if(flag==true){
            result.put("status", "1");
            result.put("errorMsg", "操作成功");
        }else{
            result.put("status", "0");
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
        boolean flag=commentservice.delCommentbyid(delIds);
        JSONObject result=new JSONObject();
        if(flag==true){
            result.put("status", "1");
        }else{
            result.put("status", "0");
            result.put("errorMsg", "操作失败");
        }
        try {
            ResponseUtil.write(resp, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public String list(HttpServletRequest req, HttpServletResponse resp) {
        List<Comment> commentlist=commentservice.getcomment();
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(commentlist);
        int count=commentservice.getCommentCount();
        try{
            result.put("rows", jsonArray);
            result.put("total", count);
            ResponseUtil.write(resp, result);
        }
        catch(Exception e){


        }
        return "";
    }

}
