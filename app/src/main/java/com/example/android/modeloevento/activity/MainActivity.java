package com.example.android.modeloevento.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.android.modeloevento.R;
import com.example.android.modeloevento.adapter.BotaoAdapter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ImageView imgView;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv_main);
        imgView = (ImageView) findViewById(R.id.imageView);

        preencherLista();
        mostrarConteudo();
    }

    // Setando o adapter e mostrando o conteudo
    protected void mostrarConteudo(){
        adapter = new BotaoAdapter(getBaseContext(), stringsList, onClickBotao());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
    }
    protected BotaoAdapter.BotaoOnClickListener onClickBotao(){
        return new BotaoAdapter.BotaoOnClickListener() {
            @Override
            public void onClickBotao(View view, int position) {
                preencherLista();
                Intent intent = new Intent(getContext(), SegundaActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("item_clicado", position);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        };
    }

    private Context getContext(){
        return this;
    }
}
