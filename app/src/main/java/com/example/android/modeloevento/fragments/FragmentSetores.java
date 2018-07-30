package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.modeloevento.R;

public class FragmentSetores extends BaseFragment {

    public FragmentSetores() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewSetores = inflater.inflate(R.layout.setores_fragment, container, false);

        return viewSetores;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getSetores();
        setSetores();
        getActivity().setTitle(R.string.setores);
    }
}
