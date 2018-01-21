package com.huruwo.restfulapp.api;

import com.huruwo.restfulapp.api.bean.LoginBean;
import com.huruwo.restfulapp.api.bean.NoteBean;
import com.huruwo.restfulapp.api.bean.BaseBean;

import io.reactivex.Observable;

/**
 * Created by dxx on 2017/11/8.
 */

public class AppDataRepository {

    public static Observable<LoginBean> userLoginRepository(String name, String pass){

        Observable<LoginBean> data = ApiClient.getAppDataService().userLogin(name,pass);

        //可以操作Observable来筛选网络或者是本地数据

        return data;
    }


    public static Observable<BaseBean> userRegisterRepository(String name, String pass){

        Observable<BaseBean> data = ApiClient.getAppDataService().userRegister(name,pass);

        //可以操作Observable来筛选网络或者是本地数据

        return data;
    }

    public static Observable<NoteBean> getNoteListRepository(int uid){

        Observable<NoteBean> data = ApiClient.getAppDataService().getNoteList(uid);

        //可以操作Observable来筛选网络或者是本地数据

        return data;
    }

    public static Observable<BaseBean> addNoteRepository(int uid,String content){

        Observable<BaseBean> data = ApiClient.getAppDataService().addNote(uid,content);

        //可以操作Observable来筛选网络或者是本地数据

        return data;
    }

}
