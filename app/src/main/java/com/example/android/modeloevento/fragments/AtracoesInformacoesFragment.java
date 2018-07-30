package com.example.android.modeloevento.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

import java.util.ArrayList;

public class AtracoesInformacoesFragment extends BaseFragment {

    private TextView tvNomeAtracao;
    private TextView tvDescAtracao;

    public AtracoesInformacoesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewAtracoesInformacoes = inflater.inflate(R.layout.tela_informacoes_atracoes, container, false);

        tvNomeAtracao = (TextView) viewAtracoesInformacoes.findViewById(R.id.tv_nome_tela_informacoes_atracoes);
        tvDescAtracao = (TextView) viewAtracoesInformacoes.findViewById(R.id.tv_desc_tela_informacoes_atracoes);

        return viewAtracoesInformacoes;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int atracao;

        getAtracoes();

        if(getArguments() != null){
            atracao = getArguments().getInt("atracao");
            tvNomeAtracao.setText(atracoes.get(atracao));
            tvDescAtracao.setText(descricoes.get(atracao));
            getActivity().setTitle(atracoes.get(atracao));
        }
    }
}
