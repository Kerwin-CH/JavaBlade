package com.huruwo.demo.controller;

import com.blade.mvc.annotation.*;
import com.blade.mvc.ui.RestResponse;
import com.huruwo.demo.User;
import com.huruwo.demo.response.ARestResponse;

/**
 * @author biezhi
 * @date 2017/9/28
 */
@Path(value = "user")
public class UserController {


    @PostRoute("save")
    @JSON
    public ARestResponse saveUser(@Param String name){

        User user=new User();
        user.setRealName(name);
        user.setAge(12);
        user.setPassword("wasdwasd");
        user.setUsername("刘万");
        Long requset= user.save();


        return ARestResponse.ok(user,400);
    }

}
