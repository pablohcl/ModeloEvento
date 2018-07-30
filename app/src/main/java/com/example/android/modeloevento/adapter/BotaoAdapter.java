package com.example.android.modeloevento.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.modeloevento.R;

import java.util.ArrayList;

public class BotaoAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> strings;
    private final BotaoOnClickListener onClickListener;
    public interface BotaoOnClickListener {
        public void onClickBotao(View view, int position);
    }

    public BotaoAdapter(Context context, ArrayList<String> strings, BotaoOnClickListener onClickListener) {
        this.context = context;
        this.strings = strings;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewBotaoAdapter = LayoutInflater.from(context).inflate(R.layout.linha_grid, parent, false);
        ViewHolder holder = new ViewHolder(viewBotaoAdapter);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder hold = (ViewHolder) holder;
        final String result = strings.get(position);

        hold.tvNome.setText(result);
        hold.imgView.setImageResource(R.drawable.ic_android_white_72dp);
        holder.itemView.setTag(position);
        if(onClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickBotao(v, position);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return strings.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        final TextView tvNome;
        final ImageView imgView;

        public ViewHolder (View v){
            super(v);
            tvNome = (TextView) v.findViewById(R.id.tv_nome);
            imgView = (ImageView) v.findViewById(R.id.imageView2);
        }
    }
}
