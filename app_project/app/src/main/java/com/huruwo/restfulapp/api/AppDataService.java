package com.huruwo.restfulapp.api;

import com.huruwo.restfulapp.api.bean.LoginBean;
import com.huruwo.restfulapp.api.bean.NoteBean;
import com.huruwo.restfulapp.api.bean.BaseBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by dxx on 2017/11/8.
 */

public interface AppDataService {

    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> userLogin(@Field("name") String name, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("user/register")
    Observable<BaseBean> userRegister(@Field("name") String name, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("note/list")
    Observable<NoteBean> getNoteList(@Field("uid") int uid);


    @FormUrlEncoded
    @POST("note/add")
    Observable<BaseBean>addNote(@Field("uid") int uid,@Field("content") String content);
}
