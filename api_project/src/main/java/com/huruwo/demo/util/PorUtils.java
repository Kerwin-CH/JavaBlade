package com.huruwo.demo.util;


import com.blade.mvc.http.Request;
import com.blade.mvc.http.Session;
import com.huruwo.demo.config.ProConst;

/**
 * Tale工具类
 * <p>
 * Created by biezhi on 2017/2/21.
 */
public class PorUtils {


    /**
     *
     *
     * @return
     */
    public static String getToken() {
        Session session = com.blade.mvc.WebContext.request().session();
        if (null == session) {
            return null;
        }
        String token = session.attribute(ProConst.LOGIN_SESSION_KEY);
        System.out.print("PorUtils:"+token);
        return token;
    }

    /**
     *
     * @param token
     */
    public static void setToken(Request request,String token) {
       request.session().attribute(ProConst.LOGIN_SESSION_KEY,"xxxxxxxxxxxxxx");
    }



}
