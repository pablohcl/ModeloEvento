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

public class TicketsAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<String> tickets;
    private ArrayList<String> ticketsDescricoes;
    private final TicketsOnClickListener onClickListener;
    public interface TicketsOnClickListener {
        void onClickTickets(View view, int position);
    }

    public TicketsAdapter(Context context, ArrayList<String> tickets, ArrayList<String> ticketsDescricoes, TicketsOnClickListener onClickListener) {
        this.context = context;
        this.tickets = tickets;
        this.ticketsDescricoes = ticketsDescricoes;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewTcketsAdapter = LayoutInflater.from(context).inflate(R.layout.linha_tickets, parent, false);
        HolderTickets holderTickets = new HolderTickets(viewTcketsAdapter);
        return holderTickets;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        HolderTickets hold = (HolderTickets) holder;

        hold.tvNomeTicket.setText(tickets.get(position));
        hold.tvDescTicket.setText(ticketsDescricoes.get(position));
        hold.itemView.setTag(position);
        if(onClickListener != null){
            hold.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClickTickets(v, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return tickets.size();
    }

    public class HolderTickets extends RecyclerView.ViewHolder{
        final TextView tvNomeTicket;
        final TextView tvDescTicket;

        public HolderTickets(View v){
            super(v);
            tvNomeTicket = (TextView) v.findViewById(R.id.tv_nome_linha_tickets);
            tvDescTicket = (TextView) v.findViewById(R.id.tv_desc_linha_tickets);
        }
    }
}
