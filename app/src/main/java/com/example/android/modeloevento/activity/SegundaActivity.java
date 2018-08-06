package com.example.android.modeloevento.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.example.android.modeloevento.R;
import com.example.android.modeloevento.fragments.FragmentAtracoes;
import com.example.android.modeloevento.fragments.FragmentEvento;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class SegundaActivity extends BaseActivity {

    private Bundle args;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        setUpToolbar();
        setUpNavDrawer();

        if(getIntent().getExtras() != null){
            args = getIntent().getExtras();
        }else{
            Log.d("LOG", "BUNDLE VAZIO");
        }


        carregarFragSelecionadoInicialmente(args.getInt("item_clicado"));
    }
}
