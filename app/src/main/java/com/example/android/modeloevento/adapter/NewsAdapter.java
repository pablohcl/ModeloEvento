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

public class NewsAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> datas;
    private ArrayList<String> descricoes;
    private final NewsOnClickListener onClickListener;
    public interface NewsOnClickListener {
        void onClickNews(View view, int position);
    }

    public NewsAdapter(Context context, ArrayList<String> datas, ArrayList<String> descricoes, NewsOnClickListener onClickListener) {
        this.context = context;
        this.datas = datas;
        this.descricoes = descricoes;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.linha_news, parent, false);
        HolderNews holderNews = new HolderNews(view);
        return holderNews;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HolderNews hold = (HolderNews) holder;

        hold.tvDatasNews.setText(datas.get(position));
        hold.tvDescNews.setText(descricoes.get(position));
        hold.itemView.setTag(position);
        if(onClickListener != null){
            hold.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickNews(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class HolderNews extends RecyclerView.ViewHolder{
        final TextView tvDatasNews;
        final TextView tvDescNews;

        public HolderNews(View v){
            super(v);
            tvDatasNews = (TextView) v.findViewById(R.id.tv_data_linha_news);
            tvDescNews = (TextView) v.findViewById(R.id.tv_desc_linha_news);
        }
    }
}
