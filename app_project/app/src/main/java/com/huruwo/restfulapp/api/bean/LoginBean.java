package com.huruwo.restfulapp.api.bean;

/**
 * @author: liuwan
 * @date: 2018-01-20
 * @action:
 */
public class LoginBean {


    /**
     * data : {"uid":3,"username":"wanzai","email":"1458476478@qq.com"}
     * success : 1
     * msg :
     * retCode : -1
     */

    private DataBean data;
    private int success;
    private String msg;
    private int retCode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * uid : 3
         * username : wanzai
         * email : 1458476478@qq.com
         */

        private int uid;
        private String username;
        private String email;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
