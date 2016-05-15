package com.leo.mzoneapp.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.leo.mzoneapp.R;

/**
 * author： LeoCheung4ever on 2016/5/9 17:22
 * email： leocheung4ever@gmail.com
 * description: song charts
 * what & why is modified:
 */
public class ActivitySongsCharts extends ActivityBase {
    public static void display(Context context) {
        context.startActivity(new Intent(context, ActivitySongs.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_charts);
    }
}
