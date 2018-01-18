package com.huruwo.demo.response;

import com.blade.kit.DateKit;

import java.beans.ConstructorProperties;


public class ARestResponse<T> {
    private T data;
    private boolean success;
    private String msg;
    private int retCode;
    private long timestamp;

    public ARestResponse() {
        this.timestamp = (long) DateKit.nowUnix();
    }

    public ARestResponse(boolean success) {
        this.timestamp = (long)DateKit.nowUnix();
        this.success = success;
    }

    public ARestResponse(boolean success, T data) {
        this.timestamp = (long)DateKit.nowUnix();
        this.success = success;
        this.data = data;
    }

    public T getdata() {
        return this.data;
    }

    public boolean isSuccess() {
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

    public long getTimestamp() {
        return this.timestamp;
    }

    public static ARestResponse ok() {
        return builder().success(true).build();
    }

    public static <T> ARestResponse ok(T data) {
        return builder().success(true).data(data).build();
    }

    public static <T> ARestResponse ok(T data, int retCode) {
        return builder().success(true).data(data).retCode(retCode).build();
    }

    public static ARestResponse fail() {
        return builder().success(false).build();
    }

    public static ARestResponse fail(String msg) {
        return builder().success(false).msg(msg).build();
    }

    public static ARestResponse fail(int retCode) {
        return builder().success(false).retCode(retCode).build();
    }

    public static ARestResponse fail(int retCode, String msg) {
        return builder().success(false).msg(msg).retCode(retCode).build();
    }

    private static int $default$retCode() {
        return -1;
    }

    private static long $default$timestamp() {
        return (long)DateKit.nowUnix();
    }

    public static <T> ARestResponse.ARestResponseBuilder<T> builder() {
        return new ARestResponse.ARestResponseBuilder();
    }

    @ConstructorProperties({"data", "success", "msg", "retCode", "timestamp"})
    public ARestResponse(T data, boolean success, String msg, int retCode, long timestamp) {
        this.data = data;
        this.success = success;
        this.msg = msg;
        this.retCode = retCode;
        this.timestamp = timestamp;
    }

    public static class ARestResponseBuilder<T> {
        private T data;
        private boolean success;
        private String msg;
        private boolean retCode$set;
        private int retCode;
        private boolean timestamp$set;
        private long timestamp;

        ARestResponseBuilder() {
        }

        public ARestResponse.ARestResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ARestResponse.ARestResponseBuilder<T> success(boolean success) {
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

        public ARestResponse.ARestResponseBuilder<T> timestamp(long timestamp) {
            this.timestamp = timestamp;
            this.timestamp$set = true;
            return this;
        }

        public ARestResponse<T> build() {
            return new ARestResponse(this.data, this.success, this.msg, this.retCode$set ? this.retCode : ARestResponse.$default$retCode(), this.timestamp$set ? this.timestamp : ARestResponse.$default$timestamp());
        }

        public String toString() {
            return "ARestResponse.ARestResponseBuilder(data=" + this.data + ", success=" + this.success + ", msg=" + this.msg + ", retCode=" + this.retCode + ", timestamp=" + this.timestamp + ")";
        }
    }
}
