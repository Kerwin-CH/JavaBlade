package com.huruwo.demo.response;

import com.blade.kit.DateKit;
import com.blade.kit.JsonKit;
import com.blade.mvc.ui.RestResponse;
import lombok.extern.slf4j.Slf4j;

import java.beans.ConstructorProperties;

public class ARestResponse<T> {
    private T data;
    private int success;
    private String msg;
    private int retCode;



    public ARestResponse(int success) {
        this.success = success;
    }

    public ARestResponse(int success, T data) {
        this.success = success;
        this.data = data;
    }

    public T getdata() {
        return this.data;
    }

    public int isSuccess() {
        return this.success;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getretCode() {
        return this.retCode;
    }

    public void setretCode(int retCode) {
        this.retCode = retCode;
    }

    public static ARestResponse ok() {
        return builder().success(1).build();
    }

    public static <T> ARestResponse ok(T data) {
        System.out.print(builder().toString());
        return builder().success(1).data(data).build();
    }

    public static <T> ARestResponse ok(T data, int retCode) {
        return builder().success(1).data(data).retCode(retCode).build();
    }

    public static ARestResponse fail() {
        return builder().success(0).build();
    }

    public static ARestResponse fail(String msg) {
        return builder().success(0).msg(msg).build();
    }

    public static ARestResponse fail(int retCode) {
        return builder().success(0).retCode(retCode).build();
    }

    public static ARestResponse fail(int retCode, String msg) {
        return builder().success(0).msg(msg).retCode(retCode).build();
    }

    private static int $default$retCode() {
        return -1;
    }


    public static <T> ARestResponse.ARestResponseBuilder<T> builder() {
        return new ARestResponse.ARestResponseBuilder();
    }

    @ConstructorProperties({"data", "success", "msg", "retCode"})
    public ARestResponse(T data, int success, String msg, int retCode) {
        this.data = data;
        this.success = success;
        this.msg = msg;
        this.retCode = retCode;
    }

    public static class ARestResponseBuilder<T> {
        private T data;
        private int success;
        private String msg;
        private boolean retCode$set;
        private int retCode;
        private ARestResponse aRestResponse;

        ARestResponseBuilder() {
        }

        public ARestResponse.ARestResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ARestResponse.ARestResponseBuilder<T> success(int success) {
            this.success = success;
            return this;
        }

        public ARestResponse.ARestResponseBuilder<T> msg(String msg) {
            this.msg = msg;
            return this;
        }

        public ARestResponse.ARestResponseBuilder<T> retCode(int retCode) {
            this.retCode = retCode;
            this.retCode$set = true;
            return this;
        }


        public ARestResponse<T> build() {

            aRestResponse= new ARestResponse(this.data, this.success, this.msg==null?"":this.msg, this.retCode$set ? this.retCode : ARestResponse.$default$retCode());
            String json = JsonKit.toString(aRestResponse);
            System.out.print(json+"\n");
            return aRestResponse;
        }

        public String toString() {


            return "";
            //return "RestResponse.RestResponseBuilder(data=" + this.data + ", success=" + this.success + ", msg=" + this.msg + ", retCode=" + this.retCode +")";

        }
    }
}
