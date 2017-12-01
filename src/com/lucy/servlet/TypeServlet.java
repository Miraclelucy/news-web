package com.lucy.servlet;

import com.lucy.bean.Type;
import com.lucy.common.BeanFactory;
import com.lucy.servlet.common.BaseServlet;
import com.lucy.service.Typeservice;
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
@WebServlet(name="typeServlet", urlPatterns={"/admin/type"},loadOnStartup=1)
public class TypeServlet extends BaseServlet {
    Typeservice typeservice= (Typeservice) BeanFactory.getBean("Typeservice");

    public String save(HttpServletRequest req, HttpServletResponse resp){
        String name = req.getParameter("typeName");
        String id=req.getParameter("typeId");
        Type type = new Type(name);
        if(StringUtil.isNotEmpty(id)){
            type.setTypeId(Integer.parseInt(id));
        }
        boolean flag =false;

        JSONObject result=new JSONObject();
        if(StringUtil.isNotEmpty(id)){
            flag=typeservice.uptype(type);
        }else{
            flag=typeservice.inserttype(name);
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
        boolean flag=typeservice.deletetype(delIds);
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
        List<Type> type=typeservice.gettype();
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(type);
        int total=typeservice.counttype();
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

    public String getComlist(HttpServletRequest req, HttpServletResponse resp) {

        List<Type> type=typeservice.gettype();
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
        return "";
    }

}
