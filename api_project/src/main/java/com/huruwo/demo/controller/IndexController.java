package com.huruwo.demo.controller;

import com.blade.mvc.annotation.GetRoute;
import com.blade.mvc.annotation.Param;
import com.blade.mvc.annotation.Path;
import com.blade.mvc.annotation.PathParam;
import com.blade.mvc.http.HttpResponse;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;

import javax.swing.text.html.HTML;
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
    public void index(Response response) {
        response.text("hello world");
    }


    @GetRoute("doc")
    public String doc(Request request) {

        return "dist/index";
    }

    @GetRoute("login")
    public void login(Response response) {

        response.redirect("http://www.baidu.com");
    }


}
