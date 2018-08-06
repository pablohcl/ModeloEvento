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

    ViewHolder hold;

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
        hold = (ViewHolder) holder;
        final String result = strings.get(position);

        hold.tvNome.setText(result);
        //hold.imgView.setImageResource(R.drawable.ic_android_white_72dp);
        setImage(position);
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

    private void setImage(int position){
        switch(position){
            case 0:
                hold.imgView.setImageResource(R.drawable.ic_evento);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 1:
                hold.imgView.setImageResource(R.drawable.ic_dj);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 2:
                hold.imgView.setImageResource(R.drawable.ic_setores);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 3:
                hold.imgView.setImageResource(R.drawable.ic_structure);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 4:
                hold.imgView.setImageResource(R.drawable.ic_tickets);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 5:
                hold.imgView.setImageResource(R.drawable.ic_news);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 6:
                hold.imgView.setImageResource(R.drawable.ic_youtube);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 7:
                hold.imgView.setImageResource(R.drawable.ic_instagram);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 8:
                hold.imgView.setImageResource(R.drawable.ic_store);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 9:
                hold.imgView.setImageResource(R.drawable.ic_ponto_venda);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 10:
                hold.imgView.setImageResource(R.drawable.ic_excursao);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 11:
                hold.imgView.setImageResource(R.drawable.ic_aniversario);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 12:
                hold.imgView.setImageResource(R.drawable.ic_campanha);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 13:
                hold.imgView.setImageResource(R.drawable.ic_map);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;

            case 14:
                hold.imgView.setImageResource(R.drawable.ic_termos);
                hold.imgView.setAdjustViewBounds(true);
                hold.imgView.setPadding(8, 8, 8, 8);
                break;
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
