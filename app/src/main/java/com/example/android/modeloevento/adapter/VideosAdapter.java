package com.example.android.modeloevento.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

import java.util.ArrayList;

public class VideosAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> videos;
    private ArrayList<String> descricoesVideos;
    private final VideosOnClickListener onClickListener;
    public interface VideosOnClickListener {
        void onClickVideos(View view, int position);
    }

    public VideosAdapter(Context context, ArrayList<String> videos, ArrayList<String> descricoesVideos, VideosOnClickListener onClickListener) {
        this.context = context;
        this.videos = videos;
        this.descricoesVideos = descricoesVideos;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.linha_videos, parent, false);
        HolderVideos holderVideos = new HolderVideos(view);
        return holderVideos;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HolderVideos hold = (HolderVideos) holder;

        hold.tvNomeVideo.setText(videos.get(position));
        hold.tvDescVideo.setText(descricoesVideos.get(position));
        hold.itemView.setTag(position);
        if(onClickListener != null){
            hold.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickVideos(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    private class HolderVideos extends RecyclerView.ViewHolder{
        final TextView tvNomeVideo;
        final TextView tvDescVideo;

        public HolderVideos(View v) {
            super(v);
            tvNomeVideo = (TextView) v.findViewById(R.id.tv_nome_linha_videos);
            tvDescVideo = (TextView) v.findViewById(R.id.tv_desc_linha_videos);
        }
    }
}
