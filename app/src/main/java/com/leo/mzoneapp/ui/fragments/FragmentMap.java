package com.leo.mzoneapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.mzoneapp.R;

/**
 * author： LeoCheung4ever on 2016/5/9 16:21
 * email： leocheung4ever@gmail.com
 * description: TODO
 * what & why is modified:
 */
public class FragmentMap extends FragmentBase {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_map,container,false);

        return v;
    }
}
