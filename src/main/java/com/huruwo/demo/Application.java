package com.huruwo.demo;

import com.blade.Blade;

public class Application {
    public static void main(String[] args) {
        Blade.me().start(Application.class, args);
    }
}
