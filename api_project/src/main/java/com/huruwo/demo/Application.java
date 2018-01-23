package com.huruwo.demo;

import com.blade.Blade;
import com.huruwo.demo.middleware.AuthMiddleware;

public class Application {
    public static void main(String[] args) {
        Blade.me().listen(880).use(new AuthMiddleware()).start(Application.class, args);
    }
}
