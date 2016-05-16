package com.leo.mzoneapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author：leo on 2016/5/16 00:12
 * email： leocheung4ever@gmail.com
 * description: TODO
 * what & why is modified:
 */
public class ServiceMzone {
    private static ApiMzone api;

    public static synchronized ApiMzone getApi() {
        if (api == null) {
            api = initializeApi();
        }
        return api;
    }

    private static ApiMzone initializeApi() {

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .build();

        Gson gson = new GsonBuilder()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiMzone.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit.create(ApiMzone.class);
    }
}
