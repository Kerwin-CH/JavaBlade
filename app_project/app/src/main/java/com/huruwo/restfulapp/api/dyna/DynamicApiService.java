package com.huruwo.restfulapp.api.dyna;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by dxx on 2017/11/20.
 */

public interface DynamicApiService<T>{

    @GET
    Observable<ResponseBody> getDynamicData(@Url String fullUrl);

}
