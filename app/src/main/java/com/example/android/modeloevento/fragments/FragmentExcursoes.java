package com.example.android.modeloevento.fragments;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.android.modeloevento.R;

public class FragmentExcursoes extends BaseFragment {

    private ConstraintLayout linha1, linha2;

    public FragmentExcursoes() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewExcursoes = inflater.inflate(R.layout.excursoes_fragment, container, false);
        linha1 = (ConstraintLayout) viewExcursoes.findViewById(R.id.layout_ache_excursao);
        linha2 = (ConstraintLayout) viewExcursoes.findViewById(R.id.layout_cadastre_excursao);
        return viewExcursoes;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.excursoes);

        linha1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentExcursoesAchar fragmentExcursoesAchar = new FragmentExcursoesAchar();
                ft.replace(R.id.frag_layout, fragmentExcursoesAchar, "FRAG EXCURSOES ACHAR");
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        linha2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.support.v4.app.FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentExcursoesCadastrar fragmentExcursoesCadastrar = new FragmentExcursoesCadastrar();
                ft.replace(R.id.frag_layout, fragmentExcursoesCadastrar, "FRAG EXCURSOES CADASTRAR");
                ft.addToBackStack(null);
                ft.commit();
            }
        });
    }
}
