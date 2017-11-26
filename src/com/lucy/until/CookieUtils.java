package com.lucy.until;

import javax.servlet.http.Cookie;

/**
 * @描述
 * @创建人 lushiqin
 * @创建时间 2017-11-06
 * @修改人和其它信息
 */
public class CookieUtils {

    public static Cookie getCookieByName(String key,Cookie[] cookies){
        for(Cookie c:cookies){
            if(key.equals(c.getName())){
                return c;
            }
        }
        return null;
    }
}
