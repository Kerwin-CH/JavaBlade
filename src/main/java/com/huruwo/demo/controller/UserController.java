package com.huruwo.demo.controller;

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

            temp.save();
            return ARestResponse.ok(temp.findAll(),400);

        }
        catch (Exception e){
             return ARestResponse.fail(e.getMessage());
        }

    }

}
