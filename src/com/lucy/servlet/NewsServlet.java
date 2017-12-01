package com.lucy.servlet;

import com.lucy.bean.News;
import com.lucy.bean.Type;
import com.lucy.common.BeanFactory;
import com.lucy.service.Typeservice;
import com.lucy.servlet.common.BaseServlet;
import com.lucy.servlet.common.ResolveNews;
import com.lucy.service.Newsservice;
import com.lucy.until.ResponseUtil;
import com.lucy.until.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-25
 * @修改人和其它信息
 */
@WebServlet(name="newsServlet", urlPatterns={"/admin/news"},loadOnStartup=1)
public class NewsServlet extends BaseServlet {
    Newsservice newsservice= (Newsservice) BeanFactory.getBean("Newsservice");
    Typeservice typeservice= (Typeservice) BeanFactory.getBean("Typeservice");

    public String save(HttpServletRequest req, HttpServletResponse resp){
        String title = req.getParameter("newTitle");
        int typeId = Integer.parseInt(req.getParameter("newTypeId"));
        //String type = req.getParameter("newType");
        String content = req.getParameter("newContent");
        String newtTime=req.getParameter("newtTime");
        String id=req.getParameter("newId");
        System.out.println("从表格中接受到的值："+id);
        System.out.println("从表格中接受到的值："+title);
        System.out.println("从表格中接受到的值："+content);
        System.out.println("从表格中接受到的值："+typeId);
        Type type=typeservice.gettypeName(typeId);
        News news = new News(title,content, type.getTypeName(), newtTime);
        if(StringUtil.isNotEmpty(id)){
            news.setNewId(Integer.parseInt(id));
        }
        boolean flag =false;

        JSONObject result=new JSONObject();
        if(StringUtil.isNotEmpty(id)){
            flag=newsservice.upnews(news);
        }else{
            flag=newsservice.insertnew(news);
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
        boolean flag=newsservice.delnewsbyid(delIds);
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
        List<News> news=newsservice.getnews();
        JSONObject result=new JSONObject();
        JSONArray jsonArray=JSONArray.fromObject(news);
        int total=newsservice.countnew();
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

    public String parseNews(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

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
        return "";
    }


}