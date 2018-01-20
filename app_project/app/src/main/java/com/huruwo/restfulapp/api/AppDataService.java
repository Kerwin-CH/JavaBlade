package com.huruwo.restfulapp.api;

import com.huruwo.restfulapp.LoginBean;
import com.huruwo.restfulapp.NoteBean;

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
    Observable<LoginBean> getFuliData(@Field("name") String name, @Field("pass") String pass);

    @FormUrlEncoded
    @POST("note/list")
    Observable<NoteBean> getNoteList(@Field("uid") int uid);

}
