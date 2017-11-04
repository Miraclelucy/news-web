package com.lucy.until;

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
	
	 public static String null2String(String s)
	  {
	    return s == null ? "" : s; 
	  }
	 
	  //生成32位随机字符编号
	 public static String getUUID(){
		 String token=UUID.randomUUID().toString().trim().replaceAll("-", "");  
		 return token; 
	 }
	 
	 
	 
	 public static void main(String[] args) {
		
		 System.out.println(getUUID());
	}
	 
	 
	 
	
}
