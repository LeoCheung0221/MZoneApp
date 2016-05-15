package com.leo.mzoneapp.ui.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.mzoneapp.R;
import com.leo.mzoneapp.ui.activities.ActivitySongs;
import com.leo.mzoneapp.ui.adapters.AdapterMzoneInfo;

/**
 * author： LeoCheung4ever on 2016/5/9 16:20
 * email： leocheung4ever@gmail.com
 * description: Mzone info
 * what & why is modified:
 */
public class FragmentMzoneInfo extends FragmentBase
        implements View.OnClickListener
{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_mzone_info,container,false);

        v.findViewById(R.id.tvSongOrder).setOnClickListener(this);
        RecyclerView mRecyclerView = (RecyclerView) v.findViewById(R.id.rvMzoneInfo);
        mRecyclerView.setAdapter(new AdapterMzoneInfo(v.getContext()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        return v;
    }

    @Override
    public void onClick(View v) {
        ActivitySongs.display(v.getContext());
    }
}
