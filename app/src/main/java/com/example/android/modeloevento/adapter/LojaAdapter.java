package com.example.android.modeloevento.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

import java.util.ArrayList;

public class LojaAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> itensLoja;
    private ArrayList<String> descItensLoja;
    private ArrayList<String> precosItensLoja;
    private final LojaOnClickListener onClickListener;
    public interface LojaOnClickListener{
        void onClickLoja(View view, int position);
    }

    public LojaAdapter(Context context, ArrayList<String> itensLoja, ArrayList<String> descItensLoja, ArrayList<String> precosItensLoja, LojaOnClickListener onClickListener) {
        this.context = context;
        this.itensLoja = itensLoja;
        this.descItensLoja = descItensLoja;
        this.precosItensLoja = precosItensLoja;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.linha_loja, parent, false);
        HolderLoja holderLoja = new HolderLoja(view);
        return holderLoja;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HolderLoja hold = (HolderLoja) holder;

        hold.tvNomeItem.setText(itensLoja.get(position));
        hold.tvDescItem.setText(descItensLoja.get(position));
        hold.tvPrecoItem.setText(precosItensLoja.get(position));
        hold.itemView.setTag(position);
        if(onClickListener != null){
            hold.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickLoja(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return itensLoja.size();
    }

    private class HolderLoja extends RecyclerView.ViewHolder{
        final TextView tvNomeItem;
        final TextView tvDescItem;
        final TextView tvPrecoItem;

        public HolderLoja(View v) {
            super(v);
            tvNomeItem = (TextView) v.findViewById(R.id.tv_nome_item_linha_loja);
            tvDescItem = (TextView) v.findViewById(R.id.tv_desc_item_linha_loja);
            tvPrecoItem = (TextView) v.findViewById(R.id.tv_preco_item_linha_loja);
        }
    }
}
