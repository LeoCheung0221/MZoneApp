package com.leo.mzoneapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leo.mzoneapp.R;
import com.leo.mzoneapp.controller.ControllerSongsQueue;

/**
 * author：leo on 2016/5/15 18:11
 * email： leocheung4ever@gmail.com
 * description: 音乐列表适配器
 * what & why is modified:
 */
public class AdapterSongsQueue extends RecyclerView.Adapter<AdapterSongsQueue.ViewHolder> {

    private Context context;

    public AdapterSongsQueue(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.view_song_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        return ControllerSongsQueue.getInstance().getSongsQueueSize();
    }

    public void update() {
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSongTitle, tvBandName, tvDuration;
        ImageView ivSongAvatar;

        public ViewHolder(View itemView) {
            super(itemView);

            tvSongTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvBandName = (TextView) itemView.findViewById(R.id.tv_band);
            tvDuration = (TextView) itemView.findViewById(R.id.tvDuration);
            ivSongAvatar = (ImageView) itemView.findViewById(R.id.ivAvatar);
        }

        public void setData(int position) {

        }
    }
}
