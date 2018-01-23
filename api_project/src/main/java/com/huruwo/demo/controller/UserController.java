package com.huruwo.demo.controller;

import com.blade.Blade;
import com.blade.kit.DateKit;
import com.blade.kit.EncryptKit;
import com.blade.mvc.annotation.*;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Session;
import com.blade.mvc.ui.RestResponse;
import com.huruwo.demo.bean.ResUsers;
import com.huruwo.demo.bean.Users;
import com.huruwo.demo.response.ARestResponse;
import com.huruwo.demo.util.PorUtils;

import java.util.Date;

/**
 * @author biezhi
 * @date 2017/9/28
 */
@Path(value = "user")
public class UserController {

    @GetRoute("test")
    @JSON
    public RestResponse test(@Param String name, @Param String pass, @Param String email) {

        Users temp = new Users();
        temp.setUsername(name);
        temp.setPassword(pass);
        temp.setEmail(email);


        return RestResponse.ok(temp);
    }

    @PostRoute("register")
    @JSON
    public ARestResponse register(@Param String name, @Param String pass, @Param String email) {

        try {
            /**
             * 检测
             */
            long count = new Users().where("username", name).count();
            if (count > 0) {
                return ARestResponse.fail("用户名已存在");
            }

            Users temp = new Users();
            temp.setUsername(name);
            temp.setPassword(pass);
            temp.setEmail(email);
            temp.save();


            return ARestResponse.ok();
        } catch (Exception e) {
            return ARestResponse.fail(e.getMessage());
        }

    }


    @PostRoute("login")
    @JSON
    public ARestResponse login(Request request,@Param String name, @Param String pass) {


        /**
         * 密码传输记得使用加密 md5/sha1
         */
        try {

            /**
             * 做查询验证
             */
            long count = new Users().where("username", name).count();
            if (count < 1) {
                return ARestResponse.fail("不存在该用户");
            }


            Users user = new Users().where("username", name).and("password", pass).find();
            if (null == user) {
                return ARestResponse.fail("用户名或密码错误");
            }


            Integer timestamp=DateKit.nowUnix();

            //通过加密得到token 加点盐
            user.setToken(EncryptKit.md5(name+pass+timestamp+"token123"));
            user.setTimestamp(timestamp);

            int  m= user.update(user.getUid());

            if(m>0){
                /**
                 * 重新查询更新的值
                 */
                user = new Users().where("username", name).and("password", pass).find();

                PorUtils.setToken(request,user.getToken());

                ResUsers resUsers = new ResUsers(user.getUid(), user.getUsername(), user.getEmail(),user.getToken());
                return ARestResponse.ok(resUsers);
            }

            return ARestResponse.fail("fail");


        } catch (Exception e) {
            return ARestResponse.fail(e.getMessage());
        }

    }

}
