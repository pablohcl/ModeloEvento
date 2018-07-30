package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.modeloevento.R;

public class FragmentTermosCondicoes extends BaseFragment {

    public FragmentTermosCondicoes() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewTermosCondicoes = inflater.inflate(R.layout.termos_condicoes_fragment, container, false);

        return viewTermosCondicoes;
    }
}
