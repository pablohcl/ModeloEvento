package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

public class FragmentExcursoesAchar extends BaseFragment {

    private TextView tvTitulo, tvP1, tvP2;

    public FragmentExcursoesAchar() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.excursoes_achar_fragment, container, false);
        tvTitulo = (TextView) view.findViewById(R.id.tv_titulo_excursoes_achar);
        tvP1 = (TextView) view.findViewById(R.id.tv_p1_excursoes_achar);
        tvP2 = (TextView) view.findViewById(R.id.tv_p2_excursoes_achar);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getActivity().setTitle(R.string.titulo_excursoes_achar);

        tvTitulo.setText(getActivity().getResources().getString(R.string.titulo_excursoes_achar));
        tvP1.setText(getActivity().getResources().getString(R.string.p1_excursoes_achar));
        tvP2.setText(getActivity().getResources().getString(R.string.p2_excursoes_achar));
    }
}
