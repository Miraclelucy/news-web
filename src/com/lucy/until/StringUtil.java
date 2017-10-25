package com.lucy.until;

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
	  
	 
	 
	
}
