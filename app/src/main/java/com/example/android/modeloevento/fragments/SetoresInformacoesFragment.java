package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

public class SetoresInformacoesFragment extends BaseFragment {

    private TextView tvTitulo;
    private TextView tvP1;
    private TextView tvP2;
    private TextView tvP3;

    public SetoresInformacoesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewSetoresInformacoes = inflater.inflate(R.layout.tela_setores_informacoes, container, false);
        tvTitulo = (TextView) viewSetoresInformacoes.findViewById(R.id.tv_titulo_setores_informacoes);
        tvP1 = (TextView) viewSetoresInformacoes.findViewById(R.id.tv_p1_setores_informacoes);
        tvP2 = (TextView) viewSetoresInformacoes.findViewById(R.id.tv_p2_setores_informacoes);
        tvP3 = (TextView) viewSetoresInformacoes.findViewById(R.id.tv_p3_setores_informacoes);
        return viewSetoresInformacoes;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        int setor;

        getSetores();

        if(getArguments() != null){
            setor = getArguments().getInt("setor");
            tvTitulo.setText(setores.get(setor));
            tvP1.setText(setoresDescricoes.get(setor));
            tvP2.setText(setoresDescricoes.get(setor));
            tvP3.setText(setoresDescricoes.get(setor));
            getActivity().setTitle(setores.get(setor));
        }
    }
}
