package com.huruwo.demo.controller;

import com.blade.kit.DateKit;
import com.blade.mvc.annotation.*;
import com.huruwo.demo.Users;
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

        try {
            Users temp = new Users();
            temp.setUsername(name);
            temp.setPassword(name);
            temp.setEmail(name);
            temp.setCreated(DateKit.nowUnix());

            temp.save();
            return ARestResponse.ok();

        }
        catch (Exception e){
             return ARestResponse.fail(e.getMessage());
        }

    }

}
