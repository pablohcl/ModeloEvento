package com.example.android.modeloevento.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.modeloevento.R;
import com.example.android.modeloevento.adapter.BotaoAdapter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ImageView imgView;
    private GridView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (GridView) findViewById(R.id.rv_main);
        imgView = (ImageView) findViewById(R.id.imageView);

        preencherLista();
        mostrarConteudo();
    }

    // Setando o adapter e mostrando o conteudo
    protected void mostrarConteudo(){
        adapter = new BotaoAdapter(getBaseContext(), stringsList);
        recyclerView.setAdapter(adapter);
        recyclerView.setNumColumns(4);
        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), SegundaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("item_clicado", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private Context getContext(){
        return this;
    }
}
