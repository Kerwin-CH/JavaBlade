package com.huruwo.restfulapp.api;

import com.huruwo.restfulapp.LoginBean;
import com.huruwo.restfulapp.NoteBean;

import io.reactivex.Observable;

/**
 * Created by dxx on 2017/11/8.
 */

public class AppDataRepository {

    public static Observable<LoginBean> getFuliDataRepository(String name, String pass){

        Observable<LoginBean> observableForGetFuliDataFromNetWork = ApiClient.getAppDataService().getFuliData(name,pass);

        //可以操作Observable来筛选网络或者是本地数据

        return observableForGetFuliDataFromNetWork;
    }


    public static Observable<NoteBean> getNoteListRepository(int uid){

        Observable<NoteBean> observableForGetFuliDataFromNetWork = ApiClient.getAppDataService().getNoteList(uid);

        //可以操作Observable来筛选网络或者是本地数据

        return observableForGetFuliDataFromNetWork;
    }
}
