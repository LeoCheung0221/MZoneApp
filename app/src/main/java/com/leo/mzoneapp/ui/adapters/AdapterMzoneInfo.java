package com.leo.mzoneapp.ui.adapters;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leo.mzoneapp.R;
import com.leo.mzoneapp.controller.ControllerSongsQueue;

/**
 * author：leo on 2016/5/15 16:07
 * email： leocheung4ever@gmail.com
 * description: TODO
 * what & why is modified:
 */
public class AdapterMzoneInfo extends RecyclerView.Adapter<AdapterMzoneInfo.ViewHolder> {

    private static final int TYPE_PLAYING_NOW = 0;
    private static final int TYPE_QUEUE = 1;
    private static final int TYPE_EMPTY = 2;

    private Context context;

    public AdapterMzoneInfo(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 && ControllerSongsQueue.getInstance().isPlayingNow())
            return TYPE_PLAYING_NOW;
        if (ControllerSongsQueue.getInstance().isQueueEmpty()) {
            return TYPE_EMPTY;
        }
        return TYPE_QUEUE;
    }

    @Override
    public AdapterMzoneInfo.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_PLAYING_NOW) {
            return new PlayingNowViewHolder(LayoutInflater.from(context).inflate(R.layout.view_list_songs_queue_playing_now, parent, false));
        } else if (viewType == TYPE_QUEUE) {
            return new QueueViewHolder(LayoutInflater.from(context).inflate(R.layout.view_list_songs_queue, parent, false));
        } else {
            return new EmptyViewHolder(LayoutInflater.from(context).inflate(R.layout.view_list_songs_queue_empty, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(AdapterMzoneInfo.ViewHolder holder, int position) {
        holder.setData(position);
    }

    @Override
    public int getItemCount() {
        int count = 0;
        if (ControllerSongsQueue.getInstance().isPlayingNow()) ++count;
        ++count;
        return count;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public void setData(int position) {

        }
    }

    private class PlayingNowViewHolder extends ViewHolder {
        public PlayingNowViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(int position) {
            super.setData(position);
        }
    }

    private class QueueViewHolder extends ViewHolder {

        RecyclerView rvSongsQueue;
        AdapterSongsQueue adapter;

        public QueueViewHolder(View itemView) {
            super(itemView);

            rvSongsQueue = (RecyclerView) itemView.findViewById(R.id.rvSongQueue);
            adapter = new AdapterSongsQueue(itemView.getContext());
            rvSongsQueue.setAdapter(adapter);
            rvSongsQueue.setLayoutManager(new LinearLayoutManager(itemView.getContext()));

        }

        @Override
        public void setData(int position) {
            adapter.update();
        }
    }

    private class EmptyViewHolder extends ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void setData(int position) {
            super.setData(position);
        }
    }
}
