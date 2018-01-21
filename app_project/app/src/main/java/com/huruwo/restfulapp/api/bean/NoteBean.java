package com.huruwo.restfulapp.api.bean;

import java.util.List;

/**
 * @author: liuwan
 * @date: 2018-01-20
 * @action:
 */
public class NoteBean {


    /**
     * data : [{"noteid":10,"uid":3,"content":"����һ�� ��ͨ �� Maven ���̣��ٴ���ʾ Blade ֻ��Ҫ�㴴����ͨ�Ĺ��̣������� Tomcat ʲô��û�й�ϵ���������ֻ��J2EE����"},{"noteid":11,"uid":3,"content":"adasdasdasdasdsadsad"},{"noteid":12,"uid":3,"content":"adasdasdasdasdsadsad"},{"noteid":13,"uid":3,"content":"adasdasdasdasdsadsad"},{"noteid":14,"uid":3,"content":"adasdasdasdasdsadsad"},{"noteid":15,"uid":3,"content":"adasdasdasdasdsadsad"}]
     * success : 1
     * msg :
     * retCode : -1
     */

    private int success;
    private String msg;
    private int retCode;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * noteid : 10
         * uid : 3
         * content : ����һ�� ��ͨ �� Maven ���̣��ٴ���ʾ Blade ֻ��Ҫ�㴴����ͨ�Ĺ��̣������� Tomcat ʲô��û�й�ϵ���������ֻ��J2EE����
         */

        private int noteid;
        private int uid;
        private String content;

        public int getNoteid() {
            return noteid;
        }

        public void setNoteid(int noteid) {
            this.noteid = noteid;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
