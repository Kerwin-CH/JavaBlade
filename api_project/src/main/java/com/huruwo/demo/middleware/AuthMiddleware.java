package com.huruwo.demo.middleware;

import com.blade.mvc.hook.Signature;
import com.blade.mvc.hook.WebHook;
import com.blade.mvc.http.Request;
import com.blade.mvc.http.Response;
import com.huruwo.demo.response.ARestResponse;
import com.huruwo.demo.util.PorUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 拦截器 作为请求之前的校验
 */
@Slf4j
public class AuthMiddleware implements WebHook {



    @Override
    public boolean before(Signature signature) {

        Request request   = signature.request();

        Response response = signature.response();

        String uri = request.uri();

        System.out.print("token:"+uri);

        if(!uri.equals("/user/login")) {

            if (!checkHeaderAuth(request)) {

                response.json(ARestResponse.fail("token错误"));

                return false;
            }

        }

        return true;
    }



    /**
     * 检查head 头参数
     * @param request
     * @return
     */
    private boolean checkHeaderAuth(Request request) {

        String auth = request.header("token");

        System.out.print("token:"+auth);

        if(auth.equals(PorUtils.getToken())){
            return true;
        }

        return false;
    }

}
