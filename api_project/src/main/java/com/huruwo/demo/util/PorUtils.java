package com.huruwo.demo.util;


import com.blade.mvc.http.Request;
import com.blade.mvc.http.Session;
import com.huruwo.demo.bean.Users;
import com.huruwo.demo.config.ProConst;

import java.util.List;

/**
 * Tale工具类
 * <p>
 * Created by biezhi on 2017/2/21.
 */
public class PorUtils {


    /**
     *
     * 值得注意的是 android 端发起的请求(非浏览器) 没有设置sessionId 所以获取的Token、为空 (因为无法保证会话一至)
     * @return
     */
    public static String getToken(Request request) {
        Session session = request.session();
        if (null == session) {
            return null;
        }
        String token = session.attribute(ProConst.LOGIN_SESSION_KEY);
        LogUtils.i("getToken",token);
        return token;
    }

    /**
     * 对应的android 使用数据库保存token验证的方式
     */
    public static String getSqlToken(Request request) {

        LogUtils.i("getSqlToken",request.queryInt("uid",0)+"");

        /**
         *
         */
        Users users=new Users().where("uid",request.queryInt("uid",0)).find();

        return users.getToken();
    }




    /**
     *
     * @param token
     */
    public static void setToken(Session session,String token) {
        LogUtils.i("setToken",token);
        session.attribute(ProConst.LOGIN_SESSION_KEY,token);
    }



}
