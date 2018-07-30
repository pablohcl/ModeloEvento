package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

public class FragmentTicketsInformacoes extends BaseFragment {

    private TextView tvTituloTicketsInformacoes;
    private TextView tvP1TicketsInformacoes;
    private TextView tvP2TicketsInformacoes;
    private TextView tvLinkTicketsInformacoes;

    public FragmentTicketsInformacoes() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewTicketsInformacoes = inflater.inflate(R.layout.tickets_informacoes_fragment, container, false);
        tvTituloTicketsInformacoes = (TextView) viewTicketsInformacoes.findViewById(R.id.tv_titulo_tickets_informacoes);
        tvP1TicketsInformacoes= (TextView) viewTicketsInformacoes.findViewById(R.id.tv_p1_tickets_informacoes);
        tvP2TicketsInformacoes= (TextView) viewTicketsInformacoes.findViewById(R.id.tv_p2_tickets_informacoes);
        tvLinkTicketsInformacoes= (TextView) viewTicketsInformacoes.findViewById(R.id.tv_link_tickets_informacoes);
        return  viewTicketsInformacoes;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int ticket;

        getTickets();

        if(getArguments() != null){
            ticket = getArguments().getInt("ticket");
            tvTituloTicketsInformacoes.setText(tickets.get(ticket));
            tvP1TicketsInformacoes.setText(ticketsDescricoes.get(ticket));
            tvP2TicketsInformacoes.setText(ticketsDescricoes.get(ticket));
            tvLinkTicketsInformacoes.setText(R.string.tickets_link);
            tvLinkTicketsInformacoes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToUrl();
                }
            });
            getActivity().setTitle(tickets.get(ticket));
        }
    }
}
