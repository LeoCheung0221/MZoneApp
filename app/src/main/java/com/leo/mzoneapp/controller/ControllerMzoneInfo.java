package com.leo.mzoneapp.controller;

import android.support.annotation.Nullable;

import com.leo.mzoneapp.api.ServiceMzone;
import com.leo.mzoneapp.api.request.RequestMzone;
import com.leo.mzoneapp.api.response.ResponseMzone;
import com.leo.mzoneapp.model.Mzone;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author：leo on 2016/5/16 08:38
 * email： leocheung4ever@gmail.com
 * description: Mzone Controller
 * what & why is modified:
 */
public class ControllerMzoneInfo
        implements Callback<ResponseMzone> {

    private static final int NO_VALUE = -1;
    private static ControllerMzoneInfo instance;

    private int mzone_id;
    @Nullable
    private Mzone data;

    private ArrayList<Callback<ResponseMzone>> listeners;

    private ControllerMzoneInfo() {
        mzone_id = NO_VALUE;
    }

    public static ControllerMzoneInfo getInstance() {
        if (instance == null)
            instance = new ControllerMzoneInfo();
        return instance;
    }

    public void setMzone_id(int mzone_id) {
        this.mzone_id = mzone_id;
    }

    public int getMzone_id() {
        return mzone_id;
    }

    public void updateData() {
        if (mzone_id == NO_VALUE) return;
        ServiceMzone.getApi().getMzone(new RequestMzone(mzone_id).enqueue(this));
    }

    public void addListener(Callback<ResponseMzone> listener) {
        if (listener == null) listeners = new ArrayList<>();
        listeners.add(listener);
    }

    public void removeListener(Callback<ResponseMzone> listener) {
        if (listener == null) return;
        listeners.remove(listener);
    }

    //todo get data
    public Mzone getData() {
        return data;
    }

    @Override
    public void onResponse(Call<ResponseMzone> call, Response<ResponseMzone> response) {
        data = response.body().boozer;
        if (listeners != null)
            for (Callback<ResponseMzone> listener : listeners)
                listener.onResponse(call, response);
    }

    @Override
    public void onFailure(Call<ResponseMzone> call, Throwable t) {
        if (listeners != null)
            for (Callback<ResponseMzone> listener : listeners)
                listener.onFailure(call, t);
    }
}
