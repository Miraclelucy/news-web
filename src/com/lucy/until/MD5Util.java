package com.lucy.until;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**  
 * @Title: MD5Util.java
 * @Package com.lucy.until
 * @Description: 
 * @author lushiqin  
 * @date 2017年10月26日 上午8:15:38
 * @version V1.0  
 */
public class MD5Util {
	/**
	 * 
	 * @param data
	 * @return
	 */
	 public static byte[] getMD5Code(byte[] data)
	  {
	    MessageDigest md5 = null;
	    try
	    {
	      md5 = MessageDigest.getInstance("MD5");
	      md5.reset();
	      md5.update(data);
	    }
	    catch (NoSuchAlgorithmException e)
	    {
	      e.printStackTrace();
	    }
	    return md5.digest();
	  }
	  
	 /** 
	     * 对字符串md5加密(小写+字母数字) 
	     * 
	     * @param str 传入要加密的字符串 
	     * @return  MD5加密后的字符串 
	     */  
	    public static String  getMD5LowerCode(String str) {  
	        try {  
	            // 生成一个MD5加密计算摘要  
	            MessageDigest md = MessageDigest.getInstance("MD5");  
	            // 计算md5函数  
	            md.update(str.getBytes());  
	            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符  
	            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值  
	            return new BigInteger(1, md.digest()).toString(16);  
	        } catch (Exception e) {  
	           e.printStackTrace();  
	           return null;  
	        }  
	    }  
	      
	      
	    /** 
	     * 对字符串md5加密(大写+字母数字) 
	     * 
	     * @param str 传入要加密的字符串 
	     * @return  MD5加密后的字符串 
	     */  
	      
	    public static String getMD5UpperCode(String s) {  
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
	  
	        try {  
	            byte[] btInput = s.getBytes();  
	            // 获得MD5摘要算法的 MessageDigest 对象  
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
	            // 使用指定的字节更新摘要  
	            mdInst.update(btInput);  
	            // 获得密文  
	            byte[] md = mdInst.digest();  
	            // 把密文转换成十六进制的字符串形式  
	            int j = md.length;  
	            char str[] = new char[j * 2];  
	            int k = 0;  
	            for (int i = 0; i < j; i++) {  
	                byte byte0 = md[i];  
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
	                str[k++] = hexDigits[byte0 & 0xf];  
	            }  
	            return new String(str);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	            return null;  
	        }  
	    }  
	  
	 
	 
	 /**文件加密
	 * @param file
	 * @return
	 */
	public static String encryptFile(File file)
	  {
	    if ((!file.exists()) || (!file.isFile())) {
	      return null;
	    }
	    MessageDigest digest = null;
	    FileInputStream in = null;
	    byte[] buffer = new byte[1024];
	    try
	    {
	      digest = MessageDigest.getInstance("MD5");
	      in = new FileInputStream(file);
	      int len;
	      while ((len = in.read(buffer, 0, 1024)) != -1)
	      {
	        digest.update(buffer, 0, len);
	      }
	      in.close();
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	      return null;
	    }
	    int len;
	    return ByteUtil.byteToString(digest.digest());
	  }
	
	  public static String getFileMD5(String filepath)
	  {
	    File file = new File(filepath);
	    return encryptFile(file);
		  
	  }
	  public static void main(String[] args) {
		  String md5 = getMD5UpperCode("password");  
          String md52 = getMD5LowerCode("password");    
          System.out.println(md5);
          System.out.println(md52);
	}
}
