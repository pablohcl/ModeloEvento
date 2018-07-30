package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.modeloevento.R;

public class FragmentEstrutura extends BaseFragment {

    private TextView tvP1;
    private TextView tvP2;

    public FragmentEstrutura() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewEstrutura = inflater.inflate(R.layout.estrutura_fragment, container, false);
        tvP1 = (TextView) viewEstrutura.findViewById(R.id.tv_titulo_estrutura);
        tvP2 = (TextView) viewEstrutura.findViewById(R.id.tv_p2_estrutura);
        return viewEstrutura;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tvP1.setText(getActivity().getResources().getString(R.string.estrutura));
        tvP2.setText(getActivity().getResources().getString(R.string.estrutura_p2));
        getActivity().setTitle(R.string.estrutura);
    }
}
