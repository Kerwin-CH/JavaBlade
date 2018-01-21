package com.huruwo.restfulapp.api.bean;

/**
 * Created by Administrator on 2018\1\21 0021.
 */

public class BaseBean {

    /**
     * data : null
     * success : 1
     * msg :
     * retCode : -1
     */

    private Object data;
    private int success;
    private String msg;
    private int retCode;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRetCode() {
        return retCode;
    }

    public void setRetCode(int retCode) {
        this.retCode = retCode;
    }
}
