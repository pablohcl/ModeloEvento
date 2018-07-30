package com.example.android.modeloevento.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.modeloevento.R;

public class FragmentAniversarios extends BaseFragment {

    public FragmentAniversarios() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewAniversarios = inflater.inflate(R.layout.aniversarios_fragment, container, false);

        return viewAniversarios;
    }
}
