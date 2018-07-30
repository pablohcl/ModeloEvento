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

public class SetoresAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> setores;
    private ArrayList<String> descricoesSetores;
    private final SetoresOnClickListener onClickListener;
    public interface SetoresOnClickListener{
        void onClickSetores(View view, int position);
    }

    public SetoresAdapter(Context context, ArrayList<String> setores, ArrayList<String> descricoesSetores, SetoresOnClickListener onClickListener) {
        this.context = context;
        this.setores = setores;
        this.descricoesSetores = descricoesSetores;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewSetoresAdapter = LayoutInflater.from(context).inflate(R.layout.linha_setores, parent, false);
        HolderSetores holderSetores = new HolderSetores(viewSetoresAdapter);
        return holderSetores;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HolderSetores holderSetores = (HolderSetores) holder;

        holderSetores.tvNomeSetores.setText(setores.get(position));
        holderSetores.tvDescSetores.setText(descricoesSetores.get(position));
        holder.itemView.setTag(position);
        if(onClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickSetores(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return setores.size();
    }

    public class HolderSetores extends RecyclerView.ViewHolder{

        final TextView tvNomeSetores;
        final TextView tvDescSetores;

        public HolderSetores(View v) {
            super(v);
            tvNomeSetores = (TextView) v.findViewById(R.id.tv_nome_setores);
            tvDescSetores = (TextView) v.findViewById(R.id.tv_desc_setores);
        }
    }
}
