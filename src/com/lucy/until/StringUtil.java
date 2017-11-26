package com.lucy.until;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class StringUtil {

	public static boolean isEmpty(String str){
		if("".equals(str)|| str==null){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isNotEmpty(String str){
		if(!"".equals(str)&&str!=null){
			return true;
		}else{
			return false;
		}
	}
	
	 public static String null2String(Object s)
	  {
	    return s == null ? "" : s.toString();
	  }
	 
	  //生成32位随机字符编号
	 public static String getUUID(){
		 String token=UUID.randomUUID().toString().trim().replaceAll("-", "");  
		 return token; 
	 }

	//获得本年最后一天的日期 *
	public String getCurrentYearEnd(){
		Date date = new Date();
		SimpleDateFormat dateFormat   =   new   SimpleDateFormat("yyyy");//可以方便地修改日期格式
		String  years  = dateFormat.format(date);
		return years+"-12-31";
	}

	//日期格式转换 将字符串形式的YYYY-MM-DD或者YYYYMMDD 转换成YYYY年MM月DD日
	public  String getFormatDate(String strdate){
		DateFormat fmt1 =new SimpleDateFormat("yyyy-MM-dd");
		DateFormat fmt2 =new SimpleDateFormat("yyyy/MM/dd");
		DateFormat fmt3 =new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
		Date date=null;
		String resultdate=strdate;
		if("8".equals(strdate.length())){
			if(strdate.contains("-")){
				try {
					date = fmt1.parse(strdate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else if(strdate.contains("/")){
				try {
					date = fmt2.parse(strdate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}else {
				try {
					date = fmt3.parse(strdate);
				} catch (ParseException e) {
					e.printStackTrace();
				}

			}

			if(date!=null)
			{
				resultdate=sdf.format(date);
			}
		}

		return resultdate;
	}


	 
	 public static void main(String[] args) {
		
		 System.out.println(getUUID());
	}
	 
	 
	 
	
}
