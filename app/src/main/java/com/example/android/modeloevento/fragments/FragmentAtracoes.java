package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.modeloevento.R;
import com.example.android.modeloevento.adapter.AtracoesAdapter;

import java.util.ArrayList;

public class FragmentAtracoes extends BaseFragment {

    public FragmentAtracoes() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewAtracoes = inflater.inflate(R.layout.atracoes_fragment, container, false);

        return viewAtracoes;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getAtracoes();
        setAtracoes();
        getActivity().setTitle(R.string.atracoes);
    }
}
