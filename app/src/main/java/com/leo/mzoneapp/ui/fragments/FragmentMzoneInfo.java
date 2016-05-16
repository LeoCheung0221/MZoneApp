package com.leo.mzoneapp.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leo.mzoneapp.R;
import com.leo.mzoneapp.api.response.ResponseMzone;
import com.leo.mzoneapp.controller.ControllerMzoneInfo;
import com.leo.mzoneapp.ui.activities.ActivityBase;
import com.leo.mzoneapp.ui.activities.ActivitySongs;
import com.leo.mzoneapp.ui.adapters.AdapterMzoneInfo;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * author： LeoCheung4ever on 2016/5/9 16:20
 * email： leocheung4ever@gmail.com
 * description: Mzone info
 * what & why is modified:
 */
public class FragmentMzoneInfo extends FragmentBase
        implements View.OnClickListener, Callback<ResponseMzone> {

    AdapterMzoneInfo adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_mzone_info, container, false);

        v.findViewById(R.id.tvSongOrder).setOnClickListener(this);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.rvMzoneInfo);
        adapter = new AdapterMzoneInfo(v.getContext());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));

        ((ActivityBase) getActivity()).setSupportActionBar((Toolbar) v.findViewById(R.id.toolbar));
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();

        //todo remove debug
        ControllerMzoneInfo.getInstance().setMzone_id(1);
        ControllerMzoneInfo.getInstance().addListener(this);
        ControllerMzoneInfo.getInstance().updateData();
    }

    @Override
    public void onPause() {
        super.onPause();
        ControllerMzoneInfo.getInstance().removeListener(this);
    }

    @Override
    public void onClick(View v) {
        ActivitySongs.display(v.getContext());
    }

    @Override
    public void onResponse(Call<ResponseMzone> call, Response<ResponseMzone> response) {
        if (response.body().error != null || response == null || response.body() == null) {
            //todo show error
        } else {
            setData();
        }
    }

    private void setData() {
        if (ControllerMzoneInfo.getInstance().getData() == null)
            return;

        if (!isAdded() || getActivity() == null)
            return;

        //todo add mzone image
//        Picasso.with(getContext())
//                .load(ControllerMzoneInfo.getInstance().getData().imgUrl)
//                .into(((ImageView) getView().findViewById(R.id.ivMzone)));
        if (!TextUtils.isEmpty(ControllerMzoneInfo.getInstance().getData().name))
            ((TextView) getView().findViewById(R.id.tvMzoneTitle)).setText(ControllerMzoneInfo.getInstance().getData().name);
        else ((TextView) getView().findViewById(R.id.tvMzoneTitle)).setText("");

        if (!TextUtils.isEmpty(ControllerMzoneInfo.getInstance().getData().address))
            ((TextView) getView().findViewById(R.id.tvMzoneAddress)).setText(ControllerMzoneInfo.getInstance().getData().address);
        else ((TextView) getView().findViewById(R.id.tvMzoneAddress)).setText("");

        if (adapter != null) adapter.updateData();
    }

    @Override
    public void onFailure(Call<ResponseMzone> call, Throwable t) {
        t.printStackTrace();
    }
}
