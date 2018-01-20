package com.huruwo.demo.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.http.Request;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author biezhi
 * @date 2017/9/28
 */
@Path
public class IndexController {

    @GetRoute
    public String index(Request request) {

        return "index.html";
    }

    @GetRoute("doc")
    public String doc(Request request) {

        return "doc.html";
    }

    @GetRoute("login")
    public String login() {
        return "login.html";
    }

}
