package com.example.android.modeloevento.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.modeloevento.R;
import com.example.android.modeloevento.activity.BaseActivity;

import java.util.ArrayList;

public class BotaoAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> strings;

    public BotaoAdapter(Context context, ArrayList<String> strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.linha_grid, null);

        TextView tvDesc = (TextView) v.findViewById(R.id.tv_nome);
        ImageView imgLinhaGrid = (ImageView) v.findViewById(R.id.img_linha_grid);

        tvDesc.setText(strings.get(position));
        switch(position){
            case 0:
                imgLinhaGrid.setImageResource(R.drawable.ic_evento);
                break;

            case 1:
                imgLinhaGrid.setImageResource(R.drawable.ic_dj);
                break;

            case 2:
                imgLinhaGrid.setImageResource(R.drawable.ic_setores);
                break;

            case 3:
                imgLinhaGrid.setImageResource(R.drawable.ic_structure);
                break;

            case 4:
                imgLinhaGrid.setImageResource(R.drawable.ic_tickets);
                break;

            case 5:
                imgLinhaGrid.setImageResource(R.drawable.ic_news);
                break;

            case 6:
                imgLinhaGrid.setImageResource(R.drawable.ic_youtube);
                break;

            case 7:
                imgLinhaGrid.setImageResource(R.drawable.ic_instagram);
                break;

            case 8:
                imgLinhaGrid.setImageResource(R.drawable.ic_shopping_basket);
                break;

            case 9:
                imgLinhaGrid.setImageResource(R.drawable.ic_store);
                break;

            case 10:
                imgLinhaGrid.setImageResource(R.drawable.ic_excursao);
                break;

            case 11:
                imgLinhaGrid.setImageResource(R.drawable.ic_aniversario);
                break;

            case 12:
                imgLinhaGrid.setImageResource(R.drawable.ic_campanha);
                break;

            case 13:
                imgLinhaGrid.setImageResource(R.drawable.ic_map);
                break;

            case 14:
                imgLinhaGrid.setImageResource(R.drawable.ic_termos);
                break;

            default:
                imgLinhaGrid.setImageResource(R.drawable.ic_android_black_48dp);
        }

        return v;
    }

    @Override
    public Object getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getCount() {
        return strings.size();
    }
}
