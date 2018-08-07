package com.example.android.modeloevento.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

import java.util.ArrayList;

public class AtracoesAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> artistas;
    private ArrayList<String> descricoes;
    private final AtracaoOnClickListener onClickListener;
    public interface AtracaoOnClickListener {
        void onClickArtista(View view, int position);
    }

    public AtracoesAdapter(Context context, ArrayList<String> artistas, ArrayList<String> descricoes, AtracaoOnClickListener onClickListener) {
        this.context = context;
        this.artistas = artistas;
        this.descricoes = descricoes;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewAtracoesAdapter = LayoutInflater.from(context).inflate(R.layout.linha_atracoes, parent, false);
        HolderAtracoes holderAtracoes = new HolderAtracoes(viewAtracoesAdapter);
        return holderAtracoes;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HolderAtracoes holderAtracoes = (HolderAtracoes) holder;

        holderAtracoes.tvNome.setText(artistas.get(position));
        holderAtracoes.tvDesc.setText(descricoes.get(position));
        holderAtracoes.imgView.setImageResource(R.drawable.ic_dj);
        holder.itemView.setTag(position);
        if(onClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickArtista(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return artistas.size();
    }

    public class HolderAtracoes extends RecyclerView.ViewHolder{

        final TextView tvNome;
        final TextView tvDesc;
        final AppCompatImageView imgView;

        public HolderAtracoes(View v){
            super(v);
            tvNome = (TextView) v.findViewById(R.id.tv_nome_linha_atracoes);
            tvDesc = (TextView) v.findViewById(R.id.tv_desc_linha_atracoes);
            imgView = (AppCompatImageView) v.findViewById(R.id.imgview_linha_atracoes);
        }
    }
}
